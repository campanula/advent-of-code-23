package day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1part1 {
    public static void main(String[] args) throws FileNotFoundException {
        int value = 0;

        File file = new File("day1/input.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
           
            // get int
            int nextLineVal = Integer.parseInt(line.replaceAll("[^0-9]", ""));
            System.out.println(nextLineVal);

            //calculate
            value = getFirstandLast(nextLineVal, value);

        }
        System.out.println(value);
    }

    public static int getFirstandLast(int nextLineVal, int value) {
        int lastNum = nextLineVal % 10;
        String firstNum = Integer.toString(nextLineVal).substring(0, 1); 
        value = value + Integer.valueOf(firstNum + "" + lastNum);

        return value;
    }

    public String swapNums(String line) {
        return null;
    }
     
 
} 