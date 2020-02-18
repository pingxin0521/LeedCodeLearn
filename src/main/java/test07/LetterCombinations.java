package test07;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test07
 * hyp create at 20-1-12
 **/
public class LetterCombinations {
    public String[] Lettermap = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        char number = digits.charAt(0);
        String letters = Lettermap[number - '0'];
        String cur = digits.substring(1,digits.length());


        List<String> res1 = letterCombinations(cur);
        if(res1.size() == 0){
            for(int i = 0;i < letters.length();i ++){
                String temp = "" + letters.charAt(i);
                res.add(temp);
            }
        }
        else{for(String thst : res1){
            for(int i = 0;i < letters.length();i ++){
                String temp = letters.charAt(i) + thst;
                res.add(temp);
            }
        }}

        return res;
    }
}
