package example.practise.design.abstractfactory;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public abstract class UserDaoImplTest {
    protected UserDao userDao;

    @Test
    public void shouldReturnInsertUserResultString() {
        //When
        String insertResult = userDao.insertUser("GSY");

        //Then
        assertThat(insertResult, is(getDatabaseName() + "Insert User GSY"));
    }

    @Test
    public void shouldReturnDeleteUserResultString() {
        //When
        String deleteResult = userDao.deleteUser("GSY");

        //Then
        assertThat(deleteResult, is(getDatabaseName() + "Delete User GSY"));
    }

    @Test
    public void shouldReturnUpdateUserResultString() {
        //When
        String updateString = userDao.updateUser("GSY");

        //Then
        assertThat(updateString, is(getDatabaseName() + "Update User GSY"));
    }

    @Test
    public void shouldReturnQueryUserResultString() {
        //When
        String queryString = userDao.queryUser("GSY");

        //Then
        assertThat(queryString, is(getDatabaseName() + "Query User GSY"));
    }

    public abstract String getDatabaseName();
}
