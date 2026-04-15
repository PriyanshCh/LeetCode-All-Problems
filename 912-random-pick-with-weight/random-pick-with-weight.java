import java.util.Random;

class Solution {

    private int[] prefix;
    private int total;
    private Random rand;

    public Solution(int[] w) {
        prefix = new int[w.length];
        rand = new Random();

        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }

        total = prefix[w.length - 1];
    }

    public int pickIndex() {
        int r = rand.nextInt(total) + 1; // [1, total]

        int low = 0, high = prefix.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (prefix[mid] >= r) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}