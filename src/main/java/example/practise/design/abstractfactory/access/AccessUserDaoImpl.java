package example.practise.design.abstractfactory.access;

import example.practise.design.abstractfactory.UserDao;

import static example.practise.design.constant.ConstantStrings.*;

public class AccessUserDaoImpl implements UserDao {
    @Override
    public String insertUser(String name) {
        return ACCESS + INSERT + USER + name;
    }

    @Override
    public String deleteUser(String name) {
        return ACCESS + DELETE + USER + name;
    }

    @Override
    public String updateUser(String name) {
        return ACCESS + UPDATE + USER + name;
    }

    @Override
    public String queryUser(String name) {
        return ACCESS + QUERY + USER + name;
    }
}
