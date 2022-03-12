package leetcode.week09;

import java.util.*;

/**
 * <pre>
 *
 *  Created by pingxin on 2022/2/27.
 * </pre>
 *
 * @author pingxin
 * @date 2022/2/27
 */
class RandomizedCollection {
    HashMap<Integer, Set<Integer>> valToIdxs = new HashMap<>();
    List<Integer> vals = new ArrayList<>();
    Random random = new Random();

    public RandomizedCollection() {
    }

    public boolean insert(int val) {
        Set<Integer> idxs = valToIdxs.getOrDefault(val, new HashSet<>());
        idxs.add(vals.size());
        vals.add(val);
        valToIdxs.put(val,idxs);
        return idxs.size() == 1;
    }

    public boolean remove(int val) {
        if(!valToIdxs.containsKey(val)){
            return false;
        }
        Set<Integer> idxs = valToIdxs.getOrDefault(val, new HashSet<>());
        Iterator<Integer> iterator = idxs.iterator();
        Integer idx = iterator.next();

        int lastIdx = vals.size() - 1;
        int lastElement = vals.get(lastIdx);

        // 删除数组值
        vals.set(idx, lastElement);
        vals.remove(lastIdx);

        // 删除旧值的下标
        idxs.remove(idx);
        if (idxs.isEmpty()) {
            valToIdxs.remove(val);
        }
        //更新最后一个值的下标
        Set<Integer> idxs2 = valToIdxs.getOrDefault(lastElement, new HashSet<>());
        idxs2.remove(lastIdx);
        if(idx<lastIdx){
            valToIdxs.get(lastElement).add(idx);
        }
        return true;
    }

    public int getRandom() {
        return vals.get(random.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
