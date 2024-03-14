
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Array
 */

// Insertion sort
public class Array {
    public void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Recursisve Insertion sort
    public static void recursiveInsertion(int arr[], int i) {
        if (i == arr.length)
            return;
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
        recursiveInsertion(arr, i + 1);
    }

    // Selection sort
    public void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int mini = i;
            int key = arr[mini];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            arr[i] = arr[mini];
            arr[mini] = key;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Bubble sort
    public static void bubbleSort(int arr[]) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int didSwap = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = 1;
                }
            }
            if (didSwap == 0) {
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void recursiveBubbleSort(int arr[], int n) {
        if (n == 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        recursiveBubbleSort(arr, n - 1);
    }

    // Merge sort
    public static void devide(int arr[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            devide(arr, low, mid);
            devide(arr, mid + 1, high);
            conquer(arr, low, mid, high);
        }
    }

    public static void conquer(int arr[], int low, int mid, int high) {
        int ans[] = new int[high - low + 1];
        int k = 0;
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                ans[k] = arr[i];
                k++;
                i++;
            } else {
                ans[k] = arr[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            ans[k++] = arr[i++];
        }
        while (j <= high) {
            ans[k++] = arr[j++];
        }

        for (int a = low; a <= high; a++) {
            arr[a] = ans[a - low];
        }

    }

    // Quick Sort
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int j = high;
        int i = low + 1;
        int pivot = arr[low];
        while (i <= j) {
            while (i <= j && arr[i] <= pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Summation of n natural nums
    public static int Summation(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return n + Summation(n - 1);
    }

    // Summation of n natural nums using parameterised way
    public static void Summation2(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        Summation2(i - 1, sum + i);
    }

    // n Factorial
    public static int Factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * Factorial(n - 1);
    }

    // Fibonacci number at n
    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // We have a number of bunnies and each bunny has two big floppy ears. We want
    // to compute the total number of ears across all the bunnies recursively.
    public static int Bunnyears(int n) {
        if (n == 1) {
            return 2;
        } else {
            return Bunnyears(n - 1) + 2;
        }
    }

    // BunnyEars2
    public static int Bunnyears2(int n) {
        if (n == 0) {
            return n;
        } else {
            if (n % 2 == 0) {
                return Bunnyears2(n - 1) + 3;
            } else {
                return Bunnyears2(n - 1) + 2;
            }

        }
    }

    // Given a non-negative int n, return the sum of its digits recursively (no
    // loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
    // while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
    public static int sumDigit(int n) {
        if (n <= 10) {
            return n;
        }
        int k = n % 10;
        return sumDigit(n / 10) + k;
    }

    // Given a non-negative int n, return the count of the occurrences of 7 as a
    // digit, so for example 717 yields 2.
    public static int Count7(int n, int m) {
        if (n < 7) {
            return 0;
        }
        int j = n % 10;
        if (j == 7) {
            m++;
        }
        Count7(n / 10, m);
        return m;
    }

    // Reverse array using recursion
    public static void ReaverseArray(int arr[], int i) {
        if (i >= arr.length - 1 - i) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j] + " ");
            }
            return;
        }
        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;
        ReaverseArray(arr, i + 1);
    }

    // Palindrome or not
    public static boolean Palindrome(String Str, int i) {
        boolean flag = true;
        if (i >= Str.length() - 1 - i) {
            return flag;
        }
        if (Str.charAt(i) == Str.charAt(Str.length() - 1 - i)) {
            return Palindrome(Str, i + 1);
        } else {
            flag = false;
        }
        return flag;
    }

    // Given an integer array nums, rotate the array to the right by k steps, where
    // k is non-negative.
    public static void rotateByk(int nums[], int k) {
        int temp[] = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[(i + k) % nums.length] = temp[i];
        }
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    //
    public static int[] zigZag(int[] numbers) {
        int ans[] = new int[numbers.length - 2];
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] < numbers[i + 1] && numbers[i + 1] > numbers[i + 2]) {
                ans[i] = 1;
            } else if (numbers[i] > numbers[i + 1] && numbers[i + 1] < numbers[i + 2]) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }
        }
        return ans;
    }

    public static void moveZeros(int arr[]) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return;
        }

        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Union of arrays
    public static void findUnioun(int arr1[], int arr2[]) {
        HashSet<Integer> Set1 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            Set1.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if (!Set1.contains(arr2[i])) {
                Set1.add(arr2[i]);
            }
        }

        for (Integer integer : Set1) {
            System.out.print(integer + " ");
        }
    }

    // Intersection of two arrays
    public static void findIntersection(int arr1[], int arr2[]) {
        HashSet<Integer> Set1 = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            Set1.add(arr1[i]);
        }
        HashSet<Integer> Set2 = new HashSet<>();
        for (int i = 0; i < arr2.length; i++) {
            if (Set1.contains(arr2[i])) {
                Set2.add(arr2[i]);
            }
        }
        for (Integer integer : Set2) {
            System.out.print(integer + " ");
        }
    }

    // Max Consecutive ones
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (max < count) {
                    max = count;
                }
                count = 0;
            }

        }
        if (nums[nums.length - 1] == 1) {
            if (max < count) {
                max = count;
            }
        }
        return max;

    }

    // Missing Number
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        int sum2 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        return sum - sum2;
    }

    // Given a non-empty array of integers nums, every element appears twice except
    // for one. Find that single one.
    public static int singleNumber(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            k = k ^ nums[i];
        }
        return k;
    }

    // twoSum
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (!map.containsKey(target - nums[i])) {
                continue;
            } else {
                return new int[] { i, map.get(target - nums[i]) };
            }
        }
        return new int[] { -1, -1 };
    }

    // Sort array of 0's, 1's & 2's.
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
                mid++;
            }
        }
    }

    // Majority element
    // Given an array nums of size n, return the majority element.The majority
    // element is the element that appears more than ⌊n / 2⌋ times.
    // BruteForce
    public int majorityElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            if (count >= nums.length / 2) {
                return count;
            }
        }
        return -1;
    }

    // Better approach for majority element.
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            if (it.getValue() > (nums.length / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }

    // Optimal approach for Majority element.
    public int majorityElement3(int[] nums) {
        return major(nums, nums[0], 0);
    }

    public int major(int[] nums, int elem, int i) {
        int count = 0;
        for (int j = i; j < nums.length; j++) {
            if (elem == nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return major(nums, nums[j], j);
            }
        }
        return elem;
    }

    // Given an integer array nums, find the subarray with the largest sum, and
    // return its sum.
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum=sum+nums[i];
            if (max<sum) {
                max=sum;
            }
            if (sum<0) {
                sum=0;
            }
        }
        return max;
    }

    // Longest subarray with sum k
    public static int getLongestSubarray(int[] nums, int k) {
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    length = Math.max(j - i + 1, length);
                }
            }
        }
        return length;
    }

    // Return number of subarrays with sum k;
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count = count + 1;
                }
            }
        }
        return count;
    }

    // Best Time to Buy and Sell Stock : Brute Force
    public int maxProfit(int[] prices) {
        int profit=0;
        int maxProfit=0;
        for (int i = prices.length-1 ; i >=1; i--) {
            for (int j = i-1; j >= 0; j--) {
                profit=prices[i]-prices[j];
                if(profit>maxProfit){
                    maxProfit=profit;
                }
            }
        }
        return maxProfit;
    }

    //Best Time to Buy and Sell Stock: Optimal solution
    public static int maxProfit2(int[] prices) {
        int min=prices[0];
        int maxProfit=0;
        for (int i = 0; i < prices.length; i++) {
            maxProfit=Math.max(maxProfit, prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return maxProfit;
    }

    //Rearrange elements by sign
    public int[] rearrangeArray(int[] nums) {
        ArrayList <Integer> pos=new ArrayList<>();
        ArrayList <Integer> neg=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0) {
                pos.add(nums[i]);
            }
            else{
                neg.add(nums[i]);
            }
        }

        if (pos.size()>neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                nums[i*2]=pos.get(i);
                nums[(i*2)+1]=neg.get(i);
            }
            int k=neg.size()*2;
            for (int i = neg.size()-1; i <pos.size() ; i++) {
                nums[k]=pos.get(i);
            }
        }else{
            for (int i = 0; i < pos.size(); i++) {
                nums[i*2]=pos.get(i);
                nums[(i*2)+1]=neg.get(i);
            }
            int k=pos.size()*2;
            for (int i = pos.size()-1; i <neg.size() ; i++) {
                nums[k]=neg.get(i);
            }
        }

        return nums;
        
    }

    //Rearrange elements by sign : Optimal
    public int[] rearrangeArray2(int[] nums) {
        int answer[]= new int[nums.length];
        int i=0,j=1;
        for(int k=0;k<nums.length;k++) {
            if (nums[k]>0) {
                answer[i]=nums[k];
                i+=2;
            }
            else{
                answer[j]=nums[k];
                j+=2;
            }
        }
        return answer;
    }

    //Next permutation.
    public void nextPermutation(int[] nums) {

        // Step 1
        int index=-1;
        for (int i = nums.length-2; i>=0; i--) {
            if (nums[i]<nums[i+1]) {
                index=i;
                break;
            }
        }
        if (index==-1) {
            for (int i = 0; i <=Math.floor(nums.length/2); i++) {
                int temp=nums[i];
                nums[i]=nums[nums.length-1-i];
                nums[nums.length-1-i]=temp;
            }
            return;
        }

        // Step 2
        for (int i = nums.length-1; i> index; i--) {
            if (nums[i]>nums[index]) {
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                break;
            }
        }

        // Step 3
        for (int i = nums.length-1; i >index; i--) {
            int temp=nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=temp;
        }

        return;
    }

    //1299. Replace Elements with Greatest Element on Right Side
    public int[] replaceElements(int[] arr) {
        int maximum=-1;
        for (int i = arr.length-1; i>=0; i++) {
            if (arr[i]>maximum) {
                int temp=arr[i];
                arr[i]=maximum;
                maximum=temp;
            } else {
                arr[i]=maximum;
            }
        }
        return arr;
    }

    //Set matrix Zero
    public void setZeroes(int[][] matrix) {
        int row=0;
        int col=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0) {
                    row=i;
                    col=j;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i==row) {
                    matrix[i][j]=0;
                }
                if (j==col) {
                    matrix[i][j]=0;
                }
            }
        }
    }

    // Rotate Matrix by 90 degree.
    public static void rotateMatrix(ArrayList<ArrayList<Integer>> mat, int n, int m) {
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.size(); j++) {
              ans.add(n-1-i, mat.get(mat.get(j)));
            }
        }
    }

    

    public static void main(String[] args) {
        int arr2[] = { 1, 1, 3, 2, 2, 3, 5 };
        System.out.println(maxProfit2(arr2));
    }
}