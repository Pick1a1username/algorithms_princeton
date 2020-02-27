package com.mycompany.app;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int size;
    private int[] grid;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        // Throw an IllegalArgumentException in the constructor if n ≤ 0. 
        if (n <= 0) {
            throw new IllegalArgumentException("The argument should be greater than zero.");
        }
        size = n;

        // Two should be added since there are two more node:
        // top node and bottom node.
        grid = new int[(n*n)+2];

        // Set id of each object to itself.
        for (int i = 0; i < (n*n)+2; i++) grid[i] = i;

        // Set id of objects at the top row and the bottom row
        // to the top node and the bottom node respectively.
        for (int i = 1; i <= n; i++) grid[i] = 0;
        for (int i = (n*n) - (n+1); i <= n; i++) grid[i] = n+2;
    }

    private int root(int target)
    {
        // Chase parent pointers until reach root
        while (target != grid[target]) target = grid[target];
        return target;
    }

    private int colRowToIndex(int row, int col) {
        if (col > size || col < 1 || row > size || row < 1) {
            throw new IllegalArgumentException("Out of Range");
        }
        return ((row-1)*size)+col;        
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        // Throw an IllegalArgumentException if any argument to open(), isOpen(), or isFull() is outside its prescribed range.
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) { 
        // Throw an IllegalArgumentException if any argument to open(), isOpen(), or isFull() is outside its prescribed range.
        if (col > size || col < 1 || row > size || row < 1) {
            throw new IllegalArgumentException("Out of Range");
        }
        return grid[((row-1)*size)+col] != ((row-1)*size)+col;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        // Throw an IllegalArgumentException if any argument to open(), isOpen(), or isFull() is outside its prescribed range.
        if (col > size || col < 1 || row > size || row < 1) {
            throw new IllegalArgumentException("Out of Range");
        }
        return root(colRowToIndex(row, col)) == root(0);
    }

    // returns the number of open sites
    public int numberOfOpenSites() { return 1;}

    // does the system percolate?
    public boolean percolates() { return true; }

    // test client (optional)
    public static void main(String[] args) {}
}