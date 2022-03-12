public class recursion01{
	//斐波那契递归调用

public static void main(String[] args){
	int i = 7;
	Mytools a = new Mytools();
	int temp = a.DiGui(i);
	if (temp > 0) {
		System.out.println("第"+ i +"个斐波那契数是"+ temp);
	}

}
}

class Mytools{
	public int DiGui(int num){
		if (num >= 1) {
			if (num ==1 || num == 2) {
				return 1 ;
			}else{
				return DiGui(num-1) + DiGui(num-2);
			}	
		}else{
			System.out.println("请输入一个大于等于1的数");
			return -1 ;
		}
	}
}