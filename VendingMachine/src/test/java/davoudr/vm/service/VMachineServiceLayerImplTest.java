/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package davoudr.vm.service;

import davoudr.vm.dao.VMachineAuditDao;
import davoudr.vm.dao.VMachineDao;
import davoudr.vm.dao.VMachinePersistenceException;
import davoudr.vm.dto.Item;
import java.math.BigDecimal;
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
public class VMachineServiceLayerImplTest {
    
    private VMachineServiceLayer service;

    
    public VMachineServiceLayerImplTest() {
        
        VMachineDao dao = new VMachineDaoStubImpl();
        VMachineAuditDao auditDao  = new VMachineAuditDaoStubImpl();    
        
        service = new VMachineServiceLayerImpl(dao, auditDao);
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetAllItems() throws VMachinePersistenceException {
        Item testItem = new Item ("Coca");
        testItem.setCost(BigDecimal.ONE);
        testItem.setInventory(10);
        
        assertEquals(2, service.getAllItems().size(),"Should have 2 Items");
        assertTrue(service.getAllItems().contains(testItem),"The item should be pepsi.");
    }
    
    
    @Test
    public void testGetItems() throws VMachinePersistenceException {
        Item testItem = new Item ("Coca");
        testItem.setCost(BigDecimal.ONE);
        testItem.setInventory(10);
        
        Item shouldBeCoca = service.getItem("Coca");
        assertNotNull(shouldBeCoca, "getting Coca should not be null.");
        assertEquals( shouldBeCoca, testItem,"Items should be the same.");
    }
    
    
    @Test
    public void testAddFundAndGetFund() {
        service.addFund(0);
        float testFundAmount = service.getFund();
        
        assertNotNull(testFundAmount, "getting fund should not be null.");
        assertEquals(8, testFundAmount, "Values should be the same.");
    }
    
    @Test
    public void testSpendMoneyAndGetFund() {
        service.spendMoney(0);
        float testFundAmount = service.getFund();
        
        assertNotNull(testFundAmount, "getting fund should not be null.");
        assertEquals(6, testFundAmount, "Values should be the same.");
    }
    
    
    @Test
    public void testVending() {
        try {
            service.checkFund(12);
            fail("Expected ValidationException was not thrown.");
        } catch (VMachineInsufficientFands e) {
            return;
        }
    } 
    
    @Test
    public void testCheckInventory () throws VMachinePersistenceException {
        try {
            service.checkInventory("Pepsi");
            fail("Expected VMachineNoItemInventoryException was not thrown.");
        } catch (VMachineNoItemInventoryException e) {
            return;
        }
    }
}
