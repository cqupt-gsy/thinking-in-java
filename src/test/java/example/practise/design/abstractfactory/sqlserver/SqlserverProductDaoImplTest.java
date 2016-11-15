package example.practise.design.abstractfactory.sqlserver;

import example.practise.design.abstractfactory.DatabaseAccess;
import example.practise.design.abstractfactory.ProductDaoImplTest;
import org.junit.Before;

import static example.practise.design.constant.ConstantStrings.SQLSERVER;

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
