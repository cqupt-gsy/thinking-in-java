package programming.practise.design_pattern.abstractfactory.access;

import programming.practise.design_pattern.abstractfactory.ProductDao;

import static programming.practise.design_pattern.constant.ConstantStrings.*;

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
