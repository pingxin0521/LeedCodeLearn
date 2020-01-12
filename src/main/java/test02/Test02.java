package test02;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author hyp
 * Project name is LeedCodeLearn
 * Include in test02
 * hyp create at 19-10-17
 **/
public class Test02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(operate(line));
        }

    }

    public static int operate(String s) {
        if (s == null || "".equals(s)) {
            return 1;
        }
        int code = 1;
        Stack<Character> stack = new Stack<Character>();
        char[] array = s.toCharArray();
        for (char c : array) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                case '<':
                    stack.push(c);
                    break;
                case '}':
                    if (stack.empty()||stack.peek() != '{') {
                        code = 0;
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.empty()||stack.peek() != '[') {
                        code = 0;
                    } else {
                        stack.pop();
                    }
                    break;
                case ')':
                    if (stack.empty()||stack.peek() != '(') {
                        code = 0;
                    } else {
                        stack.pop();
                    }
                    break;
                case '>':
                    if (stack.empty()||stack.peek() != '<') {
                        code = 0;
                    } else {
                        stack.pop();
                    }
                    break;
                default:
                    break;
            }
            if (code == 0) {
                break;
            }

        }

        return code;
    }
}
