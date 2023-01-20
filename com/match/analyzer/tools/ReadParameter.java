package tools;

import java.util.Scanner;

public class ReadParameter {

    public int readLine() {
        int value;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write parameter (How many record would you like to see?): ");

        try {
            value = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" This is not integer Value. ");
            value = readLine();
            return value;
        }

        return value;
    }

}
