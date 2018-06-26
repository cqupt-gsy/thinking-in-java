package programming.practise.design_pattern.abstractfactory.sqlserver;

import programming.practise.design_pattern.abstractfactory.DatabaseAccess;
import programming.practise.design_pattern.abstractfactory.UserDaoImplTest;
import org.junit.Before;

import static programming.practise.design_pattern.constant.ConstantStrings.SQLSERVER;

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
