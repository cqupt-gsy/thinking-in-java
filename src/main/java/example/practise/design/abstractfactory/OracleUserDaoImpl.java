package example.practise.design.abstractfactory;


import static example.practise.design.constant.ConstantStrings.*;

public class OracleUserDaoImpl implements UserDao {
    public String insertUser(String name) {
        return ORACLE + INSERT + USER + COLON + name;
    }

    @Override
    public String deleteUser(String name) {
        return ORACLE + DELETE + USER + COLON  + name;
    }

    @Override
    public String updateUser(String name) {
        return ORACLE + UPDATE + USER + COLON  + name;
    }

    @Override
    public String quertUser(String name) {
        return ORACLE + QUERY + USER + COLON + name;
    }
}
