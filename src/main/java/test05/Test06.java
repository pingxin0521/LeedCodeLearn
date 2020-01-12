package test05;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test05
 * hyp create at 19-11-8
 **/
public class Test06 {
    public static void  main(String [] args)
    {
        System.out.println(reversion(123456));
        String s = String.valueOf(123456);

    }

    public static int reversion(int num){

        int result =0;
        int tmp=num;
        while (tmp!=0)
        {
            result=10*result+(tmp%10);
            tmp=tmp/10;
        }
        return result;
    }
}
