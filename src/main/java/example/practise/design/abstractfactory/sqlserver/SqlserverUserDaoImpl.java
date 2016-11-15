package example.practise.design.abstractfactory.sqlserver;

import example.practise.design.abstractfactory.UserDao;

import static example.practise.design.constant.ConstantStrings.*;

public class SqlserverUserDaoImpl implements UserDao {
    @Override
    public String insertUser(String name) {
        return SQLSERVER + INSERT + USER + name;
    }

    @Override
    public String deleteUser(String name) {
        return SQLSERVER + DELETE + USER + name;
    }

    @Override
    public String updateUser(String name) {
        return SQLSERVER + UPDATE + USER + name;
    }

    @Override
    public String queryUser(String name) {
        return SQLSERVER + QUERY + USER + name;
    }
}
