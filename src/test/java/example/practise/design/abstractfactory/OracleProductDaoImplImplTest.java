package example.practise.design.abstractfactory;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OracleProductDaoImplImplTest {

    private OracleProductDaoImpl oracleProductDaoImpl;

    @Before
    public void setUp() throws Exception {
        oracleProductDaoImpl = new OracleProductDaoImpl();
    }

    @Test
    public void shouldReturnInsertOracleProductResultString() {
        //When
        String resultString = oracleProductDaoImpl.insertProduct("iPhone");

        //Then
        assertThat(resultString, is("Oracle Insert Product iPhone"));
    }

    @Test
    public void shouldReturnDeleteOracleProductResultString() {
        //When
        String resultString = oracleProductDaoImpl.deleteProduct("iPhone");

        //Then
        assertThat(resultString, is("Oracle Delete Product iPhone"));
    }

    @Test
    public void shouldReturnUpdateOracleProductResultString() {
        //When
        String resultString = oracleProductDaoImpl.updateProduct("iPhone");

        //Then
        assertThat(resultString, is("Oracle Update Product iPhone"));
    }

    @Test
    public void shouldReturnQueryOracleProductResultString() {
        //When
        String resultString = oracleProductDaoImpl.queryProduct("iPhone");

        //Then
        assertThat(resultString, is("Oracle Query Product iPhone"));
    }

}
