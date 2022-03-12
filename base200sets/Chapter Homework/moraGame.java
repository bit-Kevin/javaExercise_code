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
		System.out.println("请输入你要出的拳（0等于石头，1等于剪刀，2等于布");
		Scanner scanner = new Scanner(System.in);
		this.tomNum = scanner.nextInt();
	}
	//判断输赢
	public void winner(){
		if (aiNum==0&&tomNum==1) {
			printWinner("你赢了");
		}else if (aiNum==1&&tomNum==2) {
			printWinner("你赢了");
		}else if (aiNum==2&&tomNum==0) {
			printWinner("你赢了");
		}else if(aiNum==tomNum) {
			printWinner("平手");
		}else{
			printWinner("你输了");
		}
		count++;
	}
	public void printWinner(String temp){
		System.out.println("===========================================================");
		System.out.println("局数\t"+"电脑出拳\t"+"玩家出拳\t"+"输赢情况");
		System.out.println(this.count+"\t"+this.aiNum+"\t\t"+this.tomNum+"\t\t"+temp);
		System.out.println("===========================================================");

	}

}