import java.util.ArrayList;
import java.util.Random;

public class Main {
    static int arraySize = 10000;
    static ArrayList<Integer> bubbleSort = new ArrayList<>((int)arraySize);
    static ArrayList<Integer> selectionArray = new ArrayList<>(bubbleSort);
    public static void main(String[] args) {
        //Our setup for the array
        int start = 1;
        int end = arraySize;
        for (int i = 0; i < arraySize; i++) {
            arrayMaker(start, end);
        }
        
        
        //Bubble Sort
        long timerStart = System.nanoTime();
        
        for (int i = 0; i < bubbleSort.size(); i++) {
            boolean checked = true;
            for (int a = 0; a < bubbleSort.size() - 1; a++) {
                if (bubbleSort.get(a) > bubbleSort.get(a + 1)) {
                    // Swap values
                    checked = false;
                    int temp = bubbleSort.get(a);
                    bubbleSort.set(a, bubbleSort.get(a + 1));
                    bubbleSort.set(a + 1, temp);
                    
                }
            }
            if (checked){
                break;
            }
        }

        long timerEnd = System.nanoTime();
        long duration = timerEnd - timerStart;
        double milliseconds = duration / 1_000_000.0;
        double seconds = duration /1_000_000_000.0;
        System.out.println();
        System.out.println("Sorting an array of size " + arraySize + " took Selection Sort: ");
        System.out.println(duration + " nanoseconds.");
        System.out.printf("%.3f milliseconds%n", milliseconds);
        System.out.printf("%.6f seconds%n", seconds);
        System.out.println();
        
        
        
        
        //Selection Sort
        timerStart = System.nanoTime();
        ArrayList<Integer> sortedArray = new ArrayList<>((int)arraySize);
        while (!selectionArray.isEmpty()){
            int lowest = selectionArray.get(0);
            int lowestLocation = 0;
            for (int i = 0; i < selectionArray.size(); i++) {
                if (lowest > selectionArray.get(i)){
                    lowest = selectionArray.get(i);
                    lowestLocation = i;
                }
            }
            selectionArray.remove(lowestLocation);
            sortedArray.add(lowest);
        }
        timerEnd = System.nanoTime();
        duration = timerEnd - timerStart;
        milliseconds = duration / 1_000_000.0;
        seconds = duration /1_000_000_000.0;
        System.out.println("Sorting an array of size " + arraySize + " took Selection Sort: ");
        System.out.println(duration + " nanoseconds.");
        System.out.printf("%.3f milliseconds%n", milliseconds);
        System.out.printf("%.6f seconds%n", seconds);
        System.out.println();
        
    }

    public static void arrayMaker(int start, int end) {
        Random rand = new Random();
        int num = rand.nextInt(end - start - 1) + start + 1;
        bubbleSort.add(num);
    }
}