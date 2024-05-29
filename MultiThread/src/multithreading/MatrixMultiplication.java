package multithreading;

import multithreading.Worker;

public class MatrixMultiplication {
    public static void main(String args[]) {
        int[][] matrisA = new int[5][5];
        int[][] matrisB = new int[5][5];
        int[][] matrisC = new int[5][5];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                matrisA[i][j] = i + 1;
                matrisB[i][j] = j + 1;
            }
        }
        System.out.println("----A Matrisi----");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(matrisA[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println("----B Matrisi----");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(matrisA[i][j] +" ");
            }
            System.out.println();
        }
        try {
        	
        	System.out.println("Thread Başladı ");

        	long startTime1 = System.currentTimeMillis();
            Thread t1 = new Thread(new Worker(matrisA, matrisB, matrisC, 0));
            t1.start();
            t1.join();
            long endTime1 = System.currentTimeMillis();
            
            long startTime2 = System.currentTimeMillis();
            Thread t2 = new Thread(new Worker(matrisA, matrisB, matrisC, 1));
            t2.start();
            t2.join();
            long endTime2 = System.currentTimeMillis();

            long startTime3 = System.currentTimeMillis();
            Thread t3 = new Thread(new Worker(matrisA, matrisB, matrisC, 2));
            t3.start();
            t3.join();
            long endTime3 = System.currentTimeMillis();

            long startTime4 = System.currentTimeMillis();
            Thread t4 = new Thread(new Worker(matrisA, matrisB, matrisC, 3));
            t4.start();
            t4.join();
            long endTime4 = System.currentTimeMillis();

            long startTime5 = System.currentTimeMillis();
            Thread t5 = new Thread(new Worker(matrisA, matrisB, matrisC, 4));
            t5.start();
            t5.join();
            long endTime5 = System.currentTimeMillis();

            System.out.println("Thread Bitti ");
            
            long executionTime1 = endTime1 - startTime1;
            long executionTime2 = endTime2 - startTime2;
            long executionTime3 = endTime3 - startTime3;
            long executionTime4 = endTime4 - startTime4;
            long executionTime5 = endTime5 - startTime5;

            System.out.println("Thread1'in çalışma süresi: " + executionTime1 + " milisaniye");
            System.out.println("Thread2'in çalışma süresi: " + executionTime2 + " milisaniye");
            System.out.println("Thread3'in çalışma süresi: " + executionTime3 + " milisaniye");
            System.out.println("Thread4'in çalışma süresi: " + executionTime4 + " milisaniye");
            System.out.println("Thread5'in çalışma süresi: " + executionTime5 + " milisaniye");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----C Matrisi----");
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(matrisC[i][j] +" ");
            }
            System.out.println();
        }
    }
}
