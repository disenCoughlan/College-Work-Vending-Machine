package vendingMachine.Models;

import java.math.BigDecimal;

public class Product {
    private int ProductLocation;
    private String ProductName;
    private BigDecimal ProductPrice;

    public Product(int productId, String productName, BigDecimal productPrice){
        ProductLocation = productId;
        ProductName = productName;
        ProductPrice = productPrice;
    }

    public int getProductLocation() {
        return ProductLocation;
    }

    public String getProductName() {
        return ProductName;
    }

    public BigDecimal getProductPrice() {
        return ProductPrice;
    }

    @Override
    public String toString() {
        return new String("Product Location: " + getProductLocation() +
                          ", Product Name: " + getProductName() +
                          ", Product Price: " + getProductPrice());
    }
}
