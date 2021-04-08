package leetcode.editor.cn;

//将两个升序链表合并为一个新的 升序 链表并返回。
// 新链表是通过拼接给定的两个链表的所有节点组成的。

// 示例 1：
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
//
// 示例 2：
//输入：l1 = [], l2 = []
//输出：[]
//
// 示例 3：
//输入：l1 = [], l2 = [0]
//输出：[0]

// 提示：
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1530 👎 0

public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        方法1:不带傀儡节点
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //这就包含了两种链表都为null的情况
        //两个链表都非空，则进行合并
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        //创建一个新的链表，用来保存最终结果。
        ListNode newHead = null;
        //后续需要频繁的进行尾插，为了尾插方便，使用一个变量把链表的尾部给记录下来。
        ListNode newTail = null;

        //通过循环遍历两个链表，并比较。任意引用到达链表末尾，都算循环结束。
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                //此时就把cur1插入新链表的尾部
                if (newTail == null) {
                    //针对空链表插入
                    newHead = cur1;
                    newTail = newHead;
                } else {
                    //针对非空链表插入
                    newTail.next = cur1;
                    newTail = newTail.next;
                }
            } else {
                //把cur2插入到新链表末尾
                if (newTail == null) {
                    //针对空链表插入
                    newHead = cur2;
                    newTail = newHead;
                } else {
                    //针对非空链表插入
                    newTail.next = cur2;
                    newTail = newTail.next;
                }
            }
        }
        return newHead;
        */

        //方法2，带傀儡节点
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 两个链表都非空, 进行合并.
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        // 创建了一个新的链表, 用来保存最终结果.
        // 为了简化后续的插入操作, 此处使用一个 带傀儡节点 的链表.
        ListNode newHead = new ListNode(0);
        // 后续需要频繁进行尾插. 为了尾插方便, 使用一个变量把链表的尾部给记录下来.
        // 虽然链表一般都是用头结点来表示, 但是也是完全可以通过其他引用记录其他位置. 典型的就是记录尾节点.
        ListNode newTail = newHead;
        // 进行循环遍历两个链表, 并比较. 任意引用到达链表末尾, 都算循环结束.
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                // 就把 cur1 插入到新链表末尾
                newTail.next = cur1;
                // 更新循环变量
                cur1 = cur1.next;
            } else {
                // 就把 cur2 插入到新链表末尾
                newTail.next = cur2;
                // 更新循环变量
                cur2 = cur2.next;
            }
            newTail = newTail.next;
        }
        // 当上述循环结束, 意味着一定有一个引用已经先到达了链表末尾.
        // 于是就把另一个链表的剩余部分插入过来即可.
        if (cur1 == null) {
            newTail.next = cur2;
        } else {
            newTail.next = cur1;
        }
        // 返回结果链表. 此时我们需要把傀儡节点跳过.
        return newHead.next;
    }
}



























































































































































































































































































































































































































































































































































































































































































































































































































































    }
}
//leetcode submit region end(Prohibit modification and deletion)

}