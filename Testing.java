import java.util.Random;

public class Testing {
    public static void main(String args[])
    {
        Random r = new Random();

        for (int n = 1000; n <= 10000; n += 1000)
        {
            int a[] = new int[n];
            long time = 0;

            for (int i = 0; i < n; i++)
                a[i] = r.nextInt(n);

            time = System.currentTimeMillis();
            selectionSort(a);
            time = System.currentTimeMillis() - time;

            System.out.println("n: " + n + "  \tt: " + time + " ms "
                    + "\tt/n^2: " + (float) time/(n*n));
        }

        for (int n = 20000; n <= 50000; n += 10000)
        {
            int a[] = new int[n];
            long time = 0;

            for (int i = 0; i < n; i++)
                a[i] = r.nextInt(n);

            time = System.currentTimeMillis();
            selectionSort(a);
            time = System.currentTimeMillis() - time;

            System.out.println("n: " + n + "  \tt: " + time + " ms "
                    + "\tt/n^2: " + (float)time/((float)n*n));
        }
    }

    public static void selectionSort(int a[])
    {
        // Utplukksortering av en array med heltall

        int n = a.length, tmp = 0;

        for (int i = 0; i < n - 1; i++)
        {
            int min = i;
            for (int j = i + 1; j < n; j++)
            {
                if (a[j] < a[min])
                    min = j;
            }

            tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
    }

}
