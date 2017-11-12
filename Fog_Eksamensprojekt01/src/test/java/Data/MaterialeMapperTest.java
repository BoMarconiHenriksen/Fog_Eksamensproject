/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Presentation.NewException;
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
public class MaterialeMapperTest {
    
    public MaterialeMapperTest() {
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
     * Test of getMaterial method, of class MaterialeMapper.
     * @throws Presentation.NewException
     */
    @Test
    public void testGetMaterial() throws NewException {
        System.out.println("getMaterial");
        String expResult = "Stk";
        String result = MaterialeMapper.getMaterial().get(1).getEnhed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }

    /**
     * Test of getMaterialeByVarenummer method, of class MaterialeMapper.
     * @throws Presentation.NewException
     */
    @Test
    public void testGetMaterialeByVarenummer() throws NewException {
        System.out.println("getMaterialeByVarenummer");
        int varenummer = 1;
       String expResult = "Træ";
        String result = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMaterialetype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }

  
    
}
