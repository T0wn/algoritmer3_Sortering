
import java.util.LinkedList;
import java.util.PriorityQueue;


public class Sorter {



    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {

            int currentNr = array[i];
            int currentIndex = i;

            while ( currentIndex > 0 && array[currentIndex - 1] > currentNr ) {
                array[currentIndex] = array[currentIndex - 1];
                currentIndex--;
            }
            array[currentIndex] = currentNr;

        }
    }



    public static void quickSort(int[] array, int start, int end) {
        int partitionIndex;

        if (end - start > 0) {
            partitionIndex = partition(array, start, end);
            quickSort(array, start, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private  static int partition(int[] array, int start, int end) {
        int compareTall = array[start];

        int left = start;
        int right = end;
        int temp;

        while (left < right) {
            while (array[left] <= compareTall && left < right) {
                left++;
            }

            while (array[right] > compareTall) {
                right--;
            }

            if (left < right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
        array[start] = array[right];
        array[right] = compareTall;
        return right;
    }



    public static void mergeSort(int[] array, int start, int end) {

        if (start == end)
            return;

        int arraySize = end - start + 1;
        int[] temp = new int[arraySize];
        int mid = (end + start) / 2;

        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);

        for (int i = 0; i < arraySize; i++) {
            temp[i] = array[start + i];
        }

        int left = 0;
        int right = mid - start + 1;
        for (int i = 0; i < arraySize; i++) {
            if (right <= end - start) {
                if (left <= mid - start) {
                    if (temp[left] > temp[right]) {
                        array[i + start] = temp[right++];
                    }
                    else {
                        array[i + start] = temp[left++];
                    }
                }
                else {
                    array[i + start] = temp[right++];
                }
            }
            else {
                array[i + start] = temp[left++];
            }
        }

    }



    public static void radixSort(int[] array, int maxValue) {
        // oppretter en array med 10 LinkedLists
        LinkedList<Integer>[] digitQueues = (LinkedList<Integer>[]) (new LinkedList[10]);
        for (int digitVal = 0; digitVal <= 9; digitVal++)
            digitQueues[digitVal] = new LinkedList<Integer>();



        int max_digits = Integer.toString(maxValue).length();

        for (int position = 0; position <= max_digits; position++) {

            for (int scan = 0; scan < array.length; scan++) {
                String temp = String.valueOf(array[scan]);
                if (max_digits-position < temp.length()) {
                    int digit = Character.digit (temp.charAt(max_digits-position), 10);
                    digitQueues[digit].add(new Integer(array[scan]));
                }
                else {
                    digitQueues[0].add(new Integer(array[scan]));
                }

            }

            // printer alle køene
            for (int i = 0; i < digitQueues.length; i++) {
                System.out.println(i + ": " + digitQueues[i]);
            }

            int num = 0;
            for (int digitVal = 0; digitVal <= 9; digitVal++) {

                while (!(digitQueues[digitVal].isEmpty())) {
                    array[num] = digitQueues[digitVal].remove().intValue();
                    num++;
                }
            }
            Main.printArray(array);
        }

    }




}
