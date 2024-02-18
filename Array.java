/**
 * Array
 */


//Insertion sort
public class Array {
    int k;
    public void InsertionSort(int [] arr){
        for (int i = 1; i < arr.length; i++) {
            int key=arr[i];
            int j=i-1;
            while (j>=0&& arr[j]>key) {
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

//Selection sort
public void selectionSort(int arr[]){
        for (int i = 0; i < arr.length-1; i++) {
            int mini=i;
            int key= arr[mini];
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[mini]) {
                    mini=j;
                }
            }
            arr[i]=arr[mini];
            arr[mini]=key;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

//Bubble sort
public void bubbleSort(int arr[]) {
        for (int i =arr.length-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]) {
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
}

//Merge Sort
public void sort(int arr[],int low ,int high) {
    if (low<high) {
    int mid=low+ (high-low)/2;
    sort(arr, low, mid);
    sort(arr, mid+1, low);
    merge(arr,  low,  mid,high);
    }
}

public void merge(int arr[], int low, int mid, int high) {
    int helper[]=new int[high-low+1];
    for(int i = low; i <= high; i++){
        helper[i] = arr[i];
    }

    int i = low;
    int j = mid + 1;
    int k = low;

    while(i <= mid && j <= high){
        if(helper[i] <= helper[j]){
            arr[k] = helper[i];
            i++;
        } else {
            arr[k] = helper[j];
            j++;
        }
        k++;
    }

    while( i <= mid){
        arr[k] = helper[i];
        k++;
        i++;
    }
}


public void printArray(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i]+" ");
    }
}

//n Factorial
public static int Factorial(int n) {
    if (n==0 || n==1) {
        return 1;
    }
    int f=n+Factorial(n-1);
    return f;
}

//Fibonacci number at n
public static int fibonacci(int n) {
    if (n == 0 || n == 1) {
        return n;
    } else {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}


// We have a number of bunnies and each bunny has two big floppy ears. We want to compute the total number of ears across all the bunnies recursively.
public static int Bunnyears(int n){
    if (n==1) {
        return 2;
    }
    else{
        return Bunnyears(n-1)+2;
    }
}

//BunnyEars2
public static int Bunnyears2(int n){
    if (n==0) {
        return n;
    }
    else{
        if (n%2==0) {
            return Bunnyears2(n-1)+3;
        }
        else{
            return Bunnyears2(n-1)+2;
        }

    }
}


//Given a non-negative int n, return the sum of its digits recursively (no loops). Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
public static int sumDigit(int n){
    if (n<=10) {
        return n;
    }
    int k=n%10;
    return sumDigit(n/10)+k;
}

//Given a non-negative int n, return the count of the occurrences of 7 as a digit, so for example 717 yields 2.
public static int Count7(int n, int m){
    if (n<7) {
        return 0;
    }
    int j=n%10;
    if (j==7) {
        m++;
    }
    Count7(n/10,m);
    return m;
}
 public static void main(String[] args) {
 
    System.out.println(Count7(7777,0));
 }
  
}