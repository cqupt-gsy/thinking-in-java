package example.practise.design.abstractfactory;

import example.practise.design.abstractfactory.access.config.AccessConfig;
import example.practise.design.abstractfactory.annotation.DatabaseConfig;
import example.practise.design.abstractfactory.factory.AccessDatabase;
import example.practise.design.abstractfactory.factory.OracleDatabase;
import example.practise.design.abstractfactory.oracle.config.OracleConfig;
import example.practise.design.abstractfactory.sqlserver.config.SqlserverConfig;

import java.util.HashMap;
import java.util.Map;

public class DatabaseAccess {
    private static Map<String, DatabaseFactory> DATABASE_FACTORY_MAP = new HashMap<String, DatabaseFactory>() {
        {
            put("oracle", new OracleDatabase());
            put("access", new AccessDatabase());
        }
    };


    public static DatabaseFactory createDatabaseFactory(String databaseName) {
        return DATABASE_FACTORY_MAP.get(databaseName);
    }


    public static DatabaseFactory createAccessDatabase() throws Exception {
        Class<?> clazz = AccessConfig.class; //should be package scan
        return getDatabaseFactory(clazz);
    }

    public static DatabaseFactory createOracleDatabase() throws Exception {
        Class<?> clazz = OracleConfig.class; //should be package scan
        return getDatabaseFactory(clazz);
    }

    private static DatabaseFactory getDatabaseFactory(Class<?> clazz) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        DatabaseConfig databaseConfig = clazz.getAnnotation(DatabaseConfig.class);
        String fullClassName = databaseConfig.basePackage() + "." + databaseConfig.databaseType();
        Class<?> returnClass = Class.forName(fullClassName);
        return (DatabaseFactory) returnClass.newInstance();
    }

    public static DatabaseFactory createSqlserverDatabase() throws Exception {
        Class<?> clazz = SqlserverConfig.class;
        return getDatabaseFactory(clazz);
    }
}
