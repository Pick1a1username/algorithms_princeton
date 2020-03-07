package com.mycompany.app;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import com.mycompany.app.Percolation;

public class PercolationStats {

    private int size;
    private int trials;
    private int[] numberOfOpenSites;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        // Throw an IllegalArgumentException in the constructor if either n ≤ 0 or trials ≤ 0. 
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("The arguments should be greater than zero.");
        }

        // Initialize variables.
        this.size = n;
        this.trials = trials;
        this.numberOfOpenSites = new int[n];

    }

    // Simulate percolation.
    private int simulate(int n) {
        Percolation grid = new Percolation(n);

        int[][] openSites;
        int openSitesLength = size;
        int targetSiteIndex;

        while (grid.percolates() == false) {
            openSites = grid.getOpenSites();
            System.out.println(openSites);
            openSitesLength = openSites.length;
            if (openSitesLength > 1) {
                targetSiteIndex = StdRandom.uniform(openSitesLength - 1);
                grid.open(openSites[targetSiteIndex][0], openSites[targetSiteIndex][1]);
            } else {
                grid.open(openSites[0][0], openSites[0][1]);
            }
        }

        return grid.numberOfOpenSites();
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