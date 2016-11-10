package example.practise.design.abstractfactory.oracle;

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
    public void shouldReturnInsertOracleUserResultString() {
        //When
        String insertResult = oracleUserDao.insertUser("GSY");

        //Then
        assertThat(insertResult, is("Oracle Insert User GSY"));
    }

    @Test
    public void shouldReturnDeleteOracleUserResultString() {
        //When
        String deleteResult = oracleUserDao.deleteUser("GSY");

        //Then
        assertThat(deleteResult, is("Oracle Delete User GSY"));
    }

    @Test
    public void shouldReturnUpdateOracleUserResultString() {
        //When
        String updateString = oracleUserDao.updateUser("GSY");

        //Then
        assertThat(updateString, is("Oracle Update User GSY"));
    }

    @Test
    public void shouldReturnQueryOracleUserResultString() {
        //When
        String queryString = oracleUserDao.queryUser("GSY");

        //Then
        assertThat(queryString, is("Oracle Query User GSY"));
    }
}
