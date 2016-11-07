package example.practise.design.abstractfactory;

public interface UserDao {
    String insertUser(String name);

    String deleteUser(String name);

    String updateUser(String name);

    String quertUser(String name);
}
