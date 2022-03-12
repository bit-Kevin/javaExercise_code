public class yanghui{
	public static void main(String[] arge){
		int [][] yanghui = new int[10][];
		int i =0 ;//控制层数变量
		int j =0 ;//控制列数变量
		for (i = 0; i < yanghui.length;i++ ) {
			//给每一行开辟空间
			yanghui[i] = new int[i+1];
			for (j = 0; j < yanghui[i].length; j++) {
				if (j == 0||j == yanghui[i].length - 1) {//第一个和最后一个是1
					yanghui[i][j]=1;
				}else{//当前数值是上一行加上上一行前面的和
					yanghui[i][j] = yanghui[i-1][j] + yanghui[i-1][j-1];
				}
			}
		}
		//循环输出杨辉三角
		for (i = 0;i < yanghui.length ; i++) {
			for (j = 0; j < yanghui[i].length;j++ ) {
				System.out.print(yanghui[i][j] + "\t");
			}
			
			System.out.print("\n");
		}
	}
}