package vendingMachine.Managers;

import org.jetbrains.annotations.Nullable;
import vendingMachine.DataAccess.DataHandler;
import vendingMachine.Models.Balance;
import vendingMachine.Models.Product;
import vendingMachine.Models.ProductType;
import vendingMachine.Models.VendingMachine;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VendingMachineManager {
    private static VendingMachine VendingMachine;

    public static void initVendingMachine() throws Exception {
        VendingMachine = new VendingMachine(new BigDecimal(100.00), DataHandler.GetProductsFromFile());
    }

    @Nullable
    public static Product TryPurchaseProduct(int productId, BigDecimal currentInsertedAmount) throws Exception {
        Product product = VendingMachine.getProducts()
                .stream()
                .filter(x -> x.getProductLocation() == productId)
                .findFirst()
                .orElse(null);

        if (product == null)
            return new Product(00, "Product not available", new BigDecimal(0.00));
        else if (product.getProductPrice().doubleValue() > currentInsertedAmount.doubleValue())
            return new Product(00, "Unable to afford " + product.getProductName(), new BigDecimal(0.00));
        else {
            VendingMachine.RemoveProduct(product);
            VendingMachine.AddBalance(product.getProductPrice());
            return product;
        }
    }

    public static void TryAddProduct(Product product) throws Exception {
        VendingMachine.AddProduct(product);
    }

    public static ArrayList<Product> TryGetProducts() throws Exception {
        return VendingMachine.getProducts();
    }

    public static Product GetProductType(int Identifier) {
        return VendingMachine.GetProductType(Identifier);
    }

    public static void TryRemoveProduct(Product product) throws Exception {
        VendingMachine.RemoveProduct(product);
    }

    public static Balance getBalance() {
        try {
            return VendingMachine.GetBalance();
        } catch (Exception e) {
            return new Balance(new BigDecimal("0.00"));
        }
    }

    public static void AddBalance(BigDecimal amount) throws Exception {
        VendingMachine.AddBalance(amount);
    }

    public static void SubtractBalance(BigDecimal amount) throws Exception {
        VendingMachine.AddBalance(new BigDecimal("-"+amount.toString()));
    }

   // public static Balance RemoveBalance() {
   //     try {
   //         return VendingMachine.RemoveBalance();
   //     } catch (Exception e) {
   //         return new Balance(new String("0.00"));
   //     }
   // }
}


