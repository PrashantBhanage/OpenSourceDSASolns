class Solution {
    public int search(int[] nums, int target) {
        int l  = 0;
        int r  = nums.length-1;
        

        while(l <= r){
            int mid = l + (r-l)/2;

            if(nums[mid] == target){
                return mid;
            }
            //left half is sorted
            if(nums[l]<=nums[mid]){ 
                //target is on the left half
                if(nums[l]<= target && target <= nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid +1;
                }
            }
            // right half is also sorted
            else{
                //Target is on the right half
                if(nums[mid]< target && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid -1;
                }
            }
        }
        return -1;
    } 
}



The optimal soln of this one is above and its uses binary search 

  The array is already is sorted

  The core logic of this problem->

  1. Find Mid

  2. Is left half is sorted?
    nums[l] <= nums[mid]

  YES
    Is target inside left half?
    nums[i] <= target<nums[mid]
    YES --> GO LEFT
    NO --> GO RIGHT

  3. Otherwise right half is sorted
    Is target inside right half?
    nums[mid] <target <=nums[r]

    YES --> GO RIGHT
    NO --> GO LEFT
