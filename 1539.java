class Solution {
    public int findKthPositive(int[] arr, int k) {
        if(k<arr[0]){
            return k;
        }
        int l = 1, r = arr.length-1, i = 1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int missing = arr[mid] - (mid+1);
            if(missing < k){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }return l+k;
    }
}
