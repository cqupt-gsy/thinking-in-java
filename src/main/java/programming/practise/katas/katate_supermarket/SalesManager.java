package programming.practise.katas.katate_supermarket;

import programming.practise.katas.katate_supermarket.engine.PriceCalculationEngine;
import programming.practise.katas.katate_supermarket.items.Product;
import programming.practise.katas.katate_supermarket.yaml.YAMLHelper;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Arrays.stream;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class SalesManager {
    private final PriceCalculationEngine calculationEngine;
    private Map<String, Product> products;

    public SalesManager(String filename) {
        this.products = YAMLHelper.initProducts(filename);
        calculationEngine = new PriceCalculationEngine();
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public List<Product> scanBarcode(String barcode) {
        if (isBlank(barcode)) {
            return newArrayList();
        }

        return stream(barcode.toUpperCase().split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> products.keySet().contains(entry.getKey()))
                .map(entry -> {
                    final Product product = products.get(entry.getKey());
                    product.setNumber(entry.getValue());
                    return product;
                })
                .collect(Collectors.toList());
    }

    public double calculateTotalPrice(String barcode) {
        return this.scanBarcode(barcode)
                .stream()
                .map(calculationEngine::calculatePrice)
                .reduce(Double::sum)
                .get();
    }
}
