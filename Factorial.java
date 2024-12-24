public class Factorial {
	
    public static int factorial (int number) {
        if (number < 0) {
            throw new ArithmeticException("factorial should receive non negative number");
        }
        int ans = 1;
        for (int i = 1; i <= number; i++) {
            ans *= i;
        }
        assert ans > 0: "overflow has been occurred";
        return ans;
    }
    
}    