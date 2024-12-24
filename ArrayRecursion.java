public class ArrayRecursion {

    public static void main(String[] args) {
        int [] arr = {3, 4, -3, 50, 7};
        System.out.println(maxValue(arr));
    }

    public static void printArray(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int maxValue(int [] arr) {
        int maxIndex = maxValueHelper(arr,0,0);
        return arr[maxIndex];
    }
    private static int maxValueHelper(int [] arr, int curMaxIndex, int curIndex) { //{3, 4, -3, 50, 7};
        if (curIndex == arr.length) {
            return curMaxIndex;
        } 
        if (arr[curMaxIndex] < arr[curIndex]){
            return maxValueHelper(arr, curIndex, curIndex + 1);
        }
        return maxValueHelper(arr, curMaxIndex, curIndex + 1);
    }
    
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        // create a new array to store the merged elements
        int[] merged = new int[arr1.length + arr2.length];
        
        // merge the arrays
        mergeArrays(arr1, arr2, 0, 0, merged);
        
        // return the merged array
        return merged;
    }
    
    private static int[] mergeArrays(int[] arr1, int[] arr2, int index1, int index2, int[] merged) {
        // if one of the arrays is empty, copy the rest of the other array into merged
        if (index1 >= arr1.length) {
            copyArray(arr2, merged, index2, index1 + index2);
            return merged;
        }
        if (index2 >= arr2.length) {
            copyArray(arr1, merged, index1, index1 + index2);
            return merged;
        }
        // add the smaller element to the merged array
        if (arr1[index1] < arr2[index2]) {
            merged[index1 + index2] = arr1[index1];
            index1++;
        } else {
            merged[index1 + index2] = arr2[index2];
            index2++;
        }
        // recursively merge the rest of the arrays
        return mergeArrays(arr1, arr2, index1, index2, merged);
    }

    private static void copyArray(int[] arr1, int[] arr2, int index1, int index2) {
        // if finished copying, return
        if (index1 == arr1.length || index2 == arr2.length) {
            return;
        }
        
        // copy the value at the current index
        arr2[index2] = arr1[index1];
        
        // recursively copy the rest of the array
        copyArray(arr1, arr2, index1 + 1, index2 + 1);
    }


    public static int [] mapIntoSquared (int [] arr){
        return mapIntoSquaredHelper(arr, new int [arr.length], 0);
    }

    private static int [] mapIntoSquaredHelper (int [] arr, int [] result, int index){
        if (index == arr.length){
            return result;
        }
        result[index] = arr[index] * arr[index];
        return mapIntoSquaredHelper(arr,result,index + 1);    
    }


    public static String[] filterByLength(String[] arr, int minLen) { 
        int count = filterByLengthCounter(arr, minLen, 0);
        String[] filteredArray = new String[count];
        filteredArray = filterByLengthHelper(arr, filteredArray, minLen, 0, 0);
        return filteredArray;
    }

    private static int filterByLengthCounter(String[] arr, int minLen, int index) {
        if (arr.length == index) {
            return 0;
        }
        int isInLength = (arr[index].length() >= minLen) ? 1 : 0;
        return isInLength + filterByLengthCounter(arr, minLen, index + 1);
    }
    private static String[] filterByLengthHelper(String[] arr, String[] filtered, int minLen, int originalArrIndex, int newArrIndex) {
        if (arr.length == originalArrIndex) {
          return filtered;
        }
        if (arr[originalArrIndex].length() >= minLen){
          filtered[newArrIndex] = arr[originalArrIndex];
          return filterByLengthHelper(arr, filtered, minLen, originalArrIndex + 1, newArrIndex + 1);
        }
        return filterByLengthHelper(arr, filtered, minLen, originalArrIndex + 1, newArrIndex);
    }   
}
