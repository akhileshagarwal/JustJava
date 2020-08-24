package akki.algo.matrix;

import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        int sum1 = 0, sum2 = 0, size = arr.get(0).size();

        for (int i = 0, j = size - 1; i < size && j > -1; i++, j--) {
            sum1 += arr.get(i).get(i);
            sum2 += arr.get(i).get(j);
        }
        return Math.abs(sum1 - sum2);

    }
}
