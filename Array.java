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

public void merge(int arr[],int low,int mid,int high){
    int idx1=0;
    int idx2=mid+1;
    int ans[]=new int[high];
    int k=0;

    while(idx1<=mid && idx2<=high) {
        if (arr[idx1]<=arr[idx2]) {
            ans[k]=arr[idx1];
            k++;
            idx1++;
        }else{
            ans[k]=arr[idx2];
            k++;
            idx2++;
        }
    }

    while (idx1<=mid) {
        ans[k++]=arr[idx1++];
    }
    while (idx2<=high) {
        ans[k++]=arr[idx2++];
    }

    for (int i = 0; i < ans.length; i++) {
        System.out.print(ans[i]+" ");
    }

}

public void sort(int arr[],int low, int high){
    int mid=low+(high-low)/2;
    sort(arr, low, mid);
    sort(arr, mid+1, high);
    merge(arr,low,mid,high);
}


 public static void main(String[] args) {
    int [] arr={5,4,6,7,3,9,2,7};
    Array a=new Array();
    a.bubbleSort(arr);

    a.sort(arr, 0, 7);
 }
  
}