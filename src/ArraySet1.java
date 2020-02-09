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

    private static int fibonacci(int n){
        int num1 = 0;
        int num2 = 1;
        int res =0;
        if( n == 1)
            return num1;
        if(n == 2)
            return num2;
        for(int i =3;i<=n+1;i++){
            res = num1 + num2;
            num1 = num2;
            num2 = res;
        }
        return res;
    }

    private static int maxSubArraySum(int[] arr){
        int currsum =0;
        int maxsum = 0;
        for(int i=0;i<arr.length;i++){
            currsum+= arr[i];
            if(maxsum<currsum)
                maxsum = currsum;
            if(currsum < 0)
                currsum =0;
        }
        return maxsum;
    }

    private static int maximumAvg(int[] arr,int k){
        int maxsum = 0,sum =0;
        for(int i=0;i<arr.length -k ;i++){
            sum =0;
            for(int j=i;j<i+k;j++){
                sum+= arr[j];
            }
            if(sum> maxsum)
                maxsum = sum;
        }
        return maxsum;
    }

    private static int efficientMaxSum(int[] arr, int k) {
        int maxsum = 0, sum =0;
        for(int i=0;i<k;i++){
            sum+= arr[i];
        }
        maxsum = sum;
        for(int i =k;i<arr.length;i++){
            sum = sum+ arr[i]- arr[i-k];
            if(sum>maxsum)
                maxsum = sum;
        }
        return maxsum;
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
        System.out.println(fibonacci(10));
        int[] arr3 = {2, -9, 5, 1, -4, 6, 0, -7, 8};
        System.out.println(maxSubArraySum(arr3));
        int[] arr4 = {11, -8, 16, -7, 24, -2, 3};
        System.out.println(maximumAvg(arr4,3));
        System.out.println(efficientMaxSum(arr4,3));
    }
}
