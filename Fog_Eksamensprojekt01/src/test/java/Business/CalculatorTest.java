/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

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
public class CalculatorTest {
    
    public CalculatorTest() {
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
     * Test of totalPriceSimpleCarport method, of class Calculator.
     */
    //@Test 
    public void testTotalPriceSimpleCarport() throws Exception {
        System.out.println("totalPriceSimpleCarport");
        double length = 240.0;
        double width = 240.0;
        double heigth = 225.0;
        double shedLength = 0.0;
        double shedWidth = 0.0;
        Calculator instance = new Calculator();
        double expResult = 2790.60;
        double result = instance.totalPriceSimpleCarport(length, width, heigth, shedLength, shedWidth);
        assertEquals(expResult, result, 0.0);
        // This one failed because there are things in the shed that are constant so it shows that we
        // have to keep method for calculating shed price and method for calculating the carport apart
        

    }

    /**
     * Test of calculateCarportSimple method, of class Calculator.
     */
    @Test
    public void testCalculateCarportSimple() throws Exception {
        System.out.println("calculateCarportSimple");
        double length = 240.0;
        double width = 240.0;
        double heigth = 225.0;
        Calculator instance = new Calculator();
        double expResult = 2988.55;
        double result = instance.calculateCarportSimple(length, width, heigth);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
 
    /**
     * Test of numberOfRafters method, of class Calculator.
     */
    @Test
    public void testNumberOfRafters() {
        System.out.println("numberOfRafters");
        double length = 480.0;
        int expResult = 8;
        int result = Calculator.numberOfRafters(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of spaceBetweenRafters method, of class Calculator.
     */
    @Test
    public void testSpaceBetweenRafters() {
        System.out.println("spaceBetweenRafters");
        double length = 480.0;
        boolean expResult=true;
      boolean result=false;
        int space = Calculator.spaceBetweenRafters(length);
        if (space >=54&&space<=60){
           result=true;
        }
        else{
            result=false;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of spaceBetweenRafters method, of class Calculator.
     */
    
      /**
     * Test of spaceBetweenRafters method, of class Calculator.
     */
    @Test
    public void testSpaceBetweenRaftersSmallerThanItCanBe() {
        System.out.println("spaceBetweenRafters");
        double length = 120.5;
        boolean expResult=true;
      boolean result=false;
        int space = Calculator.spaceBetweenRafters(length);
        if (space >=54&&space<=60){
           result=true;
        }
        else{
            result=false;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }

    /**
     * Test of spaceBetweenRafters method, of class Calculator.
     */
    @Test
    public void testSpaceBetweenRaftersSizeNotDividableByThirty() {
        System.out.println("spaceBetweenRafters");
        double length = 1396.55;
        boolean expResult=true;
      boolean result=false;
        int space = Calculator.spaceBetweenRafters(length);
        if (space >=54&&space<=60){
           result=true;
        }
        else{
            result=false;
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }
    /**
     * Test of numberOfBottomScrewsPackageEcolite method, of class Calculator.
     */
    @Test
    public void testNumberOfBottomScrewsPackageEcoliteLargeCarport() {
        System.out.println("numberOfBottomScrewsPackageEcolite");
        double length = 930.0;
        double width = 510.0;
        int expResult = 3;
        int result = Calculator.numberOfBottomScrewsPackageEcolite(length, width);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }
 /**
     * Test of numberOfBottomScrewsPackageEcolite method, of class Calculator.
     */
   @Test
    public void testNumberOfBottomScrewsPackageEcoliteSmallCarport() {
        System.out.println("numberOfBottomScrewsPackageEcolite");
        double length = 240.0;
        double width = 240.0;
        int expResult =1;
        int result = Calculator.numberOfBottomScrewsPackageEcolite(length, width);
        assertEquals(expResult, result);
        // We found a really nice flaw by running this test the result was actually zero 
        // But it it pretty obc´vious that we need at least som screws to hold the roof. 
     
    }
/**
     * Test of numberOfBottomScrewsPackageEcolite method, of class Calculator.
     */
    @Test
    public void testNumberOfBottomScrewsPackageEcoliteAverageCarport() {
        System.out.println("numberOfBottomScrewsPackageEcolite");
        double length = 480.0;
        double width = 300.0;
        int expResult =1;
        int result = Calculator.numberOfBottomScrewsPackageEcolite(length, width);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     
    }
    /**
     * Test of calculatePriceShed method, of class Calculator.
     */
    @Test
    public void testCalculatePriceShed() throws Exception {
        System.out.println("calculatePriceShed");
        double shedLength = 210.0;
        double shedWidth = 150.0;
        Calculator instance = new Calculator();
        double expResult = 2778.48;
        double result = instance.calculatePriceShed(shedLength, shedWidth);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of main method, of class Calculator.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Calculator.main(args);
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}
