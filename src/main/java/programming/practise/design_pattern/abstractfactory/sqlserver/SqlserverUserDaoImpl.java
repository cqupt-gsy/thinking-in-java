package programming.practise.design_pattern.abstractfactory.sqlserver;

import programming.practise.design_pattern.abstractfactory.UserDao;

import static programming.practise.design_pattern.constant.ConstantStrings.*;

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
