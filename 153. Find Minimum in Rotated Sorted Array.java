class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
       

        while(l<r){
            int mid = l + (r-l)/2;

            if(nums[mid] > nums[r]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return nums[l];
    } 
}



**Here we need to return the smallest integer

  So here we check
  if(nums[mid] > nums[r]{
  l = mid+1;
  else
    r= mid;

