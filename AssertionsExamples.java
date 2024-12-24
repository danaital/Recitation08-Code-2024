public class AssertionsExamples {

    /** 
     * Takes a positive integer from the user and returns its factorial
    * Uses assertions to enforce the user to enter a valid positive argument. 
    */
    public static int factorial(int number) {
        if (number < 0) {
            throw new ArithmeticException("no negative factorial");
        }
        int ans = 1;
        for (int i = 1; i <= number; i++) {
            ans *= i;
        }
        // bool ? tCase : fCase 
        assert ans > 0 : "overflow has been occurred";
        return ans;
    }

  
}
