package akki.algo.arr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class KthSmallestElement {
    static int kthsmallest(int arr[], int low, int high, int kth) {
        // If kth is smaller than number of elements in array
        if (kth > 0 && kth <= high - low + 1) {

            // partitioning the array along the pivot
            int pivot = randomPartition(arr, low, high);


            // check if current element gives you the kth smallest element
            if (pivot - low == kth - 1)
                return arr[pivot];

            // else recurse for the left and right half accordingly
            if (pivot - low > kth - 1)
                return kthsmallest(arr, low, pivot - 1, kth);
            return kthsmallest(arr, pivot + 1, high, kth - 1 - (pivot - low));
        }

        return Integer.MAX_VALUE;
    }


    static int partition(int arr[], int low, int high) {

        int x = arr[high], i = low;
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= x) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        int temp = arr[high];
        arr[high] = arr[i];
        arr[i] = temp;
        return i;
    }

    // Function to partition the array along the random pivot
    static int randomPartition(int arr[], int low, int high) {
        Random rand = new Random();
        int n = high - low + 1;
        int pivot = rand.nextInt(n);
        int temp = arr[high];
        arr[high] = arr[low + pivot];
        arr[low + pivot] = temp;

        return partition(arr, low, high);
    }


    // Driver program
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(bf.readLine());
            int[] arr = Arrays.stream(bf.readLine().split(" ")).map(Integer::parseInt).mapToInt(num -> (num == null ? 0 : num))
                    .toArray();
            int kth = Integer.parseInt(bf.readLine());

            int num = kthsmallest(arr, 0, len - 1, kth );

            System.out.println(num);
        }
    }
}

