package example.practise.design.abstractfactory.oracle;

import example.practise.design.abstractfactory.DatabaseAccess;
import example.practise.design.abstractfactory.ProductDaoImplTest;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.ORACLE;

public class OracleProductDaoImplTest extends ProductDaoImplTest {

    @Before
    public void setUp() throws Exception {
//        productDao = new OracleDatabase().createProductDaoOperator();
//        productDao = DatabaseAccess.createDatabaseFactory("oracle").createProductDaoOperator();
        productDao = DatabaseAccess.createOracleDatabase().createProductDaoOperator();
    }

    @Override
    public String getDatabaseName() {
        return ORACLE;
    }
}
