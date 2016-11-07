/**
 * Created by IRGeekSauce on 11/30/15.
 */

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Factorial {

    static BigInteger factorial = new BigInteger("1");
    static BigInteger userInput;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter a positive integer (n >= 0) to calculate the factorial: ");
        userInput = input.nextBigInteger();

        if(userInput.compareTo(BigInteger.ZERO) == 0) {
            factorial = (userInput.add(BigInteger.ONE)).divide(userInput.add(BigInteger.ONE));
            System.out.println(userInput + "! = " + factorial + "\nWeird huh?");
            System.out.println("Look at this: ");
            System.out.println("n! = (n + 1)! / n + 1");
            System.out.println("So, 0! is 1! / 1, which is");
            System.out.println("1/1 = 1.");
        }
        else {
            System.out.println(userInput + "! is: ");
            long start = System.currentTimeMillis();
            showCalculation(userInput, factorial, start);
            System.out.println();
        }
    }

    public static BigInteger showCalculation(BigInteger userInput, BigInteger factorial, long start) {

        if(userInput.compareTo(BigInteger.ZERO) > 0) {
            for(BigInteger i = userInput; i.compareTo(BigInteger.ONE) >= 0; i = i.subtract(BigInteger.ONE)) {
                factorial = factorial.multiply(i);
                System.out.print(i);

                if(i.compareTo(BigInteger.ONE) > 0) {
                    System.out.print(" x ");
                }
                else if(i.compareTo(BigInteger.ONE) == 0) {
                    //System.out.println(" = " + factorial);
                    System.out.print(" = " + NumberFormat.getNumberInstance(Locale.US).format(factorial) + "\n\n");
                }
            }
        }
        long end = System.currentTimeMillis();
        long timeResult = end - start;

        if(timeResult < 1000) {
            System.out.println("That number took approximately " + NumberFormat.getNumberInstance(Locale.US).format(timeResult) + " milliseconds to calculate.");
        }
        /*
        These if statements will assure proper grammar (i.e. one second, two secondS, etc)
         */
        else if (timeResult >= 1001 && timeResult <= 2000){
            System.out.println("That number took approximately " + TimeUnit.MILLISECONDS.toSeconds(timeResult) + " second to calculate.");
        }
        else {
            System.out.println("That number took approximately " + TimeUnit.MILLISECONDS.toSeconds(timeResult) + " seconds to calculate.");
        }
        return userInput;
    }
}









