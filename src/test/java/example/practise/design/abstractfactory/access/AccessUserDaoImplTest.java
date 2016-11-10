package example.practise.design.abstractfactory.access;

import example.practise.design.abstractfactory.UserDao;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccessUserDaoImplTest {

    private UserDao accessUserDao;

    @Before
    public void setUp() throws Exception {
        accessUserDao = new AccessUserDaoImpl();
    }

    @Test
    public void shouldReturnInsertOracleUserResultString() {
        //When
        String insertResult = accessUserDao.insertUser("GSY");

        //Then
        assertThat(insertResult, is("Access Insert User GSY"));
    }

    @Test
    public void shouldReturnDeleteOracleUserResultString() {
        //When
        String deleteResult = accessUserDao.deleteUser("GSY");

        //Then
        assertThat(deleteResult, is("Access Delete User GSY"));
    }

    @Test
    public void shouldReturnUpdateOracleUserResultString() {
        //When
        String updateString = accessUserDao.updateUser("GSY");

        //Then
        assertThat(updateString, is("Access Update User GSY"));
    }

    @Test
    public void shouldReturnQueryOracleUserResultString() {
        //When
        String queryString = accessUserDao.queryUser("GSY");

        //Then
        assertThat(queryString, is("Access Query User GSY"));
    }
}
