public class recursion01{
	//쳲������ݹ����

public static void main(String[] args){
	int i = 7;
	Mytools a = new Mytools();
	int temp = a.DiGui(i);
	if (temp > 0) {
		System.out.println("��"+ i +"��쳲���������"+ temp);
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
			System.out.println("������һ�����ڵ���1����");
			return -1 ;
		}
	}
}