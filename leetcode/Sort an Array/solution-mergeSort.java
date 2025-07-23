class Solution {
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1){
            return nums;
        }

        int mid = nums.length/2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, nums.length);

        return sort(nums, sortArray(left), sortArray(right));
    }

    private int[] sort(int[] origin, int[] left, int[] right){
        int op = 0;
        int lp=0;
        int rp = 0;

        while(lp < left.length && rp < right.length){
            if(left[lp] < right[rp]){
                origin[op++] = left[lp++];
            } else{
                origin[op++] = right[rp++];
            }
        }

        while(lp < left.length) {
            origin[op++] = left[lp++];
        }

        while(rp < right.length) {
            origin[op++] = right[rp++];
        }

        return origin;
    }
}
