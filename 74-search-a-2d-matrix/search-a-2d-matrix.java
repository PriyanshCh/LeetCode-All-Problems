class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length, n=matrix[0].length;
        int left=0, right=m*n-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            int mid_value=matrix[mid/n][mid%n];

            if(mid_value==target){
                return true;
            } else if (mid_value<target) {
                left=mid+1;
            }else {
                right=mid-1;
            }

        }
        return false;
        // int n = matrix.length, m = matrix[0].length;

        // // traverse the matrix:
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         if (matrix[i][j]== target)
        //             return true;
        //     }
        // }
        // return false;
    }

}
