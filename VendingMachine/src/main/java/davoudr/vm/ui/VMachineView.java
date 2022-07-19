/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */


package davoudr.vm.ui;


import davoudr.vm.dto.Item;
import java.util.List;


public class VMachineView {
// ------------------------------------------ 
    private UserIO io;
    
    public VMachineView (UserIO io) {
        this.io = io;
    }
// ------------------------------------------ 

    
    
    
    
    
    
    
    
    
// ------------------------------------------   
    public void welcomeBanner () {
        io.print("-----------------------------");
        io.print("-----------WELCOME-----------");
        io.print("-----------------------------");
    }
// ------------------------------------------
    public void showItemList(List<Item> items) {
        io.print("-----------------------------");
        io.print("-----------------------------");
        items.stream()
                .map( (item) -> item.toString())
                .forEach(str -> io.print(str));
    }
// ------------------------------------------
    public String getItemNameSellection() {
        io.print("-----------------------------");
        io.print("-------Sellect the Item------");
        return io.readString("Please sellect one item by its name!");
    }
// ------------------------------------------
    public float prtintInitialOptionAndGetSellection() {
        io.print("-----------------------------");
        io.print("------------Options----------");
        io.print("Adding Fund: Insert the fund amount that you want to spend in $ i.e. 9.99!");
        return io.readFloat("Adding Fund: Insert zero if you want to exit the program!", 0, 100);
    }
// ------------------------------------------
    public void displayError(String message) {
        io.print("-----------------------------");
        io.print("-------------Error-----------");
        io.print(message);
    }
// ------------------------------------------ 
    public void successfulAddingFund(float fund) {
        io.print("-----------------------------");
        io.print("--$" + fund + " added successfully--");
        io.print("-----------------------------");
    }
// ------------------------------------------ 
    public String getUserSellectionFromItems() {
        io.print("-----------------------------");
        return io.readString("----Choose an Item by name---");
    }
// ------------------------------------------ 
    public void wrongItemName() {
        displayError("The inserted item name is not included in the list, try again!");
    }
// ------------------------------------------  
    public void successfullPurchase(String message) {
        io.print("------------------------------");
        io.print("--You purchased successfully--");
        io.print(message);
    }
// ------------------------------------------
}
