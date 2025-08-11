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
