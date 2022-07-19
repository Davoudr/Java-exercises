/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package davoudr.vm.dao;

import davoudr.vm.dto.Item;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author davoudramezanikermani
 */
public class VMachineDaoImplTest {
    
    VMachineDao testDao;
    
    public VMachineDaoImplTest() {
    }
    
    
    @BeforeEach
    public void setUp() throws IOException {
        
        String testFile = "testItems.txt";
        new FileWriter(testFile);
        testDao = new VMachineDaoImpl(testFile);
        // file includes only one line ---> Water::1::100
        // name : Water / price : 1 / inventory : 100
    }
    
    
//    @Test
//    public void testGetAllItems() throws VMachinePersistenceException {
//        
//        Item testItem = new Item ("Water");
//        testItem.setCost(BigDecimal.ONE);
//        testItem.setInventory(100);
//        
//        List<Item> testItemList = new ArrayList<>();
//        testItemList.add(testItem);
//        
//        List<Item> listReturnedByMethod = testDao.getAllItems();
//        
//        assertEquals(testItem,listReturnedByMethod.get(0),
//                    "both should be Water/1/100");
//    }
    
}
