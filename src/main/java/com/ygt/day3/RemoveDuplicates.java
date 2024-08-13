package com.ygt.day3;

/**
 * 26. 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * 判题标准:
 * 系统会用下面的代码来测试你的题解:
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * int k = removeDuplicates(nums); // 调用
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * @author ygt
 * @since 2024/8/13
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println("删除有序数组中的重复项的答案：" + new RemoveDuplicates().removeDuplicates(nums));
    }

    /*主要解题思路：需要掌握双指针*/
    public int removeDuplicates(int[] nums) {
        // 需要注意的一点是，"原地" 即在原数组上操作 --> 所以不能创建一个新数组
        /*
            这道题的思路：在于双指针的使用，顾名思义，需要两个指针，通过两个指针不断比较，移动指针实现目的。
            定义两个指针：fast：快指针 slow：慢指针
                     开始比较，发现0=0 ，并且f向前移动  第二次开始比较，0!=1，s移动一位，并替换为1
                一开始的数组       -->          移动后的数组        -->        移动后的数组
            [ 0, 0, 1, 1, 2, 3]         [ 0, 0, 1, 1, 2, 3]             [ 0, 1, 1, 1, 2, 3]
              s  f                        s     f                            s  f
            第三次开始比较，f一直移动到2处，1!=2，s移动一位，并替换为2     第四次开始比较，f移动到3处，2!=3，s移动一位，并替换为3
            -->     移动后的数组          -->     移动后的数组             -->     移动后的数组
              [ 0, 1, 1, 1, 2, 3]                [ 0, 1, 2, 1, 2, 3]        [ 0, 1, 2, 3, 2, 3]
                   s        f                            s     f                       s     f
             最后f到达数组末尾，结束

         */
        int slow = 0, fast = 1;

        // fast只能移动到数组末尾处
        while (fast < nums.length) {
            if(nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }

        // 可以看一下当前数组 --> 可以看到前面正常改成功了，slow后面的是不管的。
        //System.out.println(Arrays.toString(nums));

        // 最终长度就是slow+1的大小
        return slow+1;
    }
}
