package multithreading;


public class Worker implements Runnable {
    int[][] matrisA;
    int[][] matrisB;
    int[][] matrisC;
    int j;

    public Worker(int[][] matrisA, int[][] matrisB, int[][] matrisC, int j) {
        this.matrisA = matrisA;
        this.matrisB = matrisB;
        this.matrisC = matrisC;
        this.j = j;
    }

    @Override
    public void run(){
        for(int i = 0; i < 5; i++) {
            for(int k = 0; k < 5; k++) {
                matrisC[j][k] += matrisA[j][k] * matrisB[k][i];
            }
        }
    }
}