// EMILY LIAO
// pd9
// HW32
// 2013-11-25
// Partner in Crime: Sherry Ko

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

/*==================================================
  the Breakdown:

  Start off with two given numbers, the lower and upper bounds.
  Start the game by allowing for the player to pick one number.
  Base Case: Target is equal to the guess. Ctr ++
  If the number is too high, then set the _hi equal to the guess -1 and keep playing until number is equal. Ctr ++
  If the number is too low, then set the _lo equal to the guess +1 and keep playing until number is equal. Ctr ++
  ==================================================*/


import cs1.Keyboard; /* must have cs1 dir in same dir as this file 
			for this to work */

public class GuessNumber {

    //instance vars
    private int _lo, _hi, _guessCtr, _target;



    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
            _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) {
	_lo = a;
	_hi = b;
	_guessCtr=0;
	_target= _lo +(int) ( Math.random() * (_hi-_lo));
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
                        Uses recursion.
      pre:  
      post: 
      ==================================================*/

    public void playRec() {
	String t = "\nGuess a number between " + _lo + " &  " + _hi + "!"; 
	t+= "\n Guess: ";
	System.out.print(t);
	int guess = Keyboard.readInt();
       	if (guess == _target){
	    _guessCtr += 1;
	    t="GREAT JOB! YOU GUESSED THE NUMBER IN "+_guessCtr+" GUESSES!/n";
	    System.out.print(t);
	}
	else {
	    if (guess > _target){
		System.out.println("Too high, try again... ");
		_guessCtr++;
		_hi = guess - 1;
		playRec();}
	    else if( guess < _target){
		System.out.println("Too low, try again...");
		_guessCtr++;
		_lo = guess + 1;
		playRec();}
	}

    }
    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
                         Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() {
	String s = "\nGuess a number from " + _lo + " to " + _hi + "!";
	s += "\n Guess: ";
	System.out.print(s);
	int guess = Keyboard.readInt();
	_guessCtr++;
	while (guess != _target){
	    if (guess > _target){
		System.out.println("Too high, try again... ");
		_guessCtr++;
		_hi = guess - 1;
	    }
	    else if( guess < _target){
		System.out.println("Too low, try again... ");
		_guessCtr++;
		_lo = guess + 1;
	    }
	    String r = "\nGuess a number from " + _lo + " to " + _hi + "!";
	    r += "\n Guess: ";
	    System.out.print(r);
	    guess = Keyboard.readInt();
	}
	if (_guessCtr == 1 ) 
	    s="GREAT JOB YOU GUESS THE NUMBER IN "+_guessCtr+" GUESS!/n";
	else
	    s="GREAT JOB YOU GUESS THE NUMBER IN "+_guessCtr+" GUESSES!/n";
	System.out.print(s);
    }




    //wrapper for playRec/playIter to simplify calling
    public void play() { 
	//use one or the other below:
	playRec();
	//playIter();
    }


    //main method to run it all
    public static void main( String[] args ) {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1, 100);

	//start the game
	g.play();
    }


    /*==================================================
      _ _(_) -- 
      pre:  
      post: 
      ==================================================*/

    /*==================================================
      THE BIG Q's:

      1. What is the max # of guesses if num is b/t 1 & 100?
      7, because you can continuously divide by 2 to get closer to the number.
      7 is the greatest power of 2 greater than 100.

      2. What is the max # of guesses if num is b/t 1 & 200?
      8, based on the same reasoning as above.
      In addition, you can get to the case with 100 in 1 guess.

      3. What is the max # of guesses if num is b/t 1 & 400?
      9. You can easily go from 400 to the case in 200 with one guess.
      Therefore, all you have to do is add 1.

      4. What is the max # of guesses if num is b/t 1 & 1000?
      10, by the same reasoning as above. :)

      5. What is the max # of guesses if num is b/t 1 & n?
      The max number of guesses would be the ceiling of log base 2 n.
      ==================================================*/

}//end class
