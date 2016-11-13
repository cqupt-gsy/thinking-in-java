package example.practise.design.abstractfactory.oracle;

import example.practise.design.abstractfactory.ProductDaoImplTest;
import example.practise.design.abstractfactory.factory.OracleDatabase;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.ORACLE;

public class OracleProductDaoImplTest extends ProductDaoImplTest {

    @Before
    public void setUp() throws Exception {
        productDao = new OracleDatabase().createProductDaoOperator();
    }

    @Override
    public String getDatabaseName() {
        return ORACLE;
    }
}
