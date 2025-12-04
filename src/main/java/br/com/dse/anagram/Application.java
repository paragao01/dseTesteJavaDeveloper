package br.com.dse.anagram;

import java.util.List;
import java.util.Scanner;

/**
 * Classe de entrada da aplicação (console).
 *
 * <p>Permite ao usuário digitar um grupo de letras e
 * imprime todos os anagramas possíveis utilizando
 * {@link AnagramGenerator}.</p>
 */
public class Application {

    public static void main(String[] args) {
        AnagramGenerator generator = new AnagramGenerator();

        // Caso o usuário passe o parâmetro diretamente na linha de comando
        if (args.length == 1) {
            executarComEntrada(generator, args[0]);
            return;
        }

        // Modo interativo via console
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== Gerador de Anagramas (DSE) ===");
            System.out.print("Informe uma sequência de letras distintas (ex: abc): ");
            String input = scanner.nextLine();
            executarComEntrada(generator, input);
        }
    }

    private static void executarComEntrada(AnagramGenerator generator, String input) {
        try {
            List<String> anagrams = generator.generateAnagrams(input);

            System.out.println("Total de anagramas gerados: " + anagrams.size());
            for (String s : anagrams) {
                System.out.println(s);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Erro de validação: " + e.getMessage());
            System.exit(1);
        }
    }
}


