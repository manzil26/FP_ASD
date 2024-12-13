import java.util.Arrays;

//Main class
class Main {
    public static void main(String args[]) {

        int[] data = { 8, 7, 2, 1, 0, 9, 6 };
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        int size = data.length;

        // call quicksort() on array data
        Quicksort.quickSort(data, 0, size - 1);

        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
class QuickSort {
    // method to find the partion position
    static int partition(int array[], int low, int high ){
        // chose the righmost element as pivot
        int pivot = array[high];
        // pointer for greter element
        int i = (low-1);

        // traverse througj all elemenet
        // compare each elemenet with pivot
        for (int j= low; j< high; j++){
            if (array[j] <= pivot ){
                // if element smaller than pivot is found
                // swap it with  the greter element pointed by i
                i++;

                // swapping element at i with element at j
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }
        }
        // swap the element with the greter element specified by i
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;
    }

}

