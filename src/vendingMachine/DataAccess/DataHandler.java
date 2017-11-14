package vendingMachine.DataAccess;

import vendingMachine.Models.Balance;
import vendingMachine.Models.Product;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.logging.FileHandler;

public class DataHandler {
    private static String directory = System.getProperty("user.dir");
    private static BufferedReader reader;
    private static String productFileName = "Product.csv";
    private static String balanceFileName = "Balance.txt";
    private static final String pathname = directory + "\\" + productFileName;
    private static int ProductLocation = 0;
    private static int ProductName = 1;
    private static int ProductPrice = 2;
    private static final String pathnameB = directory + "\\" + balanceFileName;

    public static ArrayList<Product> GetProductsFromFile() throws Exception {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(pathname);
        if(file.exists())
        {
            try{
                reader = new BufferedReader(new FileReader(pathname));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] product  = line.split(",");
                    products.add(new Product(
                            Integer.parseInt(product[ProductLocation]),
                            product[ProductName],
                            new BigDecimal(product[ProductPrice])));
                }
            } catch (Exception e) {
                throw new Exception("An issue occurred when reading data from product file." ,e);
            }
        }
        return products;
    }

    public static Balance GetBalancesFromFile() throws Exception {
        File file = new File(pathnameB);
        if(file.exists())
        {
            try {
                reader = new BufferedReader(new FileReader(pathnameB));
                String balance = reader.readLine();
                reader.close();
                return new Balance(new BigDecimal(balance));
            }catch (Exception e){
                throw new Exception("an issue occurred when reading data from balance file");
            }
        }
        return new Balance(new BigDecimal("0.00"));
    }

    public static void WriteBalanceToFile(Balance balance)throws Exception{
        CreateFile(pathnameB);
        try {
            Balance currentBalance = GetBalancesFromFile();
            BigDecimal currentBalanceAmount = currentBalance.getBalanceAmount();
            BigDecimal balanceToAdd = balance.getBalanceAmount();
            Balance newBalance = new Balance(currentBalanceAmount.add(balanceToAdd));
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathnameB, false));
            writer.append(new String(newBalance.getBalanceAmount() + "\n"));
            writer.close();
        }
        catch (Exception e)
        {
            throw new Exception("Issue adding Balance to file");
        }
    }

    public static void WriteProductToFile(Product product) throws Exception {
        CreateFile(pathname);
        try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(pathname, true));
                writer.append(new String(product.getProductLocation() +
                        "," + product.getProductName() +
                        "," + product.getProductPrice()
                            + "\n"));
                writer.close();
        }
        catch (Exception e)
        {
            throw new Exception("Issue adding product to file");
        }
    }

    public static void RemoveProduct(Product product) throws Exception
    {
        StringBuilder fileContents = new StringBuilder();
        reader = new BufferedReader(new FileReader(pathname));
        String line;
        boolean hasBeenRemoved = false;
        while((line = reader.readLine()) != null){
            if(!line.startsWith(product.getProductLocation() + ",") || hasBeenRemoved)
                fileContents.append(line + "\n");
            else{
                hasBeenRemoved = true;
            }
        }

            File file = new File(pathname);
        file.delete();
        file.createNewFile();

        BufferedWriter writer = new BufferedWriter(new FileWriter(pathname));
        writer.write(fileContents.toString());
        writer.close();
    }

    private static void CreateFile(String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists())
            file.createNewFile();

    }
}
