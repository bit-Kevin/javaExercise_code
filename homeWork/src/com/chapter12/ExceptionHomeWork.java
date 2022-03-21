package com.chapter12;

public class ExceptionHomeWork {
    public static void main(String[] args) {

        try{
            if (args.length!= 2){
                throw new ArrayIndexOutOfBoundsException("元素个数不对");
            }
            int temp1 = Integer.parseInt(args[0]);
            int temp2 = Integer.parseInt(args[1]);
            double n= math(temp1,temp2);
            System.out.println(n);
        }catch(NumberFormatException e){
            System.out.println("参数格式不对");
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }catch (ArithmeticException e){
            System.out.println("出现了除0的情况");
        }
    }

    public static double math(int i ,int j){
        return i/j;
    }
}
