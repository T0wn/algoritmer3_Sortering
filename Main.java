import java.util.Random;

public class Main {

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

            // oppretter en array med tilfeldige tall
            int[] randomNummbers = new int[intArgs[0]];
            Random ran = new Random();
            for (int i = 0; i < Integer.parseInt(args[0]); i++) {
                randomNummbers[i] = ran.nextInt(2 * intArgs[0]);
            }
            printArray(randomNummbers);


            // sjekker hvilken test som skal utføres
            if (intArgs[2] == 1) {

                long startTime = System.nanoTime();

                // velger sorteringsalgoritme og sorterer arrayen
                switch (intArgs[1]) {
                    case 1:
                        Sorter.insertionSort(randomNummbers);
                        break;

                    case 2:
                        Sorter.quickSort(randomNummbers, 0, randomNummbers.length - 1);
                        break;

                    case 3:
                        Sorter.mergeSort(randomNummbers, 0, randomNummbers.length - 1);
                        break;

                    case 4:
                        Sorter.radixSort(randomNummbers, 2 * intArgs[0]);
                        break;

                    default:
                        System.out.println("Error! Parameter nr.2 må være mellom 1-4");
                }

                // regner og skriver ut tidsbruket til sorteringsalgoritmen.
                long endTime = System.nanoTime();
                long timeUsed = (endTime - startTime) / 1000000;
                System.out.println("Sorteringen tar: " + timeUsed + " milisek");

            }

            else if (intArgs[2] == 2) {

            }

            else {
                System.out.println("Error! Parameter nr.3 må være enten 1 eller 2");
            }

        }
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }

}
