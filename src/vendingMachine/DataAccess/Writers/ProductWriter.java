package vendingMachine.DataAccess.Writers;

import vendingMachine.DataAccess.DataHandler;
import vendingMachine.Models.Product;

//This class should write to some file in csv format
public class ProductWriter {

    public static void AddProduct (Product product){
        try {
            DataHandler.WriteProductToFile(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void RemoveProduct (Product product){
        try{
            DataHandler.RemoveProduct(product);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}