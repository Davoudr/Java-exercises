/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */


package davoudr.vm.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class Change {

     private int penny;
     private int nickle;
     private int dime;
     private int quarter;
     private BigDecimal changeValue;
      
//--------------------------    
    public int getPenny() {
        return penny;
    }

    public void setPenny(int penny) {
        this.penny = penny;
    }
//-------------------------- 
    public int getNickle() {
        return nickle;
    }

    public void setNickle(int nickle) {
        this.nickle = nickle;
    }
//-------------------------- 
    public int getDime() {
        return dime;
    }

    public void setDime(int dime) {
        this.dime = dime;
    }
//-------------------------- 
    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }
//--------------------------     
    public BigDecimal getChangeValue() {
        return changeValue;
    }

    public void setChangeValue(BigDecimal changeValue) {
        this.changeValue = changeValue;
    }
//--------------------------     
    private void calculateAndSetCoin() {
        BigDecimal rounded = getChangeValue().setScale(2, RoundingMode.HALF_UP);
        BigDecimal roundedInCents = rounded.movePointRight(2);
        int cents;
        cents = roundedInCents.intValueExact();
//        
        setQuarter(Math.round(cents/Coin.QUARTER.getValue()));
        cents = cents - (getQuarter()*Coin.QUARTER.getValue());
//         
        setDime(Math.round(cents/Coin.DIME.getValue()));
        cents = cents - (getDime()*Coin.DIME.getValue());
//        
        setNickle(Math.round(cents/Coin.NICKLE.getValue()));
        cents = cents - (getNickle()*Coin.NICKLE.getValue());
//        
        setPenny(Math.round(cents/Coin.PENNY.getValue()));
    }
//--------------------------
/*
Constructors    
*/
    public Change (BigDecimal changeValue) {
         setChangeValue(changeValue);
         calculateAndSetCoin();
     }    
//--------------------------      
    @Override
    public String toString() {
        return "the change is in total $" 
                   + this.getChangeValue()  + " including: " 
                   + this.getQuarter()      + " quarter, "
                   + this.getDime()         + " dim, "
                   + this.getNickle()       + " nickle, "
                   + this.getPenny()        + " penny.";
    }
//--------------------------     

    
}





























