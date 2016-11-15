package example.practise.design.abstractfactory.sqlserver;

import example.practise.design.abstractfactory.DatabaseAccess;
import example.practise.design.abstractfactory.UserDaoImplTest;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.SQLSERVER;

public class SqlserverUserDaoImplTest extends UserDaoImplTest {

    @Before
    public void setUp() throws Exception {
        userDao = DatabaseAccess.createSqlserverDatabase().createUserDaoOperator();

    }

    @Override
    public String getDatabaseName() {
        return SQLSERVER;
    }
}
