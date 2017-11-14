package vendingMachine.Models;

import vendingMachine.DataAccess.Readers.BalanceReader;
import vendingMachine.DataAccess.Readers.ProductReader;
import vendingMachine.DataAccess.Writers.BalanceWriter;
import vendingMachine.DataAccess.Writers.ProductWriter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class VendingMachine {
    private BigDecimal VendingMachineBalance;
    private ArrayList<Product> Products;


    private ArrayList<Product> ProductTypes;

    public VendingMachine(BigDecimal vendingMachineBalance, ArrayList<Product> products){

        VendingMachineBalance = vendingMachineBalance;
        Products = products;
        ProductTypes = new ArrayList<Product>();
            ProductTypes.add(new Product(11, "Walkers cheese & onion", new BigDecimal("1.50")));
            ProductTypes.add(new Product(12, "Walkers cheese & onion", new BigDecimal("1.50")));
            ProductTypes.add(new Product(13, "Walkers ready salted", new BigDecimal("1.50")));
            ProductTypes.add(new Product(14, "Walkers ready salted", new BigDecimal("1.50")));
            ProductTypes.add(new Product(21, "McCoys flame grilled stake", new BigDecimal("1.50")));
            ProductTypes.add(new Product(22, "McCoys salt & malt vingar", new BigDecimal("1.50")));
            ProductTypes.add(new Product(23, "McCoys cheddar & onion", new BigDecimal("1.50")));
            ProductTypes.add(new Product(24, "Quavers", new BigDecimal("1.50")));
            ProductTypes.add(new Product(31, "M&M", new BigDecimal("1.00")));
            ProductTypes.add(new Product(32, "Minstrels", new BigDecimal("1.00")));
            ProductTypes.add(new Product(33, "Maltesers", new BigDecimal("1.00")));
            ProductTypes.add(new Product(34, "double decker", new BigDecimal("1.00")));
            ProductTypes.add(new Product(35, "Kit Kat", new BigDecimal("1.00")));
            ProductTypes.add(new Product(36, "Boost", new BigDecimal("1.00")));
            ProductTypes.add(new Product(37, "Twirl", new BigDecimal("1.00")));
            ProductTypes.add(new Product(38, "Wispa", new BigDecimal("1.00")));
            ProductTypes.add(new Product(41, "Pasta", new BigDecimal("3.00")));
            ProductTypes.add(new Product(42, "Pasta", new BigDecimal("3.00")));
            ProductTypes.add(new Product(43, "Ham and cheese", new BigDecimal("2.00")));
            ProductTypes.add(new Product(44, "Double cheese and onion", new BigDecimal("2.00")));
            ProductTypes.add(new Product(51, "Water", new BigDecimal("1.00")));
            ProductTypes.add(new Product(52, "Lucozade", new BigDecimal("1.50")));
            ProductTypes.add(new Product(53, "Engery drink", new BigDecimal("1.50")));
            ProductTypes.add(new Product(54, "Ribena", new BigDecimal("1.50")));
            ProductTypes.add(new Product(55, "Tropicana", new BigDecimal("1.50")));
            ProductTypes.add(new Product(56, "Coke botle", new BigDecimal("1.50")));
            ProductTypes.add(new Product(61, "Redbull", new BigDecimal("2.00")));
            ProductTypes.add(new Product(62, "Sprite", new BigDecimal("1.00")));
            ProductTypes.add(new Product(63, "Fanta", new BigDecimal("1.00")));
            ProductTypes.add(new Product(64, "Coke can", new BigDecimal("1.00")));

    }

    public BigDecimal getVendingMachineBalance() {
        return VendingMachineBalance;
    }

    public ArrayList<Product> getProducts() throws Exception {
        Products = ProductReader.LoadProducts();
        return Products;
    }

    public void RemoveProduct(Product product) throws Exception {
        ProductWriter.RemoveProduct(product);
        Products = ProductReader.LoadProducts();
    }

    public void AddProduct (Product product)throws Exception{
        ProductWriter.AddProduct(product);
        Products = ProductReader.LoadProducts();
    }

    public ArrayList<Product> GetProductTypes(){
        return ProductTypes;
    }

    public Product GetProductType(int identifier){
        Stream<Product> stream = ProductTypes
                .stream()
                .filter(x -> x.getProductLocation() == identifier);
        return stream.findFirst().orElse(null);

    }

    public Balance GetBalance() throws Exception {
        return BalanceReader.LoadBalance();
    }

    public void AddBalance (Balance balance)throws Exception{
        BalanceWriter.AddBalance(balance);

    }
    public void AddBalance(BigDecimal amount) throws Exception {
        AddBalance(new Balance(amount));
    }

}
