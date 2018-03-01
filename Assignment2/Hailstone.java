import acm.program.*;

public class Hailstone extends ConsoleProgram {
	private static final long serialVersionUID = 1L;
	int n = 999999;
	int steps;
	
	public void run() {
		while (n > 1) {
			steps++;
			if ((n % 2) == 0 ) {
				println(n + " is even so I take half: " + n/2);
				n = n/2;			
			}
			else {
				println(n + " is odd so I make 3n+1: " + ((n*3) + 1));
				n = n*3 + 1;
			}
		}
		println("The process took " + steps + " steps to reach 1.");
	}
}