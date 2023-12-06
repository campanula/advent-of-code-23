package day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day1part2 {
    public static void main(String[] args) throws FileNotFoundException {
        int value = 0;

        File file = new File("day1/input.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);

            // Swap letters for digits
            String newLine = swapNums(line);

            // get int
            int parsedLine = Integer.parseInt(newLine.replaceAll("[^0-9]", ""));
            System.out.println(parsedLine);

            // calculate
            value = getFirstandLast(parsedLine, value);

        }
        System.out.println("Final Num " + value);
    }

    public static int getFirstandLast(int nextLineVal, int value) {
        int lastNum = nextLineVal % 10;
        String firstNum = Integer.toString(nextLineVal).substring(0, 1);

        value = value + Integer.valueOf(firstNum + "" + lastNum);
        System.out.println("Val " + value);
        return value;
    }

    private static Map<String, String> createMap() {

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("one", "1");
        hashMap.put("two", "2");
        hashMap.put("three", "3");
        hashMap.put("four", "4");
        hashMap.put("five", "5");
        hashMap.put("six", "6");
        hashMap.put("seven", "7");
        hashMap.put("eight", "8");
        hashMap.put("nine", "9");
        hashMap.put("oneight", "18");
        hashMap.put("twone", "21");
        hashMap.put("eightwo", "82");
        return hashMap;
    }

    public static String swapNums(String num) {
        Map<String, String> wordToNumber = createMap();
        StringBuilder newNum = new StringBuilder();

        Pattern pattern = Pattern.compile("(?:\\d+|oneight|twone|eightwo|one|two|three|four|five|six|seven|eight|nine)");
        
        Matcher matcher = pattern.matcher(num);

        String temp;

        while (matcher.find()) {    
            String match = matcher.group();
                if (!(Character.isDigit(match.charAt(0)))) {
                    temp  = wordToNumber.get(match);
                    newNum.append(temp);
                } else {
                    newNum.append(match);
                }

            //for (Map.Entry<String, String> entry : wordToNumber.entrySet()) {
            //    num = num.replace(entry.getKey(), entry.getValue());
            //}

        }

        System.out.println("SwapNums: " + newNum);
        return newNum.toString();
    }

}