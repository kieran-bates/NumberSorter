 /*
 * Kieran Bates
 * November 15, 2019
 * This program will sort a user selected quantity of random numbers from least to greatest or greatest to least according to user input
 */

package numbersorter;
import java.util.Scanner;
/**
 *
 * @author kibat6204
 */
public class NumberSorter {
    
    /**
     * Determine in which direction the user wants the numbers sorted
     * @param input
     * @return an output boolean indicating the sort direction
     */
    public static boolean sortDirection(int input)
    {
        boolean output = true;
        if(input == 1) //If user input is 1
        {
            output = true;
        }
        if(input == 2) //If user input is 2
        {
            output = false;
        }
    return output;
    }
    
    /**
     * Determine if user wants to repeat the program and output a boolean
     * @param userInput
     * @return repeat program yes or no
     */
    public static boolean repeatProg(String userInput)
    {
        boolean repeat = false;
        if(userInput.equals("yes") || userInput.equals("Yes") || userInput.equals("YES")) //if answer is yes, output true
        {
            repeat = true;
        }
        if(userInput.equals("no") || userInput.equals("No") || userInput.equals("NO")) //if answer is no, output false
        {
            repeat = false;
        }
        return repeat;
    }
    /**
     * Generate a random number and output
     * @param numberOfIntegers An integer that stores the number of random integers the user wants generated
     * @return An int that contains the random number
     */
    public static int generateRandomNum(int numberOfIntegers)
    {
        int one = (int)(Math.random() * (numberOfIntegers-1)+1); //Generate random number
        return one; //return number
    }
    
    /**
     * Ask the user if they want to repeat the program and output a boolean answer
     * @return Returns the program repeat boolean
     */
    public static boolean runAnotherSet()
    {
        boolean repeat = true; //declare variables
        String userInput;
        
        Scanner input2 = new Scanner(System.in); //new scanner
        
        System.out.print("Would you like to run another set? -->"); //prompt user for input
        
        userInput = input2.next(); //obtain user input
        
        repeat = repeatProg(userInput);
        
        return repeat; //return the boolean storing the user selection
    }
    /**
     * 
     * @param args The main method
     */
    public static void main(String[] args) {
        
        boolean repeat = true; //Program repeat variable
        System.out.println("***NUMBER SORTER***"); //Output program title
        while(repeat == true) //Repeat program until boolean repeat is false
        {
        Scanner input = new Scanner(System.in); //New scanner for input
        
        System.out.print("\nHow many random numbers would you like to genterate? -->"); //Prompt user for input
        
        int numberOfInt = input.nextInt(); //store user input
        int numbers[] = new int[numberOfInt]; //new array for random numbers - user input length
        int one = 0;
        for(int i = 0; i<numbers.length ; i++) //generate specified number of random numbers using the generateRandomNum method
        {
            one = generateRandomNum(numberOfInt);
            numbers[i] = one;
            System.out.println(numbers[i]);
        }
        System.out.println("Sort from...");
        System.out.println("1...Least to greatest");
        System.out.println("2...Greatest to least");
        System.out.print("Enter number --> ");
        
        int userSelection = input.nextInt();
        
        System.out.println("Sorting..."); //Print sorting
        
        //sort the numbers using a bubble sort algorithm
        if(sortDirection(userSelection) == true)
        {
        boolean exit = false;
        int temp;
        
        while(exit == false) //repeat until numbers are sorted
        {
            exit = true;
            for(int i=0 ; i<numbers.length-1 ; i++) //Scan the length of the array for numbers out of place
            {
                if(numbers[i]>numbers[i+1]) //If number to the left is less than number to the right
                {
                    //Swap numbers
                    temp = numbers[i+1];
                    numbers[i+1]=numbers[i];
                    numbers[i] = temp;
                    exit = false;
                }
            }
        }
        }
        if(sortDirection(userSelection) == false)
        {
        boolean exit = false;
        int temp;
        
        while(exit == false) //repeat until numbers are sorted
        {
            exit = true;
            for(int i=0 ; i<numbers.length-1 ; i++) //Scan the length of the array for numbers out of place
            {
                if(numbers[i]<numbers[i+1]) //If number to the left is greater than number to the right
                {
                    //Swap numbers
                    temp = numbers[i+1];
                    numbers[i+1]=numbers[i];
                    numbers[i] = temp;
                    exit = false;
                }
            }
        }
        }
        
        //Print the sorted numbers to the screen
        for(int i=0 ; i<numbers.length ; i++)
        {
            System.out.println(numbers[i]);
        }
        repeat = runAnotherSet();
    }
    
}
}