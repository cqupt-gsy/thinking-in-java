package example.practise.design.abstractfactory.oracle;


import example.practise.design.abstractfactory.UserDao;

import static example.practise.design.constant.ConstantStrings.*;

public class OracleUserDaoImpl implements UserDao {

    @Override
    public String insertUser(String name) {
        return ORACLE + INSERT + USER + name;
    }

    @Override
    public String deleteUser(String name) {
        return ORACLE + DELETE + USER  + name;
    }

    @Override
    public String updateUser(String name) {
        return ORACLE + UPDATE + USER  + name;
    }

    @Override
    public String queryUser(String name) {
        return ORACLE + QUERY + USER + name;
    }
}
