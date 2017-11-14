package vendingMachine.Models;

import java.math.BigDecimal;

public class Balance {
    private BigDecimal BalanceAmount;
    public Balance(BigDecimal balanceAmount){
        BalanceAmount = balanceAmount;
    }
    public BigDecimal getBalanceAmount(){return BalanceAmount;}
    @Override
    public String toString(){
        return new String("BalanceAmount:"+ getBalanceAmount());
    }
}
