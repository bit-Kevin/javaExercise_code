public class ConstructorExercise{
	public static void main(String[] args){
		Constructor A1 = new Constructor();
		System.out.println("������"+A1.name+" ���䣺"+A1.age);
		Constructor A2 = new Constructor("��ΰ",50);
		System.out.println("������"+A2.name+" ���䣺"+A2.age);

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