public class RecursionPeach{
	public static void main(String[] args){
		int end_day =10;
		int day = 1;
		MyTools A = new MyTools();
		int temp = A.peach(day,end_day);
		if (temp > 0 ) {
			System.out.println("��"+day+"����������ǣ�"+temp);
		}
	}
}

class MyTools{
	public int peach(int day,int end_day){
		if (day == end_day) {
			return 1;                                
		}else if(day > 0 && day < end_day){
			return (peach(day+1,end_day)+1)*2; 
		}else{
			System.out.println("���������Ч");
			return -1 ;
		}
	}
}