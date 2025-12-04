package br.com.dse.anagram;

import java.util.ArrayList;
import java.util.List;

/**
 * Utilitário responsável por gerar todos os anagramas possíveis
 * a partir de uma sequência de letras distintas.
 *
 * <p>Exemplo: entrada "abc" gera:
 * abc, acb, bac, bca, cab, cba.</p>
 *
 * <p>Regras de validação:
 * <ul>
 *   <li>Entrada não pode ser nula;</li>
 *   <li>Entrada não pode ser vazia;</li>
 *   <li>Entrada deve conter apenas letras (a-z ou A-Z).</li>
 * </ul>
 * Em caso de violação, será lançada {@link IllegalArgumentException}.</p>
 */
public class AnagramGenerator {

    /**
     * Gera todos os anagramas possíveis de uma string de letras distintas.
     *
     * @param input sequência de letras (não nula, não vazia, apenas letras)
     * @return lista contendo todos os anagramas possíveis
     * @throws IllegalArgumentException se a entrada for nula, vazia ou contiver caracteres não alfabéticos
     */
    public List<String> generateAnagrams(String input) {
        // Validação de entrada (não-nulo, não-vazio, apenas letras)
        if (input == null || input.isEmpty() || !input.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("A entrada não deve ser vazia e deve conter apenas letras (a-zA-Z).");
        }

        List<String> results = new ArrayList<>();

        // Início da recursão de permutação
        permute(input, "", results);

        return results;
    }

    /**
     * Método recursivo (backtracking) que constrói todos os anagramas possíveis.
     *
     * @param remaining caracteres que ainda não foram utilizados
     * @param current   construção parcial do anagrama atual
     * @param results   coleção onde os anagramas completos serão armazenados
     */
    private void permute(String remaining, String current, List<String> results) {
        // Caso base: quando não há mais caracteres disponíveis,
        // significa que o anagrama atual está completo.
        if (remaining.isEmpty()) {
            results.add(current);
            return;
        }

        // Caso recursivo: escolhe cada caractere possível da string "remaining",
        // adiciona em "current" e chama recursivamente para o restante.
        for (int i = 0; i < remaining.length(); i++) {
            char charToMove = remaining.charAt(i);

            // Cria nova string 'remaining' sem o caractere escolhido
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            // Avança a recursão com o caractere escolhido concatenado à string atual
            permute(newRemaining, current + charToMove, results);
        }
    }
}


