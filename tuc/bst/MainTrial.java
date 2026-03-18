public class MainTrial {
    public static void main(String[] args) {
        int N[] = {30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 100000};
        double[][][] data = new double[4][10][9];
        int Nindex = 0;
        for (int i : N ){
            Nindex++;
            DynamicMemoryBST myTree = new DynamicMemoryBST();
            
            ArrayBST myArray = new ArrayBST(100000);

            java.util.Random randomGenerator = new java.util.Random();
            int[] randomInts = randomGenerator.ints(1, 2*i+1).distinct().limit(i).toArray();

            for(int j=0; j<i; j++){
                myTree.insert(randomInts[j]);
                myArray.insert(randomInts[j]);

            }
            int K;
            if (i < 201) {
                K=20;
            }else if (i > 200 && i < 1001){
                K=50;
            }else{
                K=100;
            }
            
            
            
            int[] randomInts2 = randomGenerator.ints(0, 2*i+1).limit(i).toArray();
            long time1, time2;

            // loop for a)
            for(int j=0; j<K; j++){

                time1 = System.nanoTime();
                myTree.insert(randomInts2[j]);
                time2 = System.nanoTime();
                data[0][Nindex][1] += time2 - time1;
                data[0][Nindex][2] += myTree.getRepeti();
                

                time1 = System.nanoTime();
                myArray.insert(randomInts2[j]);
                time2 = System.nanoTime();
                data[0][Nindex][4] += time2 - time1;
                data[0][Nindex][5] += myArray.getRepeti();
            }
            for(int l=0;l<9;l++){
                data[0][Nindex][l] = data[0][Nindex][l] / K;
            }
            //loop for b)
            for(int j=0; j<K; j++){

                time1 = System.nanoTime();
                myTree.delete(randomInts2[j]);
                time2 = System.nanoTime();
                data[1][Nindex][1] += time2 - time1;
                data[1][Nindex][2] += myTree.getRepeti();
                

                time1 = System.nanoTime();
                myArray.delete(randomInts2[j]);
                time2 = System.nanoTime();
                data[1][Nindex][4] += time2 - time1;
                data[1][Nindex][5] += myArray.getRepeti();
            }
            for(int l=0;l<9;l++){
                data[1][Nindex][l] = data[1][Nindex][l] / K;
            }
            //loop for c)
            for(int j=0; j<K; j++){

                time1 = System.nanoTime();
                myTree.search(randomInts2[j]);
                time2 = System.nanoTime();
                data[2][Nindex][1] += time2 - time1;
                data[2][Nindex][2] += myTree.getRepeti();
                

                time1 = System.nanoTime();
                myArray.search(randomInts2[j]);
                time2 = System.nanoTime();
                data[2][Nindex][4] += time2 - time1;
                data[2][Nindex][5] += myArray.getRepeti();
            }
            for(int l=0;l<9;l++){
                data[2][Nindex][l] = data[2][Nindex][l] / K;
            }
        }
    }
}
