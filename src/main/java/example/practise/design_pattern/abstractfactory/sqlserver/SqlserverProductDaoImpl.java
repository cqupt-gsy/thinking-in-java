package example.practise.design_pattern.abstractfactory.sqlserver;

import example.practise.design_pattern.abstractfactory.ProductDao;

import static example.practise.design_pattern.constant.ConstantStrings.*;

public class SqlserverProductDaoImpl implements ProductDao {
    @Override
    public String insertProduct(String product) {
        return SQLSERVER + INSERT + PRODUCT + product;
    }

    @Override
    public String deleteProduct(String product) {
        return SQLSERVER + DELETE + PRODUCT + product;
    }

    @Override
    public String updateProduct(String product) {
        return SQLSERVER + UPDATE + PRODUCT + product;
    }

    @Override
    public String queryProduct(String product) {
        return SQLSERVER + QUERY + PRODUCT + product;
    }
}
