// EMILY LIAO
// pd9
// HW34
// 2013-11-26

/*==================================================
  class BinSearch2
  skeleton file
  ==================================================*/

public class BinSearch2 {


    /*==================================================
      int binSearch(int[],int) -- searches an array of ints for target int
      pre:  input array is sorted in ascending order
      post: returns index of target, or returns -1 if target not found
      ==================================================*/
    public static int binSearch ( Comparable[] a, Comparable target ) {
	//uncomment exactly 1 of the 2 stmts below:
	//return binSearchIter( a, target, 0, a.length-1 );
	return binSearchRec( a, target, 0, a.length-1 );
    }


    public static int binSearchRec( Comparable[] a, Comparable target, int lo, int hi ) {
	int mid =  (hi + lo) / 2 ;
	Comparable guess = a[mid];
	if ( guess.compareTo(target) == 0 ) {
	    return mid;
	}
	else if ( target < lo || target > hi) {
	    mid = -1;
	}
	else if ( guess > target ) {
	    hi = mid - 1;
	    binSearchRec( a, target, lo, hi );
	}
	else if ( guess < target ) {
	    lo = mid + 1;
	    binSearchRec( a, target, lo, hi );
	}
	else {
	    mid = -1;
	}
	return mid; 
    }


    public static int binSearchIter( int[] a, int target, int lo, int hi ) {
	int mid = (hi + lo) / 2;
	int guess = a[mid];
	while ( guess != target ) {
	    if ( target > hi || target < lo ) {
		mid = -1;
		break;
	    }
	    else if ( guess > target ) {
		hi = mid - 1;
	    }
	    else if ( guess < target ) {
		lo = mid + 1;
	    }
	    mid = (hi + lo) / 2;
	    guess = a[mid];
	}
	return mid;
    }



    //tell whether an array is sorted in ascending order
    private static boolean isSorted( int[] arr ) {
	boolean yay = false;
	for ( int a = 0; a < arr.length - 1; a++ ) {
	    if ( arr[a] < arr[a+1] ) {
		yay = true;
	    }
	    else {
		yay = false;
		break;
	    }
	}
	return yay;
    }

    //for Comparables
        private static boolean isSorted( Comparable[] arr ) {
	boolean yay = true;
	for ( int a = 0; a < arr.length - 1; a++ ) {
	    if ( arr[a].compareTo(arr[a+1]) > 0 )
		yay = false;
	}
	return yay;
    }
    

    // utility/helper fxn to display contents of an array of Objects
    private static void printArray( int[] arr ) {
	String output = "[ "; 

	for( int i : arr )
	    output += i + ", ";

	output = output.substring( 0, output.length()-2 ) + " ]";

	System.out.println( output );
    }


    //main method for testing
    public static void main ( String[] args ) {



	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	System.out.println("\nNow testing binSearch on int array...");

	//Declare and initialize array of ints
	int[] iArr = { 2, 4, 6, 8, 6, 42 };
	printArray( iArr );
	System.out.println( "sorted? -- " + isSorted(iArr) );

	int[] iArr2 = { 2, 4, 6, 8, 13, 42 };
	printArray( iArr2 );
	System.out.println( "sorted? -- " + isSorted(iArr2) );

	//search for 6 in array 
	System.out.println( binSearch(iArr2,6) );

	//search for 43 in array 
	System.out.println( binSearch(iArr2,43) );

	//search for 23 in array -- extra test!
	System.out.println( binSearch(iArr2,23) );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/*==================================================
	==================================================*/

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }//end main()

}//end class BinSearch2
