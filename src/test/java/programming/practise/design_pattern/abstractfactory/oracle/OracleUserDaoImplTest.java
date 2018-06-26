package programming.practise.design_pattern.abstractfactory.oracle;

import programming.practise.design_pattern.abstractfactory.DatabaseAccess;
import programming.practise.design_pattern.abstractfactory.UserDaoImplTest;
import org.junit.Before;

import static programming.practise.design_pattern.constant.ConstantStrings.ORACLE;

public class OracleUserDaoImplTest extends UserDaoImplTest {

    @Before
    public void setUp() throws Exception {
//        userDao = new OracleDatabase().createUserDaoOperator();
//        userDao = DatabaseAccess.createDatabaseFactory("oracle").createUserDaoOperator();
        userDao = DatabaseAccess.createOracleDatabase().createUserDaoOperator();
    }


    @Override
    public String getDatabaseName() {
        return ORACLE;
    }
}
