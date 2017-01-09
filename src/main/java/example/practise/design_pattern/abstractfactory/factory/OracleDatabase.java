package example.practise.design_pattern.abstractfactory.factory;

import example.practise.design_pattern.abstractfactory.DatabaseFactory;
import example.practise.design_pattern.abstractfactory.ProductDao;
import example.practise.design_pattern.abstractfactory.UserDao;
import example.practise.design_pattern.abstractfactory.oracle.OracleProductDaoImpl;
import example.practise.design_pattern.abstractfactory.oracle.OracleUserDaoImpl;

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
