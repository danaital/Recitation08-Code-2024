public class Memo {
    // 
    public static void main(String[] args) {
        System.out.println(fibonacciMemozation(30));
    }
    public static long fibonacciMemozation(int n){
        return fibonacciMemozation(n, new long [n + 1]);
    }
    public static long fibonacciMemozation(int n,long [] fib) {
        // if n is 0 or 1, return n
        if (n == 0 || n == 1) {
            return n;
        }
        // if the Fibonacci number has already been calculated, return it
        if (fib[n] != 0) {
            return fib[n];
        }
        
        // the Fibonacci number at index n is the sum of the previous two numbers
        fib[n] = fibonacciMemozation(n - 1, fib) + fibonacciMemozation(n - 2, fib);
        return fib[n];
    }

    public static int maxSubArray(int[] nums) {
        // create new array for memo'
        int [] maxSub = new int [nums.length];
        // create fill the data with Integer.MIN_VALUE to not tamper with calculation 
        fillArray(maxSub, 0, Integer.MIN_VALUE);
        // base case 
        maxSub[0] = nums[0];
        // fill rest of memo array
        maxSubArrayHelper(nums, maxSub, 1);
        // find max in the memo array
        return findMax(maxSub);
    }
    
    private static void maxSubArrayHelper(int[] nums, int [] maxSub, int index) {
        // if the finished running, return
        if (nums.length == index) {
            return ;
        }
        // calculating according to formula
        maxSub[index] = Math.max(maxSub[index - 1] + nums[index], nums[index]);
        
        // recursively calculating the rest of the array
        maxSubArrayHelper(nums, maxSub, index + 1);
    }

    private static void fillArray(int[] arr, int index, int value) {
        // if the finished running, return
        if (index == arr.length) {
            return;
        }
        // set the value at the current index
        arr[index] = value;
        
        // recursively fill the rest of the array
        fillArray(arr, index + 1, value);
    }
    private static int findMax(int [] arr) {
        int maxIndex = findMaxHelper(arr,0,0);
        return arr[maxIndex];
    }

    private static int findMaxHelper(int [] arr, int curMaxIndex, int curIndex) {
        if (curIndex == arr.length) {
            return curMaxIndex;
        } 
        if (arr[curMaxIndex] < arr[curIndex]){
            return findMaxHelper(arr, curIndex, curIndex + 1);
        }
        return findMaxHelper(arr, curMaxIndex, curIndex + 1);
    }


}
