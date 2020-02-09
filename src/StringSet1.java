import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Stack;

public class StringSet1 {

    private static String reverseString(String s) {
        StringBuilder str = new  StringBuilder(s);
        int low  = 0;
        int high = str.length()-1;
        while (low<=high){
            char temp = str.charAt(low);
            str.setCharAt(low,str.charAt(high));
            str.setCharAt(high,temp);
            low++;
            high--;
        }
        return str.toString();
    }

    private static String reverseWord(String s){
        String[] str = s.split(" ");
        for(int i =0;i<str.length;i++){
            str[i] = reverseString(str[i]);
        }
        return String.join(" ",str);
    }

    private static String reverseWordPosition(String s) {
        String[] str = s.split(" ");
        int low = 0;
        int high =  str.length-1;
        while (low<=high){
            String temp = str[low];
            str[low] = str[high];
            str[high] = temp;
            low++;
            high--;
        }
        return String.join(" ",str);
    }

    private static String removeSpace(String s){
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<str.length;i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }

//    private static String largestSubStr(String s){
//        int count = 0;
//        int strt =0,end =0;
//        for(int i =0;i<s.length();i++){
//            boolean[] arr = new boolean[26];
//            while ()
//        }
//    }
    private static boolean validateParanthesis(String s){
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                stack.push(s.charAt(i));
            if(s.charAt(i) == ')'){
                if(stack.isEmpty())
                    return false;
                char tmp = stack.pop();
                if(tmp != '(')
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        else return false;
    }

    private static int reversePolish(String s) {
        if(s.length() ==1){
            return Integer.parseInt(s);
        }
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) >='0' && s.charAt(i) <='9'){
                stack.push(s.charAt(i) - '0');
            }
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();
                char c = s.charAt(i);
                switch (c){
                    case '+':
                        stack.push(val1+val2);
                        break;
                    case '-':
                        stack.push(val2-val1);
                        break;
                    case '*':
                        stack.push(val2*val1);
                        break;
                    case '/':
                        stack.push(val2/val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    private static Character firstNonRepeating(String s){
        if(s.length() ==1) {
            return s.charAt(0);
        }
        int[] arr = new int[26];
        for(int i =0;i<26;i++){
            arr[i] =-1;
        }
        for(int i=0;i<s.length();i++){
            int pos = s.charAt(i) - 'A';
            if(arr[pos] !=-1){
                arr[pos]+= 1 ;
            } else {
                arr[pos]= 1 ;
            }
        }
        for(int i=0;i<26;i++){
            if(arr[i] ==1){
                return (char)(i+65);
            }
        }
        return null;
    }

    public static void main(String args[]){
        String input = "My name is Ankit Kejriwal";
        System.out.println(reverseString(input));
        System.out.println(reverseWord(input));
        System.out.println(reverseWordPosition(input));
        System.out.println(removeSpace(input));
        System.out.println(validateParanthesis("((BCD)AE)"));
        System.out.println(validateParanthesis(")(PH)N(X)"));
        System.out.println(reversePolish("512+4*+3-"));
        System.out.println(firstNonRepeating("ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB"));
    }
}
