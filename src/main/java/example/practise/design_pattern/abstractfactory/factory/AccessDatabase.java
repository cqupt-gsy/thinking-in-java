package example.practise.design_pattern.abstractfactory.factory;

import example.practise.design_pattern.abstractfactory.DatabaseFactory;
import example.practise.design_pattern.abstractfactory.ProductDao;
import example.practise.design_pattern.abstractfactory.UserDao;
import example.practise.design_pattern.abstractfactory.access.AccessProductDaoImpl;
import example.practise.design_pattern.abstractfactory.access.AccessUserDaoImpl;

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
