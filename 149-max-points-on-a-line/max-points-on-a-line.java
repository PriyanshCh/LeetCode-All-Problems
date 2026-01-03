class Solution {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int ans = 0;

        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> map = new HashMap<>();
            int same = 1, max = 0;

            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    same++;
                } else {
                    int g = gcd(dx, dy);
                    dx /= g;
                    dy /= g;
                    String key = dx + ":" + dy;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                    max = Math.max(max, map.get(key));
                }
            }

            ans = Math.max(ans, max + same);
        }

        return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
