package leetcode.week10;

import java.util.Objects;

/**
 * <pre>
 *
 *  Created by pingxin on 2022/2/27.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/27
 */
public class Trie {
    private TrieNode<Boolean> root = new TrieNode<>();

    public Trie() {

    }

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (p.children[idx] == null) {
                p.children[idx] = new TrieNode();
            }
            p = p.children[idx];
        }
        p.val = true;
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if (p.children[idx] == null) {
                return null;
            }
            p = p.children[idx];
        }
        return p;
    }

    public boolean search(String word) {
        TrieNode p = searchPrefix(word);
        return p != null && Objects.equals(p.val, Boolean.TRUE);
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public static class TrieNode<V> {
        V val = null;
        TrieNode<V>[] children = new TrieNode[26];

        public TrieNode() {
        }

        public TrieNode(V v) {
            val = v;
        }
    }
}


