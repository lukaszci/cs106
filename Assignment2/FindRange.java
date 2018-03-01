import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final long serialVersionUID = 1L;
	int value;
	int lowestValue;
	int highestValue;
	int userAttempts;//total number of times user provided a number
	
	public void run() {
		value = readInt("Give me a number: ");
		highestValue = value;//handle the case where user inputs a zero on second try
		lowestValue = value;//handle the case where user inputs a zero on second try
		while (value != 0) {//ask for a number as long as user does not provide a zero
			if (value > highestValue && value != 0) {//protect the highestValue variable from becoming a zero
				highestValue = value;
			} 
			if (value < lowestValue && value != 0){//protect the lowestValue variable from becoming a zero
				lowestValue = value;
			} 
			if (value == 0) {
				break;
				}
			value = readInt("give me a number: ");
			userAttempts++;
		} if (userAttempts == 0) {//handle the case where user inputs a zero in the very beginning
			println("User entered a zero on their first attempt");
		} else {
			println("smallest value entered was: " + lowestValue);
			println("largest value entered was: " + highestValue);
		}
	}
}