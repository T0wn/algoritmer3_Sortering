import java.util.Random;

public class Main {

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        // sjekker at antall parametere er riktig
        if (args.length != 3) {
            System.out.println(
                    "Feil antall parametere. Krever 3 parametere hvor " +
                    "\n1. Antall tall som skal sorteres." +
                    "\n2. Hvilken sorteringsmetode som skal brukes. ( 1 = insertion, 2 = quicksort, 3 = mergesort, 4 = radixsort )" +
                    "\n3. Hvilken test av sorteringsmetoden som skal utføres."
            );
        }
        else {

            // parser parameterene
            int[] intArgs = new int[3];
            for (int i = 0; i < args.length; i++) {
                intArgs[i] = Integer.parseInt(args[i]);
            }

            int[] randomNummbers = new int[intArgs[0]];
            Random ran = new Random();
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                randomNummbers[i] = ran.nextInt(intArgs[0] * 2);
            }
            printArray(randomNummbers);
            Sorter.mergeSort(randomNummbers, 0, randomNummbers.length - 1);
            printArray(randomNummbers);

        }
    }

}
