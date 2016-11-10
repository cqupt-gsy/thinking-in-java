package example.practise.design.abstractfactory.access;

import example.practise.design.abstractfactory.ProductDao;

import static example.practise.design.constant.ConstantStrings.*;

public class AccessProductDaoImpl implements ProductDao {
    @Override
    public String insertProduct(String product) {
        return ACCESS + INSERT + PRODUCT + product;
    }

    @Override
    public String deleteProduct(String product) {
        return ACCESS + DELETE + PRODUCT + product;
    }

    @Override
    public String updateProduct(String product) {
        return ACCESS + UPDATE + PRODUCT + product;
    }

    @Override
    public String queryProduct(String product) {
        return ACCESS + QUERY + PRODUCT + product;
    }
}
