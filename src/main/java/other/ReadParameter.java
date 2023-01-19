package other;

import java.util.Scanner;

public class ReadParameter {

    public int readLine(){
        int value = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write parameter: ");

        try {
            value = Integer.parseInt(scanner.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println(" This is not integer Value. ");
            value = readLine();
            return value;
        }

        System.out.println(" value: " + value);
        return value;
    }



}
