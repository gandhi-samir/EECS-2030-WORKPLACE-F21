import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 * See under doc/index.html for the API of methods.
 * This lab requires definitions of recursive helper methods. 
 */
public class RecursiveMethods {
	/*
	 * Return an array storing the first n numbers in an arithmetic sequence,
	 * with initial term 'start' and common difference 'diff'.  
	 * You can assume that n is non-negative (larger than or equal to 0).
	 * e.g., arithmeticArray(2, 3, 5) returns an array {2, 5, 8, 11, 14}.
	 * 
	 * Parameters:
	 * `start`: the first term in an arithmetic sequence
	 * `diff`: the common difference between terms in an arithmetic sequence
	 * `n`: the first n numbers in an arithmetic sequence
	 * 
	 *  You are forbidden to use the arithmeticList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticArrayHelper.
		 */
		return null;
	}
	
	/*
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 * 
	 * Parameters:
	 * `i`: position in `seq` to be assigned to
	 * `diff`: common difference of the arithmetics sequence 
	 * `seq`: a partially filled arithmetic sequence
	 *  
	 * Each recursive call to this helper method stores at index `i` of the resulting
	 * arithmetic sequence `seq`, which is assumed to have been partially filled at indices 0, 1, ..., i - 1. 
	 */
	void arithmeticArrayHelper(int i, int diff, int[] seq) {
		seq[i-1]=(i-1)*diff;
	}
	
	/*
	 * Return a list storing the first n numbers in an arithmetic sequence,
	 * with initial term 'start' and common difference 'diff'.  
	 * You can assume that n is non-negative (larger than or equal to 0).
	 * e.g., arithmeticList(2, 3, 5) returns a list {2, 5, 8, 11, 14}.
	 * 
	 * Parameters:
	 * `start`: the first term in an arithmetic sequence
	 * `diff`: the common difference between terms in an arithmetic sequence
	 * `n`: the first n numbers in an arithmetic sequence
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while). 
	 */
	public List<Integer> arithmeticList(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticListHelper.
		 */
		return null;
	}
	
	/*
	 * This is a recursive helper method expected to be used by arithmeticList.
	 * 
	 * Parameters:
	 * `i`: position in `seq` to be assigned to
	 * `diff`: common difference of the arithmetics sequence 
	 * `seq`: a partially filled arithmetic sequence
	 * `n`: size of the arithmetic sequence to be built eventually
	 *  
	 * Each recursive call to this helper method stores at index `i` of the resulting
	 * arithmetic sequence `seq`, which is assumed to have been partially filled at indices 0, 1, ..., i - 1. 
	 */
	void arithmeticListHelper(int i, int diff, List<Integer> seq, int n) {
		/*
		 * Your Task
		 */
	}
	
	/*
	 * Return whether or not an array represents the first n numbers of an arithmetic sequence.
	 * An arithmetic sequence has a common difference between every two adjacent terms.   
	 * The array may or may not be empty.
	 * e.g., isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1, 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * 
	 * Parameters:
	 * `a`: an array
	 * 
	 * You are forbidden to use the isArithmeticList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isArithmeticArray(int[] a) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticArrayHelper.
		 */
		return false;
	}
	
	/*
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 * 
	 * Parameters:
	 * `i`: position in `seq`, starting from which the remaining sub-sequence is an arithmetic sequence
	 * `diff`: common difference of the arithmetics sequence
	 * `a`" an array which may or may not be an arithmetic sequence 
	 *  
	 * Each recursive call to this helper method considers if elements of `a` at indices `i - 1` and `i`
	 * make two valid adjacent elements in the arithmetic sequence, 
	 * i.e., their difference is equal to the common difference `diff`. 
	 * Also, it considers if the remaining sub-sequence (indices i + 1, i + 2, ..., a.length - 1) 
	 * is an arithmetic sequence with common difference `diff`. 
	 */
	boolean isArithmeticArrayHelper(int i, int diff, int[] a) {
		/*
		 * Your Task
		 */
		return false;
	}
	
	/*
	 * Return whether or not a list represents the first n numbers of an arithmetic sequence.
	 * An arithmetic sequence has a common difference between every two adjacent terms.   
	 * The list may or may not be empty.
	 * e.g., isArithmeticList({1, 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns true (because the common difference is 2).
	 *
	 * Parameters:
	 * `l`: a list
	 * 
	 * You are forbidden to use the isArithmeticArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public boolean isArithmeticList(List<Integer> l) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticListHelper.
		 */
		return false;
	}
	
	/*
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 * 
	 * Parameters:
	 * `i`: position in `seq`, starting from which the remaining sub-sequence is an arithmetic sequence
	 * `diff`: common difference of the arithmetics sequence 
	 * `l`: l a list which may or may not be an arithmetic sequence
	 *  
	 * Each recursive call to this helper method considers if elements of `l` at indices `i - 1` and `i`
	 * make two valid adjacent elements in the arithmetic sequence, 
	 * i.e., their difference is equal to the common difference `diff`. 
	 * Also, it considers if the remaining sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) 
	 * is an arithmetic sequence with common difference `diff`. 
	 */
	boolean isArithmeticListHelper(int i, int diff, List<Integer> l) {
		/*
		 * Your Task
		 */
		return false;
	}
	
	/*
	 * Given a sorted input array a, return a sorted array of size a.length + 1, 
	 * consisting of all elements of array a and integer i.
	 * 
	 * Parameters:
	 * `a`: an array that is sorted in a non-descending order
	 * `i`: an integer
	 * 
	 * e.g., insertIntoSortedArray({1, 2, 4, 5}, 3) returns a sorted array {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedList method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		return null;
	}
	
	/*
	 * Given a sorted input list, return a sorted list of size list.size() + 1, 
	 * consisting of all elements of the input list and integer i.
	 * 
	 * Parameters:
	 * `list`: a list that is sorted in a non-descending order
	 * `i`: an integer
	 * 
	 * e.g., insertIntoSortedList({1, 2, 4, 5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 * 
	 * You are forbidden to use the insertIntoSortedArray method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> list, int i) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		return null;
	}
	
	/*
	 * Given two sorted arrays left and right, 
	 * where left is sorted in a non-descending order and right is sorted in a ***non-ascending*** order,
	 * return an array (of size left.length + right.length) sorted in a non-descending order, 
	 * consisting of all elements of arrays left and right.
	 * 
	 * Parameters:
	 * `left`: an array sorted in a non-descending order
	 * `right`: an array sorted in a non-ascending order
	 * 
	 * e.g., mergeSortedArrays({1, 3, 5, 7}, {8, 6, 4, 2}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedLists method below to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		return null;
	}
	
	/*
	 * Given two sorted lists left and right, 
	 * where left is sorted in a non-descending order and right is sorted in a ***non-ascending*** order,
	 * return a list (of size left.length + right.length) sorted in a non-descending order, 
	 * consisting of all elements of lists left and right.
	 * 
	 * Parameters:
	 * `left`: a list sorted in a non-descending order
	 * `right`: a list sorted in a non-ascending order
	 * 
	 * e.g., mergeSortedLists({1, 3, 5, 7}, {8, 6, 4, 2}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 * You are forbidden to use the mergeSortedArrays method above to solve this problem.
	 * 
	 * Requirement:
	 * You are required to implement all methods recursively.
	 * You receive a zero if there is any occurrence of a loop (e.g., for, while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		/*
		 * Your Task: Define a recursive method yourself and use it here.
		 */
		return null;
	}
}
