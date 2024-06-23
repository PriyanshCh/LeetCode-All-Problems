class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=i; j<matrix[0].length; j++){
                swap(matrix,i,j);
            }
        }
        for(int i=0; i<matrix.length; i++){
            reverse(matrix[i]);
        }
    }
    public static void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }

    public static void reverse(int[] row){
        int start = 0;
        int end = row.length - 1;
        while(start < end){
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }
}