/**
 * Array
 */
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

 public static void main(String[] args) {
    int [] arr={5,4,6,7,3,9,2,7};
    Array a=new Array();
    a.bubbleSort(arr);;
 }
  
}