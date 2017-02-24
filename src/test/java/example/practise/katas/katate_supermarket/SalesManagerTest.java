package example.practise.katas.katate_supermarket;

import example.practise.katas.katate_supermarket.items.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SalesManagerTest {

    private SalesManager salesManager = new SalesManager("product.yml");

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnProductList() {
        //when
        final Map<String, Product> products = salesManager.getProducts();

        //Then
        assertThat(products.size()).isEqualTo(4);
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
}
