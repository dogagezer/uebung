import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(array));

        SearchAlgortihms.MergeSort.mergeSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}