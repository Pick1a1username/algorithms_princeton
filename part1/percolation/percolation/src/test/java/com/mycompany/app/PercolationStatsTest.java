package com.mycompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

public class PercolationStatsTest 
{
    @Test
    public void instantiateClass()
    {
        PercolationStats newObject = new PercolationStats(3, 1);
        assertNotNull(newObject);
    }

    @Test
    public void instantiateClassException()
    {
        try {
            PercolationStats newObject = new PercolationStats(-3, -10);
            fail("Exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("The arguments should be greater than zero.", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown");
        }
    }

    // @Test
    // public void testIsOpen()
    // {
    //     Percolation grid = new Percolation(3);
    //     assertEquals(false, grid.isOpen(1, 1));
    //     grid.open(1, 1);
    //     assertEquals(true, grid.isOpen(1, 1));

    // }

    // @Test
    // public void testIsOpenException()
    // {
    //     try {
    //         Percolation gridOne = new Percolation(3);
    //         gridOne.isOpen(4,1);
    //         fail("Exception not thrown");
    //     } catch (IllegalArgumentException e) {
    //         assertEquals("Out of Range", e.getMessage());
    //     } catch (Exception e) {
    //         fail("Unexpected exception thrown");
    //     }

    //     try {
    //         Percolation gridTwo = new Percolation(3);
    //         gridTwo.isOpen(1,4);
    //     } catch (IllegalArgumentException e) {
    //         assertEquals("Out of Range", e.getMessage());
    //     } catch (Exception e) {
    //         fail("Unexpected exception thrown");
    //     }
    // }

}
