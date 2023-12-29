public class Solution {
    public static void ri(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            // swapping
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;

            // inverting
            arr[i] = (arr[i] == 0) ? 1 : 0;
            arr[j] = (arr[j] == 0) ? 1 : 0;

            i++;
            j--;
        }
         if (i == j) 
            arr[i] = (arr[i] == 0) ? 1 : 0;
     }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            ri(image[i]);
        }
        return image;
    }
}
