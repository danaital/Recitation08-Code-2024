public class MaxElement {
   
    // wrapper for the recursiveMax function.
    public static int recursiveMax (int[] array){
        return recursiveMax(array, 0, array.length - 1);
    }
   

    // recursively calculates the maximum element in array, 
    // which is located between the start and end indices
    public static int recursiveMax(int[] array, int start, int end){
        if(start == end){
            return array[start];
        }
        int mid = (start + end) / 2;
        return Math.max(recursiveMax(array, start, mid), recursiveMax(array, mid + 1, end));
    }
}
