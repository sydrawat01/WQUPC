package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class UF_Client {
    public static int count(int n) {
        int connections = 0;
        UF_HWQUPC uf = new UF_HWQUPC(n);

        Random random = new Random();

        while(uf.components() > 1) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            if(!uf.connected(p, q)){
                uf.union(p,q);
            }
            connections++;
        }
        return connections;
    }

    public static void main(String[] args) {
        System.out.printf("%-10s %-10s %-30s %-20s\n", "n", "m", "fn = 0.54 * n * ln(n)",  "offset = (fn - m) / m");

        for(int i=100; i<1000000; i*=2) {
            int sum = 0;
            for(int j=0; j<10; j++)
                sum += count(i);
            // number of pairs generated
            double m = sum/10.0;
            // m = f(n) = 0.54 * n * ln(n)
            int fn = (int) (0.54 * i * Math.log(i));
            System.out.printf("%-10s %-10s %-30s %-20s\n", i, (int) m, fn,  (fn - m) / m);
        }
    }
}
