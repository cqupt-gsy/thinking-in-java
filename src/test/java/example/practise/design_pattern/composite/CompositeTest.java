package example.practise.design_pattern.composite;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompositeTest {

    @Test
    public void shouldReturnCompositeStructure() {
        //Given
        Composite composite = new Composite("root");
        composite.addChild(new Child("childA"));
        composite.addChild(new Child("childA"));
        Composite secondLevel = new Composite("childC");
        secondLevel.addChild(new Child("childCA"));
        secondLevel.addChild(new Child("childCB"));
        Composite thirdLevel = new Composite("childCC");
        thirdLevel.addChild(new Child("childCCA"));
        thirdLevel.addChild(new Child("childCCB"));
        secondLevel.addChild(thirdLevel);
        composite.addChild(secondLevel);

        //When
        String result = composite.display(0);

        //Then
        assertThat(result, is("root\n" +
                "--childA\n" +
                "--childA\n" +
                "--childC\n" +
                "----childCA\n" +
                "----childCB\n" +
                "----childCC\n" +
                "------childCCA\n" +
                "------childCCB\n"));
    }
}
