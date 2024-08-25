import java.util.Arrays;

public class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int pivot = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0,pivot));
        int[] right = sortArray(Arrays.copyOfRange(nums, pivot , nums.length));
        return merge(left, right);
    }

    public int[] merge(int[] leftSide , int[] rightSide){
        int[] result = new int[leftSide.length + rightSide.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        while (leftIndex < leftSide.length && rightIndex < rightSide.length) {
            if (leftSide[leftIndex] < rightSide[rightIndex]) {
                result[resultIndex++] = leftSide[leftIndex++];
            } else {
                result[resultIndex++] = rightSide[rightIndex++];
            }
        }
        while (leftIndex < leftSide.length) {
            result[resultIndex++] = leftSide[leftIndex++];
        }
        while (rightIndex < rightSide.length) {
            result[resultIndex++] = rightSide[rightIndex++];
        }
        return result;
    }
}