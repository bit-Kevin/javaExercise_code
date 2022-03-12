public class MethodExercise{
	public static void main(String[] arge){
		AA a = new AA();
		if (a.isodd(3)) {
			System.out.println("你输入的数是奇数");
		}else{
			System.out.println("你输入的数是偶数");
		}
		a.print(5,5,'#');

	}
}

class AA{
	public boolean isodd(int num){
		return num % 2 != 0 ? true:false;
	}
	public void print(int row , int col , char ch){
		for (int i = 0;i < row ;i++ ) {
			for (int j = 0; j < col; j++) {
				System.out.print(ch);
			}
			System.out.println();
		}
	}
}