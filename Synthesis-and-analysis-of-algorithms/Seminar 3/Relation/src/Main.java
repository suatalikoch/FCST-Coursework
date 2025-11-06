import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//- Task 4
public class Main {
    public static void main(String[] args) {
        List<Integer> series = new ArrayList<>();

        populateSeries(series);

        boolean result = isRelationTrue(series);

        System.out.println(result
                ? "The relation a0 < a1 > a2 < a3 > a4 ... is true."
                : "The relation a0 < a1 > a2 < a3 > a4 ... is NOT true");
    }

    private static void populateSeries(List<Integer> series) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter n: ");
        int n = scanner.nextInt();

        while(n < 0) {
            System.out.println("Value of n cannot be negative.");
            System.out.print("Please enter n: ");
            n = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Please enter number: ");
            series.add(scanner.nextInt());
        }

        scanner.close();
    }

    private static boolean isRelationTrue(List<Integer> series) {
        int size = series.size();

        if (size < 2) {
            return true;
        }

        for (int i = 1; i < size - 1; i+=2) {
            int left = series.get(i - 1);
            int mid = series.get(i);
            int right = series.get(i + 1);

            if (mid <= left || mid <= right) {
                return false;
            }
        }

        if (series.size() % 2 == 0) {
            return series.get(series.size() - 2) < series.get(series.size() - 1);
        }

        return true;
    }
}