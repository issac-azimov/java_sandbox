public class IntList {

	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	public int size() {
		if (rest == null) {
			return 1;
		} else {
			return 1 + this.rest.size();
		}
	}

	public int interativeSize() {
		int i = 1;
		IntList currentLink = this.rest;
		while (currentLink != null) {
			i++;
			currentLink = currentLink.rest;
		}
		return i;
	}

	public int get(int i) {
		int j = 0;
		IntList p = this;
		int getItem = p.first;
		while (j < i) {
			if (p.rest != null) {
				p = p.rest;
				getItem = p.first;
			}
			j++;
		}
		return getItem;
	}

	//recusive get
	public int recursiveGet(int i) {
		if (i == 0) {
			return first;
		} else {
			return this.rest.recursiveGet(i -1);
		}
	}
	/** Returns an IntList identical to L, but with
	 * each element incremented by x. L is not allowed
	 * to change. */
	public static IntList incrList(IntList L, int x) {
		
		if (L == null) {
			return L;
		} else {
			IntList incr = new IntList(L.first + x, incrList(L.rest, x));
			return incr;
		}
	}

	public static IntList incrListIterative(IntList L, int x) {
		IntList tempL = L.rest;
		IntList incr = new IntList(L.first +x, null);
		
		
		while (tempL != null) {
			incr = new IntList(tempL.first + x, incr);
			tempL = tempL.rest;
		}

		return reverseList(incr);
	}	


	public static IntList reverseList(IntList list) {
		IntList revList = new IntList(list.first, null);
		IntList tempList = list;
		int temp = 0;

		while (tempList != null) {
			temp = tempList.first;
			revList = new IntList(temp, revList);
			tempList = tempList.rest;

		}
		return revList;
	}

	/** Returns an IntList identical to L, but with
	  * each element incremented by x. Not allowed to use
	  * the 'new' keyword. */
	public static IntList dincrList(IntList L, int x) {
		if (L == null ) {
			return L;
		} else {
			L.first = L.first + x;
			return dincrList(L.rest, x);
				
		}
	}


	public static void main(String[] args) {
	//terrible implementation of a Linked List
		// IntList l = new IntList(3, null);
		// l.rest = new IntList(2, null);
		// l.rest.rest = new IntList(1, null);

	//better implementation of a Linked List
		IntList intList = new IntList(3, null);
		intList = new IntList(2, intList);
		intList = new IntList(1, intList);


		dincrList(intList, 1);
		for (int i = 0; i < intList.size(); i++) {
			System.out.println(intList.get(i));
		}

		// for (int i = 0; i < intList.size(); i++ ) {
		// 	System.out.println(reverseList(incrList(intList, 1)).get(i));
		// }
		
		// for (int i = 0; i < intList.size(); i++) {
		// 	System.out.println(intList.get(i));
		// }

	}
}