import streamlit as st
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
        self.validation_prompt = ChatPromptTemplate.from_messages([
            ("system", "You are an assistant that validates Structured Natural Language (SNL). Ensure it is correct."),
            ("human", "{input}"),
        ])
        self.validation_chain = self.validation_prompt | self.llm

        # Prompt pour la conversion du SNL en NLP et en prompt de génération de code
        self.conversion_prompt = ChatPromptTemplate.from_messages([
            ("system", "Convert SNL to a clear NLP description and a structured prompt for code generation. "
                       "Format:\n[NLP]: <Description>\n[PROMPT]: <Prompt for code generation>\n\n"),
            ("human", "{input}"),
        ])
        self.conversion_chain = self.conversion_prompt | self.llm

    def validate(self, snl_text: str) -> str:
        """Valide la syntaxe du SNL"""
        response = self.validation_chain.invoke({"input": snl_text})
        return response.content if hasattr(response, 'content') else response

    def convert_to_nlp(self, snl_text: str) -> str:
        """Convertit le SNL en NLP"""
        response = self.conversion_chain.invoke({"input": snl_text})
        return response.content if hasattr(response, 'content') else response

    def parse_conversion(self, conversion_output: str):
        """Extrait la description NLP et le prompt"""
        nlp_text, prompt_text = "", ""
        for line in conversion_output.split("\n"):
            if line.startswith("[NLP]:"):
                nlp_text = line.replace("[NLP]:", "").strip()
            elif line.startswith("[PROMPT]:"):
                prompt_text = line.replace("[PROMPT]:", "").strip()
        return nlp_text, prompt_text

    def process_snl(self, snl_text: str) -> dict:
        """Processus complet du SNL"""
        validation_result = self.validate(snl_text)
        if "Valid SNL" not in validation_result:
            return {"status": "error", "message": validation_result}
        
        conversion_output = self.convert_to_nlp(snl_text)
        nlp_text, prompt_text = self.parse_conversion(conversion_output)
        return {"status": "success", "nlp": nlp_text, "prompt": prompt_text}

def generate_code(prompt, lang_target):
    """Génère du code à partir du prompt"""
    generation_prompt = f"Generate {lang_target} code based on the following description:\n{prompt}"
    llm = ChatGoogleGenerativeAI(model="gemini-1.5-pro")
    response = llm.invoke(generation_prompt)
    return response.content if hasattr(response, 'content') else response

# ----------------- Interface Streamlit -----------------

st.title("SNL to Code Generator")

st.markdown("""
Ce projet convertit un code en **Structured Natural Language (SNL)** en une description NLP 
et génère du code dans le langage de votre choix.
""")

# Zone de saisie du SNL
snl_input = st.text_area("Entrez votre code SNL ici", height=300, value="""
    ALGORITHM Somme_Nombres;
        BEGIN
            INPUT (N : integer);
            OUTPUT (somme : integer);
            
            DECLARE somme : integer = 0;
            DECLARE i : integer = 1;
            
            LOOP UNTIL (i > N)
                STEP 1: somme = somme + i;
                STEP 2: i = i + 1;
            ENDLOOP;
            
            RETURN somme;
        END.
""")

# Choix du langage cible
lang_target = st.selectbox("Choisissez le langage de programmation", ["Python", "Java", "C++", "JavaScript"])

# Bouton de validation
if st.button("Valider et Convertir"):
    processor = SNLProcessor()
    result = processor.process_snl(snl_input)
    
    if result["status"] == "error":
        st.error("Erreur de validation SNL : " + result["message"])
    else:
        st.success("SNL validé avec succès!")
        st.subheader("Description NLP:")
        st.write(result["nlp"])
        st.subheader("Prompt pour la génération de code:")
        st.write(result["prompt"])
        
        # Génération du code
        code_output = generate_code(result["prompt"], lang_target)
        st.subheader(f"Code généré en {lang_target}:")
        st.code(code_output, language=lang_target.lower())
