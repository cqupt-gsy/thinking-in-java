package programming.practise.design_pattern.abstractfactory.oracle;


import programming.practise.design_pattern.abstractfactory.UserDao;

import static programming.practise.design_pattern.constant.ConstantStrings.*;

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
