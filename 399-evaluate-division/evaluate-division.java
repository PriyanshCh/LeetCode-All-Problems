class Solution {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            if (!graph.containsKey(c) || !graph.containsKey(d)) res[i] = -1.0;
            else if (c.equals(d)) res[i] = 1.0;
            else res[i] = dfs(c, d, new HashSet<>(), 1.0);
        }
        return res;
    }

    private double dfs(String cur, String target, Set<String> visited, double val) {
        if (cur.equals(target)) return val;
        visited.add(cur);

        for (String nei : graph.get(cur).keySet()) {
            if (!visited.contains(nei)) {
                double res = dfs(nei, target, visited, val * graph.get(cur).get(nei));
                if (res != -1.0) return res;
            }
        }
        return -1.0;
    }
}
