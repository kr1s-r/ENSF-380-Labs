package edu.ucalgary.oop;

// Debug this code using the code provided in MainTest.
public class ReturnNumber {
	private int largest;
	private int smallest;
	private int middle;

	// Getter
	public int getMiddle() {
		return this.middle;
	}

	// Getter
	public int getLargest() {
		return this.largest;
	}

	// Getter
	public int getSmallest() {
		return this.smallest;
	}

	// Setter: replace the smallest number with a new number, reorder numbers
	public void setSmallest(int newNumber) {
    this.setAll(newNumber, this.middle, this.largest);
		return;
	}

	// Setter: replace the middle number with a new number, reorder numbers
	public void setMiddle(int newNumber) {
    this.setAll(this.smallest, newNumber, this.largest);

		return;
	}

	// Setter: replace the largest number with a new number, reorder numbers
	public void setLargest(int newNumber) {
    this.setAll(this.smallest, this.middle, newNumber);
		return;
	}

	// Take three integers, order from largest to smallest and store.
	public void setAll(int one, int two, int three) {
    // 6 cases:
    // one > two > three (good)
    // one > three > two (good)
    // two > one > three (good)
    // two > three > one (good)
    // three > one > two (good)
    // three > two > one (good)

		if (one >= two && two >= three) {
			this.largest = one;
			this.middle = two;
			this.smallest = three;
			return;
		}

    if (one >= three && three >= two) {
      this.largest = one;
      this.middle = three;
      this.smallest = two;
      return;
    }

		if (two >= one && one >= three) {
			this.largest = two;
			this.middle = one;
			this.smallest = three;
			return;
		}

    if (two >= three && three >= one) {
      this.largest = two;
      this.middle = three;
      this.smallest = one;
      return;
    }

    if (three >= one && one >= two) {
      this.largest = three;
      this.middle = one;
      this.smallest = two;
      return;
    }

		if (three >= two && two >= one) {
			this.largest = three;
			this.middle = two;
			this.smallest = one;
			return;
		}
	}

	// Constructor
	public ReturnNumber(int one, int two, int three) {
		setAll(one, two, three);
	}
}
