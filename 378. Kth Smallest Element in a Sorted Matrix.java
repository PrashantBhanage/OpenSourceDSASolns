Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5


  class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int h = matrix[n-1][n-1];
        int l = matrix[0][0];
        while(l<h){
            int mid = l+(h-l)/2;

            int count = countLessEqual(matrix,mid);
            if(count<k){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        return l;
    }

    private int countLessEqual(int matrix[][], int target){
        int n = matrix.length;

        int row = n-1; //start from bottom left
        int col  = 0;
        int count = 0;

        while(row>=0 && col<n){
            if(matrix[row][col]<=target){
                //means all elements above this are <= target
                count += row+1;
                col++; //move right
            }else{
                row--; //move up
            }
        }
        return count;
    }
}



Accepted
87 / 87 testcases passed
Time taken: 30m 13s
Prashant Bhanage
submitted at Jun 30, 2026 08:48


Runtime
0
ms
Beats
100.00%
