package com.mycompany.app;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class PercolationStats {

    private int size;
    private int trials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        // Throw an IllegalArgumentException in the constructor if either n ≤ 0 or trials ≤ 0. 
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("The arguments should be greater than zero.");
        }

        this.size = n;
        this.trials = trials;
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