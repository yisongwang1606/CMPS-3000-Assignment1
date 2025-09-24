import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //Declare an array containing all the units-digit integers
        final String[] digitArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        //Declare an input scanner
        Scanner input = new Scanner(System.in);

        //Declare a String 'x' to receive input
        System.out.println("input a positive integer:");
        String x = input.nextLine();

        //Declare a char array to split 'x'
        String[] xArray = new String[x.length()];
        for (int i = 0; i < x.length(); i++) {
            xArray[i] = String.valueOf(x.charAt(i));
        }

        //Declare a Boolean value "isPositiveInteger"
        boolean isPositiveInteger = true;

        //check null input
        if (x.isEmpty()) {
            isPositiveInteger = false;
        }

        //Checks if x length>1 starts with a 0 (a positive integer cannot start with a 0 unless it is a single 0)
        else if (x.length() > 1 && xArray[0].equals("0")) {
            isPositiveInteger = false;
        }

        //check if x is 0
        else if (x.equals("0")){
            isPositiveInteger = false;
        }

        //Check if each character is a digit
        else {
            for (String xEach : xArray) {
                boolean isDigit = false;
                for (String digit : digitArray) {
                    if (digit.equals(xEach)) {
                        isDigit = true;
                        break;
                    }
                }
                //If any character is not a number, it is directly judged as a non-positive integer
                if (!isDigit) {
                    isPositiveInteger = false;
                    break;
                }
            }
        }

        // output result
        if (isPositiveInteger) {
            System.out.println("input is a positive integer");
        } else {
            System.out.println("input is not a positive integer");
        }

        //close Scanner
        input.close();
    }
}
