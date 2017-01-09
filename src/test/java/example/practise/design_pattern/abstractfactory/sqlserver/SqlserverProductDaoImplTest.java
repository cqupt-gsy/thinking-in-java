package example.practise.design_pattern.abstractfactory.sqlserver;

import example.practise.design_pattern.abstractfactory.DatabaseAccess;
import example.practise.design_pattern.abstractfactory.ProductDaoImplTest;
import org.junit.Before;

import static example.practise.design_pattern.constant.ConstantStrings.SQLSERVER;

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
