#!/bin/bash

# ====================================================================
#  Script de Configuration Automatique pour le Compilateur SNL
#  Ce script prépare la structure du projet, génère le parser
#  et met en place les fichiers sources nécessaires.
# ====================================================================

# -- Configuration --
# Répertoires
GRAMMAR_DIR="grammar"
GEN_DIR="$GRAMMAR_DIR/gen"
SRC_DIR="src"
MAIN_JAVA_DIR="$SRC_DIR/main/java"

# Configuration du package Java
PACKAGE_NAME="com/your_project"
PACKAGE_DIR="$MAIN_JAVA_DIR/$PACKAGE_NAME"

echo "====================================================="
echo "  Configuration Automatique du Projet SNL"
echo "====================================================="

# ÉTAPE 0: Nettoyage (optionnel mais recommandé)
echo -e "\n[ÉTAPE 0/6] Nettoyage des anciens fichiers générés..."
rm -f "$MAIN_JAVA_DIR"/*.java
echo "-> Fichiers .java potentiellement mal placés ont été supprimés de '$MAIN_JAVA_DIR'."

# ÉTAPE 1: Génération du parser ANTLR
echo -e "\n[ÉTAPE 1/6] Génération du parser ANTLR..."
if [ ! -f "$GRAMMAR_DIR/snl.g4" ]; then
    echo "ERREUR : Le fichier de grammaire '$GRAMMAR_DIR/snl.g4' est introuvable."
    exit 1
fi

# Exécute la commande ANTLR depuis le dossier de la grammaire
(cd "$GRAMMAR_DIR" && antlr4 -visitor -o gen snl.g4)

# Vérification du succès de la génération
if [ ! -d "$GEN_DIR" ]; then
    echo "ERREUR : La génération ANTLR a échoué. Le dossier '$GEN_DIR' n'a pas été créé."
    exit 1
fi
echo "-> Parser généré avec succès dans le dossier '$GEN_DIR'."

# ÉTAPE 2: Création de l'arborescence du projet
echo -e "\n[ÉTAPE 2/6] Création de l'arborescence du projet Maven..."
mkdir -p "$PACKAGE_DIR"
echo "-> Arborescence créée : '$PACKAGE_DIR'."

# ÉTAPE 3: Déplacement des fichiers générés
echo -e "\n[ÉTAPE 3/6] Déplacement des fichiers du parser (.java)..."
# On ne déplace que les fichiers .java nécessaires à la compilation Java
mv "$GEN_DIR"/*.java "$PACKAGE_DIR/"
echo "-> Fichiers .java déplacés vers '$MAIN_JAVA_DIR/'."
echo "-> Le reste des fichiers générés est laissé dans '$GEN_DIR' pour référence."

# ÉTAPE 4: Création du fichier pom.xml
echo -e "\n[ÉTAPE 4/6] Création du fichier de configuration Maven 'pom.xml'..."
cat > pom.xml << 'EOF'
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.your_project</groupId>
    <artifactId>snl-compiler</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <!-- Utiliser 'release' est la pratique moderne pour cibler une version Java -->
        <maven.compiler.release>11</maven.compiler.release>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <!-- Dépendance essentielle pour l'exécution d'ANTLR -->
        <dependency>
            <groupId>org.antlr</groupId>
            <artifactId>antlr4-runtime</artifactId>
            <version>4.13.1</version>
        </dependency>
    </dependencies>

    <!-- Plugin pour exécuter facilement notre classe principale -->
    <build>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <mainClass>com.your_project.Compiler</mainClass>
                    <arguments>
                        <argument>test.snl</argument> <!-- Argument par défaut: le fichier test -->
                    </arguments>
                </configuration>
            </plugin>
            <!-- Plugin pour créer un "Fat JAR" qui inclut toutes les dépendances -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.5.2</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>com.your_project.Compiler</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>

    <profiles>
        <profile>
            <id>native</id>
            <build>
                <plugins>
                    <!-- Créer l'exécutable natif à partir du "Fat JAR" -->
                    <plugin>
                        <groupId>org.panteleyev</groupId>
                        <artifactId>jpackage-maven-plugin</artifactId>
                        <version>1.6.0</version>
                        <executions>
                            <execution>
                                <!-- Doit s'exécuter après le shade plugin -->
                                <phase>package</phase>
                                <goals>
                                    <goal>jpackage</goal>
                                </goals>
                            </execution>
                        </executions>
                        <configuration>
                            <name>snlc</name>
                            <appVersion>${project.version}</appVersion>
                            <vendor>SNL Project</vendor>
                            <destination>target/dist</destination>
                            <!-- jpackage prendra le Fat JAR créé par le shade plugin -->
                            <!-- On spécifie explicitement le dossier d'input -->
                            <input>${project.build.directory}</input>
                            <mainClass>com.your_project.Compiler</mainClass>
                            <mainJar>${project.build.finalName}.jar</mainJar>
                        </configuration>
                    </plugin>
                </plugins>
            </build>
        </profile>
    </profiles>
</project>
EOF
echo "-> Fichier 'pom.xml' créé avec succès."

# ÉTAPE 5: Création des fichiers sources Java
echo -e "\n[ÉTAPE 5/6] Création des fichiers sources Java..."

# Création du fichier Compiler.java (modifié pour lire un fichier en argument)
cat > "$PACKAGE_DIR/Compiler.java" << 'EOF'
package com.your_project;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class Compiler {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Erreur: Veuillez fournir le chemin du fichier SNL en argument.");
            System.exit(1);
        }
        String inputFile = args[0];
        
        System.out.println("--- Démarrage du compilateur SNL pour le fichier : " + inputFile + " ---");

        // 1. Créer un CharStream qui lit notre fichier source
        CharStream input = CharStreams.fromFileName(inputFile);

        // 2. Créer un Lexer
        snlLexer lexer = new snlLexer(input);

        // 3. Créer un buffer de tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // 4. Créer un Parser
        snlParser parser = new snlParser(tokens);

        System.out.println("\n--- Phase d'analyse syntaxique ---");
        // 5. Lancer l'analyse et obtenir l'arbre
        ParseTree tree = parser.program();

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("\n[SNL] FAILED: La compilation a échoué en raison d'erreurs de syntaxe.");
            System.exit(1);
        }
        
        System.out.println("\n--- Phase d'analyse sémantique ---");
        // 6. Créer et lancer notre visiteur
        AstVerifierVisitor verifier = new AstVerifierVisitor();
        verifier.visit(tree);

        // 7. Vérifier les erreurs sémantiques
        if (!verifier.semanticErrors.isEmpty()) {
            System.err.println("\n--- Erreurs sémantiques détectées ---");
            for (String error : verifier.semanticErrors) {
                System.err.println(error);
            }
            System.err.println("\n[SNL] FAILED: La compilation a échoué en raison d'erreurs sémantiques.");
            System.exit(1);
        }

        System.out.println("\n[SNL] SUCCEEDED: La compilation de '" + inputFile + "' s'est terminée sans erreur.");
    }
}
EOF
echo "-> Fichier 'Compiler.java' créé."

# Création du fichier AstVerifierVisitor.java
cat > "$PACKAGE_DIR/AstVerifierVisitor.java" << 'EOF'
package com.your_project;

import org.antlr.v4.runtime.ParserRuleContext;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AstVerifierVisitor extends snlBaseVisitor<String> { // NOTE: The return type is now String
    private int indentLevel = 0;
    // A stack of scopes. Each scope is a map from identifier name to its type.
    // We also store class/entity definitions to check member access.
    private Map<String, Map<String, String>> typeDefinitions = new HashMap<>();
    private String currentTypeName = null; // To know which class/entity we are currently defining

    private Deque<Map<String, String>> scopes = new ArrayDeque<>();
    public final List<String> semanticErrors = new ArrayList<>();

    private void printIndent(String message) {
        for (int i = 0; i < indentLevel; i++) System.out.print("  ");
        System.out.println(message);
    }

    private void enterScope() {
        scopes.push(new HashMap<>());
    }

    private void exitScope() {
        scopes.pop();
    }

    // Finds a symbol in the current or outer scopes.
    private String findSymbol(String name) {
        for (Map<String, String> scope : scopes) {
            if (scope.containsKey(name)) {
                return scope.get(name);
            }
        }
        return null;
    }

    // Defines a symbol in the current scope.
    private void defineSymbol(String name, String type, ParserRuleContext ctx) {
        Map<String, String> currentScope = scopes.peek();
        if (currentScope != null && currentScope.containsKey(name)) {
            String error = "Semantic Error (line " + ctx.getStart().getLine() + "): Identifier '" + name + "' is already defined in this scope.";
            semanticErrors.add(error);
        } else if (currentScope != null) {
            currentScope.put(name, type);
        }
    }

    private void checkAssignment(String lhsType, String rhsType, ParserRuleContext ctx) {
        if (lhsType == null || rhsType == null || lhsType.equals("error_type") || rhsType.equals("error_type")) {
            return; // Avoid cascade errors if the right-hand side already has an error.
        }
        if (!lhsType.equals(rhsType)) {
            String error = "Semantic Error (line " + ctx.getStart().getLine() + "): Type mismatch. Cannot assign expression of type '" + rhsType + "' to a variable of type '" + lhsType + "'.";
            semanticErrors.add(error);
        }
    }

    @Override
    public String visitProject(snlParser.ProjectContext ctx) {
        enterScope(); // Global scope
        String projectName = ctx.STRING().getText();
        String language = ctx.language().getText();
        printIndent("Vérification du projet: " + projectName + " en langage " + language);
        indentLevel++;
        visitChildren(ctx);
        indentLevel--;
        exitScope();
        return null;
    }

    @Override
    public String visitClassDecl(snlParser.ClassDeclContext ctx) {
        String className = ctx.ID(0).getText();
        String parentInfo = ctx.ID().size() > 1 ? " (hérite de " + ctx.ID(1).getText() + ")" : "";
        currentTypeName = className;
        typeDefinitions.put(className, new HashMap<>());
        defineSymbol(className, "class", ctx);
        printIndent("Détection de la classe: '" + className + "'" + parentInfo);
        enterScope();
        indentLevel++;
        visitChildren(ctx);
        indentLevel--;
        exitScope();
        currentTypeName = null;
        return null;
    }

    @Override
    public String visitFieldDecl(snlParser.FieldDeclContext ctx) {
        String visibility = ctx.visibility() != null ? ctx.visibility().getText() + " " : "";
        String type = ctx.type().getText();
        String name = ctx.ID().getText();
        defineSymbol(name, type, ctx);
        if (currentTypeName != null) {
            typeDefinitions.get(currentTypeName).put(name, type);
        }
        if (ctx.expression() != null) {
            String valueType = visit(ctx.expression());
            checkAssignment(type, valueType, ctx);
        }
        String valueInfo = ctx.expression() != null ? " = " + ctx.expression().getText() : "";
        printIndent("Détection d'un champ: " + visibility + type + " " + name + valueInfo);
        return null;
    }

    @Override
    public String visitEntityDecl(snlParser.EntityDeclContext ctx) {
        String entityName = ctx.ID().getText();
        currentTypeName = entityName;
        typeDefinitions.put(entityName, new HashMap<>());
        defineSymbol(entityName, "entity", ctx);
        printIndent("Détection de l'entité: '" + entityName + "'");
        enterScope();
        indentLevel++;
        visitChildren(ctx);
        indentLevel--;
        exitScope();
        currentTypeName = null;
        return null;
    }

    @Override
    public String visitEntityMember(snlParser.EntityMemberContext ctx) {
        String name = ctx.ID().getText();
        String type = ctx.type().getText();
        defineSymbol(name, type, ctx);
        if (currentTypeName != null) {
            typeDefinitions.get(currentTypeName).put(name, type);
        }
        if (ctx.expression() != null) {
            String valueType = visit(ctx.expression());
            checkAssignment(type, valueType, ctx);
        }
        String valueInfo = ctx.expression() != null ? " = " + ctx.expression().getText() : "";
        printIndent("Membre d'entité: " + name + " : " + type + valueInfo);
        // Ne pas appeler visitChildren ici pour éviter de descendre dans l'expression
        return null;
    }

    @Override
    public String visitMethodDecl(snlParser.MethodDeclContext ctx) {
        String methodName = ctx.ID().getText();
        String visibility = ctx.visibility() != null ? ctx.visibility().getText() + " " : "";
        defineSymbol(methodName, "method", ctx);
        printIndent("Détection de la méthode: " + visibility + "'" + methodName + "'");
        enterScope();
        indentLevel++;
        visitChildren(ctx);
        indentLevel--;
        exitScope();
        return null;
    }

    @Override
    public String visitFunctionDecl(snlParser.FunctionDeclContext ctx) {
        String funcName = ctx.ID().getText();
        defineSymbol(funcName, "function", ctx);
        printIndent("Détection de la fonction: '" + funcName + "'");
        enterScope();
        indentLevel++;
        visitChildren(ctx);
        indentLevel--;
        exitScope();
        return null;
    }

    @Override
    public String visitVarDecl(snlParser.VarDeclContext ctx) {
        String type = ctx.varDeclaration().type().getText();
        String name = ctx.varDeclaration().ID().getText();
        defineSymbol(name, type, ctx);
        if (ctx.varDeclaration().expression() != null) {
            String valueType = visit(ctx.varDeclaration().expression());
            checkAssignment(type, valueType, ctx);
        }
        String valueInfo = ctx.varDeclaration().expression() != null ? " avec l'assignation " + ctx.varDeclaration().expression().getText() : "";
        printIndent("Déclaration de variable: '" + name + "' de type '" + type + "'" + valueInfo);
        return null;
    }

    // --- Methods for evaluating expression types ---

    @Override
    public String visitNewObjectExpr(snlParser.NewObjectExprContext ctx) {
        String className = ctx.newExpr().ID().getText();
        printIndent("-> Vérification d'une instanciation : new " + className + "()");
        // The type of a 'new' expression is the class name.
        return className;
    }

    @Override
    public String visitLiteralExpr(snlParser.LiteralExprContext ctx) {
        if (ctx.literal().NUMBER() != null) return "integer";
        if (ctx.literal().FLOAT() != null) return "float";
        if (ctx.literal().STRING() != null) return "string";
        if (ctx.literal().BOOLEAN() != null) return "boolean";
        return "unknown_type";
    }

    @Override
    public String visitVarRef(snlParser.VarRefContext ctx) {
        String name = ctx.ID().getText();
        String type = findSymbol(name);
        if (type == null) {
            String error = "Semantic Error (line " + ctx.getStart().getLine() + "): Identifier '" + name + "' is not defined.";
            semanticErrors.add(error);
            return "error_type"; // Special type to prevent cascade errors
        }
        return type;
    }

    @Override
    public String visitParenExpr(snlParser.ParenExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public String visitPostfix(snlParser.PostfixContext ctx) {
        // Manually handle postfix expressions to correctly propagate types through member access chains (e.g., a.b.c)
        String currentType = visit(ctx.primary());

        for (snlParser.PostfixTailContext tail : ctx.postfixTail()) {
            if (currentType == null || currentType.equals("error_type")) {
                return "error_type"; // Stop processing if there's an error
            }

            if (tail instanceof snlParser.MemberAccessContext) {
                snlParser.MemberAccessContext memberCtx = (snlParser.MemberAccessContext) tail;
                String memberName = memberCtx.ID().getText();

                Map<String, String> members = typeDefinitions.get(currentType);
                if (members == null) {
                    semanticErrors.add("Semantic Error (line " + tail.getStart().getLine() + "): Type '" + currentType + "' is not a class or entity with members.");
                    return "error_type";
                }
                String memberType = members.get(memberName);
                if (memberType == null) {
                    semanticErrors.add("Semantic Error (line " + tail.getStart().getLine() + "): Member '" + memberName + "' not found in type '" + currentType + "'.");
                    return "error_type";
                }
                currentType = memberType; // The new type is the type of the member
            } else {
                semanticErrors.add("Semantic Error (line " + tail.getStart().getLine() + "): This type of member access (e.g., method calls, index access) is not yet supported.");
                return "error_type";
            }
        }
        return currentType;
    }

    @Override
    public String visitAssignment(snlParser.AssignmentContext ctx) {
        // In an assignment `a = b`, the type of the expression is the type of `b`.
        // We also need to check for type compatibility if it's an assignment.
        if (ctx.assignment() != null) { // This is an assignment like `x = y = 5`
            String lhsType = visit(ctx.logic_or());
            String rhsType = visit(ctx.assignment());
            checkAssignment(lhsType, rhsType, ctx);
            return lhsType;
        }
        return visit(ctx.logic_or());
    }

    @Override
    public String visitExprStmt(snlParser.ExprStmtContext ctx) {
        visit(ctx.expression());
        return null;
    }
}
EOF
echo "-> Fichier 'AstVerifierVisitor.java' créé."

# ÉTAPE 6: Création d'un fichier SNL d'exemple
echo -e "\n[ÉTAPE 6/6] Création d'un fichier d'exemple 'test.snl'..."
cat > test.snl << 'EOF'
create project "WebAppTest" with language snl {

    // Déclaration d'une entité simple
    create entity Product {
        id: integer;
        name: string;
        price: float;
    }

    // Déclaration d'une classe qui utilise l'entité
    class User {
        public string username;
        private string password;

        public void setPassword(string newPass) {
            // Logique ici
            print("Password set.");
        }
    }

    // Fonction principale du programme
    create func main {
        print("Initialisation du programme...");
        var u : User = new User();
        u.username = "test_user";

        if (10 > 5) then {
            print("La condition est vraie.");
        }

        // Erreur sémantique : Incompatibilité de type
        var i : integer = "ceci n'est pas un entier";
    }
}
EOF
echo "-> Fichier 'test.snl' créé."

echo -e "\n====================================================="
echo "  Configuration terminée avec succès ! "
echo "====================================================="
echo -e "\nProchaines étapes :"
echo "1. Compilez le projet avec Maven :"
echo "   mvn clean install"
echo "2. Pour exécuter le code source directement :"
echo "   mvn clean compile exec:java"
echo "3. Pour créer l'exécutable natif (nécessite JDK 16+) :"
echo "   mvn clean package -Pnative"
echo "   -> L'exécutable sera dans 'target/dist/snlc/'"
echo ""