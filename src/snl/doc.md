
````markdown
# SNL (Structured Natural Language)  
**Documentation Officielle & Guide du Compilateur**

Bienvenue dans le projet **SNL** !  
Ce document est un guide complet pour **écrire du code en SNL** et **contribuer au compilateur**.

Après un long développement, SNL est aujourd’hui une base stable pour un langage d’intention **lisible**, **structuré** et **puissant**.

---

## Table des Matières

### Partie I — Le Langage SNL *(Pour les utilisateurs)*
1. [Philosophie et objectifs](#philosophie-et-objectifs)
2. [Structure d’un programme](#structure-dun-programme-snl)
3. [Commentaires](#commentaires)
4. [Types de données](#types-de-données)
5. [Variables](#variables)
6. [Entités (Structures de données)](#entités-structures-de-données)
7. [Classes (POO)](#classes-programmation-orientée-objet)
8. [Fonctions](#fonctions)
9. [Structures de contrôle](#structures-de-contrôle)
10. [Expressions et opérateurs](#expressions-et-opérateurs)

### Partie II — Le Compilateur SNL *(Pour les développeurs)*
1. [Prérequis techniques](#prérequis-techniques)
2. [Construire et exécuter le projet](#comment-construire-et-exécuter-le-projet)
3. [Structure du dépôt](#structure-du-dépôt)
4. [Prochaines étapes — Créer un .exe](#prochaines-étapes-créer-un-exe)

---

## Partie I — Le Langage SNL

### Philosophie et objectifs
SNL (**Structured Natural Language**) vise à rendre le code **aussi clair qu’une phrase bien construite**.  
Inspirations :
- **Python** pour la lisibilité
- **Java** pour la structure
- **Langages déclaratifs** pour la simplicité

Objectif : faciliter la définition de logiques applicatives de haut niveau.

---

### Structure d’un programme SNL

Un fichier SNL commence toujours par `create project`.

**Syntaxe**
```snl
create project "NomDuProjet" with language [python|javascript] {
    // Code de l’application
}
````

* `"NomDuProjet"` : nom de l’application (entre guillemets)
* `language` : langage cible (`python` ou `javascript`)

**Exemple**

```snl
create project "Mon CRM" with language python {
    // ...
}
```

---

### Commentaires

* **Ligne unique** : `// Ceci est un commentaire`
* **Multi-lignes** : `/* ... */`

```snl
// Crée une variable utilisateur
var nom : string = "Alice"; /* Valeur par défaut */
```

---

### Types de données

#### Types primitifs

* `integer` — nombres entiers
* `float` — nombres à virgule flottante
* `string` — chaînes de caractères
* `boolean` — `true` ou `false`

#### Types futurs

* `date`, `list`, `dict`

#### Types personnalisés

Tout nom de `class` ou `entity` déclarée devient un type valide.

---

### Variables

**Syntaxe**

```snl
var nomVariable : type = expression;
```

**Exemples**

```snl
var score : integer = 0;
var nomUtilisateur : string = "admin";
var estActif : boolean = true;
var monProduit : Produit; // Sans initialisation
```

---

### Entités (Structures de données)

Simples structures pour regrouper des champs (équivalent `struct`).

**Syntaxe**

```snl
create entity NomEntite {
    membre1: type;
    membre2: type;
}
```

**Exemple**

```snl
create entity Facture {
    id: integer;
    montant: float;
    client: string;
}
```

---

### Classes (POO)

Support de l’héritage simple, champs, méthodes.

**Syntaxe**

```snl
class NomClasse extends ClasseParente {
    [public|private|protected] type nomChamp = valeur;
    
    [public|private|protected] typeRetour nomMethode(type nomParam, ...) {
        // corps
    }
}
```

**Exemple**

```snl
class Personne {
    public string nom;
}

class Employe extends Personne {
    private integer idEmploye;

    public void afficherDetails() {
        print(self.nom);
    }
}
```

---

### Fonctions

Blocs réutilisables hors classe.

**Syntaxe standard**

```snl
create func nomFonction(param: type, ...) {
    // ...
}
```

**Exemple**

```snl
create func demarrerServeur() {
    print("Serveur démarré.");
}

create func additionner with arguments a, b {
    return a + b;
}
```

> La syntaxe `with arguments` est temporaire et sera remplacée par la notation `(type nom, ...)`.

---

### Structures de contrôle

#### If / else

```snl
if (age >= 18) then {
    print("Vous êtes majeur.");
} else {
    print("Vous êtes mineur.");
}
```

#### While

```snl
var compteur : integer = 10;
while (compteur > 0) {
    print(compteur);
    compteur = compteur - 1;
}
```

#### For

```snl
for (var i : integer = 0; i < 5; i = i + 1) {
    print("Itération " + i);
}
```

---

### Expressions et opérateurs

| Type         | Opérateurs                  | Description               |
| ------------ | --------------------------- | ------------------------- |
| Arithmétique | `*` `/` `%` `+` `-`         | Multiplication, division… |
| Comparaison  | `>` `>=` `<` `<=` `==` `!=` | Tests de comparaison      |
| Logique      | `not` `!` `and` `or`        | Opérateurs logiques       |
| Assignation  | `=`                         | Affectation               |

---

## Partie II — Le Compilateur SNL

### Prérequis techniques

* **JDK** ≥ 11
* **Apache Maven**
* **ANTLR v4** (`antlr4` dans le PATH)

---

### Comment construire et exécuter le projet

#### 1. Configuration initiale

```bash
chmod +x snl.sh
./snl.sh
```

#### 2. Compilation

```bash
mvn clean install
```

#### 3. Exécution

```bash
mvn exec:java
```

---

### Structure du dépôt

* `grammar/snl.g4` — grammaire du langage
* `src/main/java/com/...` — code source Java

  * `Compiler.java` — point d’entrée
  * `AstVerifierVisitor.java` — analyse sémantique
  * Fichiers générés (`snlParser.java`, `snlLexer.java`, …)
* `pom.xml` — configuration Maven
* `test.snl` — fichier test
* `snl.sh` — script build

---

### Prochaines étapes — Créer un `.exe`

Profil Maven `native` déjà présent dans `pom.xml`.

**Commande**

```bash
mvn clean package -Pnative
```

