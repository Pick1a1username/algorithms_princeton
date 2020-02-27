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

    @Test
    public void checkOpen()
    {
        Percolation grid = new Percolation(3);
        assertEquals(false, grid.isOpen(2,1));
        assertEquals(true, grid.isOpen(1,1));
    }

    @Test
    public void checkOpenException()
    {
        try {
            Percolation gridOne = new Percolation(3);
            gridOne.isOpen(4,1);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Out of Range", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }

        try {
            Percolation gridTwo = new Percolation(3);
            gridTwo.isOpen(1,4);
        } catch (IllegalArgumentException e) {
            assertEquals("Out of Range", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }
    }
}
