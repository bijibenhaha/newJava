package basic;

public class Maopaopaixu {
    public static void sort(int[] arr){
        for (int i = arr.length; i >0 ; i--) {

        }

    }
    public static void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,5,3};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
