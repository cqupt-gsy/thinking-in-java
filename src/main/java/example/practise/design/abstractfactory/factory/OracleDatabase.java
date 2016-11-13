package example.practise.design.abstractfactory.factory;

import example.practise.design.abstractfactory.DatabaseFactory;
import example.practise.design.abstractfactory.ProductDao;
import example.practise.design.abstractfactory.UserDao;
import example.practise.design.abstractfactory.oracle.OracleProductDaoImpl;
import example.practise.design.abstractfactory.oracle.OracleUserDaoImpl;

public class OracleDatabase implements DatabaseFactory {

    @Override
    public UserDao createUserDaoOperator() {
        return new OracleUserDaoImpl();
    }

    @Override
    public ProductDao createProductDaoOperator() {
        return new OracleProductDaoImpl();
    }
}
