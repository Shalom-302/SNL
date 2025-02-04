import streamlit as st
from snl_parser import SNLProcessor

# Initialisation de l'objet SNLProcessor
processor = SNLProcessor()

st.title("SNL to Code Generator")

st.markdown("""
Ce projet convertit un code en **Structured Natural Language (SNL)** en une description NLP structurée et génère un prompt pour la génération de code dans le langage de votre choix.
""")

# Zone de saisie pour le SNL
snl_input = st.text_area(
    label="Entrez votre code SNL ici",
    height=300,
    value=""

)

# Choix du langage cible pour la génération de code
lang_target = st.selectbox("Choisissez le langage de programmation", ["Python", "Java", "C++", "JavaScript"])

# Fonction pour générer du code à partir du prompt et du langage cible
def generate_code(prompt, lang):
    """Génère du code à partir du prompt et du langage cible"""
    # Ici, on pourrait utiliser une API LLM comme OpenAI pour générer du code.
    # Pour l'instant, on retourne un message simulé.
    return f"// Code généré pour {lang}\n// Prompt: {prompt}\n\nprint('Hello, World!')"

if st.button("Valider et Convertir"):
    # Processus complet sur le SNL
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
