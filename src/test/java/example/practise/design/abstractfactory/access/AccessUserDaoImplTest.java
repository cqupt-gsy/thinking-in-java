package example.practise.design.abstractfactory.access;

import example.practise.design.abstractfactory.DatabaseAccess;
import example.practise.design.abstractfactory.UserDaoImplTest;
import example.practise.design.abstractfactory.factory.AccessDatabase;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.ACCESS;

public class AccessUserDaoImplTest extends UserDaoImplTest {

    @Before
    public void setUp() throws Exception {
//        userDao = new AccessDatabase().createUserDaoOperator();
        userDao = new DatabaseAccess().createUserDao("access");
    }

    @Override
    public String getDatabaseName() {
        return ACCESS;
    }
}
