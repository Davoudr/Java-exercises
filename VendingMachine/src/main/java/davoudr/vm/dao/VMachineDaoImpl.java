/**
 * @author: Davoud Ramezani Kermani
 * email:   davoud.rk@gmail.com
 * date:    2022
 * purpose: ""
 */

package davoudr.vm.dao;

import davoudr.vm.dto.Change;
import davoudr.vm.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class VMachineDaoImpl implements VMachineDao{

//-------------------------------------------    
    private final String ITEMS_FILE;
    private final String DELIMITER = "::";

    private Map<String, Item> items = new HashMap<>();
    
    private float fund = 0;
    private Change change;
//-------------------------------------------      
    public VMachineDaoImpl () {
        ITEMS_FILE = "items.txt";
    }
        
    public VMachineDaoImpl (String itemsTextFileName) {
        ITEMS_FILE = itemsTextFileName;
    }
//-------------------------------------------      
    @Override
    public List<Item> getAllItems() throws VMachinePersistenceException {
        loadItems();
        return new ArrayList<Item>(items.values());
    }
    
    @Override 
    public Item getItem(String itemName)  throws VMachinePersistenceException {
        loadItems();
        return items.get(itemName);
    }
    
    @Override 
    public void addFund(float addedFund) {
        fund += addedFund;
    }
    
    @Override 
    public float spendMoney(float price) {
        return fund -= price;
    }
    
    @Override 
    public float getFund() {
        return fund;
    }
    
    @Override 
    public String chnageToReturn(float inDollar){
        String inDollarStr = String.valueOf(inDollar);
        BigDecimal dollarValue = new BigDecimal(inDollarStr);
        change = new Change (dollarValue.setScale(2, RoundingMode.HALF_UP));
        return change.toString();
    }
    
    @Override
    public void updateInventory(String theItemName) throws VMachinePersistenceException{
        Item soldItem = getItem(theItemName);
        if (soldItem.getInventory()>0) {
           soldItem.setInventory(soldItem.getInventory()-1); 
        }
        items.put(theItemName, soldItem);
    }
    
    @Override
    public void updateFile() throws VMachinePersistenceException {
        writeItems();
    }
    
//-------------------------------------------    
    private Item unmarshallItem(String itemAsText) {
        
        String[] studentTokens = itemAsText.split(DELIMITER);
        
        String itemName = studentTokens[0];
        BigDecimal itemCost = new BigDecimal(studentTokens[1]);
        int ItemInventory =  Integer.parseInt(studentTokens[2]);
        
        Item itemFromFile = new Item(itemName, itemCost, ItemInventory);
        
        return itemFromFile;
    }
//---------------------   
    private String marshallItem(Item itemObj) {
        
        String itemAsText  = itemObj.getName() + DELIMITER;
        
        BigDecimal cost = itemObj.getCost();
        itemAsText += cost.toString();
        itemAsText += DELIMITER;
        
        int inventory = itemObj.getInventory();
        itemAsText += String.valueOf(inventory);
        
        return itemAsText;
    }
//-------------------------------------------  
/*
updates items collection by file content!
*/
    private void loadItems() throws VMachinePersistenceException {
        
        Scanner sc;

        try {
            sc = new Scanner (
                    new BufferedReader (
                        new FileReader ( ITEMS_FILE )));
        } catch (FileNotFoundException e) {
            throw new VMachinePersistenceException ("Could not load items data into memory.", e);
        }
            
        String currentLine;
        Item currentItem;
        
        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentItem = unmarshallItem(currentLine);
            items.put(currentItem.getName(), currentItem);
        }
        sc.close();
    }
//---------------------    
    private void writeItems() throws VMachinePersistenceException {
        
        PrintWriter pw;
        
        try {
            pw = new PrintWriter (
                    new FileWriter (ITEMS_FILE));
        } catch (IOException e) {
            throw new VMachinePersistenceException ("Could not save items data", e);
        }
        
        List<Item> itemsList = this.getAllItems();
        
        itemsList.stream()
                .map(item -> marshallItem(item))
                .forEach(itemAsText -> {
                    pw.println(itemAsText);
                    pw.flush();
                });
        
        pw.close();
    }
//------------------------------------------- 

    
    
}
