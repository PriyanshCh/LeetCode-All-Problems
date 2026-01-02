class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> minCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < profits.length; i++)
            minCap.offer(new int[]{capital[i], profits[i]});

        while (k-- > 0) {
            while (!minCap.isEmpty() && minCap.peek()[0] <= w)
                maxProfit.offer(minCap.poll()[1]);

            if (maxProfit.isEmpty()) break;
            w += maxProfit.poll();
        }

        return w;
    }
}
