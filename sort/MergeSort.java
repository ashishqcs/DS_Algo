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
        if (end < start)
        {
            return;
        }
        int mid = (start + end) / 2;
        merge(array, start, mid);
        merge(array, mid+1, end);
        sort(array, start, mid, end);
    }

    void sort(int[] array, int start, int mid, int end) {

    }
}
