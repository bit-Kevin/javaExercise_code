package com.chapter13.Exercise2;

public class charTurn {
    public static void main(String[] args) {
        String s = new String("abcdefg");
        try {
            s =reverse(s,2,8);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public static String reverse(String str,int start,int end){
        if (!(str!=null&&start>0&&end<=str.length()&&end>start)){
            throw new RuntimeException("参数不正确");
        }
         char [] cs = str.toCharArray();
         char temp;
         for (int i=start-1,j=end-1;i<j;i++,j--){
             temp = cs[i];
             cs[i]= cs[j];
             cs[j]= temp;
         }
         return new String(cs);
    }
}
