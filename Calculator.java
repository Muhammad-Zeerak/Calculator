import java.util.Scanner;
import java.lang.Math;

public class Calculator {
	private char Operator; // instance variable's declarations
	private double isFirstNum;
	private double isSecondNum;
	private double isResult;

	public Calculator() // default no argument constructor
	{
	}

	public Calculator(double Fnum, char function, double Snum) // constructor with three arguments
	{
		this.isFirstNum = Fnum;
		this.Operator = function;
		this.isSecondNum = Snum;
	} // end

	public Calculator(double Fnum, char function) // constructor with two args
	{
		this.isFirstNum = Fnum;
		this.Operator = function;
	} // end

	public void setisResult(double isResult) // setter for isResult
	{
		this.isResult = isResult;
	} // end

	public void Instructions() // instructions before using the program
	{
		System.out.println("1- Once you start giving input, Each input should be separated by a space.");
		System.out.println("\n2- So after each input press space. Like after first digit then after operator than after 2nd and so on.");
		System.out.println("\n3- This calculator takes operators as:");
		System.out.println("\n********In Basic Mode********");
		System.out.println(" + for addition\n - for subtraction\n for product\n / for division\n p for power-of ");
		System.out.println("Example: 20 + 40.4 + 124 – 231947 * 867");
		System.out.println("\n********In Moderate Mode********");
		System.out.println(" s for sin\n c for cos\n t for tan\n l for natural-log\n L for common-log");
		System.out.println("u for square-root-of\n S for sin-1\n C for cos-1\n T for tan-1");
		System.out.println("Example: s 30--only works for one operator at a time(place space after operator and after number!)");
		System.out.println("\n******In Advanced Mode******");
		System.out.println(" You can get values from a quadratic equation.");
		System.out.println("\n4- The point where you want to get result press enter instead for space.");
	} // end instructions

	public double doCalculation() // method to calculate isResult for basic
	{
		switch (Operator)
		{
			case '+':
				setisResult(isFirstNum + isSecondNum);
				break;
			case '-':
				setisResult(isFirstNum - isSecondNum);
				break;
			case '*':
				setisResult(isFirstNum * isSecondNum);
				break;
			case '/':
				if (isSecondNum != 0)
				{
					setisResult(isFirstNum / isSecondNum);
				}
				else if(isSecondNum == 0) // if denominator is 0
				{
					System.out.println("You can't divide anything by zero.");
				}
				break;
			case 'p':
				double x = Math.pow(isFirstNum, isSecondNum);
				setisResult(x);
				break;
			default:
				setisResult(0.0);
				break;
		} // end switch
		return isResult;
	} // end function doCalculation

	public double specialFunctions() // to calculate isResult for moderate
	{
		double x;
		switch(Operator)
		{
		case 's':	
			x = Math.sin(isFirstNum);
			setisResult(x);
			break;
		case 'c':
			x = Math.cos(isFirstNum);
			setisResult(x);
			break;
		case 't':
			x = Math.tan(isFirstNum);
			setisResult(x);
			break;	
		case 'l':
			x = Math.log(isFirstNum);
			setisResult(x);
			break;
		case 'L':
			x = Math.log10(isFirstNum);
			setisResult(x);
			break;
		case 'u':
			x = Math.sqrt(isFirstNum);
			setisResult(x);
			break;
		case 'S':
			x = Math.asin(isFirstNum);
			setisResult(x);
			break;
		case 'C':
			x = Math.acos(isFirstNum);
			setisResult(x);
			break;
		case 'T':
			x = Math.atan(isFirstNum);
			setisResult(x);
			break;
		default:
			setisResult(0.0);
			break;
		} // end switch
		return isResult;
	} // end functionSpecialFunctions

	public void doCalculation2() // implementation of SpecialFunctions
	{
		double Fnum;
		char oper;
		double newNumber = 0.0;
		Scanner input = new Scanner(System.in);
		System.out.println("Ok you may start giving inputs, At any point press \".\" to get result.");
		oper = input.next().charAt(0); // space will be pressed to go to next input
		Fnum = input.nextDouble();
		if (oper == 's' || oper == 'c' || oper == 't') // only if operator is s/c/t than Fnum will be converted to radian because these function take parameters in radians
			Fnum = Math.toRadians(Fnum);
		Calculator c = new Calculator(Fnum, oper); // new object
		newNumber = c.specialFunctions(); // value stored
		System.out.println("The result is: " + newNumber ); //result printed
	} // end function doCalculation2

	public void doCalculation3() // implementation of quadratic equations
	{
		Scanner input = new Scanner(System.in);
		double a = 0;
		double b = 0;
		double c = 0;
		double x1 = 0.0;
		double x2 = 0.0;
		System.out.println("Compare your equation with ax2+bx+c and provide the values of a, b and c.");
		System.out.print("a = ");
		a = input.nextDouble();	
		System.out.print("b = ");
		b = input.nextDouble();
		System.out.print("c = ");
		c = input.nextDouble();
		x1 = ((-1*b) + (Math.sqrt((b*b)-(4*a*c))))/(2*a);
		x2 = ((-1*b) - (Math.sqrt((b*b)-(4*a*c))))/(2*a);;
		System.out.println("The value of x is: " + x1);
		System.out.println("The other value of x is: " + x2);
	} // end function doCalculation3

	public void UnlimitedInputs() // implementation of Basic calculator
	{
		double Fnum, Snum;
		char oper;
		double newNumber = 0.0;
		Scanner input = new Scanner(System.in);
		System.out.println("Ok you may start giving inputs, At any point press \".\" to get result.");
		Fnum = input.nextDouble();
		while(true)
		{
			oper = input.next().charAt(0);
			if (oper == '.')
			{
				System.out.println("The result is: " + newNumber);	
				break;
			}
			Snum = input.nextDouble();
			Calculator c = new Calculator(Fnum, oper, Snum); //object made
			newNumber = c.doCalculation(); // calculations performed by calling function
			Fnum = newNumber; // Fnum is changed to the preceding result of First number, operator, 2nd number
			continue; // continue till . is pressed
		} // end while
	} // end function UnlimitedInputs
} // end class Calculator
