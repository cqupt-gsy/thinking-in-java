package example.practise.design_pattern.abstractfactory.sqlserver;

import example.practise.design_pattern.abstractfactory.DatabaseAccess;
import example.practise.design_pattern.abstractfactory.UserDaoImplTest;
import org.junit.Before;

import static example.practise.design_pattern.constant.ConstantStrings.SQLSERVER;

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
