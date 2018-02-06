import java.util.Scanner;

public class Main {
	public static void main(String [] args)
	{
		System.out.println("How many stairs will you be climbing?");
		Scanner scanner = new Scanner(System.in);
		int stairs = scanner.nextInt();
		System.out.println("Hold on while I calculate how many ways there are to climb " + stairs + " stair(s)...");
		
		// Recursive method
		System.out.println("Our recursive method: " + recursiveMethod(stairs) + " way(s)");
		// Top-down method
		System.out.println("Our top-down method: " + topDownMethod(stairs, new int [stairs + 1]) + " way(s)");
		// Bottom-up method
		System.out.println("Our bottom-up method: " + bottomUpMethod(stairs) + " way(s)");
	}
	
	public static int recursiveMethod(int n)
	{
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;
		return recursiveMethod(n - 1) + recursiveMethod(n - 2) + recursiveMethod(n - 3);
	}
	
	public static int topDownMethod(int n, int [] memo)
	{
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;
		if(memo[n] > 0)
			return memo[n];
		else
		{
			memo[n] = topDownMethod(n - 1, memo) + topDownMethod(n - 2, memo) + 
					topDownMethod(n - 3, memo);
			return memo[n];
		}
	}
	
	public static int bottomUpMethod(int n)
	{
		if(n < 0)
			return 0;
		if(n == 0)
			return 1;
		int [] memo = new int [n + 1];
		memo[0] = 1;
		memo[1] = 1;
		if(n > 1)
		{
			memo[2] = 2;
			for(int i = 3; i < n + 1; i++)
			{
				memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
			}
		}
		return memo[n];
	}
}
