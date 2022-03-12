package leetcode.week09;

/**
 * <pre>
 *
 *  Created by pingxin on 2022/2/27.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/27
 */
public class TrieNode<V> {
    V val = null;
    TrieNode<V>[] children = new TrieNode[256];
    public TrieNode(){}
    public TrieNode(V v){
        val = v;
    }
}
