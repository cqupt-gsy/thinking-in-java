package example.practise.katas.karate_anagrams;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnagramsGeneratorTest {

    @Test
    public void shouldReturnAnagramsList() throws IOException {
        //Given
        AnagramsGenerator anagramsGenerator = new AnagramsGenerator();

        //When
        Map<String, List<String>> result = anagramsGenerator.generateAnagrams();

        //Then
        System.out.println(result.size());
        System.out.println(result.get("aepst"));
    }
}