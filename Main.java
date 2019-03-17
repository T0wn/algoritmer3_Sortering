import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static int[] fyllArray(int length, int highestVal) {
        Random ran = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = ran.nextInt(highestVal);
        }
        return array;
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
            return;
        }

        // parser parameterene
        int[] intArgs = new int[3];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.parseInt(args[i]);
        }


        // Utfører sorteringen og gir tiden den bruker.
        if (intArgs[2] == 1) {

            // oppretter en array med tilfeldige tall
            int[] randomNummbers = fyllArray(intArgs[0], 2 * intArgs[0]);

            long startTime = System.currentTimeMillis();

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
                    return;
            }

            // regner og skriver ut tidsbruket til sorteringsalgoritmen.
            long endTime = System.currentTimeMillis();
            long timeUsed = endTime - startTime;
            System.out.println("Sorteringen tar: " + timeUsed + " milisek");

        }
        // Estimering av verdien C
        else if (intArgs[2] == 2) {

            ArrayList<Float> C_save = new ArrayList<>();

            for (int n = 10000; n <= 40000; n += 3000) {

                int[] a = fyllArray(n, 2 * n);
                float C = 0;
                long time = System.currentTimeMillis();

                // valg av sorterings algoritme
                switch (intArgs[1]) {
                    case 1:
                        Sorter.insertionSort(a);
                        time = System.currentTimeMillis() - time;
                        C = ((float)(time)/(n*n));
                        C_save.add(C);
                        break;

                    case 2:
                        Sorter.quickSort(a, 0, a.length - 1);
                        time = System.currentTimeMillis() - time;
                        C = ((float)(time)/(float)(n * Math.log((double)(n)) ));
                        C_save.add(C);
                        break;

                    case 3:
                        Sorter.mergeSort(a, 0, a.length - 1);
                        time = System.currentTimeMillis() - time;
                        C = ((float)(time)/(float)(n * Math.log((double)(n)) ));
                        C_save.add(C);
                        break;

                    case 4:
                        Sorter.radixSort(a, 2 * intArgs[0]);
                        time = System.currentTimeMillis() - time;
                        C = ((float)(time)/(n));
                        C_save.add(C);
                        break;

                    default:
                        System.out.println("Error! Parameter nr.2 må være mellom 1-4");
                        return;
                }


                System.out.println("n: " + n + "\tt: " + time + "ms  \tC: " + C);


            }

            // regner gjennomsnittlig C verdi
            float C_avg = 0;
            for (float nr : C_save) {
                C_avg += nr;
            }
            C_avg /= C_save.size();

            System.out.println("\nC average: " + C_avg);

        }
        else {
            System.out.println("Error! Parameter nr.3 må være enten 1 eller 2");
        }


    }


}
