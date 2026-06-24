class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; 

        int l = 0;
        int r = rows * cols-1;

        while(l <= r){
            int mid = l + (r - l) /2;

            int value = matrix[mid / cols][mid % cols];

            if(value == target){
                return true;
            }

            if(value<target){
                l = mid +1;
            }else{
                r = mid -1;
            }
        }
        return false;
    }
}




One line to remember
int value = matrix[mid / cols][mid % cols];
mid / cols → row
mid % cols → column

  This quetions is similar to Search in rotated sorted array but the only diff is it uses matrix of rows and cols.
