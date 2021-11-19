import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import fr.epsi.core.MathUtils;
import fr.epsi.core.StringUtils;

class StringUtilsTests {

	@Test
	void test() {

	}

	@ParameterizedTest(name = "{0} est pas palindrome") // {0} sera remplacé par le 1e argument
	@ValueSource(strings = { "bob" }) // Le test sera lancé 6 fois
	void isPalindrome(String phrase) {
		assertTrue(StringUtils.isPalindrome(phrase));
	}
	
	@ParameterizedTest(name = "{0} n'est pas palindrome") // {0} sera remplacé par le 1e argument
	@ValueSource(strings = { "bobh" }) // Le test sera lancé 6 fois
	void isNotPalindrome(String phrase) {
		assertFalse(StringUtils.isPalindrome(phrase));
	}

	@ParameterizedTest(name = "{0} encodee :{1}  ")
    @CsvFileSource(resources = "/cesar.csv", numLinesToSkip = 1)

    void cesarEncode(String sentence, String request, int step) {
        assertEquals(request, StringUtils.cesarEncode(sentence, step));

    }

    @ParameterizedTest(name = "{1} decodee  :{0}  ")
    @CsvFileSource(resources = "/cesar.csv", numLinesToSkip = 1)

    void cesarDecode(String sentence, String request, int step) {
        assertEquals(sentence, StringUtils.cesarDecode(request, step));
    }
}
