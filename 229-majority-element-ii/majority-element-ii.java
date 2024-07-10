class Solution {
    public List<Integer> majorityElement(int[] v) {
        int n=v.length;
        List<Integer>ls=new ArrayList<>();

        HashMap<Integer,Integer>map=new HashMap<>();

        int mini=(int)(n/3)+1;

        for(int i=0; i<n; i++){
            int value=map.getOrDefault(v[i],0);
            map.put(v[i],value+1);

            if(map.get(v[i])==mini){
                ls.add(v[i]);
            }
            if(ls.size()==2){
                break;
            }
        }
        return ls;
    }
}