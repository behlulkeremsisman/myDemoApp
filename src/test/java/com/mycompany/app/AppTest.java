package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest
extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }
    
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        ArrayList<Integer> evenNumbersArray = new ArrayList<>(Arrays.asList(2, 4));
        assertTrue(new App().findEvenNumbers(array, 5, evenNumbersArray).equals(evenNumbersArray));
    }
    
    public void testNotFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(10,20,25,27,30));
        ArrayList<Integer> evenNumbersArray = new ArrayList<>(Arrays.asList(10,20));
        assertFalse(!new App().findEvenNumbers(array, 26, evenNumbersArray).equals(evenNumbersArray));
    }
    
    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<Integer> evenNumbersArray = new ArrayList<>(Arrays.asList());
        assertFalse(!array.isEmpty());
    }
    
    public void testNull() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        ArrayList<Integer> evenNumbersArray = new ArrayList<>(Arrays.asList());
        assertFalse(!evenNumbersArray.isEmpty());
    }
}
