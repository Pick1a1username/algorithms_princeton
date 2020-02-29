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

        int topIndex = 0;
        int bottomIndex = (n*n)+1;
        int gridLength = (n*n)+2;

        // Two should be added since there are two more node:
        // top node and bottom node.
        grid = new int[gridLength];

        // Set id of each object to -1, which means 'not open'.
        for (int i = 0; i < gridLength; i++) grid[i] = -1;

        // Set id of the top and bottom objects to itself.
        grid[topIndex] = topIndex;
        grid[bottomIndex] = bottomIndex;

        // Set id of objects at the top row and the bottom row
        // to the top node and the bottom node respectively.
        for (int i = 1; i <= n; i++) grid[i] = topIndex;
        for (int i = (n*n) - (n+1); i <= n; i++) grid[i] = bottomIndex;
    }

    private int root(int target)
    {
        if (grid[target] == -1) return target;
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

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        // Todo: 
        // if (i == j) return;
        // if (sz[i] < sz[j]) { id[i] = j; sz[j] += sz[i]; }
        // else               { id[j] = i; sz[i] += sz[j]; }

        grid[i] = j;
    }

    // opens the site (row, col) if it is not open already
    // Todo: colRwoToIndex can be called only once.
    public void open(int row, int col) {
        // Throw an IllegalArgumentException if any argument to open(), isOpen(), or isFull() is outside its prescribed range.
        if (col > size || col < 1 || row > size || row < 1) {
            throw new IllegalArgumentException("Out of Range");
        }
        
        if (grid[colRowToIndex(row, col)] == -1) {
            // Open the site.
            grid[colRowToIndex(row, col)] = colRowToIndex(row, col);

            // If size > 1, check sites around the site.
            // If there are sites, connect it with the site.
            if (size > 1) {
                // Left
                if ( col > 1 ) {
                    if ( isOpen(row, col-1) == true ) union(colRowToIndex(row, col), colRowToIndex(row, col-1));
                }

                // Right
                if ( col < size ) {
                    if ( isOpen(row, col+1) == true ) union(colRowToIndex(row, col), colRowToIndex(row, col+1));    
                }

                // Up
                if ( row < size ) {
                    if ( isOpen(row-1, col) == true ) union(colRowToIndex(row, col), colRowToIndex(row-1, col));
                }

                // Down
                if ( (size - row) >= 1 ) {
                    if ( isOpen(row+1, col) == true ) union(colRowToIndex(row, col), colRowToIndex(row+1, col));
                }
            }

        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) { 
        // Throw an IllegalArgumentException if any argument to open(), isOpen(), or isFull() is outside its prescribed range.
        if (col > size || col < 1 || row > size || row < 1) {
            throw new IllegalArgumentException("Out of Range");
        }
        return grid[colRowToIndex(row, col)] != -1;
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