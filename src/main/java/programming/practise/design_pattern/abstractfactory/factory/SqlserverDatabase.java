package programming.practise.design_pattern.abstractfactory.factory;

import programming.practise.design_pattern.abstractfactory.DatabaseFactory;
import programming.practise.design_pattern.abstractfactory.ProductDao;
import programming.practise.design_pattern.abstractfactory.UserDao;
import programming.practise.design_pattern.abstractfactory.sqlserver.SqlserverProductDaoImpl;
import programming.practise.design_pattern.abstractfactory.sqlserver.SqlserverUserDaoImpl;

public class SqlserverDatabase implements DatabaseFactory {
    @Override
    public UserDao createUserDaoOperator() {
        return new SqlserverUserDaoImpl();
    }

    @Override
    public ProductDao createProductDaoOperator() {
        return new SqlserverProductDaoImpl();
    }
}
