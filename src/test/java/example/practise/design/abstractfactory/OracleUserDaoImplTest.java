package example.practise.design.abstractfactory;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OracleUserDaoImplTest {

    private OracleUserDaoImpl oracleUserDao;

    @Before
    public void setUp() throws Exception {
        oracleUserDao = new OracleUserDaoImpl();
    }

    @Test
    public void shouldReturnInsertResultString() {
        //When
        String insertResult = oracleUserDao.insertUser("GSY");

        //Then
        assertThat(insertResult, is("Oracle Insert User: GSY"));
    }

    @Test
    public void shouldReturnDeleteResultString() {
        //When
        String deleteResult = oracleUserDao.deleteUser("GSY");

        //Then
        assertThat(deleteResult, is("Oracle Delete User: GSY"));
    }

    @Test
    public void shouldReturnUpdateResultString() {
        //When
        String updateString = oracleUserDao.updateUser("GSY");

        //Then
        assertThat(updateString, is("Oracle Update User: GSY"));
    }

    @Test
    public void shouldReturnQueryResultString() {
        //When
        String queryString = oracleUserDao.quertUser("GSY");

        //Then
        assertThat(queryString, is("Oracle Query User: GSY"));


    }
}
