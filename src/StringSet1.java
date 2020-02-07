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

    public static void main(String args[]){
        String input = "Ankit Kejriwal";
        System.out.println(reverseString(input));
        System.out.println(reverseWord(input));
        System.out.println(reverseWordPosition(input));
    }
}
