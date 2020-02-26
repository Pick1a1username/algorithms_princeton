package com.mycompany.app;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        // Throw an IllegalArgumentException in the constructor if n ≤ 0. 
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        // Throw an IllegalArgumentException if any argument to open(), isOpen(), or isFull() is outside its prescribed range.
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) { 
        // Throw an IllegalArgumentException if any argument to open(), isOpen(), or isFull() is outside its prescribed range.
        return true; 
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) { return true;}

    // returns the number of open sites
    public int numberOfOpenSites() { return 1;}

    // does the system percolate?
    public boolean percolates() { return true; }

    // test client (optional)
    public static void main(String[] args) {}
}