public class homeDog{
	public static void main(String[] args){
		dog A = new dog("小花",18,"黑白相间");
		A.show();
	}
}
class dog{
	String name;
	int age;
	String colour;
	public dog(String name,int age,String colour){
		this.name = name;
		this.age = age ;
		this.colour = colour;
	}
	public void show(){
		System.out.println("这只狗的信息如下");
		System.out.println("姓名："+name);
		System.out.println("年龄："+age);
		System.out.println("颜色："+colour);

	}
}