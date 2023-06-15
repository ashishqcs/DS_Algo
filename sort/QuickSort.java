package sort;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 0, 6, 7, 1};
        QuickSort quickSort = new QuickSort();

        quickSort.quick(array, 0, array.length - 1);

        for (int i: array) {
            System.out.println(i);
        }
    }


    void quick(int[] array, int start, int end){
        if (start < end){
            int i = sort(array, start, end);
            quick(array, start, i-1);
            quick(array, i+1, end);
        }
    }

    int sort(int[] array, int start, int end){
        int pivot = array[end];
        int i = start-1;
        int j = start;
        for (int k=start; k<end; k++){
            if (array[j] < pivot){
                swap(array, i, j);
                i++;
            }
            j++;
        }
        swap(array, i, end);

        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[++i];
        array[i] = array[j];
        array[j] = temp;
    }
}
