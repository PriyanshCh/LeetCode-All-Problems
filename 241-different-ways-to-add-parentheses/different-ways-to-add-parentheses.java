class Solution {
    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String exp) {
        if (memo.containsKey(exp))
            return memo.get(exp);

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(exp.substring(0, i));
                List<Integer> right = diffWaysToCompute(exp.substring(i + 1));

                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') res.add(a + b);
                        else if (c == '-') res.add(a - b);
                        else res.add(a * b);
                    }
                }
            }
        }

        if (res.isEmpty())
            res.add(Integer.parseInt(exp));

        memo.put(exp, res);
        return res;
    }
}
