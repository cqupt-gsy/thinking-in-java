package example.practise.design.abstractfactory;

import example.practise.design.abstractfactory.access.AccessProductDaoImpl;
import example.practise.design.abstractfactory.access.AccessUserDaoImpl;
import example.practise.design.abstractfactory.oracle.OracleProductDaoImpl;
import example.practise.design.abstractfactory.oracle.OracleUserDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class DatabaseAccess {
    private static Map<String, UserDao> USER_DAO_OPERATOR = new HashMap<String, UserDao>() {
        {
            put("oracle", new OracleUserDaoImpl());
            put("access", new AccessUserDaoImpl());
        }
    };

    private static Map<String, ProductDao> PRODUCT_DAO_OPERATOR = new HashMap<String, ProductDao>() {
        {
            put("oracle", new OracleProductDaoImpl());
            put("access", new AccessProductDaoImpl());
        }
    };

    public static UserDao createUserDao(String databaseName) {
        return USER_DAO_OPERATOR.get(databaseName);
    }

    public static ProductDao createProductDao(String databaseName) {
        return PRODUCT_DAO_OPERATOR.get(databaseName);
    }
}
