package example.practise.design.abstractfactory.factory;

import example.practise.design.abstractfactory.DatabaseFactory;
import example.practise.design.abstractfactory.ProductDao;
import example.practise.design.abstractfactory.UserDao;
import example.practise.design.abstractfactory.sqlserver.SqlserverProductDaoImpl;
import example.practise.design.abstractfactory.sqlserver.SqlserverUserDaoImpl;

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
