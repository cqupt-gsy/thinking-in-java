package programming.practise.design_pattern.abstractfactory.factory;

import programming.practise.design_pattern.abstractfactory.DatabaseFactory;
import programming.practise.design_pattern.abstractfactory.ProductDao;
import programming.practise.design_pattern.abstractfactory.UserDao;
import programming.practise.design_pattern.abstractfactory.oracle.OracleProductDaoImpl;
import programming.practise.design_pattern.abstractfactory.oracle.OracleUserDaoImpl;

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
