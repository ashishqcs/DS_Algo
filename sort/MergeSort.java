package sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 0, 6, 7, 1};
        MergeSort mergeSort = new MergeSort();

        mergeSort.merge(array, 0, array.length - 1);

        for (int i: array) {
            System.out.println(i);
        }
    }

    void merge(int[] array, int start, int end){
        if (start >= end)
            return;

        int mid = (start + end) / 2;
        merge(array, start, mid);
        merge(array, mid+1, end);
        sort(array, start, mid, end);
    }

    void sort(int[] array, int start, int mid, int end) {

        int[] arr1 = new int[mid - start + 1];
        int[] arr2 = new int[end - mid];

        int i = 0;
        int j = 0;

        for (int x=start; x<=mid; x++){
            arr1[i++] = array[x];
        }
        for (int x=mid+1; x<=end; x++){
            arr2[j++] = array[x];
        }

        i = 0; j = 0;


        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                array[start++] = arr1[i++];
            }
            else if (arr2[j] <= arr1[i]){
                array[start++] = arr2[j++];
            }
        }

        while(i < arr1.length){
            array[start++] = arr1[i++];
        }
        while(j < arr2.length){
            array[start++] = arr2[j++];
        }
    }
}
