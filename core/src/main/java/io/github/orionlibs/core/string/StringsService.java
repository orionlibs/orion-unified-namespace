package io.github.orionlibs.core.string;

import io.github.orionlibs.core.exception.Assert;
import io.github.orionlibs.core.string.tasks.ArePermutationsOfEachOtherTask;
import io.github.orionlibs.core.string.tasks.ConcatenateSeparatedBySpaceTask;
import io.github.orionlibs.core.string.tasks.ConcatenateTask;
import io.github.orionlibs.core.string.tasks.ConnectStringsByStringTask;
import io.github.orionlibs.core.string.tasks.ConvertFirstCharacterOfEachWordToUppercaseTask;
import io.github.orionlibs.core.string.tasks.ConvertFirstCharacterToUppercaseTask;
import io.github.orionlibs.core.string.tasks.ConvertToCommaAndSpaceSeparatedStringTask;
import io.github.orionlibs.core.string.tasks.ConvertToCommaSeparatedStringTask;
import io.github.orionlibs.core.string.tasks.CopyFromTheBeginningUpToTask;
import io.github.orionlibs.core.string.tasks.CopyStringTask;
import io.github.orionlibs.core.string.tasks.DeleteCharacterFromTheEndTask;
import io.github.orionlibs.core.string.tasks.DeleteLineSeparatorFromTheEndTask;
import io.github.orionlibs.core.string.tasks.DoesMatchRegularExpressionTask;
import io.github.orionlibs.core.string.tasks.DoesStringEndWithAnyTask;
import io.github.orionlibs.core.string.tasks.DoesStringStartWithAnyTask;
import io.github.orionlibs.core.string.tasks.FormatWith2CharactersTask;
import io.github.orionlibs.core.string.tasks.GenerateRandomNumericCodeTask;
import io.github.orionlibs.core.string.tasks.GenerateRandomStringTask;
import io.github.orionlibs.core.string.tasks.GetAlphabeticalValueTask;
import io.github.orionlibs.core.string.tasks.GetHashCodeTask;
import io.github.orionlibs.core.string.tasks.GetLongestCommonSubstringTask;
import io.github.orionlibs.core.string.tasks.GetSimilarityPercentageBetweenTask;
import io.github.orionlibs.core.string.tasks.IsLastCharacterAWhitespaceTask;
import io.github.orionlibs.core.string.tasks.IsOnlyAlphabeticalTask;
import io.github.orionlibs.core.string.tasks.IsOnlyAlphabeticalWithHyphensAndSpacesTask;
import io.github.orionlibs.core.string.tasks.IsOnlyAlphabeticalWithHyphensTask;
import io.github.orionlibs.core.string.tasks.PermuteStringTask;
import io.github.orionlibs.core.string.tasks.PrefixStringTask;
import io.github.orionlibs.core.string.tasks.SeparateByStringTask;
import io.github.orionlibs.core.string.tasks.ShuffleStringTask;
import io.github.orionlibs.core.string.tasks.SurroundWithStringTask;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

public class StringsService
{
    private static final String Symbols = "[; !\"#$%&'()*+,-./:=?@^_~]*";
    private static final String SymbolsExceptForHyphenAndSpace = "[;!\"#$%&'()*+,./:=?@^_~]*";


    public static boolean arePermutationsOfEachOther(String s1, String s2)
    {
        return ArePermutationsOfEachOtherTask.run(s1, s2);
    }


    public static List<String> permuteString(String s)
    {
        return new PermuteStringTask().run(s);
    }


    public static double getSimilarityPercentageBetween(String s1, String s2)
    {
        return GetSimilarityPercentageBetweenTask.run(s1, s2);
    }


    public static String convertFirstCharacterToUppercase(String aString)
    {
        return ConvertFirstCharacterToUppercaseTask.run(aString);
    }


    public static String convertFirstCharacterOfEachWordToUppercase(String[] stringTokens)
    {
        return ConvertFirstCharacterOfEachWordToUppercaseTask.run(stringTokens);
    }


    public static String convertFirstCharacterOfEachWordToUppercase(String aString)
    {
        return ConvertFirstCharacterOfEachWordToUppercaseTask.run(aString);
    }


    public static String deleteLineSeparatorFromTheEnd(String aString)
    {
        return DeleteLineSeparatorFromTheEndTask.run(aString);
    }


    public static String deleteCharacterFromTheEnd(String aString, String characterToDelete)
    {
        return DeleteCharacterFromTheEndTask.run(aString, characterToDelete);
    }


    public static StringBuilder deleteLineSeparatorFromTheEnd(StringBuilder stringBuilder)
    {
        Assert.notNull(stringBuilder, "The stringBuilder input cannot be null.");
        return new StringBuilder(deleteLineSeparatorFromTheEnd(stringBuilder.toString()));
    }


    public static StringBuilder deleteCharacterFromTheEnd(StringBuilder stringBuilder, String characterToDelete)
    {
        Assert.notNull(stringBuilder, "The stringBuilder input cannot be null.");
        return new StringBuilder(deleteCharacterFromTheEnd(stringBuilder.toString(), characterToDelete));
    }


