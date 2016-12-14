package example.practise.design.prototype;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProtoTypeTest {

    private ProtoType protoType;

    @Before
    public void setUp() throws Exception {
        protoType = new ProtoType();
    }

    @Test
    public void shouldReturnACopyOfProtoTypeClass() throws CloneNotSupportedException {
        //Given
        protoType.setName("Hello");
        protoType.setValue(12);

        //When
        ProtoType cloneProtoType = (ProtoType) protoType.clone();

        //Then
        assertThat(cloneProtoType.getName(), is("Hello"));
        assertThat(cloneProtoType.getValue(), is(12));
    }

    @Test
    public void shouldReturnACopyOfProtoTypeClassWithDifferentValue() throws CloneNotSupportedException {
        //When
        ProtoType cloneProtoType = (ProtoType) protoType.clone();
        cloneProtoType.setName("ABC");
        cloneProtoType.setValue(11);

        //Then
        assertThat(cloneProtoType.getName(), is("ABC"));
        assertThat(cloneProtoType.getValue(), is(11));
    }

    @Test
    public void shouldReturnACopyOfProtoTypeClassWithDifferentReferenceValue() throws CloneNotSupportedException {
        //Given
        protoType.setPerson(new Person("gsy", 12));

        //When
        ProtoType cloneProtoType = (ProtoType) protoType.clone();

        //Then
        assertThat(cloneProtoType.getPerson().getName(), is("gsy"));
        assertThat(cloneProtoType.getPerson().getValue(), is(12));

        cloneProtoType.setPerson(new Person("hello", 56));

        assertThat(cloneProtoType.getPerson().getName(), is("hello"));
        assertThat(cloneProtoType.getPerson().getValue(), is(56));
        assertThat(protoType.getPerson().getName(), is("gsy"));
        assertThat(protoType.getPerson().getValue(), is(12));

    }
}