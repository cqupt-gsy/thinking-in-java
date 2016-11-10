package example.practise.design.abstractfactory.oracle;

import example.practise.design.abstractfactory.ProductDao;
import example.practise.design.abstractfactory.oracle.OracleProductDaoImpl;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OracleProductDaoImplImplTest {

    private ProductDao productDao;

    @Before
    public void setUp() throws Exception {
        productDao = new OracleProductDaoImpl();
    }

    @Test
    public void shouldReturnInsertOracleProductResultString() {
        //When
        String resultString = productDao.insertProduct("iPhone");

        //Then
        assertThat(resultString, is("Oracle Insert Product iPhone"));
    }

    @Test
    public void shouldReturnDeleteOracleProductResultString() {
        //When
        String resultString = productDao.deleteProduct("iPhone");

        //Then
        assertThat(resultString, is("Oracle Delete Product iPhone"));
    }

    @Test
    public void shouldReturnUpdateOracleProductResultString() {
        //When
        String resultString = productDao.updateProduct("iPhone");

        //Then
        assertThat(resultString, is("Oracle Update Product iPhone"));
    }

    @Test
    public void shouldReturnQueryOracleProductResultString() {
        //When
        String resultString = productDao.queryProduct("iPhone");

        //Then
        assertThat(resultString, is("Oracle Query Product iPhone"));
    }

}
