package example.practise.design.abstractfactory.oracle;

import example.practise.design.abstractfactory.DatabaseAccess;
import example.practise.design.abstractfactory.UserDaoImplTest;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.ORACLE;

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
