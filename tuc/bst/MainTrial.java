public class MainTrial {
    public static void main(String[] args) {
        int N[] = {30, 50, 100, 200, 500, 800, 1000, 5000, 10000, 100000};
        
        for (int i : N ){
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
            for(int j=0; j<i; j++){
                long totalTime;

                
                long time1, time2;
                time1 = System.nanoTime();
                myTree.insert(randomInts2[j]);
                myArray.insert(randomInts2[j]);
                time2 = System.nanoTime();
                totalTime = time2 - time1;
                long numberOfRepetitions = myTree.getRepeti();
                float meanTimePerRepetition = (double) totalTime / numberOfRepetitions
                System.out.println(totalTime);
            }
        }
    }
}
