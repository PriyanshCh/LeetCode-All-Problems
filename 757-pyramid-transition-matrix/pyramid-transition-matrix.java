class Solution {
    int[][] mask=new int[7][7];
    public boolean pyramidTransition(String bottom,List<String> allowed){
        for(String s:allowed){
            int a=s.charAt(0)-'A';
            int b=s.charAt(1)-'A';
            int c=s.charAt(2)-'A';
            mask[a][b]|=1<<c;
        }
        return dfs(bottom.toCharArray(),new char[bottom.length()-1],0);
    }
    private boolean dfs(char[] cur,char[] next,int idx){
        if(cur.length==1) return true;
        if(idx==cur.length-1) return dfs(next,new char[next.length-1],0);
        int a=cur[idx]-'A',b=cur[idx+1]-'A';
        int m=mask[a][b];
        while(m>0){
            int bit=m&-m;
            int c=Integer.numberOfTrailingZeros(bit);
            next[idx]=(char)('A'+c);
            if(dfs(cur,next,idx+1)) return true;
            m-=bit;
        }
        return false;
    }
}