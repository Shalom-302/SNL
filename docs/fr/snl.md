
# **Documentation du Projet SNL (Structured Natural Language)**  
*Version 1.0*  

---

## **1. Introduction**  
### **1.1 Objectif du Projet**  
Créer un langage structuré (**SNL**) permettant de décrire des algorithmes de manière claire et intuitive, puis de les convertir automatiquement :  
1. **Validation du SNL** : Vérification de la syntaxe et de la logique.  
2. **Conversion SNL → NLP** : Transformation en description naturelle via un LLM.  
3. **Génération de code** : Création de code exécutable (Python, JavaScript, etc.) à partir du NLP.  

**Avantages** :  
- Réduction des erreurs de logique.  
- Accessibilité pour les non-experts en programmation.  
- Génération de code propre et structuré.  

---

## **2. Syntaxe et Grammaire du SNL**  
### **2.1 Grammaire de Base (Classique)**  
Le SNL suit une structure inspirée des langages procéduraux (ex : Pascal) avec des mots-clés explicites.  

**Exemple de structure :**  
```plaintext
ALGORITHM <Nom_Algorithme>;  
BEGIN  
    INPUT (<variables> : <type>);  
    OUTPUT (<variables> : <type>);  

    DECLARE <variable> : <type> = <valeur>;  

    LOOP UNTIL (<condition>)  
        STEP <num>: <action>;  
    ENDLOOP;  

    RETURN <variable>;  
END.  
```

**Règles syntaxiques :**  
- **Mots-clés obligatoires** : `ALGORITHM`, `BEGIN`, `END.`  
- **Blocs structurés** : `INPUT`, `OUTPUT`, `DECLARE`, `LOOP`, `IF/ELSE`.  
- **Typage explicite** : `integer`, `string`, `boolean`, `float`, etc.  

---

### **2.2 Grammaire POO (Programmation Orientée Objet)**  
Extension du SNL pour supporter les concepts orientés objet.  

**Exemple de classe :**  
```plaintext
CLASS Animal  
BEGIN  
    DECLARE name : string;  
    DECLARE age : integer;  

    CONSTRUCTOR (name : string, age : integer)  
    BEGIN  
        SELF.name = name;  
        SELF.age = age;  
    END;  

    METHOD speak() : string  
    BEGIN  
        RETURN "Sound";  
    END;  
END.  
```

**Mots-clés POO :**  
- `CLASS`, `METHOD`, `CONSTRUCTOR`, `INHERITS`, `SELF`.  
- **Visibilité** : `PUBLIC`, `PRIVATE`, `PROTECTED` (optionnel).  

---

## **3. Vocabulaire SNL**  
### **3.1 Vocabulaire Classique**  
| Mot-clé       | Description                                  | Exemple                          |  
|---------------|----------------------------------------------|----------------------------------|  
| `ALGORITHM`   | Déclare le nom de l'algorithme.              | `ALGORITHM CalculMoyenne;`       |  
| `INPUT`       | Définit les entrées de l'algorithme.         | `INPUT (notes : list<float>);`   |  
| `DECLARE`     | Initialise une variable.                     | `DECLARE total : float = 0.0;`   |  
| `LOOP UNTIL`  | Boucle tant qu'une condition est fausse.     | `LOOP UNTIL (i > 10);`           |  
| `IF/ELSE`     | Structure conditionnelle.                    | `IF (age >= 18) THEN ...`        |  

### **3.2 Vocabulaire POO**  
| Mot-clé       | Description                                  | Exemple                          |  
|---------------|----------------------------------------------|----------------------------------|  
| `CLASS`       | Déclare une classe.                          | `CLASS Voiture;`                 |  
| `METHOD`      | Définit une méthode.                         | `METHOD demarrer() : void;`      |  
| `INHERITS`    | Gère l'héritage entre classes.               | `CLASS Chien INHERITS Animal;`   |  
| `SELF`        | Référence l'instance courante.               | `SELF.marque = "Toyota";`        |  

---

## **4. Validation du SNL**  
### **4.1 Vérifications Syntaxiques**  
- **Structure** : Présence des mots-clés obligatoires (`ALGORITHM`, `BEGIN`, `END.`).  
- **Typage** : Cohérence entre les types déclarés et utilisés.  
- **Portée** : Les variables doivent être déclarées avant utilisation.  

**Exemple d'erreur détectée :**  
```plaintext
DECLARE x : integer = "hello";  // Erreur : Type mismatch.
```

### **4.2 Vérifications Logiques**  
- **Boucles infinies** : Conditions de sortie réalisables.  
- **Variables non initialisées** : Toutes les variables doivent avoir une valeur par défaut.  

---

## **5. Conversion SNL → NLP**  
### **5.1 Rôle du LLM**  
Un modèle de langage (ex: Google Gemini) analyse le SNL et génère une description en langage naturel.  

**Prompt utilisé :**  
```plaintext
"Convert this SNL code into a natural language description (NLP) explaining the algorithm step by step."
```

**Exemple de sortie NLP :**  
```plaintext
[NLP]: This algorithm calculates the factorial of a number N. The user inputs an integer N. 
The algorithm initializes a variable 'result' to 1 and a counter 'i' to 1. It multiplies 'result' by 'i' 
in each iteration until 'i' exceeds N, then returns the final result.
```

---

## **6. Génération de Code**  
### **6.1 Création du Prompt Structuré**  
À partir du NLP, un prompt est généré pour guider le LLM :  

**Exemple de prompt :**  
```plaintext
[PROMPT]: "Write a Python function that calculates the factorial of a number `n` using a loop."
```

### **6.2 Exemple de Code Généré**  
**Python :**  
```python
def factorial(n):
    result = 1
    i = 1
    while i <= n:
        result *= i
        i += 1
    return result
```

**JavaScript :**  
```javascript
function factorial(n) {
    let result = 1;
    for (let i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

---

## **7. Workflow Complet**  
```plaintext
SNL (Structured) 
    → [Validation] → SNL Valide 
    → [LLM] → NLP (Description Naturelle) 
    → [LLM] → Code Exécutable (Python, JS, etc.)
```

---

## **8. Prochaines Étapes**  
- **Support multi-langages** : Ajouter C++, Java, etc.  
- **Gestion d'erreurs avancée** : Détection de conflits de variables, optimisations de code.  
- **Interface graphique** : Éditeur SNL avec coloration syntaxique.  

---

## **9. Conclusion**  
Le SNL offre une alternative structurée pour décrire des algorithmes, facilitant la génération de code fiable et compréhensible. En combinant validation syntaxique, NLP et LLM, il réduit les erreurs et accélère le développement.  

