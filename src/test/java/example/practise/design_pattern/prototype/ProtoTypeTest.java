package example.practise.design_pattern.prototype;

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
        Person gsy = new Person("gsy", 12);
        protoType.setPerson(gsy);
        Person wh = new Person("wh", 24);
        protoType.setPerson_1(wh);

        //When
        ProtoType cloneProtoType = (ProtoType) protoType.clone();

        //Then
        assertThat(cloneProtoType.getPerson().getName(), is("gsy"));
        assertThat(cloneProtoType.getPerson().getValue(), is(12));
        assertThat(cloneProtoType.getPerson_1().getName(), is("wh"));
        assertThat(cloneProtoType.getPerson_1().getValue(), is(24));

        gsy.setName("hello");
        gsy.setAge(11);
        wh.setName("world");
        wh.setAge(22);

        assertThat(protoType.getPerson().getName(), is("hello"));
        assertThat(protoType.getPerson().getValue(), is(11));
        assertThat(protoType.getPerson_1().getName(), is("wh"));
        assertThat(protoType.getPerson_1().getValue(), is(24));

        assertThat(cloneProtoType.getPerson().getName(), is("hello"));
        assertThat(cloneProtoType.getPerson().getValue(), is(11));
        assertThat(cloneProtoType.getPerson_1().getName(), is("wh"));
        assertThat(cloneProtoType.getPerson_1().getValue(), is(24));

    }
}
