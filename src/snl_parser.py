from langchain_google_genai import ChatGoogleGenerativeAI
import google.generativeai as genai
from langchain_core.prompts import ChatPromptTemplate
from dotenv import load_dotenv
import os

# Charger les variables d'environnement
load_dotenv()
apikey = os.getenv("GOOGLE_API_KEY")
genai.configure(api_key=apikey)

class SNLProcessor:
    def __init__(self, model="gemini-1.5-pro"):
        self.llm = ChatGoogleGenerativeAI(model=model)
        self._init_prompts()
    
    def _init_prompts(self):
        # Prompt pour la validation du SNL
        self.validation_prompt = ChatPromptTemplate.from_messages(
            [
                (
                    "system",
                    "You are an assistant that validates the logic and clarity of SNL (Structured Natural Language) before it is converted into NLP. "
                    "Ensure that the SNL is syntactically correct and logically coherent. If it is valid, return 'Valid SNL', otherwise explain what needs to be fixed.",
                ),
                ("human", "{input}"),
            ]
        )
        self.validation_chain = self.validation_prompt | self.llm

        # Prompt pour la conversion du SNL en NLP et la génération du prompt pour code
        self.conversion_prompt = ChatPromptTemplate.from_messages(
            [
                (
                    "system",
                    "You are an assistant that converts SNL (Structured Natural Language) to a clear NLP description "
                    "and also provides a structured prompt for code generation. "
                    "Your output must be in this format:\n\n"
                    "[NLP]: <Natural Language Description>\n"
                    "[PROMPT]: <Prompt to use for code generation>\n\n",
                ),
                ("human", "{input}"),
            ]
        )
        self.conversion_chain = self.conversion_prompt | self.llm

    def validate(self, snl_text: str) -> str:
        """
        Valide la syntaxe et la logique du SNL.
        Retourne la réponse du validateur.
        """
        response = self.validation_chain.invoke({"input_language": "SNL", "input": snl_text})
        return response.content if hasattr(response, 'content') else response

    def convert_to_nlp(self, snl_text: str) -> str:
        """
        Convertit le SNL validé en une description NLP structurée.
        Retourne le contenu brut de la réponse.
        """
        response = self.conversion_chain.invoke({"input_language": "SNL", "output_language": "NLP", "input": snl_text})
        return response.content if hasattr(response, 'content') else response

    def parse_conversion(self, conversion_output: str) -> (str):
        """
        Parse la sortie de la conversion pour extraire la description NLP et le prompt pour la génération de code.
        Retourne un tuple (nlp_text, prompt_text).
        """
        nlp_text = ""
        prompt_text = ""
        for line in conversion_output.split("\n"):
            if line.startswith("[NLP]:"):
                nlp_text = line.replace("[NLP]:", "").strip()
            elif line.startswith("[PROMPT]:"):
                prompt_text = line.replace("[PROMPT]:", "").strip()
        return nlp_text, prompt_text

    def process_snl(self, snl_text: str) -> dict:
        """
        Exécute tout le workflow : validation, conversion et extraction.
        Si le SNL est invalide, retourne un dictionnaire avec l'erreur.
        Sinon, retourne le NLP et le prompt pour code.
        """
        validation_result = self.validate(snl_text)
        if "Valid SNL" not in validation_result:
            return {"status": "error", "message": validation_result}
        conversion_output = self.convert_to_nlp(snl_text)
        nlp_text, prompt_text = self.parse_conversion(conversion_output)
        return {"status": "success", "nlp": nlp_text, "prompt": prompt_text}
