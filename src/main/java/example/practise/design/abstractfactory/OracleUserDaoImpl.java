package example.practise.design.abstractfactory;

public class OracleUserDaoImpl implements UserDao {
    public String insertUser(String name) {
        return "Oracle Insert User: " + name;
    }
}
