package test08;

import java.util.BitSet;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test08
 * hyp create at 20-2-28
 **/
public class ArrayIntersection {
    public static void main(String[] args) {

        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] b = new int[]{5, 6, 7, 8, 9, 10};

        BitSet bs1 = new BitSet();
        BitSet bs2 = new BitSet();

        for (int i : a) {
            bs1.set(i);
        }
        for (int i : b) {
            bs2.set(i);
        }
        System.out.println(bs1);
        //交集
        bs1.and(bs2);
        System.out.println(bs1);
        //或集
        bs1.or(bs2);
        System.out.println(bs1);
        //差集
        bs1.andNot(bs2);
        System.out.println(bs1);
        //
        bs1.intersects(bs2);

        System.out.println(bs1);

    }

    public static int getUnsignedByte(byte data) {
        //将data字节型数据转换为0~255 (0xFF 即BYTE)。
        return data & 0x0FF;
    }

    public static int getUnsignedShort(short data) {
        return data & 0xFFFF;
    }


    public static long getUnsignedInt(int data) {
        return data & 0xFFFFFF;
    }

}
