public class IsValidParenthases {
        
    // Question 1
    public static boolean isValidParentheses (String str){
        // initialize count to 0
        int count = 0;
        // call the recursive function
        return isValidParentheses(str, count);

    }

    // helper function
    private static boolean isValidParentheses (String str,int counter){
        // if the counter is negative, return false
        if (counter < 0) {
            return false;
        }
        // if the string is empty, return true if the counter is 0, false otherwise
        if (str.length() == 0) {
            return counter == 0;
        }
        // if the first character is not a parenthesis, call the function again with the rest of the string, and the same counter
        if ("()".indexOf(str.charAt(0)) == -1) {
            return isValidParentheses(str.substring(1), counter);
        }
           
        // if the first character is a parenthesis, call the function again with the rest of the string
        // the counter will increase or decrease by 1, depending on the parenthesis
        // if the parenthesis is '(' the counter will increase by 1,
        // if the parenthesis is ')' the counter will decrease by 1.
        // "))("indexOf(')') will result in 0 - 1 = -1
        // "))("indexOf('(') will result in 2 - 1 = 1

        return isValidParentheses(str.substring(1), counter + ("))(".indexOf(str.charAt(0)) - 1));

        // Another way to write the above line is:

        // if (str.charAt(0) == '(') {
        //     return isValidParentheses(str.substring(1), counter + 1);
        // }
        // return isValidParentheses(str.substring(1), counter - 1);

    }
     
}
