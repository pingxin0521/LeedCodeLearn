package leetcode.week09;

import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *
 *  Created by pingxin on 2022/2/27.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/27
 */
public class TrieMapImpl<V> implements TrieMap<V> {
    // ASCII 码个数
    private static final int R = 256;
    // 当前存在 Map 中的键值对个数
    private int size = 0;

    // Trie 树的根节点
    private TrieNode<V> root = new TrieNode<>();

    // 从节点 node 开始搜索 key，如果存在返回对应节点，否则返回 null
    private TrieNode<V> getNode(TrieNode<V> node, String key) {
        TrieNode<V> p = node;
        // 从节点 node 开始搜索 key
        for (int i = 0; i < key.length(); i++) {
            if (p == null) {
                return null;
            }
            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;
    }

    @Override
    public void put(String key, V val) {
        if (!containsKey(key)) {
            size++;
        }
        // 需要一个额外的辅助函数，并接收其返回值
        root = put(root, key, val, 0);
    }

    // 定义：向以 node 为根的 Trie 树中插入 key[i..]，返回插入完成后的根节点
    private TrieNode<V> put(TrieNode<V> x, String key, V val, int i) {
        if (x == null) {
            // 如果树枝不存在，新建
            x = new TrieNode<>();
        }
        if (i == key.length()) {
            // key 的路径已插入完成，将值 val 存入节点
            x.val = val;
            return x;
        }
        char c = key.charAt(i);
        // 递归插入子节点，并接收返回值
        x.children[c] = put(x.children[c], key, val, i + 1);
        return x;
    }

    @Override
    public void remove(String key) {
        if (!containsKey(key)){
            return;
        }
        root = remove(root,key,0);
        size--;
    }
    // 定义：在以 node 为根的 Trie 树中删除 key[i..]，返回删除后的根节点
    private TrieNode<V> remove(TrieNode<V> x,String key,int i){
        if(x==null){
            return null;
        }
        if(i==key.length()){
            // 找到了 key 对应的 TrieNode，删除 val
            x.val = null;
        } else {
            char c = key.charAt(i);
            x.children[c] = remove(x.children[c],key,i+1);
        }
        // 后序位置，递归路径上的节点可能需要被清理
        if (x.val != null) {
            // 如果该 TireNode 存储着 val，不需要被清理
            return x;
        }
        // 检查该 TrieNode 是否还有后缀
        for (char c = 0; c < R; c++) {
            if(x.children[c]!=null){
                // 只要存在一个子节点（后缀树枝），就不需要被清理
                return x;
            }
        }
        // 既没有存储 val，也没有后缀树枝，则该节点需要被清理
        return null;
    }

    @Override
    public V get(String key) {
        TrieNode<V> x = getNode(root, key);
        if (x == null || x.val == null) {
            return null;
        }
        return x.val;
    }

    @Override
    public boolean containsKey(String key) {
        TrieNode<V> x = getNode(root, key);
        return x != null && x.val != null;
    }

    // 在所有键中寻找 query 的最短前缀
    @Override
    public String shortestPrefixOf(String query) {
        // 从节点 node 开始搜索 key
        TrieNode<V> p = root;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                // 无法向下搜索
                return "";
            }
            if (p.val != null) {
                // 找到一个键是 query 的前缀
                return query.substring(0, i);
            }
            // 向下搜索
            char c = query.charAt(i);
            p = p.children[c];
        }
        if (p != null && p.val != null) {
            // 如果 query 本身就是一个键
            return query;
        }
        return "";
    }

    @Override
    public String longestPrefixOf(String query) {
        // 从节点 node 开始搜索 key
        TrieNode<V> p = root;
        int maxLen = 0;
        for (int i = 0; i < query.length(); i++) {
            if (p == null) {
                // 无法向下搜索
                break;
            }
            if (p.val != null) {
                // 找到一个键是 query 的前缀，更新前缀的最大长度
                maxLen = i;
            }
            // 向下搜索
            char c = query.charAt(i);
            p = p.children[c];
        }
        if (p != null && p.val != null) {
            // 如果 query 本身就是一个键
            return query;
        }
        return query.substring(0, maxLen);
    }

    // 搜索前缀为 prefix 的所有键
    @Override
    public List<String> keysWithPrefix(String prefix) {
        LinkedList<String> res = new LinkedList<>();
        // 找到匹配 prefix 在 Trie 树中的那个节点
        TrieNode<V> x = getNode(root, prefix);
        if (x == null) {
            return res;
        }
        // DFS 遍历以 x 为根的这棵 Trie 树
        dfs(x, new StringBuilder(prefix), res);
        return res;
    }

    // 遍历以 node 节点为根的 Trie 树，找到所有键
    private void dfs(TrieNode<V> x, StringBuilder path, LinkedList<String> res) {
        // 到达 Trie 树底部叶子结点
        if (x == null) {
            return;
        }
        if (x.val != null) {
            // 找到一个 key，添加到结果列表中
            res.add(path.toString());
        }
        // 回溯算法遍历框架
        for (char c = 0; c < R; c++) {
            if (x.children[c] != null) {
                path.append(c);
                dfs(x.children[c], path, res);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    @Override
    public boolean hasKeyWithPrefix(String prefix) {
        return getNode(root, prefix) != null;
    }

    @Override
    public List<String> keysWithPattern(String pattern) {
        List<String> res = new LinkedList<>();
        dfs(root, new StringBuilder(), pattern, 0, res);
        return res;
    }

    private void dfs(TrieNode<V> x, StringBuilder path,
                     String pattern, int i, List<String> res) {
        // 树枝不存在，即字符 pattern[i-1] 匹配失败
        if (x == null) {
            return;
        }
        if (i == pattern.length()) {
            // pattern 匹配完成
            if (x.val != null) {
                // 如果这个节点存储着 val，则找到一个匹配的键
                res.add(path.toString());
            }
            return;
        }
        char c = pattern.charAt(i);
        if (c == '.') {
            // pattern[i] 是通配符，可以变化成任意字符
            // 多叉树（回溯算法）遍历框架
            for (char j = 0; j < R; j++) {
                if (x.children[j] != null) {
                    path.append(j);
                    dfs(x, path, pattern, i + 1, res);
                    path.deleteCharAt(path.length() - 1);
                }
            }
        } else {
            // pattern[i] 是普通字符 c
            if (x.children[c] != null) {
                path.append(c);
                dfs(x.children[c], path, pattern, i + 1, res);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    // 判断是和否存在前缀为 prefix 的键
    @Override
    public boolean hasKeyWithPattern(String pattern) {
        // 从 root 节点开始匹配 pattern[0..]
        return dfs(root, pattern, 0);
    }

    // 函数定义：从 node 节点开始匹配 pattern[i..]，返回是否成功匹配
    private boolean dfs(TrieNode<V> x, String pattern, int i) {
        if (x == null) {
            return false;
        }
        if (i == pattern.length()) {
            // 模式串走到头了，看看匹配到的是否是一个键
            return x.val != null;
        }
        char c = pattern.charAt(i);
        // 没有遇到通配符
        if (c != '.') {
            // 从 node.children[c] 节点开始匹配 pattern[i+1..]
            return dfs(x.children[c], pattern, i + 1);
        }
        // pattern[i] 是通配符，可以变化成任意字符
        // 多叉树（回溯算法）遍历框架
        for (char j = 0; j < R; j++) {
            if (x.children[j] != null) {
                // pattern[i] 可以变化成任意字符，尝试所有可能，只要遇到一个匹配成功就返回
                if (dfs(x.children[j], pattern, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
