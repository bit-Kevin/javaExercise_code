import java.util.Scanner;
import java.util.Random;
public class moraGame{
	public static void main(String[] args){
		moraGameTools A = new moraGameTools();
		A.getAiNum();
		A.getTomNum();
		A.winner();
	}
}
class moraGameTools{
	int aiNum;
	int tomNum;
	int win;
	int count=1;
	public void getAiNum(){
		Random r = new Random();
		this.aiNum = r.nextInt(3);
	}
	public void getTomNum(){
		System.out.println("��������Ҫ����ȭ��0����ʯͷ��1���ڼ�����2���ڲ�");
		Scanner scanner = new Scanner(System.in);
		this.tomNum = scanner.nextInt();
	}
	//�ж���Ӯ
	public void winner(){
		if (aiNum==0&&tomNum==1) {
			printWinner("��Ӯ��");
		}else if (aiNum==1&&tomNum==2) {
			printWinner("��Ӯ��");
		}else if (aiNum==2&&tomNum==0) {
			printWinner("��Ӯ��");
		}else if(aiNum==tomNum) {
			printWinner("ƽ��");
		}else{
			printWinner("������");
		}
		count++;
	}
	public void printWinner(String temp){
		System.out.println("===========================================================");
		System.out.println("����\t"+"���Գ�ȭ\t"+"��ҳ�ȭ\t"+"��Ӯ���");
		System.out.println(this.count+"\t"+this.aiNum+"\t\t"+this.tomNum+"\t\t"+temp);
		System.out.println("===========================================================");

	}

}