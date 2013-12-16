/*========================================
Another sample AP question. 1 of 4 free-response questions, 
for which you will have about 1hr45min.
Note that for today's work, you will have to implement a constructor 
and a main method yourself for testing...

The following class WordList is designed to store and manipulate a 
list of words. The incomplete class declaration is shown below. 
You will be asked to implement two methods.
========================================*/

import java.util.ArrayList;

public class WordList {

    private ArrayList<String> myList; // contains Strings made up of letters

    public WordList() {
	ArrayList<String> myList = new ArrayList<String>();
	myList.add("cat");
	myList.add("mouse");
	myList.add("frog");
	myList.add("dog");
	myList.add("dog");
    }

    //postcond: returns the number of words in this WordList that are 
    //          exactly len letters long
    public int numWordsOfLength(int len) {
	int ctr = 0;
	for ( String a : myList ) {
	    if (len == a.length() )
		ctr++;
	}
	return ctr;
    }

    //postcond: all words that are exactly len letters long have been removed 
    //          from this WordList, with order of remaining words unchanged
    public void removeWordsOfLength(int len) { 
	int ind = 0;
	for ( String a : myList ) {
	    if ( len == a.length() ) {
		myList.remove(ind);
		ind--;
	    }
	    ind++;
	}
    }

    //... constructor and other methods not shown
}


/*========================================
QUESTION 1A: Write the WordList method numWordsOfLength. 
Method numWordsOfLength returns the number of words in the WordList that 
are exactly len letters long. For example, assume that the instance 
variable myList of the WordList animals contains the following.
    ["cat", "mouse", "frog", "dog", "dog"] 

The table below shows several sample calls to numWordsOfLength.

Call                                    Result returned by call
animals.numWordsOfLength(4)             1
animals.numWordsOfLength(3)             3
animals.numWordsOfLength(2)             0

Complete method numWordsOfLength below.



//postcond: returns the number of words in this WordList that 
//          are exactly len letters long 
public int numWordsOfLength(int len) {
    int ctr = 0;
    for ( String a : myList ) {
	if (len == a.length() )
	    ctr++;
    }
    return ctr;
}
========================================*/



/*========================================
QUESTION 1B: Write the WordList method removeWordsOfLength. 
Method removeWordsOfLength removes all words from the WordList that are exactly 
len letters long, leaving the order of the remaining words unchanged. 
For example, assume that the instance variable myList of the WordList 
animals contains the following.
    ["cat", "mouse", "frog", "dog", "dog"] 

The table below shows a sequence of calls to the removeWordsOfLength method.

Call                                   myList after the call 
animals.removeWordsOfLength(4);        ["cat", "mouse", "dog", "dog"] 
animals.removeWordsOfLength(3);        ["mouse"] 
animals.removeWordsOfLength(2);        ["mouse"]

Complete method removeWordsOfLength below.



//postcond: all words that are exactly len letters long 
//          have been removed from this WordList, with the 
//          order of the remaining words unchanged 
public void removeWordsOfLength(int len) { 
    int ind = 0;
    for ( String a : myList ) {
	if ( len == a.length() ) {
	    myList.remove(ind);
	    ind--;
	}
	ind++;
    }
}
========================================*/
