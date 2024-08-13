package com.ygt.day3;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
 * 假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
 * 更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
 * 返回 k。
 * 用户评测：
 * 评测机将使用以下代码测试您的解决方案：
 * int[] nums = [...]; // 输入数组
 * int val = ...; // 要移除的值
 * int[] expectedNums = [...]; // 长度正确的预期答案。
 *                             // 它以不等于 val 的值排序。
 * int k = removeElement(nums, val); // 调用你的实现
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // 排序 nums 的前 k 个元素
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * 如果所有的断言都通过，你的解决方案将会 通过。
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3,_,_,_]
 * 解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
 * 注意这五个元素可以任意顺序返回。
 * 你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
 * @author ygt
 * @since 2024/8/13
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println("移除元素得到的答案：" + new RemoveElement().removeElement(nums, 2));
    }

    /*主要解题思路：需要掌握双指针*/
    public int removeElement(int[] nums, int val) {
        // 需要注意的一点是，"原地" 即在原数组上操作 --> 所以不能创建一个新数组
        //
        /*
            首先，实现的关键还是双指针，其次这道题跟前面一道题的区别：
            增加了一个val值，这道题跟顺序没大关系，只要是等于val的元素，就可以排除掉，而且返回的数组元素是无序。

            移动过程中，只要不是等于val值，s的替换为f的值。
                       比较，f继续移动，直到遇到val值        f开始移动，直到遇到不是val值，s替换后并移动
                一开始的数组       -->          移动后的数组        -->        移动后的数组
            [ 0,1,2,2,3,0,4,2]         [ 0,1,2,2,3,0,4,2]             [0,1,3,2,3,0,4,2]
              s                              s                               s   f
              f                              f
               一直移动，s不断替换，直到遇到2       但是到数组末尾了，不需要再替换了，结束
            -->     移动后的数组          -->     移动后的数组
              [0,1,3,0,4,0,4,2]                [0,1,3,0,4,0,4,2]
                       s     f                          s   f
         */
        int slow = 0, fast = 0;

        // fast只能移动到数组末尾处
        while (fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        // 可以看一下当前数组 --> 可以看到前面正常改成功了，slow后面的是不管的。
        //System.out.println(Arrays.toString(nums));

        // 最终长度就是slow的大小 --> 这里不需要加一了，因为slow有自动加一。
        return slow;
    }
}
