package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput() {
        return scanner.nextInt();
    }

    public static double getDoubleInput() {
        return scanner.nextDouble();
    }
}
