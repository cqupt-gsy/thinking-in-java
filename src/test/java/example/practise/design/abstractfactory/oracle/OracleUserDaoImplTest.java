package example.practise.design.abstractfactory.oracle;

import example.practise.design.abstractfactory.DatabaseAccess;
import example.practise.design.abstractfactory.UserDaoImplTest;
import example.practise.design.abstractfactory.factory.OracleDatabase;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.ORACLE;

public class OracleUserDaoImplTest extends UserDaoImplTest {

    @Before
    public void setUp() throws Exception {
//        userDao = new OracleDatabase().createUserDaoOperator();
        userDao = DatabaseAccess.createUserDao("oracle");
    }

    @Override
    public String getDatabaseName() {
        return ORACLE;
    }
}
