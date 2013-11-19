// EMILY LIAO
// pd9
// HW27
// 2013-11-18

public class Rational {

    //Phase Numero Uno

    //Instance vars
    private int numer;
    private int denom;
  
    //Default constructor
    public Rational() {
	numer = 0;
	denom = 1;
    }

    //Overloaded constructor
    public Rational(int x, int y) {
	numer = x;
	denom = y;
	if (y == 0 ) {
	    numer = 0;
	    denom = 1;
	    System.out.println("The denominator is invalid. Your rational number has been set to 0/1");
	}
    }

    //Overloaded toString
    public String toString() {
	String retStr = "" + numer + "/" + denom ;
	return retStr;
    }

    //Methods
    public void multiply(Rational a) {
	numer *= a.numer;
	denom *= a.denom;
    }

    public void divide(Rational b) {
	numer *= b.denom;
	denom *= b.numer;
	//because dividing by a fraction is = to multiplying by its reciprocal
    }

    //Phase Numero Dos
    public void add(Rational c) {
	int cnum = c.numer;
	int cden = c.denom;
	numer *= cden;
	cnum *= denom;
	denom *= cden;
	cden = denom;
	numer += cnum;
    }

    public void subtract(Rational d) {
	int dnum = d.numer;
	int dden = d.denom;
	numer *= dden;
	dnum *= denom;
	denom *= dden;
	dden = denom;
	numer -= dnum;
    }

    public int gcd(int p, int q) {
	if (p % q == 0) {
	    return q;
	}
	else {
	    return gcd(q, p % q);
	}
    }

    public void reduce() {
	int z = gcd(numer, denom);
	numer /= z;
	denom /= z;
    }

    //Phase Numero Tres
    public static int gcdtic(int numer, int denom) {
	if (numer % denom == 0) {
	    return denom;
	}
	else {
	    return gcdtic(denom, numer % denom);
	}
    }

    public int compareTo(Rational e) {
	int crossmult1 = numer * e.denom;
	int crossmult2 = denom * e.numer;
	if (crossmult1 == crossmult2)
	    return 0;
	else if (crossmult1 > crossmult2) 
	    return 1;
	else
	    return -1;
    }

    public static void main ( String[] args ) {

	//Testing Constructors
	Rational a = new Rational();
	System.out.println(a);
	Rational b = new Rational(1, 2);
	System.out.println(b);
	Rational c = new Rational(3, 0);
	System.out.println(c);

	//Testing Multiply
	Rational d = new Rational(2, 3);
	d.multiply(b);
	System.out.println(d);
	System.out.println(b); //shouldn't change >> still 1/2

	//Testing Divide
	//Remember: d is now 2/6 >> want it to be 4/6
	d.divide(b);
	System.out.println(d);
	System.out.println(b); //shouldn't change >> still 1/2

	//Testing Add
	Rational e = new Rational(2, 3);
	Rational f = new Rational(1, 2);
	e.add(f);
	System.out.println(e);
	System.out.println(f);

	//Testing Subtract
	e.subtract(f); //remember, e is 7/6 now
	System.out.println(e); //should be changed to 8/12
	System.out.println(f); // should stay the same >> 1/2

	//Testing Reduce
	Rational g = new Rational(4, 18);
	g.reduce(); 
	System.out.println(g); //should be reduced to 2/9

	//Testing Static gcd
	System.out.println(gcdtic(3, 6));

	//Testing CompareTo
	Rational h = new Rational(5, 13);
	Rational i = new Rational(3, 2);
	System.out.println(h.compareTo(i)); //should return -1
	System.out.println(i.compareTo(h)); //should return 1
	Rational j = new Rational(1, 2);
	Rational k = new Rational(4, 8);
	System.out.println(j.compareTo(k)); //should return 0
    }
}
