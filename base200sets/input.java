import java.util.Scanner;
public class input{
	public static void main(String[] arge){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入姓名：");
		String name = input.next();
		System.out.println("请输入年龄：");
		int age = input.nextInt();
		System.out.println("请输入工资：");
		double salary = input.nextDouble();
		System.out.println("姓名：" + name );
		System.out.println("年龄：" + age );
		System.out.println("工资：" + salary );
	
	
		
	}
}