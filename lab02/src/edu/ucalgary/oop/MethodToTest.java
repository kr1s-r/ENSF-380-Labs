package edu.ucalgary.oop;

public class MethodToTest {

  // edge cases: (-2^31, -8), (-8, 0), (0, 2^31 - 1)

  // what will happen:
  // if positive return sum - product
  // if between 0 and -8 return product - sum
  // else if less than -8 return 0

  // Take two integers. Subtract the product from the sum. Return
  // this number if it is positive. If it is below -8, return 0.
  // Otherwise, subtract the sum from the product and return that value.
  public static int subtractProductSum(int first, int second) {
    int sum = first + second;
    int product = first * second;
    int sumMinusProduct = sum - product;

    if (sumMinusProduct > 0)
      return sumMinusProduct;
    else {
      if (sumMinusProduct < -8)
        return 0;
      else
        return product - sum;
    }
  }

  public static void main(String[] args) {
		// What if sum - product < 0?
		// Expected: product - sum
		System.out.print("-3, -2 should give 0. Gave: ");
		System.out.println(subtractProductSum(-3, -2));

		// What if sum - product = 0?
		// Expected: product - sum
		System.out.print("0, 0 should give 0. Gave: ");
		System.out.println(subtractProductSum(0, 0));

		// What if sum - product is < -8?
		// Expected: special case of 0
		System.out.print("10, 20 should give 0. Gave: ");
		System.out.println(subtractProductSum(10, 20));

		// What if sum - product = -8?
		// Expected: product - sum
		System.out.print("-2, -2 should give 8. Gave: ");
		System.out.println(subtractProductSum(-2, -2));
	}
}
