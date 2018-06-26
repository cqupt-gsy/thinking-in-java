package programming.practise.design_pattern.abstractfactory.access;

import programming.practise.design_pattern.abstractfactory.UserDao;

import static programming.practise.design_pattern.constant.ConstantStrings.*;

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
