package programming.practise.design_pattern.abstractfactory;

public interface DatabaseFactory {

    UserDao createUserDaoOperator();

    ProductDao createProductDaoOperator();
}
