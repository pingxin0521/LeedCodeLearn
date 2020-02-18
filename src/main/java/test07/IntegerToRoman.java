package test07;

/**https://leetcode-cn.com/problems/integer-to-roman/
 *https://leetcode-cn.com/problems/roman-to-integer/
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class IntegerToRoman {

    public static void main(String[] args) {
        String s = intToRoman(2994);
        System.out.println(s);
        System.out.println(romanToInt(s));
    }
    public static String intToRoman(int num) {
        int[] number = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] numberStr = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            if(num>=number[i]){
                int count = num/number[i];
                for (int j = 0; j < count; j++) {
                    builder.append(numberStr[i]);
                    num-=number[i];
                }
            }
        }
        return builder.toString();
    }

    /**
     * 其实只要每次比较后一个和前一个的值的大小关系即可：
     *
     * 前值小于后值，减去前值
     * 前值大于或等于后值，加上前值
     * 最后一个值必然是加上的
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

}
