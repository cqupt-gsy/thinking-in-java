package programming.practise.katas.karate_anagrams;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Stopwatch.createStarted;
import static org.assertj.core.api.Assertions.assertThat;

public class AnagramsGeneratorTest {

    @Test
    public void shouldReturnAnagramsList() throws IOException {
        //Given
        AnagramsGenerator anagramsGenerator = new AnagramsGenerator();

        //When
        Stopwatch timer = createStarted();
        Map<String, List<String>> result = anagramsGenerator.generateAnagrams();
        timer.stop();
        System.out.println(timer.toString());

        //Then
        assertThat(result.size()).isEqualTo(20683);
        assertThat(result.get("hiiknps")).containsExactly("kinship", "pinkish");
        assertThat(result.get("eilnst")).containsExactly("elints","enlist", "inlets", "listen", "silent", "tinsel");
        assertThat(result.get("abeorst")).containsExactly("boaster", "boaters", "borates", "rebatos", "sorbate");
        assertThat(result.get("eefhrrs")).containsExactly("fresher", "refresh");
        assertThat(result.get("iknss")).containsExactly("sinks", "skins");
        assertThat(result.get("iknst")).containsExactly("knits", "skint", "stink", "tinks");
        assertThat(result.get("orst")).containsExactly("orts", "rots", "sort", "stor", "tors");
        assertThat(result.get("ceiprstu")).containsExactly("crepitus", "cuprites", "pictures", "piecrust");
        assertThat(result.get("aepst")).containsExactly("paste", "pates", "peats", "septa", "spate", "tapes", "tepas");
        assertThat(result.get("ciilnoptu")).containsExactly("punctilio", "unpolitic");
        assertThat(result.get("denrssu")).containsExactly("sunders", "undress");
    }
}