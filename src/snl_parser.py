from langchain_google_genai import ChatGoogleGenerativeAI
import google.generativeai as genai
from langchain_core.prompts import ChatPromptTemplate
from dotenv import load_dotenv
import os

# Charger les variables d'environnement et configurer l'API
load_dotenv()
apikey = os.getenv("GOOGLE_API_KEY")
genai.configure(api_key=apikey)

class SNLProcessor:
    def __init__(self, model="gemini-1.5-pro"):
        self.llm = ChatGoogleGenerativeAI(model=model)
        self._init_prompts()
    
    def _init_prompts(self):
        # Prompt de validation minimaliste :
        # On demande seulement "Valid SNL" si le code est correct, sinon "Invalid SNL".
        self.validation_prompt = ChatPromptTemplate.from_messages([
            (
                "system",
                "You are an assistant that checks the provided SNL code strictly for syntactical and logical correctness. "
                "If the SNL code is valid, reply exactly 'Valid SNL'. If not, reply exactly 'Invalid SNL'. Do not provide any additional commentary or suggestions."
            ),
            ("human", "{input}")
        ])
        self.validation_chain = self.validation_prompt | self.llm

        # Prompt pour la conversion SNL → NLP et génération de prompt pour code
        self.conversion_prompt = ChatPromptTemplate.from_messages([
            (
                "system",
                "You are an assistant that converts SNL (Structured Natural Language) into a clear NLP description "
                "and produces a structured prompt for code generation. "
                "Your output must be in the following format:\n\n"
                "[NLP]: <Natural Language Description>\n"
                "[PROMPT]: <Prompt to use for code generation>\n\n"
                "Do not include any additional suggestions."
            ),
            ("human", "{input}")
        ])
        self.conversion_chain = self.conversion_prompt | self.llm

    def validate(self, snl_text: str) -> str:
        """
        Valide uniquement la syntaxe et la logique du SNL.
        Renvoie "Valid SNL" si c'est correct, sinon "Invalid SNL".
        """
        response = self.validation_chain.invoke({"input": snl_text})
        return response.content.strip() if hasattr(response, 'content') else response.strip()

    def convert_to_nlp(self, snl_text: str) -> str:
        """
        Convertit le SNL validé en une description NLP structurée.
        Renvoie la réponse brute du LLM.
        """
        response = self.conversion_chain.invoke({"input": snl_text})
        return response.content if hasattr(response, 'content') else response

    def parse_conversion(self, conversion_output: str) -> (str):
        """
        Extrait la description NLP et le prompt pour la génération de code à partir de la réponse.
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
        Exécute le workflow complet : validation, conversion et extraction.
        Renvoie un dictionnaire contenant le résultat.
        """
        validation_result = self.validate(snl_text)
        if validation_result != "Valid SNL":
            return {"status": "error", "message": "Invalid SNL. Please check your code."}
        conversion_output = self.convert_to_nlp(snl_text)
        nlp_text, prompt_text = self.parse_conversion(conversion_output)
        return {"status": "success", "nlp": nlp_text, "prompt": prompt_text}


