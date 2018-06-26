package programming.practise.design_pattern.abstractfactory.access;

import programming.practise.design_pattern.abstractfactory.DatabaseAccess;
import programming.practise.design_pattern.abstractfactory.ProductDaoImplTest;
import org.junit.Before;

import static programming.practise.design_pattern.constant.ConstantStrings.ACCESS;

public class AccessProductDaoImplTest extends ProductDaoImplTest {


    @Before
    public void setUp() throws Exception {
//        productDao = new AccessDatabase().createProductDaoOperator();
//        productDao = DatabaseAccess.createDatabaseFactory("access").createProductDaoOperator();
        productDao = DatabaseAccess.createAccessDatabase().createProductDaoOperator();

    }

    @Override
    public String getDatabaseName() {
        return ACCESS;
    }
}
