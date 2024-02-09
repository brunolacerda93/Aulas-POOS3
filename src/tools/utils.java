package tools;

import java.util.List;
import java.util.Scanner;

public class utils {
    public static Double averageOf(List<? extends Number> array) {
        if (array == null || array.isEmpty()) {
            return null;
        }

        double sum = 0.0;
        for (Number n : array) {
            sum += n.doubleValue();
        }
        return sum / array.size();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Press <enter> to continue... ");
        sc.nextLine();
    }
}
