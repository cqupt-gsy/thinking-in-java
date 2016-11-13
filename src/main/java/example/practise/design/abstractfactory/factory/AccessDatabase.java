package example.practise.design.abstractfactory.factory;

import example.practise.design.abstractfactory.DatabaseFactory;
import example.practise.design.abstractfactory.ProductDao;
import example.practise.design.abstractfactory.UserDao;
import example.practise.design.abstractfactory.access.AccessProductDaoImpl;
import example.practise.design.abstractfactory.access.AccessUserDaoImpl;

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
