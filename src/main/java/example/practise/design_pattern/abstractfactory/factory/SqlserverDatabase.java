package example.practise.design_pattern.abstractfactory.factory;

import example.practise.design_pattern.abstractfactory.DatabaseFactory;
import example.practise.design_pattern.abstractfactory.ProductDao;
import example.practise.design_pattern.abstractfactory.UserDao;
import example.practise.design_pattern.abstractfactory.sqlserver.SqlserverProductDaoImpl;
import example.practise.design_pattern.abstractfactory.sqlserver.SqlserverUserDaoImpl;

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
