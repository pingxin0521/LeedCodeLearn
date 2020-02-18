package test01;

import java.util.*;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test01
 * hyp create at 19-8-25
 **/
public class Test01 {
    public static void main(String [] args)
    {
//        int num=100;
//        int x=num+2;
//        System.out.println(x);
//        int num=50;
//        num=num++*2;
//        System.out.println(num);
//        System.out.println((char) 68);

        HashMap<Integer,String> map=new HashMap<>();
        int i=100;
        for (int j = 0; j < i; j++) {
            map.put(j,""+j);
        }
        //更改
        Set<Integer> keySet =
                map.keySet();
//        keySet.add("str101");
        System.out.println(keySet.remove(1));

        Deque<Object> deque=new LinkedList<Object>();
        Queue<Object> queue=new LinkedList<>();
        List<Object> list=new LinkedList<>();
        Collection<Object> collection=new LinkedHashSet<>();



    }
}
