package example.practise.katas.katate_conflict_objective;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static com.google.common.base.Stopwatch.createStarted;

public class ConflictObjectiveTest {

    @Test
    public void shouldReturnConflictObjective() throws IOException {
        final ConflictObjective conflictObjective = new ConflictObjective();
        Stopwatch timer = createStarted();
        List<String> objective = conflictObjective.generateConflictObjective();
        timer.stop();
        System.out.println(timer.toString());
        System.out.println(objective.size());
    }

    @Test
    public void shouldReturnConflictObjectiveWithLengthConstruct() throws IOException {
        final ConflictObjective conflictObjective = new ConflictObjective(6);
        Stopwatch timer = createStarted();
        List<String> objective = conflictObjective.generateConflictObjective();
        timer.stop();
        System.out.println(timer.toString());
        System.out.println(objective.size());
    }
}