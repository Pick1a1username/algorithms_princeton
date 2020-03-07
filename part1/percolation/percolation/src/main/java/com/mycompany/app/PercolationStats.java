package com.mycompany.app;

import java.lang.Math;

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

        // Start calculation.

        // Simulate percolation n times.
        for (int i = 0; i < trials; i++) {
            this.numberOfOpenSites[i] = simulate(n);
        }
    }

    // Simulate percolation.
    private int simulate(int n) {
        Percolation grid = new Percolation(n);

        int[][] closeSites;
        int closeSitesLength = size;
        int targetSiteIndex;

        while (grid.percolates() == false) {
            closeSites = grid.getCloseSites();
            closeSitesLength = closeSites.length;
            if (closeSitesLength > 1) {
                targetSiteIndex = StdRandom.uniform(closeSitesLength - 1);
                grid.open(closeSites[targetSiteIndex][0], closeSites[targetSiteIndex][1]);
            } else {
                grid.open(closeSites[0][0], closeSites[0][1]);
            }
        }

        return grid.numberOfOpenSites();
    }

    // sample mean of percolation threshold
    public double mean() { 
        return StdStats.mean(this.numberOfOpenSites);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(this.numberOfOpenSites);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() { 
        return this.mean() - ((1.96 * this.stddev()) / Math.sqrt(this.trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return this.mean() + ((1.96 * this.stddev()) / Math.sqrt(this.trials));
    }

    // test client (see below)
    public static void main(String[] args) {}

}