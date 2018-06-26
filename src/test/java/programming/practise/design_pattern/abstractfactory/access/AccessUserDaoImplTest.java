package programming.practise.design_pattern.abstractfactory.access;

import programming.practise.design_pattern.abstractfactory.DatabaseAccess;
import programming.practise.design_pattern.abstractfactory.UserDaoImplTest;
import org.junit.Before;

import static programming.practise.design_pattern.constant.ConstantStrings.ACCESS;

public class AccessUserDaoImplTest extends UserDaoImplTest {

    @Before
    public void setUp() throws Exception {
//        userDao = new AccessDatabase().createUserDaoOperator();
//        userDao = DatabaseAccess.createDatabaseFactory("access").createUserDaoOperator();
        userDao = DatabaseAccess.createAccessDatabase().createUserDaoOperator();
    }

    @Override
    public String getDatabaseName() {
        return ACCESS;
    }
}
