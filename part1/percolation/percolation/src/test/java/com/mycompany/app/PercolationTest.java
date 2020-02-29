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
    public void testIsOpen()
    {
        Percolation grid = new Percolation(3);
        assertEquals(false, grid.isOpen(1, 1));
        grid.open(1, 1);
        assertEquals(true, grid.isOpen(1, 1));

    }

    @Test
    public void testIsOpenException()
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

    @Test
    public void testIsFull()
    {
        Percolation grid = new Percolation(3);
        
        assertEquals(false, grid.isFull(1, 1));
        grid.open(1, 1);
        assertEquals(true, grid.isFull(1, 1));

        assertEquals(false, grid.isFull(3, 3));
        grid.open(3, 3);
        assertEquals(false, grid.isFull(3, 3));
    }

    @Test
    public void testIsFullException()
    {
        try {
            Percolation gridOne = new Percolation(3);
            gridOne.isFull(4,1);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Out of Range", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }

        try {
            Percolation gridTwo = new Percolation(3);
            gridTwo.isFull(1,4);
        } catch (IllegalArgumentException e) {
            assertEquals("Out of Range", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }
    }

    // Todo: Should be revised.
    @Test
    public void testOpen()
    {
        Percolation grid = new Percolation(5);

        // Up
        assertEquals(false, grid.isOpen(2,1));
        grid.open(1,1);
        grid.open(2,1);
        assertEquals(true, grid.isOpen(2,1));
        assertEquals(true, grid.isFull(2,1));

        // Nothing
        assertEquals(false, grid.isOpen(3,3));
        grid.open(3,3);
        assertEquals(true, grid.isOpen(3,3));
        assertEquals(false, grid.isFull(3,3));

        // Left
        assertEquals(false, grid.isOpen(3,4));
        grid.open(3,4);
        assertEquals(true, grid.isOpen(3,4));
        assertEquals(false, grid.isFull(3,4));

        // Right
        assertEquals(false, grid.isOpen(3,2));
        grid.open(3,2);
        assertEquals(true, grid.isOpen(3,2));
        assertEquals(false, grid.isFull(3,2));

        // Down
        assertEquals(false, grid.isOpen(5,1));
        grid.open(5,1);
        assertEquals(true, grid.isOpen(5,1));
        assertEquals(false, grid.isFull(5,1));

        // Test percull..
        grid.open(3,1);
        grid.open(4,1);
        assertEquals(true, grid.isFull(5,1));
    }


    @Test
    public void testOpenException()
    {
        try {
            Percolation gridOne = new Percolation(3);
            gridOne.open(4,1);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Out of Range", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }

        try {
            Percolation gridTwo = new Percolation(3);
            gridTwo.open(1,4);
        } catch (IllegalArgumentException e) {
            assertEquals("Out of Range", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }
    }

    @Test
    public void testPercolates()
    {
        Percolation grid = new Percolation(3);
        
        assertEquals(false, grid.percolates());
        
        grid.open(1,1);
        grid.open(2,1);
        grid.open(3,1);

        assertEquals(true, grid.isFull(1, 1));
        assertEquals(true, grid.isFull(2, 1));
        assertEquals(true, grid.isFull(3, 1));

        assertEquals(true, grid.percolates());
    }

    @Test
    public void testNumberOfOpenSites()
    {
        Percolation grid = new Percolation(3);

        assertEquals(0, grid.numberOfOpenSites());

        grid.open(1, 1);
        grid.open(2, 2);
        grid.open(3, 3);

        assertEquals(3, grid.numberOfOpenSites());
    }
}
