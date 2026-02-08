class Solution {
    public String fractionToDecimal(int n, int d) {
        if (n == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if ((n < 0) ^ (d < 0)) sb.append('-');

        long a = Math.abs((long) n), b = Math.abs((long) d);
        sb.append(a / b);

        long r = a % b;
        if (r == 0) return sb.toString();

        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();

        while (r != 0) {
            if (map.containsKey(r)) {
                sb.insert(map.get(r), "(");
                sb.append(")");
                break;
            }
            map.put(r, sb.length());
            r *= 10;
            sb.append(r / b);
            r %= b;
        }

        return sb.toString();
    }
}
