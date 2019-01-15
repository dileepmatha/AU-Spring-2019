package com.accolite.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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

    /* 
        Test case for getting max element
    */
	public void testMax() {
        assertEquals(4.0,App.Max());
    }
    /*
        Test case for getting min element
    */
    public void testMin() {
        assertEquals(0.0,App.Min());
	}
}
