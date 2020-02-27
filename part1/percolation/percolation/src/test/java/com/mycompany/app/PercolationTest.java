package com.mycompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PercolationTest 
{
    @Test
    public void instantiateClass()
    {
        Percolation newObject = new Percolation(2);
        assertNotNull(newObject);
    }

    @Test
    public void instantiateClassException()
    {
        try {
            Percolation newObject = new Percolation(-1);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("The argument should be greater than zero.", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }
    }
}
