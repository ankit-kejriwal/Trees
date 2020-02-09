public class ArraySet1 {


    private static void selectionSort(int[] arr){
        for(int i =0;i<arr.length-1;i++){
            int index = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[index])
                    index = j;
            }
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    private static void insertionSort(int[] arr){
        for(int i =0;i<arr.length;i++){
            int temp = arr[i];
            int j =i;
            while (j>0 && temp <arr[j-1]){
                arr[j] = arr[j-1];
                j =j-1;
            }
            arr[j] =temp;
        }
    }

    private static void bubbleSort(int[] arr) {
        for(int i =0;i<arr.length-1;i++){
            for(int j =0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] =arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    private static void printArr(int[] arr){
        for(int val:arr)
            System.out.print(val+ " ");
        System.out.println();
    }

    private  static void rotateArray(int[] arr, int k){
        int len = arr.length;
        for(int i =0;i<k;i++){
            int temp = arr[0];
            for(int j=1;j<len;j++){
                arr[j-1] = arr[j];
            }
            arr[len-1] = temp;
        }
    }
    private  static void efficientRotateArray(int[] arr, int k){
        if(k<0)
            System.out.println("no rotation");
        k = k% arr.length;
        int low = 0;
        int high = k-1;
        while (low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        low = k;
        high = arr.length-1;
        while (low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        low = 0;
        high = arr.length -1;
        while (low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,20,5,7,0,15,8};
        selectionSort(arr);
        printArr(arr);
        int[] arr1 = {1,2,3,4,5};
        rotateArray(arr1,3);
        printArr(arr1);
        int[] arr2 = {1,2,3,4,5};
        efficientRotateArray(arr2,6);
        printArr(arr2);
    }
}
