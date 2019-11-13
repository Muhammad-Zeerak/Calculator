import java.util.Scanner;
public class TestCalculator // TestCalculator class
	{
	public static void main(String[] args)
	{
		Calculator c2 = new Calculator();
		int x;
		Scanner input = new Scanner(System.in);
		char key;
		do // to run until q is pressed
		{
			System.out.println("Which mode you want to use: 1-Basic, 2-Moderate, 3-Advanced."); // select the type you want
			x = input.nextInt();
			if (x == 1)
				c2.UnlimitedInputs();
			else if (x == 2)
				c2.doCalculation2();
			else if (x == 3)
				c2.doCalculation3();
			System.out.println("Press q to quit anything else to continue!");
			key = input.next().charAt(0); // to look for q
		}while (key != 'q');
		System.out.println("Thank You!");
	} // end main
} // end class TestCalculator
