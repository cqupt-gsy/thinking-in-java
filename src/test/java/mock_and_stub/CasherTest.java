package mock_and_stub;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CasherTest {

    private Casher casher;

    @Before
    public void setUp() throws Exception {
        casher = new Casher();
    }

    @Test
    public void shouldCallMockPrintWhenCasherPrint() {
        //Given
        FakePrint fakePrint = new FakePrint();
        casher.setPrint(fakePrint);

        //When
        casher.print("Hello World!");

        //Then
        assertTrue(fakePrint.isPrint());
    }

    @Test
    public void shouldStubPrintWhenCasherPrint() {
        //Given
        FakePrint fakePrint = new FakePrint();
        casher.setPrint(fakePrint);

        //When
        casher.print("Hello World!");

        //Then
        assertThat(fakePrint.printString(), is("Hello World!"));

    }
}
