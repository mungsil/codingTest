class CountingSortSolution {

    public void sortColors(int[] nums) {
        int[] countArr = new int[3];
        for (int n : nums) {
            countArr[n]++;
        }

        int numSize = nums.length;
        int[] outputArr = new int[numSize];

        int color = 0;
        for (int i = 0; i < numSize; i++) {
            if (countArr[color] > 0) {
                outputArr[i] = color;
                countArr[color]--;
            } else {
                color++;
                i--; // 다음 루프에서 다시 시도
            }
        }

        // nums 배열에 결과를 복사
        for (int i = 0; i < numSize; i++) {
            nums[i] = outputArr[i];
        }
    }
}
