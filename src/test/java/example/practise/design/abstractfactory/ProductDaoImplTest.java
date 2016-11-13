package example.practise.design.abstractfactory;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public abstract class ProductDaoImplTest {
    protected ProductDao productDao;

    @Test
    public void shouldReturnInsertOracleProductResultString() {
        //When
        String resultString = productDao.insertProduct("iPhone");

        //Then
        assertThat(resultString, is(getDatabaseName() + "Insert Product iPhone"));
    }


    @Test
    public void shouldReturnDeleteOracleProductResultString() {
        //When
        String resultString = productDao.deleteProduct("iPhone");

        //Then
        assertThat(resultString, is(getDatabaseName() + "Delete Product iPhone"));
    }

    @Test
    public void shouldReturnUpdateOracleProductResultString() {
        //When
        String resultString = productDao.updateProduct("iPhone");

        //Then
        assertThat(resultString, is(getDatabaseName() + "Update Product iPhone"));
    }

    @Test
    public void shouldReturnQueryOracleProductResultString() {
        //When
        String resultString = productDao.queryProduct("iPhone");

        //Then
        assertThat(resultString, is(getDatabaseName() + "Query Product iPhone"));
    }

    public abstract String getDatabaseName();
}
