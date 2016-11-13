package example.practise.design.abstractfactory;

public interface DatabaseFactory {

    UserDao createUserDaoOperator();

    ProductDao createProductDaoOperator();
}
