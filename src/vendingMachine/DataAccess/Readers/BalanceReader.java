package vendingMachine.DataAccess.Readers;

import vendingMachine.DataAccess.DataHandler;
import vendingMachine.Models.Balance;

public class BalanceReader {
    public static Balance LoadBalance() throws Exception {
        return DataHandler.GetBalancesFromFile();
    }
}