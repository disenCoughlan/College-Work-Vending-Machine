package vendingMachine.DataAccess.Writers;

import vendingMachine.DataAccess.DataHandler;
import vendingMachine.Models.Balance;

public class BalanceWriter {
    public static void AddBalance (Balance balance){
        try {
            DataHandler.WriteBalanceToFile(balance);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
