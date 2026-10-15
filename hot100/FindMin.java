import java.util.Arrays;

public class FindMin {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left < right) { // 区间至少两个元素就继续二分
            mid = (left + right) / 2; // 中点下标

            // 核心判断
            if(nums[mid] > nums[right]) {
                // 中点值 > 最右侧值：最小值一定在 mid 右边
                // 例 [3,4,5,1,2] mid=2(5) > right=4(2)，最小在右边
                left = mid + 1;
            } else {
                // 中点值 <= 最右侧值：最小值在 mid 及左边区间
                // 不能写 right=mid-1，会漏掉mid本身就是最小值的情况
                right = mid;
            }
        }
        // 循环结束 left=right，指向最小值
        return nums[left];
    }
}
