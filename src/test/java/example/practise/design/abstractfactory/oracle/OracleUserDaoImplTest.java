package example.practise.design.abstractfactory.oracle;

import example.practise.design.abstractfactory.UserDaoImplTest;
import org.junit.Before;
import org.junit.Test;

import static example.practise.design.constant.ConstantStrings.ORACLE;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class OracleUserDaoImplTest extends UserDaoImplTest {

    @Before
    public void setUp() throws Exception {
        userDao = new OracleUserDaoImpl();
    }

    @Override
    public String getDatabaseName() {
        return ORACLE;
    }
}
