from langchain_google_genai import ChatGoogleGenerativeAI
import google.generativeai as genai
from langchain_core.prompts import ChatPromptTemplate
from dotenv import load_dotenv
import os

# Charger les variables d'environnement
load_dotenv()

apikey = os.getenv("GOOGLE_API_KEY")
genai.configure(api_key=apikey)

llm = ChatGoogleGenerativeAI(model="gemini-1.5-pro")

# 🔹 Nouveau prompt pour structurer la sortie
prompt = ChatPromptTemplate.from_messages(
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

# Création du pipeline
chain = prompt | llm

# Exécution de la conversion
response = chain.invoke(
    {
        "input_language": "SNL",
        "output_language": "NLP",
        "input": """
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
        """
    }
)

# 🔹 Parser la réponse pour extraire uniquement le texte brut
output_text = response.content if hasattr(response, 'content') else response

# 🔹 Extraire les parties NLP et Prompt
nlp_text = ""
prompt_text = ""

for line in output_text.split("\n"):
    if line.startswith("[NLP]:"):
        nlp_text = line.replace("[NLP]:", "").strip()
    elif line.startswith("[PROMPT]:"):
        prompt_text = line.replace("[PROMPT]:", "").strip()

# 🔹 Afficher les résultats
print("\n🔹 **NLP Description:**")
print(nlp_text)

print("\n🔹 **Prompt for Code Generation:**")
print(prompt_text)
print("\n")