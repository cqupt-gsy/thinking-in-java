package programming.practise.design_pattern.abstractfactory.oracle;

import programming.practise.design_pattern.abstractfactory.ProductDao;

import static programming.practise.design_pattern.constant.ConstantStrings.*;

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
