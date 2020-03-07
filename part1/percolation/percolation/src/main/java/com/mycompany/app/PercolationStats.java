package com.mycompany.app;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import com.mycompany.app.Percolation;

public class PercolationStats {

    private int size;
    private int trials;
    private int[] openSites;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        // Throw an IllegalArgumentException in the constructor if either n ≤ 0 or trials ≤ 0. 
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("The arguments should be greater than zero.");
        }

        // Initialize variables.
        this.size = n;
        this.trials = trials;
        this.openSites = new int[n];

        // Start calculation.

        // Simulate percolation n times.
        for (int i = 0; i < trials; i++) {
            openSites[i] = simulate(n);
        }
    }

    // Simulate percolation.
    private int simulate(int n) {
        // Percolation grid = new Percolation(n);

        // int[] cols;
        // int[] rows;
        // int col;
        // int row;

        // while (grid.percolates() == false) {
        //     col = StdRandom.discrete(cols);
        //     row = StdRandom.discrete(rows);
        //     grid.open(col, row);

        //     for (int i = 0; i < cols.length; i++) {
        //         cols[i] = 
        //     }

        //     System.out.println("aaa");
        // }

        // return grid.numberOfOpenSites();
        return 1;
    }

    // sample mean of percolation threshold
    public double mean() { return 1.0; }

    // sample standard deviation of percolation threshold
    public double stddev() { return 1.0; }

    // low endpoint of 95% confidence interval
    public double confidenceLo() { return 1.0; }

    // high endpoint of 95% confidence interval
    public double confidenceHi() { return 1.0; }

    // test client (see below)
    public static void main(String[] args) {}

}