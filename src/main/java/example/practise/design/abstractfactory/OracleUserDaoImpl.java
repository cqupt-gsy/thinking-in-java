package example.practise.design.abstractfactory;


import static example.practise.design.constant.ConstantStrings.*;

public class OracleUserDaoImpl implements UserDao {
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
    public String quertUser(String name) {
        return ORACLE + QUERY + USER + name;
    }
}
