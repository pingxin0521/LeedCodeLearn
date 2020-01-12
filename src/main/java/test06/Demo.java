package test06;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Vector;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test06
 * hyp create at 19-11-5
 **/
public class Demo {
    public static void main(String[] args) {

        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        ListIterator<Integer> listIterator =
                vector.listIterator(vector.size());
        while (listIterator.hasNext()) {
//            listIterator.set(listIterator.next()+1);
            listIterator.previous();
            listIterator.add(listIterator.previousIndex());

        }
        System.out.println(vector);
    }

}


