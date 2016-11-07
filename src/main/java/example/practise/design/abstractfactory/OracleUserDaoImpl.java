package example.practise.design.abstractfactory;


import static example.practise.design.constant.ConstantStrings.*;

public class OracleUserDaoImpl implements UserDao {
    public String insertUser(String name) {
        return ORACLE + INSERT_USER + COLON + name;
    }

    @Override
    public String deleteUser(String name) {
        return ORACLE + DELETE_USER + COLON  + name;
    }

    @Override
    public String updateUser(String name) {
        return ORACLE + UPDATE_USER + COLON  + name;
    }

    @Override
    public String quertUser(String name) {
        return ORACLE + QUERY_USER + COLON + name;
    }
}
