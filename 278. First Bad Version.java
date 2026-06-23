/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;  // starting version
        int r = n; //search ends at version n
        int ans = n;// stores the first current bad version found

        while(l<=r){
            int mid = l + (r - l) / 2; //middle version
            if(isBadVersion(mid)){
                ans = mid; //found a bad version
                r= mid-1; // search for an earlier bad version
            }else{
                l = mid+1;// first bad version must be on the right 
               
            }
        } 
        return ans; 
    }
}


** Just read the quetion for couple of times and ask yourself-
  What's the input 
  What's the output
  Is it sorted or needs to be sorted
  Do we need to check first number?
  DO we need to store the ans?

  From the problem statement-
  We need to find the first bad version
  and after that one, every versions are bad
  so we start the code from -

  int l(means left) = 1; because all versions are start from 1 not 0
  int r = n;  means the serch ends at first current bad version
  int ans = n; to store the first curr bad version

  And after thar we try to find the mid version as-
    while(l<=r){
            int mid = l + (r - l) / 2; //middle version

if find or not find-
   if(isBadVersion(mid)){
                ans = mid; //found a bad version
                r= mid-1; // search for an earlier bad version
            }else{
                l = mid+1;// first bad version must be on the right 
               
            }

  And then return ans.

    Thats all it is-

    BINARY SEARCH
    
  
