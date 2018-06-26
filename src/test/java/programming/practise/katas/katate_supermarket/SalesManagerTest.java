package programming.practise.katas.katate_supermarket;

import programming.practise.katas.katate_supermarket.items.Product;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SalesManagerTest {

    private SalesManager salesManager = new SalesManager("product.yml");

    @Test
    public void shouldReturnProductList() {
        //when
        final Map<String, Product> products = salesManager.getProducts();

        //Then
        assertThat(products.size()).isEqualTo(6);
        assertThat(products.get("A"))
                .hasFieldOrPropertyWithValue("name", "A")
                .hasFieldOrPropertyWithValue("price", 50.0)
                .hasFieldOrPropertyWithValue("discountRule", "3 for 130")
                .hasFieldOrPropertyWithValue("number", 0L);
        assertThat(products.get("B"))
                .hasFieldOrPropertyWithValue("name", "B")
                .hasFieldOrPropertyWithValue("price", 30.0)
                .hasFieldOrPropertyWithValue("discountRule", "2 for 45")
                .hasFieldOrPropertyWithValue("number", 0L);
        assertThat(products.get("C"))
                .hasFieldOrPropertyWithValue("name", "C")
                .hasFieldOrPropertyWithValue("price", 20.0)
                .hasFieldOrPropertyWithValue("discountRule", null)
                .hasFieldOrPropertyWithValue("number", 0L);
        assertThat(products.get("D"))
                .hasFieldOrPropertyWithValue("name", "D")
                .hasFieldOrPropertyWithValue("price", 15.0)
                .hasFieldOrPropertyWithValue("discountRule", null)
                .hasFieldOrPropertyWithValue("number", 0L);
    }

    @Test
    public void shouldReturnProductListWhenScanABarcode() {
        //When
        final List<Product> inputProducts = salesManager.scanBarcode("AABCACB");

        //Then
        assertThat(inputProducts.size()).isEqualTo(3);
        assertThat(inputProducts.get(0))
                .hasFieldOrPropertyWithValue("name", "A")
                .hasFieldOrPropertyWithValue("number", 3L);
        assertThat(inputProducts.get(1))
                .hasFieldOrPropertyWithValue("name", "B")
                .hasFieldOrPropertyWithValue("number", 2L);
        assertThat(inputProducts.get(2))
                .hasFieldOrPropertyWithValue("name", "C")
                .hasFieldOrPropertyWithValue("number", 2L);
    }

    @Test
    public void shouldReturnEmptyProductListWhenScanAEmptyBarcode() {
        //When
        final List<Product> inputProducts = salesManager.scanBarcode("");

        //Then
        assertThat(inputProducts.size()).isEqualTo(0);
    }

    @Test
    public void shouldReturnTotalPriceOfProductsWithoutDiscount() {
        //When
        double totalPrice = salesManager.calculateTotalPrice("dcdcc");

        //Then
        assertThat(totalPrice).isEqualTo(90.0);

    }

    @Test
    public void shouldReturnTotalPriceOfProductsOnlyWithDiscount() {
        //When
        double totalPrice = salesManager.calculateTotalPrice("aabab");

        //Then
        assertThat(totalPrice).isEqualTo(175.00);

    }

    @Test
    public void shouldReturnTotalPriceOfProducts() {
        //When
        double totalPrice = salesManager.calculateTotalPrice("aaccbadcdb");

        //Then
        assertThat(totalPrice).isEqualTo(265.00);

    }

    @Test
    public void shouldReturnTotalPriceOfProductsWithAllKindProductsWithoutDiscount() {
        //When
        double totalPrice = salesManager.calculateTotalPrice("aaccdcdb");

        //Then
        assertThat(totalPrice).isEqualTo(220.00);

    }

    @Test
    public void shouldReturnTotalPriceOfProductsWithNewDiscountRule() {
        //When
        double totalPrice = salesManager.calculateTotalPrice("effe");

        //Then
        assertThat(totalPrice).isEqualTo(58.00);

    }
}
