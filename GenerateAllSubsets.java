// The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

// For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

// You may also use a list or array to represent a set.



// import java.util.Scanner;
// import java.util.ArrayList;

import java.util.*;

// Time complexity is O(2^n) and space complexity is O(n).
class GenerateAllSubsets {

	ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

	public void addEmptySet() {

		ans.add(new ArrayList<Integer>());
	}


	void recur(ArrayList<Integer> arrayList, ArrayList<Integer> temp, int index) {


		for(int i=index; i<arrayList.size(); i++) {

			temp.add(arrayList.get(i));
			ans.add(new ArrayList<Integer>(temp));
			recur(arrayList, temp, i+1);
			temp.remove(temp.size() - 1);
		}
	}
	
	void print() {

		for(int i=0; i<ans.size(); i++) {

			for(int j=0; j<ans.get(i).size(); j++) {

				System.out.print(ans.get(i).get(j) + " ");
			}

			System.out.println("");
		}
	}

	public static void main(String... s) {

		
		GenerateAllSubsets obj = new GenerateAllSubsets();
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for(int i=0; i<size; i++) {

			arrayList.add(sc.nextInt());
		}

		Collections.sort(arrayList);

		obj.addEmptySet();

		if(arrayList.size() == 0) {

			obj.print();
		}
		else{

			obj.recur(arrayList, new ArrayList<Integer>(), 0);
			obj.print();
		}

	}

}