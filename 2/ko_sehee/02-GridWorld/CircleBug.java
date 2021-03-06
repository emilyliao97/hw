import info.gridworld.actor.Bug;

public class CircleBug extends Bug{
    private int steps, sideLength;
    public CircleBug(int length){
    sideLength = length;
    }
    public void act(){
        if (steps < sideLength && canMove())
	    {
		move();
		steps++;
	    }
        else
	    {
		turn();
		steps = 0;
	    }
    }
}