    public static boolean isNotEmpty(String aString)
    {
        return aString != null && !aString.isEmpty();
    }


    public static boolean isEmpty(String aString)
    {
        return !isNotEmpty(aString);
    }


    public static char getLastCharacter(String aString)
    {
        Assert.notEmpty(aString, "The string input cannot be null/empty.");
        return aString.charAt(aString.length() - 1);
    }


    public static String getLastCharacterAsString(String aString)
    {
        return Character.toString(getLastCharacter(aString));
    }


    public static char getFirstCharacter(String aString)
    {
        Assert.notEmpty(aString, "The string input cannot be null/empty.");
        return aString.charAt(0);
    }


    public static String getFirstCharacterAsString(String aString)
    {
        return Character.toString(getFirstCharacter(aString));
    }


    public static boolean isWhitespace(char character)
    {
        return Character.isWhitespace(character);
    }


    public static boolean isWhitespace(String character)
    {
        Assert.hasLength(character, 1, "The character input has to have only 1 character.");
        return Character.isWhitespace(character.charAt(0));
    }


    public static boolean isNthCharacterADigit(String aString, int n)
    {
        return Character.isDigit(aString.charAt(n));
    }


    public static boolean isNthCharacterNotADigit(String aString, int n)
    {
        return !isNthCharacterADigit(aString, n);
    }


    public static boolean isLastCharacterAWhitespace(String aString)
    {
        return IsLastCharacterAWhitespaceTask.run(aString);
    }


    public static boolean isLastCharacterNotAWhitespace(String aString)
    {
        return !isLastCharacterAWhitespace(aString);
    }


    public static String surroundWithSingleQuotes(String aString)
    {
        return surroundWithString(aString, "'");
    }


    public static String surroundWithDoubleQuotes(String aString)
    {
        return surroundWithString(aString, "\"");
    }


    public static String surroundWithParentheses(String aString)
    {
        return surroundWithString(aString, "(", ")");
    }


    public static String surroundWithSquareBrackets(String aString)
    {
        return surroundWithString(aString, "[", "]");
    }


    public static String surroundWithAngleBrackets(String aString)
    {
        return surroundWithString(aString, "<", ">");
    }


    public static String surroundWithString(String aString, String stringToSurroundInputWith)
    {
        return SurroundWithStringTask.run(aString, "'");
    }


    public static String surroundWithString(String aString, String stringPrefix, String stringSuffix)
    {
        return SurroundWithStringTask.run(aString, stringPrefix, stringSuffix);
    }


    public static String convertToCommaSeparatedString(List<String> strings)
    {
        return ConvertToCommaSeparatedStringTask.run(strings);
    }


    public static String convertToCommaAndSpaceSeparatedString(List<String> strings)
    {
        return ConvertToCommaAndSpaceSeparatedStringTask.run(strings);
    }


    public static String separateByString(List<String> strings, String separator)
    {
        return SeparateByStringTask.run(strings, separator);
    }


    public static String shuffleString(String stringToShuffle)
    {
        return ShuffleStringTask.run(stringToShuffle);
    }


    public static String copy(String stringToCopy)
    {
        return CopyStringTask.run(stringToCopy);
    }


    public static String copy(String stringToCopyFrom, int indexToCopyFrom)
    {
        return CopyStringTask.run(stringToCopyFrom, indexToCopyFrom);
    }


    public static String copy(String stringToCopyFrom, int indexToCopyFrom, int indexToCopyTo)
    {
        return CopyStringTask.run(stringToCopyFrom, indexToCopyFrom, indexToCopyTo);
    }


    public static String copyFromTheBeginningUpTo(String stringToCopyFrom, int indexToCopyTo)
    {
        return CopyFromTheBeginningUpToTask.run(stringToCopyFrom, indexToCopyTo);
    }


    public static boolean doSubstringsMatch(String string1, int string1Offset, String string2, int string2Offset, int lengthOfSubstringToCheck)
    {
        Assert.notEmpty(string1, "The string1 input cannot be null/empty.");
        return string1.regionMatches(string1Offset, string2, string2Offset, lengthOfSubstringToCheck);
    }


    public static boolean doSubstringsMatch(boolean ignoreCase, String string1, int string1Offset, String string2, int string2Offset, int lengthOfSubstringToCheck)
    {
        Assert.notEmpty(string1, "The string1 input cannot be null/empty.");
        return string1.regionMatches(ignoreCase, string1Offset, string2, string2Offset, lengthOfSubstringToCheck);
    }


    public static String concatenate(String... strings)
    {
        return ConcatenateTask.run(strings);
    }


    public static String concatenateSeparatedBySpace(String... strings)
    {
        return ConcatenateSeparatedBySpaceTask.run(strings);
    }


    public static String concatenate(Collection<String> strings)
    {
        return ConcatenateTask.run(strings);
    }


