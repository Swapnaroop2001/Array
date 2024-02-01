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

 public static void main(String[] args) {
    int [] arr={3,4,1,2,9,7};
    Array a=new Array();
    a.InsertionSort(arr);
 }
  
}