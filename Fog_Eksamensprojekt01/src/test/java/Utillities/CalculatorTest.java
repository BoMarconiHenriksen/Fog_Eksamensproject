/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import Business.Calculator;
import Business.Exception.NewException;
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
public class CalculatorTest {
    
    /**
     *
     */
    public CalculatorTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }
    
    

    /**
     * Test of calculateCarportSimple method, of class Calculator.
     * @throws Business.Exception.NewException
     */
    @Test
    public void testCalculateCarportSimpleSmall()   throws NewException{
        try {
            System.out.println("calculateCarportSimple");
            double length = 240.0;
            double width = 240.0;
            double heigth = 225.0;
            Calculator instance = new Calculator();
            double expResult = 2988.55;
            double result = instance.calculateCarportSimple(length, width, heigth);
            assertEquals(expResult, result, 0.0);
            // TODO review the generated test code and remove the default call to fail.
        } catch (NewException ex) {
            Logger.getLogger(CalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     /**
     * Test of calculateCarportSimple method, of class Calculator.
     * @throws Business.Exception.NewException
     */
    @Test
    public void testCalculateCarportSimpleMedium()  throws NewException {
        try {
            System.out.println("calculateCarportSimple");
            double length = 480.0;
            double width = 300.0;
            double heigth = 225.0;
            Calculator instance = new Calculator();
            double expResult = 4300.26;
            double result = instance.calculateCarportSimple(length, width, heigth);
            assertEquals(expResult, result, 0.0);
            // TODO review the generated test code and remove the default call to fail.
        } catch (NewException ex) {
            Logger.getLogger(CalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
     /**
     * Test of calculateCarportSimple method, of class Calculator.
     * @throws Business.Exception.NewException
     */
    @Test
    public void testCalculateCarportSimpleLarge()  throws NewException {
        try {
            System.out.println("calculateCarportSimple");
            double length = 600.0;
            double width = 480.0;
            double heigth = 225.0;
            Calculator instance = new Calculator();
            double expResult = 6739.36;
            double result = instance.calculateCarportSimple(length, width, heigth);
            assertEquals(expResult, result, 0.01);
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception ex) {
            Logger.getLogger(CalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    /**
     *
     * @throws NewException
     */
    @Test
    public void testCalculateCarportSimpleLongerThanAnyEcolite() throws NewException   {
        try {
            System.out.println("calculateCarportSimple");
            double length = 660.0;
            double width = 480.0;
            double heigth = 225.0;
            Calculator instance = new Calculator();
            double expResult = 6959.85;
            double result = instance.calculateCarportSimple(length, width, heigth);
            assertEquals(expResult, result, 0.0);
            // igen en god ting at teste det hele. Jeg fandt ud af at jeg ikke havde
            // for alle tre ecoliteTagUdregninger og derved fik jeg rettet sÃ¥ at der
            //skulle regnes to slags tagplader ind i regnestykket nÃ¥r carportens
            //lÃ¦ngde var stÃ¸rre end 600
        } catch (Exception ex) {
            Logger.getLogger(CalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
       
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
      boolean result;
        int space = Calculator.spaceBetweenRafters(length);
        result = space >=54&&space<=60;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
   
    }

  
    
      /**
     * Test of spaceBetweenRafters method, of class Calculator.
     */
    @Test
    public void testSpaceBetweenRaftersSmallerThanItCanBe() {
        System.out.println("spaceBetweenRafters");
        double length = 120.5;
        boolean expResult=true;
      boolean result;
        int space = Calculator.spaceBetweenRafters(length);
        result = space >=54&&space<=60;
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
      boolean result;
        int space = Calculator.spaceBetweenRafters(length);
        result = space >=54&&space<=60;
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
        // But it it pretty obcÂ´vious that we need at least some screws to hold the roof. 
     
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
     * Test of numberOfBottomScrewsPackageEcolite method, of class Calculator.
     */
    @Test
    public void testNumberOfBottomScrewsPackageEcoliteNull() {
        System.out.println("numberOfBottomScrewsPackageEcolite");
        double length = 0.0;
        double width = 0.0;
        int expResult = 0;
        int result = Calculator.numberOfBottomScrewsPackageEcolite(length, width);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
    
    /**
     * Test of calculatePriceShed method, of class Calculator.
     * @throws Business.Exception.NewException
     */
    @Test
    public void testCalculatePriceShed() throws NewException {
        try {
            System.out.println("calculatePriceShed");
            double shedLength = 210.0;
            double shedWidth = 150.0;
            Calculator instance = new Calculator();
            double expResult = 2778.48;
            double result = instance.calculatePriceShed(shedLength, shedWidth);
            assertEquals(expResult, result, 0.0);
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception ex) {
            Logger.getLogger(CalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

 



    /**
     * Test of calculateNumberOfRafters method, of class Calculator.
     */
    @Test
    public void testCalculateNumberOfRaftersNull() {
        System.out.println("calculateNumberOfRafters");
        double length = 0.0;
        int expResult = 0;
        int result = Calculator.calculateNumberOfRafters(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of CalculateWidthForRemmeISiderSkur method, of class Calculator.
     */
    @Test
    public void testCalculateWidthForRemmeISiderSkur() {
        System.out.println("CalculateWidthForRemmeISiderSkur");
        double skurBredde = 150.0;
        double expResult = 300;
        double result = Calculator.CalculateWidthForRemmeISiderSkur(skurBredde);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
     
    }

    /**
     * Test of calculateNumberOfEcoliteRoof method, of class Calculator.
     */
    @Test
    public void testCalculateNumberOfEcoliteRoof() {
        System.out.println("calculateNumberOfEcoliteRoof");
        double width = 300.0;
        int expResult = 3;
        int result = Calculator.calculateNumberOfEcoliteRoof(width);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
      /**
     * Test of calculateNumberOfEcoliteRoof method, of class Calculator.
     */
    @Test
    public void testCalculateNumberOfEcoliteRoofSmall() {
        System.out.println("calculateNumberOfEcoliteRoof");
        double width = 240.0;
        int expResult = 3;
        int result = Calculator.calculateNumberOfEcoliteRoof(width);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of CalculateCoverWoodShed method, of class Calculator.
     */
    @Test
    public void testCalculateCoverWoodShed() {
        System.out.println("CalculateCoverWoodShed");
        double skurBredde = 150.0;
        double skurLængde = 270.0;
        double expResult = 84.0;
        double result = Calculator.CalculateCoverWoodShed(skurBredde, skurLængde);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of calculateCarportSimple method, of class Calculator.
     * @throws Business.Exception.NewException
     */
    @Test
    public void testCalculateCarportSimpleZero() throws  NewException  {
        System.out.println("calculateCarportSimple");
        double length = 0.0;
        double width = 0.0;
        double heigth = 0.0;
        Calculator instance = new Calculator();
        double expResult = 0.0;
        double result = instance.calculateCarportSimple(length, width, heigth);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
      
    }


    /**
     * Test of numberOfBottomScrewsPackageEcolite method, of class Calculator.
     */
    @Test
    public void testNumberOfBottomScrewsPackageEcoliteZero() {
        System.out.println("numberOfBottomScrewsPackageEcolite");
        double length = 0.0;
        double width = 0.0;
        int expResult = 0;
        int result = Calculator.numberOfBottomScrewsPackageEcolite(length, width);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of main method, of class Calculator.
     * @throws Business.Exception.NewException
     */
    @Test
    public void testMain()  throws NewException{
        try {
            System.out.println("main");
            String[] args = null;
            Calculator.main(args);
            // TODO review the generated test code and remove the default call to fail.
        } catch (Exception ex) {
            Logger.getLogger(CalculatorTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    /**
     * Test of calculateNumberOfRafters method, of class Calculator.
     */
    @Test
    public void testCalculateNumberOfRafters() {
        System.out.println("calculateNumberOfRafters");
        double length = 0.0;
        int expResult = 0;
        int result = Calculator.calculateNumberOfRafters(length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
  
    }
    
   

  
    
}
