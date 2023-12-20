import java.util.Arrays;

public class SearchAlgortihms {
    public class LinearSearch {
        public static int linearSearch(int[] array, int target) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == target) {
                    return i; // Return the index if found
                }
            }
            return -1; // Return -1 if not found
        }
    }
    public class BinarySearch {

        public static int binarySearch(int[] array, int target) {
            int low = 0, high = array.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (array[mid] == target) {
                    return mid; // Return the index if found
                } else if (array[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1; // Return -1 if not found
        }
    }
    public class MergeSort {
        public static void mergeSort(int[] array) {
            if (array == null || array.length <= 1) {
                return; // Already sorted
            }

            // Split the array into two halves
            int mid = array.length / 2;
            int[] leftArray = new int[mid];
            int[] rightArray = new int[array.length - mid];

            System.arraycopy(array, 0, leftArray, 0, mid);
            System.arraycopy(array, mid, rightArray, 0, array.length - mid);

            // Recursively sort the two halves
            mergeSort(leftArray);
            mergeSort(rightArray);

            // Merge the sorted halves
            merge(array, leftArray, rightArray);
        }

        private static void merge(int[] array, int[] leftArray, int[] rightArray) {
            int i = 0; // Index for leftArray
            int j = 0; // Index for rightArray
            int k = 0; // Index for merged array

            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] <= rightArray[j]) {
                    array[k] = leftArray[i];
                    i++;
                } else {
                    array[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            // Copy remaining elements of leftArray, if any
            while (i < leftArray.length) {
                array[k] = leftArray[i];
                i++;
                k++;
            }

            // Copy remaining elements of rightArray, if any
            while (j < rightArray.length) {
                array[k] = rightArray[j];
                j++;
                k++;
            }
        }

    }

    public class InsertionSort {
        public static void insertionSort(int[] array) {
            if (array == null || array.length <= 1) {
                return; // Already sorted
            }

            int n = array.length;

            for (int i = 1; i < n; i++) {
                int key = array[i];
                int j = i - 1;

                // Move elements of array[0..i-1] that are greater than key
                // to one position ahead of their current position
                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j--;
                }

                array[j + 1] = key;
            }
        }
    }


}
