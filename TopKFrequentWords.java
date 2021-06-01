package leetcode.editor.cn;

//给一非空的单词列表，返回前 k 个出现次数最多的单词。
//返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。

// 示例 1：
//输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
//输出: ["i", "love"]
//解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
//注意，按字母顺序 "i" 在 "love" 之前。

// 示例 2：
//输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k= 4
//输出: ["the", "is", "sunny", "day"]
//解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
//出现次数依次为 4, 3, 2 和 1 次。

// 注意：
// 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。 
// 输入的单词均由小写字母组成。
// 扩展练习：
// 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
// Related Topics 堆 字典树 哈希表 
// 👍 226 👎 0

public class TopKFrequentWords{
    public static void main(String[] args) {
        Solution solution = new TopKFrequentWords().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // 1. 使用 map 统计 words 中每个单词出现的次数
        Map<String, Integer> map = new HashMap<>();
        for (String x : words) {
            Integer value = map.getOrDefault(x, 0);
            map.put(x, value + 1);
        }

        // 2. 把所有的 key 都取出来, 放到一个 List 中
        List<String> wordList = new ArrayList<>(map.keySet());

        // 3. 把 wordList 进行排序, 需要在 sort 的第二个参数中
        // 传入一个 Comparator 比较器对象, 用来指定比较规则
        /*
        此处创建一个匿名内部类，并且创建了该类的实例，这个内部类的类名我们不清楚，
        但是知道这个类实现Comparator接口~ ~ { } 里面的内容就是该匿名内部类的实现！
         */
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // Java 的匿名内部类, 能够自动捕获到外部的变量
                Integer count1 = map.get(o1);
                Integer count2 = map.get(o2);
                if (count1.equals(count2)) {
                    // 出现次数相同, 就按照字符串的字典序来排列
                    return o1.compareTo(o2);
                }
                // 不要背!!! 试试就知道了
                return count2 - count1;
            }
        });

        return wordList.subList(0, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}