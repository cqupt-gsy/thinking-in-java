package programming.practise.design_pattern.facade;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FacadeClassTest {

    private FacadeClass facadeClass;
    private OldClassOne classOne;
    private OldClassTwo classTwo;
    private OldClassThree classThree;

    @Before
    public void setUp() throws Exception {
        classOne = mock(OldClassOne.class);
        classTwo = mock(OldClassTwo.class);
        classThree = mock(OldClassThree.class);
        facadeClass = new FacadeClass(classOne, classTwo, classThree);
    }

    @Test
    public void shouldExecuteComlicateMethodCallInFacadeClass() {
        //Given
        given(classOne.methodCall()).willReturn("Old Class One Call");
        given(classTwo.dealWithDatabase()).willReturn("Old Class Two Call");
        given(classThree.dealWithHttp()).willReturn("Old Class Three Call");

        //When
        facadeClass.easyApiCall();

        //Then
        verify(classOne, times(1)).methodCall();
        verify(classTwo, times(1)).dealWithDatabase();
        verify(classThree, times(1)).dealWithHttp();
    }
}