    public static String concatenateSeparatedBySpace(List<String> strings)
    {
        return ConcatenateSeparatedBySpaceTask.run(strings);
    }


    public static String connectStringsByString(String connectorString, String... strings)
    {
        return ConnectStringsByStringTask.run(connectorString, strings);
    }


    public static String connectStringsByString(String connectorString, List<String> strings)
    {
        return ConnectStringsByStringTask.run(connectorString, strings);
    }


    public static String toLowerCase(String aString, int fromIndex, int toIndex)
    {
        Assert.notEmpty(aString, "The string input cannot be null/empty.");
        return aString.substring(0, fromIndex) + aString.substring(fromIndex, toIndex + 1).toLowerCase() + aString.substring(toIndex + 1);
    }


    public static String toUpperCase(String aString, int fromIndex, int toIndex)
    {
        Assert.notEmpty(aString, "The string input cannot be null/empty.");
        return aString.substring(0, fromIndex) + aString.substring(fromIndex, toIndex + 1).toUpperCase() + aString.substring(toIndex + 1);
    }


    public static String deleteCharacterAtPosition(String aString, int indexToDeleteCharacterAt)
    {
        Assert.notEmpty(aString, "The string input cannot be null/empty.");
        return aString.substring(0, indexToDeleteCharacterAt) + aString.substring(indexToDeleteCharacterAt + 1);
    }


    public static String delete(String aString, int startIndex, int endIndex)
    {
        Assert.notEmpty(aString, "The string input cannot be null/empty.");
        return aString.substring(0, startIndex) + aString.substring(endIndex + 1);
    }


    public static int getHashCode(String s)
    {
        return GetHashCodeTask.run(s);
    }


    public static boolean arePalindromes(String s1, String s2)
    {
        Assert.notEmpty(s1, "The s1 input cannot be null/empty.");
        return s1.equals(new StringBuilder(s2).reverse().toString());
    }


    public static boolean isPalindrome(String s)
    {
        Assert.notEmpty(s, "The s input cannot be null/empty.");
        return s.equals(new StringBuilder(s).reverse().toString());
    }


    public static int getAlphabeticalValue(char c)
    {
        return GetAlphabeticalValueTask.run(c);
    }


    public static List<String> rotateString(String string)
    {
        Assert.notEmpty(string, "The string input cannot be null/empty.");
        List<String> rotations = new ArrayList<String>();
        IntStream.range(0, string.length()).forEach(i -> rotations.add(string.substring(i) + string.substring(0, i)));
        return rotations;
    }


    public static String getLongestCommonSubstring(String s1, String s2)
    {
        return GetLongestCommonSubstringTask.run(s1, s2);
    }


    public static boolean isOnlyAlphabetical(String s)
    {
        return IsOnlyAlphabeticalTask.run(s);
    }


    public static boolean isOnlyAlphabeticalWithHyphens(String s)
    {
        return IsOnlyAlphabeticalWithHyphensTask.run(s);
    }


    public static boolean isOnlyAlphabeticalWithHyphensAndSpaces(String s)
    {
        return IsOnlyAlphabeticalWithHyphensAndSpacesTask.run(s);
    }


    public static boolean isNotOnlyAlphabetical(String s)
    {
        return !isOnlyAlphabetical(s);
    }


    public static boolean isNotOnlyAlphabeticalWithHyphens(String s)
    {
        return !isOnlyAlphabeticalWithHyphens(s);
    }


    public static boolean isNotOnlyAlphabeticalWithHyphensAndSpaces(String s)
    {
        return !isOnlyAlphabeticalWithHyphensAndSpaces(s);
    }


    public static String generateRandomString(int length, boolean useSymbols)
    {
        return GenerateRandomStringTask.run(length, useSymbols);
    }


    public static String generateRandomNumericCode(int length)
    {
        return GenerateRandomNumericCodeTask.run(length);
    }


    public static String prefixString(String s, String prefix)
    {
        return PrefixStringTask.run(s, prefix);
    }


    public static String deleteSymbolCharacters(String s)
    {
        return s.replaceAll(Symbols, "");
    }


    public static String deleteSymbolCharactersExceptForHyphenAndSpace(String s)
    {
        return s.replaceAll(SymbolsExceptForHyphenAndSpace, "");
    }


    public static boolean doesMatchRegularExpression(String s, String regularExpression)
    {
        return DoesMatchRegularExpressionTask.run(s, regularExpression);
    }


    public static boolean doesStartWithAny(String s, List<String> stringsToCheck)
    {
        return DoesStringStartWithAnyTask.run(s, stringsToCheck);
    }


    public static boolean doesEndWithAny(String s, List<String> stringsToCheck)
    {
        return DoesStringEndWithAnyTask.run(s, stringsToCheck);
    }


    public static String formatWith2Characters(int value)
    {
        return FormatWith2CharactersTask.run(value);
    }


    public static String formatWith2Characters(long value)
    {
        return FormatWith2CharactersTask.run(value);
    }
}