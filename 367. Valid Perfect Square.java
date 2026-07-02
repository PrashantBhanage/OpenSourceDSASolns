The is asking to return true if the sqrt of number is integer otherwise return false.

  class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long h = num;

        while(l<=h){
            long mid =  (l+h)>>1;

            if(mid*mid == num){
                return true;
            }else if(mid*mid <num){
                l = (int) mid+1;
            }else{
                h = (int) mid-1;
            }
        }
        return false;
    }
}
