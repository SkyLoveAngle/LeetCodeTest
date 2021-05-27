package leetcode.editor.cn;

//给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，
//该指针可以指向链表中的任何节点或空节点。
//构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，
//其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random
//指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。 
//
//例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。
//那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random--> y 。
//返回复制链表的头节点。用一个由 n 个节点组成的链表来表示输入/输出中的链表。
//每个节点用一个 [val, random_index] 表示：
// val：一个表示 Node.val 的整数。 
// random_index：随机指针指向的节点索引（范围从 0 到 n-1）；
// 如果不指向任何节点，则为 null 。
//你的代码 只 接受原链表的头节点 head 作为传入参数。

// 示例 1：
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

// 示例 2：
//输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]

// 示例 3：
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]

// 示例 4：
//输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。

// 提示：
// 0 <= n <= 1000 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 
// Related Topics 哈希表 链表 
// 👍 529 👎 0

public class CopyListWithRandomPointer{
    public static void main(String[] args) {
        Solution solution = new CopyListWithRandomPointer().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /*方法一：
    首先不考虑random~~直接把旧链表拷贝一份~~保证next都是指向正确的（此时所有random都指向null）
    接下来考虑random过程，针对每个旧的节点，计算该节点的random指向位置相对于连表头结点的偏移。
    根据这个偏移，就可以让新的链表的对应的节点的random指向相同偏移的位置。
     */

    /*方法2：
   借助Map来维护我们新旧节点之间的关系！
    */
    public Node copyRandomList(Node head) {
        //先创建一个Map，key是旧的节点，value就是新的节点
        Map<Node, Node> map = new HashMap<>();
        // 遍历旧链表, 同时构造出旧节点对应的新节点, 插入到 Map 中
        for(Node cur = head; cur !=null;cur =cur.next) {
            map.put(cur, new Node(cur.val));
        }
        // 接下来把新链表的 next 给连接上
        // 再次遍历旧链表
        for(Node cur = head; cur !=null;cur =cur.next) {
            // 取出 cur 对应的新节点
            //map.get(cur).next = map.get(cur.next);
            // 该段代码拆分如下：
            Node curNew = map.get(cur);
            Node curNextNew = map.get(cur.next);
            curNew.next = curNextNew;

            map.get(cur).random = map.get(cur.random);
        }
        return map.get(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}