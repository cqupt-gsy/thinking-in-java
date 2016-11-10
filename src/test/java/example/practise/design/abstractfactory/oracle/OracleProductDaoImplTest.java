package example.practise.design.abstractfactory.oracle;

import example.practise.design.abstractfactory.ProductDaoImplTest;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.ORACLE;

public class OracleProductDaoImplTest extends ProductDaoImplTest {

    @Before
    public void setUp() throws Exception {
        productDao = new OracleProductDaoImpl();
    }

    @Override
    public String getDatabaseName() {
        return ORACLE;
    }
}
