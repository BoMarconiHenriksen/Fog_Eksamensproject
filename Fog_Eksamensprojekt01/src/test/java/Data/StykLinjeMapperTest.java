/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.StykLinje;
import Presentation.NewException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ejer
 */
public class StykLinjeMapperTest {
    
    public StykLinjeMapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getStykLinje method, of class StykLinjeMapper.
     * @throws java.lang.Exception
     */
    @Test
    public void testGetStykLinje() throws NewException {
        System.out.println("getStykLinje");
        String expResult = "l";
        String result = StykLinjeMapper.getStykLinje().get(1).getDimension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of getStykLinjeById method, of class StykLinjeMapper.
     * @throws Presentation.NewException
     */
    @Test
    public void testGetStykLinjeById() throws NewException {
        try {
            System.out.println("getStykLinjeById");
            
            String expResult = "b";
            String result = StykLinjeMapper.getStykLinjeById(1).getDimension();
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StykLinjeMapperTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

  
    
}
