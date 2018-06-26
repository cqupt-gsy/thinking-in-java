package programming.practise.katas.katate_supermarket.yaml;

import programming.practise.katas.katate_supermarket.items.Product;
import org.yaml.snakeyaml.Yaml;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YAMLHelper {

    public static Map<String, Product> initProducts(String filename) {
        final Yaml yaml = new Yaml();
        final  List<Map<String, Object>> products = (List) yaml.load(
                YAMLHelper.class.getClassLoader().getResourceAsStream(filename));
        return  products
                .stream()
                .map((Map<String, Object> product) -> new Product(
                        (String)product.get("name"), (Double) product.get("price"),
                        (String)product.get("discountRule"), (Integer)product.get("number")))
                .collect(Collectors.toMap(Product::getName, product -> product));
    }


}
