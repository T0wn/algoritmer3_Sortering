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



    public static void quickSort(int[] array, int start, int stop) {
        int partitionIndex;

        if (stop - start > 0) {
            partitionIndex = partition(array, start, stop);
            quickSort(array, start, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, stop);
        }
    }

    private  static int partition(int[] array, int start, int stop) {
        int compareTall = array[start];

        int left = start;
        int right = stop;
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



    public static void mergeSort(int[] array) {

    }



}
