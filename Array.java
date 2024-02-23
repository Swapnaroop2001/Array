
/**
 * Array
 */

// Insertion sort
public class Array {
    int k;

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

    public static void recursiveBubbleSort(int arr[],int n){
        if (n==1) {
            return;
        }
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]>arr[i+1]) {
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
        recursiveBubbleSort(arr,n-1);
    }

     //Merge sort
     public static void devide(int arr[],int low,int high) {
        if (low<high) {
            int mid= low + (high-low)/2;
            devide(arr, low, mid);
            devide(arr, mid+1, high);
            conquer(arr, low, mid, high);
        }
    }
    public static void conquer(int arr[],int low, int mid,int high) {
        int ans[]=new int[high-low+1];
        int k=0;
        int i=low;
        int j=mid+1;
        while (i<=mid && j<=high) {
            if (arr[i]<=arr[j]) {
                ans[k]=arr[i];
                k++;
                i++;
            }else{
                ans[k]=arr[j];
                k++;
                j++;
            }
        }
        while (i<=mid) {
            ans[k++]=arr[i++];
        }
        while (j<=high) {
            ans[k++]=arr[j++];
        }

        for (int a = low; a <= high; a++) {
            arr[a] = ans[a -low];
        }

    }
    // Quick Sort
    public static void quickSort(int arr[], int low, int high) {
        if (low<high) {
            int pi=partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }


    public static int partition(int arr[], int low, int high) {
        int j=high;
        int i=low+1;
        int pivot=arr[low];
        while (i<=j) {
            while (i<=j && arr[i]<=pivot) {
                i++;
            }
            while (i<=j && arr[j]>pivot) {
                j--;
            }
            if (i<j) {
               int temp=arr[i];
               arr[i]=arr[j];
               arr[j]=temp; 
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

    public static void main(String[] args) {
        int arr[] = { 5,4,3,2,1};
        recursiveBubbleSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}