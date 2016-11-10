package example.practise.design.abstractfactory.oracle;

import example.practise.design.abstractfactory.ProductDao;

import static example.practise.design.constant.ConstantStrings.*;

public class OracleProductDaoImpl implements ProductDao {

    @Override
    public String insertProduct(String product) {
        return ORACLE + INSERT + PRODUCT + product;
    }

    @Override
    public String deleteProduct(String product) {
        return ORACLE + DELETE + PRODUCT + product;
    }

    @Override
    public String updateProduct(String product) {
        return ORACLE + UPDATE + PRODUCT +product;
    }

    @Override
    public String queryProduct(String product) {
        return ORACLE + QUERY + PRODUCT + product;
    }
}
