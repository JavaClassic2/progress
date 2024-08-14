import java.util.Arrays;

public class BinarySearch {
    private static int search(int[] arr, int start, int end, int n) {
        if (start < 0 || end < 0) {
            throw new IllegalArgumentException();
        }

        if (start > end) {
            return -1;
        }

        int index = (start + end) / 2;

        if (arr[index] == n) {
            return index;
        }

        if (arr[index] < n) {
            start = index+1;
            return search(arr, start, end, n);
        }

        end = index-1;
        return search(arr, start, end, n);
    }

    public static int search(int[] arr, int n) {
        return search(arr, 0, arr.length-1, n);
    }

    public static void main(String[] args) {
    int[] a = { 22, 33, 44, 55, 66, 77, 88, 99 };
    System.out.println(Arrays.toString(a));
    System.out.println("search(a, 44): " + search(a, 44));
    System.out.println("search(a, 50): " + search(a, 50));
    System.out.println("search(a, 77): " + search(a, 77));
    System.out.println("search(a, 99): " + search(a, 99));
    System.out.println("search(a, 100): " + search(a, 100));
}
}
