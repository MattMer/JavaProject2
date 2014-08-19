
import java.util.Scanner;
public class RollDie {
	public static void main(String args[]){
		@SuppressWarnings("resource")
		Scanner input = new Scanner( System.in );
		String userString;
		int userTotal = 0, compTotal = 0, breakPoint = 21;
		final String hit = "Hit";
		final int DIE_SIDES = 6; // Number of sides for dice
		
		// Create two instances of the Die class.
		Die die1 = new Die(DIE_SIDES);
		Die die2 = new Die(DIE_SIDES);
		
		// Ask to start playing.
		System.out.println("Let's play a game of 21! Enter either \"Hit\" or \"Quit\" (Case sensitive.)");
		userString = input.next(); 
		if(userString.equals(hit)){ 
			//Adds the initiating values of creating instances of the Die class for compTotal.
			compTotal = compTotal + die1.getValue() + die2.getValue();
			die1.roll();
			die2.roll();
			//Adds the random rolls to userTotal.
			userTotal = userTotal + die1.getValue() + die2.getValue();
			die1.roll();
			die2.roll();
			//Asks to continue to quit.
			System.out.println("Your total is " + userTotal + ". would you like to Hit or Quit?");
			userString = input.next();
			while(userString.equals(hit)){ 
				//If they continue, will add to compTotal, then get new values for die1 and die2 for userTotal before adding.
				compTotal = compTotal + die1.getValue() + die2.getValue();
				die1.roll();
				die2.roll();
				userTotal = userTotal + die1.getValue() + die2.getValue();
				if( userTotal > breakPoint){
					//If the user is above 21, will end program. Is safe to system.exit(0)?
					System.out.println("Sorry! You have lost with a total of " + userTotal);
					System.exit(0);
				}
				else{
				System.out.println("Your total is " + userTotal + ". would you like to Hit or Quit?");
				userString = input.next();
				die1.roll();
				die2.roll();
				}				
			}
			if( compTotal > breakPoint) //If dealer is above 21, users wins by default.
					System.out.println("You win! The dealer broke 21 at " + compTotal + ".");
				else if( userTotal == compTotal) //If dealer value equals user value, it's considered a "push."
					System.out.println("It was a push(tie)! Your total: " + userTotal + " Dealer total: " + compTotal + ".");
				else if( userTotal > compTotal){ //User wins if they have a higher total than computer. SAFE: checked for userTotal < breakPoint.
					System.out.println("You win! Your total is " + userTotal 
								+ " and the dealer total is " + compTotal + ".");
				}
				else {
					System.out.println("You lose! Your total is " + userTotal 
								+ " and the dealer total is " + compTotal + ".");
				}
		}
		else { //If user doesn't want to play.
			System.out.println("Thank you anyways! Have a nice evening.");
		}
	}
}
