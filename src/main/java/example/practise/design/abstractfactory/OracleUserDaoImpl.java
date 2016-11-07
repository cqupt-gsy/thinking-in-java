package example.practise.design.abstractfactory;

public class OracleUserDaoImpl implements UserDao {
    public String insertUser(String name) {
        return "Oracle Insert User: " + name;
    }

    @Override
    public String deleteUser(String name) {

        return "Oracle Delete User: " + name;
    }
}
