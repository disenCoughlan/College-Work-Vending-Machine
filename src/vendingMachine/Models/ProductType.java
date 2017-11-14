package vendingMachine.Models;

public class ProductType
{
    private final String productLocation;
    private final String productName;
    private final String productPrice;
    public ProductType(String productLocation, String productName, String productPrice){

        this.productLocation = productLocation;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductLocation() {
        return productLocation;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }
}
