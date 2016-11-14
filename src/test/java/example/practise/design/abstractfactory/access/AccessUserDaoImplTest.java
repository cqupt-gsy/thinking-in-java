package example.practise.design.abstractfactory.access;

import example.practise.design.abstractfactory.DatabaseAccess;
import example.practise.design.abstractfactory.UserDaoImplTest;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.ACCESS;

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
