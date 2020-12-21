/*
cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. For example, 
car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
*/


// Time complexity O(n) and Space complexity is O(1)
class Pair<G> {

	private G a;
	private G b;

	Pair(G a, G b) {

		this.a = a;
		this.b = b;
	}
	
	public static <G> Pair<G> cons(G a, G b) {

		return new Pair<G>(a, b);

	}

	public static <G> G car(Pair<G> pair) {

		return pair.a;
	}

	public static <G> G cdr(Pair<G> pair) {

		return pair.b;
	}

	@Override
    public String toString() {
        return "(" + a + "," + b + ")";
    }

	public static void main(String... s){

		Pair<Integer> pair = Pair.cons(1, 2);
		System.out.println("Pair : " + pair);

		int a = pair.car(pair);
		System.out.println("Output of car : "+ a);

		int b = pair.cdr(pair);
		System.out.println("Output of cdr : "+ b);
	}
}