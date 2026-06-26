int l = 0;
int r = nums.length-1;
int i = 0;

while(l<r){
int mid = l + (r-l) /2;
if(nums[mid]> nums[mid+1]){
r = mid;
}else{
  l = mid+1;
}
}
return -1;


