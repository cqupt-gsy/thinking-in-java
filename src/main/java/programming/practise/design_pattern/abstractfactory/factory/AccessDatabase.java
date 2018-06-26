package programming.practise.design_pattern.abstractfactory.factory;

import programming.practise.design_pattern.abstractfactory.DatabaseFactory;
import programming.practise.design_pattern.abstractfactory.ProductDao;
import programming.practise.design_pattern.abstractfactory.UserDao;
import programming.practise.design_pattern.abstractfactory.access.AccessProductDaoImpl;
import programming.practise.design_pattern.abstractfactory.access.AccessUserDaoImpl;

public class AccessDatabase implements DatabaseFactory {
    @Override
    public UserDao createUserDaoOperator() {
        return new AccessUserDaoImpl();
    }

    @Override
    public ProductDao createProductDaoOperator() {
        return new AccessProductDaoImpl();
    }
}
