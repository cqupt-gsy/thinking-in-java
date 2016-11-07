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
    public void shouldReturnInsertString() {
        //When
        String insertResult = oracleUserDao.insertUser("GSY");

        //Then
        assertThat(insertResult, is("Oracle Insert User: GSY"));
    }

    @Test
    public void shouldReturnDeleteString() {
        //When
        String deleteResult = oracleUserDao.deleteUser("GSY");

        //Then
        assertThat(deleteResult, is("Oracle Delete User: GSY"));
    }
}
