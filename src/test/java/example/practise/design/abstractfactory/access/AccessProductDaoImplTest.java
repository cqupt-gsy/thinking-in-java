package example.practise.design.abstractfactory.access;

import example.practise.design.abstractfactory.DatabaseAccess;
import example.practise.design.abstractfactory.ProductDaoImplTest;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.ACCESS;

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
