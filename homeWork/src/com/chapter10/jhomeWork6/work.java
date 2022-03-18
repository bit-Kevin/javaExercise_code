package com.chapter10.jhomeWork6;

public class work {
    public static void main(String[] args) {
        Color color = Color.GREEN;
        switch (color){
            case RED:
                color.show();
                break;
            case BLACK:
                color.show();
            default:
                System.out.println("未找到");
        }
    }
}
enum Color{
    RED(255,0,0),BLUE(0,0,255),
    BLACK(0,0,0),YELLOW(255,255,0),
    GREEN(0,255,0);

    private int redValue;
    private int greenValue;
    private int  blueValue;

    Color(int redValue, int greenValue, int blueValue) {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }
    public void show(){
        System.out.println(redValue+","+greenValue+","+blueValue);
    }
}
