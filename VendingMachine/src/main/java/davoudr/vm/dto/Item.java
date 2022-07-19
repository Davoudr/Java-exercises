/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */


package davoudr.vm.dto;

import java.math.BigDecimal;
import java.util.Objects;


public class Item {
    private String name;
    private BigDecimal cost;
    private int inventory;    

    /*
    constructors
    */
    
    public Item (String name) {
        this.name = name;
    }
    
    
    public Item (String name, BigDecimal cost, int inventory) {
        this.name = name;
        this.cost = cost;
        this.inventory = inventory;
    }    
    
    /*
    getter & setter
    */
    
    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
    
//    --------------
    
    @Override
    public String toString() {
        return this.name 
                + "\n    $" + this.cost
                + "---------"
                + " in stock " + this.inventory;
    }

//    --------------
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.cost);
        hash = 89 * hash + this.inventory;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.inventory != other.inventory) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.cost, other.cost);
    }


  
}

