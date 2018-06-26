package programming.practise.design_pattern.abstractfactory;

public interface UserDao {
    String insertUser(String name);

    String deleteUser(String name);

    String updateUser(String name);

    String queryUser(String name);
}
