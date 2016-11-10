package example.practise.design.abstractfactory;

public interface ProductDao {
    String insertProduct(String product);

    String deleteProduct(String product);

    String updateProduct(String product);

    String queryProduct(String product);
}
