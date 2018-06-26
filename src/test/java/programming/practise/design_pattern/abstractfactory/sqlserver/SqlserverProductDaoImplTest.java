package programming.practise.design_pattern.abstractfactory.sqlserver;

import programming.practise.design_pattern.abstractfactory.DatabaseAccess;
import programming.practise.design_pattern.abstractfactory.ProductDaoImplTest;
import org.junit.Before;

import static programming.practise.design_pattern.constant.ConstantStrings.SQLSERVER;

public class SqlserverProductDaoImplTest extends ProductDaoImplTest {

    @Before
    public void setUp() throws Exception {
        productDao = DatabaseAccess.createSqlserverDatabase().createProductDaoOperator();

    }

    @Override
    public String getDatabaseName() {
        return SQLSERVER;
    }
}
