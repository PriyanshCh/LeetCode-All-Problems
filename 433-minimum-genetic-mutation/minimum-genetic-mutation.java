class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;

        Queue<String> q = new LinkedList<>();
        q.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(start);

        char[] genes = {'A','C','G','T'};
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String cur = q.poll();
                if (cur.equals(end)) return steps;

                char[] arr = cur.toCharArray();
                for (int i = 0; i < 8; i++) {
                    char old = arr[i];
                    for (char g : genes) {
                        if (g == old) continue;
                        arr[i] = g;
                        String next = new String(arr);
                        if (set.contains(next) && !visited.contains(next)) {
                            visited.add(next);
                            q.offer(next);
                        }
                    }
                    arr[i] = old;
                }
            }
            steps++;
        }

        return -1;
    }
}
