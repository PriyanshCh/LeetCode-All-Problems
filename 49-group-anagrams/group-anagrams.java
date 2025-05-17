class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        Map<String,List<String>>map=new HashMap<>();

        for(String s:arr){
            char[]chars=s.toCharArray();
            Arrays.sort(chars);
            String sorted=new String(chars);

            map.putIfAbsent(sorted,new ArrayList<>());
            map.get(sorted).add(s);
            
        }
        List<List<String>>res=new ArrayList<>();

        for(List<String>gp:map.values()){
            res.add(new ArrayList<>(gp));
        }
        return res;
    }
}