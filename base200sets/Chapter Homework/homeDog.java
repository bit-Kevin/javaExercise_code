public class homeDog{
	public static void main(String[] args){
		dog A = new dog("С��",18,"�ڰ����");
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
		System.out.println("��ֻ������Ϣ����");
		System.out.println("������"+name);
		System.out.println("���䣺"+age);
		System.out.println("��ɫ��"+colour);

	}
}