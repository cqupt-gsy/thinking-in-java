package example.practise.design.builder;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BuilderTest {

    private Builder builder;

    @Before
    public void setUp() throws Exception {
        builder = new Builder();
    }

    @Test
    public void shouldReturnPersonInformationWhenBuildBigPerson() {
        //When
        builder.buildArms("big arm");
        builder.buildLegs("big leg");
        Person person = builder.createPerson();

        //Then
        assertThat(person.toString(), is("big arm big leg"));
    }
    @Test
    public void shouldReturnPersonInformationWhenBuildSmallPerson() {
        //When
        builder.buildArms("small arm");
        builder.buildLegs("small leg");
        Person person = builder.createPerson();

        //Then
        assertThat(person.toString(), is("small arm small leg"));
    }

    @Test
    public void shouldReturnPersonUsingDirect() {
        //Given
        Direct direct = new Direct();

        //When
        Person person = direct.createPerson();

        //Then
        assertThat(person.toString(), is("middle arm middle leg"));

    }
}
