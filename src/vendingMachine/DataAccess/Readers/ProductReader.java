package vendingMachine.DataAccess.Readers;

import vendingMachine.DataAccess.DataHandler;
import vendingMachine.Models.Product;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
//This class should read from csv file in a certain format
public class ProductReader {

    public static ArrayList<Product> LoadProducts() throws Exception {//where does you enter the list?
        return DataHandler.GetProductsFromFile();
    }
}
