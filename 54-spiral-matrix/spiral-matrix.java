class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        ArrayList<Integer>res=new ArrayList<>();

        int rows=mat.length;
        int cols=mat[0].length;

        int startRow=0, endRow=rows-1;
        int startCol=0, endCol=cols-1;

        while(startRow <= endRow  && startCol <= endCol){
            for(int i=startCol; i<=endCol; i++){
                res.add(mat[startRow][i]);
            }
            startRow++;

            for(int i=startRow; i<=endRow; i++){
                res.add(mat[i][endCol]);
            }
            endCol--;

            if(startRow<=endRow){
                for(int i=endCol; i>=startCol; i--){
                    res.add(mat[endRow][i]);
                }
                endRow--;
            }

            if(startCol<=endCol){
                for(int i=endRow; i>=startRow; i--){
                    res.add(mat[i][startCol]);
                }
                startCol++;
            }
        }
        return res;
    }
}