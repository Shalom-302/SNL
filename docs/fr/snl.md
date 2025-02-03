
# **Documentation du Projet SNL (Structured Natural Language)**  
*Version 1.1*  

---

## **1. Introduction**  
### **1.1 Objectif du Projet**  
Créer un langage structuré (**SNL**) permettant de décrire des algorithmes de manière claire et intuitive, puis de les convertir automatiquement en code exécutable via un processus en quatre étapes :  
1. **Validation du SNL** : Vérification de la syntaxe, de la logique, de la propreté et de la clarté.  
2. **Conversion SNL → NLP** : Transformation en description naturelle via un LLM.  
3. **Génération de code** : Création de code exécutable (Python, JavaScript, etc.) à partir du NLP.  
4. **Vérification de cohérence** : Assurer que le code généré correspond bien au SNL d'origine.  

**Avantages** :  
- Réduction des erreurs de logique et de syntaxe.  
- Code généré fiable et cohérent avec l'intention initiale.  
- Processus automatisé et évolutif.  

---

## **2. Syntaxe et Grammaire du SNL**  
*(Voir section précédente pour la grammaire classique et POO.)*  

---

## **3. Validation du SNL**  
### **3.1 Objectif de la Validation**  
La validation vise à garantir que le SNL est :  
1. **Syntaxiquement correct** : Respect des règles de grammaire et de vocabulaire.  
2. **Logiquement cohérent** : Absence de contradictions ou d'erreurs de logique.  
3. **Propre et clair** : Code bien structuré et facile à comprendre.  

### **3.2 Étapes de Validation**  
1. **Vérification Syntaxique** :  
   - Présence des mots-clés obligatoires (`ALGORITHM`, `BEGIN`, `END.`).  
   - Typage correct des variables (`integer`, `string`, etc.).  
   - Structure des boucles et conditions (`LOOP UNTIL`, `IF/ELSE`).  

   **Exemple d'erreur détectée :**  
   ```plaintext
   DECLARE x : integer = "hello";  // Erreur : Type mismatch.
   ```

2. **Vérification Logique** :  
   - **Boucles infinies** : Les conditions de sortie doivent être réalisables.  
   - **Variables non initialisées** : Toutes les variables doivent avoir une valeur par défaut.  
   - **Conflits de noms** : Pas de duplication de noms de variables ou de fonctions.  

   **Exemple d'erreur détectée :**  
   ```plaintext
   LOOP UNTIL (i > 10);  // Erreur : 'i' non initialisé.
   ```

3. **Vérification de Propreté et Clarté** :  
   - **Indentation** : Le code doit être bien indenté pour une meilleure lisibilité.  
   - **Noms significatifs** : Les variables et fonctions doivent avoir des noms descriptifs.  
   - **Commentaires** : Ajout de commentaires pour expliquer les étapes complexes.  

   **Exemple de bonnes pratiques :**  
   ```plaintext
   DECLARE totalSomme : float = 0.0;  // Bon : Nom descriptif.
   ```

---

## **4. Conversion SNL → NLP**  
### **4.1 Rôle du LLM**  
Le modèle de langage (ex: Google Gemini) analyse le SNL validé et génère une description en langage naturel (NLP).  

**Prompt utilisé :**  
```plaintext
"Convert this validated SNL code into a natural language description (NLP) explaining the algorithm step by step."
```

**Exemple de sortie NLP :**  
```plaintext
[NLP]: This algorithm calculates the factorial of a number N. The user inputs an integer N. 
The algorithm initializes a variable 'result' to 1 and a counter 'i' to 1. It multiplies 'result' by 'i' 
in each iteration until 'i' exceeds N, then returns the final result.
```

---

## **5. Génération de Code**  
### **5.1 Création du Prompt Structuré**  
À partir du NLP, un prompt est généré pour guider le LLM :  

**Exemple de prompt :**  
```plaintext
[PROMPT]: "Write a Python function that calculates the factorial of a number `n` using a loop."
```

### **5.2 Exemple de Code Généré**  
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

---

## **6. Vérification de Cohérence**  
### **6.1 Objectif**  
Assurer que le code généré correspond bien au SNL d'origine et au NLP intermédiaire.  

### **6.2 Méthode**  
1. **Comparaison des étapes** :  
   - Vérifier que chaque étape du SNL est bien traduite dans le code généré.  
   - Exemple : Si le SNL contient une boucle `LOOP UNTIL`, le code généré doit contenir une boucle équivalente (`while` ou `for`).  

2. **Test unitaire** :  
   - Exécuter le code généré avec des entrées simples pour vérifier qu'il produit les résultats attendus.  

3. **Retour au LLM** :  
   - Si une incohérence est détectée, le LLM est invité à réviser le code généré en se basant sur le NLP.  

---

## **7. Workflow Complet**  
```plaintext
SNL (Structured) 
    → [Validation] → SNL Valide 
    → [LLM] → NLP (Description Naturelle) 
    → [LLM] → Code Exécutable (Python, JS, etc.) 
    → [Vérification de Cohérence] → Code Fiable
```

---

## **8. Prochaines Étapes**  
- **Support multi-langages** : Ajouter C++, Java, etc.  
- **Optimisation des prompts** : Améliorer la précision des descriptions NLP et du code généré.  
- **Interface graphique** : Éditeur SNL avec coloration syntaxique et validation en temps réel.  

---

## **9. Conclusion**  
Le SNL, combiné à une validation rigoureuse et à l'utilisation de LLM, offre une solution puissante pour générer du code fiable et cohérent. Ce processus garantit que chaque étape, de la description algorithmique à la génération de code, est claire, logique et exempte d'erreurs.  

