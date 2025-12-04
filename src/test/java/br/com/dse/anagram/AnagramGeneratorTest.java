package br.com.dse.anagram;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testes unitários para {@link AnagramGenerator}.
 *
 * <p>Os casos de teste seguem os requisitos do enunciado:
 * <ul>
 *     <li>Entrada com três letras distintas ("abc");</li>
 *     <li>Entrada com uma única letra ("Z");</li>
 *     <li>Validação de entrada vazia (deve lançar exceção).</li>
 * </ul>
 * </p>
 */
public class AnagramGeneratorTest {

    private final AnagramGenerator generator = new AnagramGenerator();

    @Test
    public void testThreeDistinctLetters() {
        String input = "abc";
        List<String> expected = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");

        List<String> actual = generator.generateAnagrams(input);

        // 3! = 6 combinações
        assertEquals(6, actual.size());
        assertTrue(actual.containsAll(expected) && expected.containsAll(actual));
    }

    @Test
    public void testSingleLetterInput() {
        String input = "Z";

        List<String> actual = generator.generateAnagrams(input);

        assertEquals(Collections.singletonList("Z"), actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyInputValidation() {
        generator.generateAnagrams("");
    }
}


