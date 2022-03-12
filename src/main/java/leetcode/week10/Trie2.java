package leetcode.week10;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <pre>
 *
 *  Created by pingxin on 2022/2/27.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/27
 */
public class Trie2 {

    private TrieNode<Integer> root = new TrieNode<>();

    public Trie2() {
    }

    public void insert(String word) {
        TrieNode<Integer> p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (p.children[idx] == null) {
                p.children[idx] = new TrieNode<>(0);
            }
            p = p.children[idx];
        }
        p.val++;
    }

    private TrieNode<Integer> searchPrefix(String prefix) {
        TrieNode<Integer> p = root;
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

    public int countWordsEqualTo(String word) {
        TrieNode<Integer> p = searchPrefix(word);
        return p == null || p.val == null ? 0 : p.val;
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode<Integer> p = searchPrefix(prefix);
        if (p == null) {
            return 0;
        }
        Queue<TrieNode<Integer>> queue = new LinkedList<>();
        queue.offer(p);
        int ans = 0;
        while (!queue.isEmpty()) {
            p = queue.poll();
            ans += p.val;
            for (TrieNode<Integer> node : p.children) {
                if (node != null) {
                    queue.offer(node);
                }
            }
        }
        return ans;
    }

    public void erase(String word) {
        TrieNode<Integer> p = searchPrefix(word);
        if (p != null && p.val > 0) {
            p.val--;
        }
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

