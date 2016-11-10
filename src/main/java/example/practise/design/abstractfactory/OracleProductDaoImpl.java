package example.practise.design.abstractfactory;

import static example.practise.design.constant.ConstantStrings.*;

public class OracleProductDaoImpl {

    public String insertProduct(String product) {
        return ORACLE + INSERT + PRODUCT + product;
    }

    public String deleteProduct(String prodoct) {
        return ORACLE + DELETE + PRODUCT + prodoct;
    }

    public String updateProduct(String product) {
        return ORACLE + UPDATE + PRODUCT +product;
    }

    public String queryProduct(String product) {
        return ORACLE + QUERY + PRODUCT + product;
    }
}
