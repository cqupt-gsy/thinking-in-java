package programming.practise.design_pattern.abstractfactory.oracle;

import programming.practise.design_pattern.abstractfactory.DatabaseAccess;
import programming.practise.design_pattern.abstractfactory.ProductDaoImplTest;
import org.junit.Before;

import static programming.practise.design_pattern.constant.ConstantStrings.ORACLE;

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
