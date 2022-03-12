public class ConstructorExercise{
	public static void main(String[] args){
		Constructor A1 = new Constructor();
		System.out.println("姓名："+A1.name+" 年龄："+A1.age);
		Constructor A2 = new Constructor("王伟",50);
		System.out.println("姓名："+A2.name+" 年龄："+A2.age);

	}
}
class Constructor{
	int age;
	String name;
	public Constructor(){
		age =18;
	}
	public Constructor(String tname,int tage){
		name = tname;
		age = tage;
	}
}