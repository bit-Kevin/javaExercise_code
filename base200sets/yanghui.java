public class yanghui{
	public static void main(String[] arge){
		int [][] yanghui = new int[10][];
		int i =0 ;//���Ʋ�������
		int j =0 ;//������������
		for (i = 0; i < yanghui.length;i++ ) {
			//��ÿһ�п��ٿռ�
			yanghui[i] = new int[i+1];
			for (j = 0; j < yanghui[i].length; j++) {
				if (j == 0||j == yanghui[i].length - 1) {//��һ�������һ����1
					yanghui[i][j]=1;
				}else{//��ǰ��ֵ����һ�м�����һ��ǰ��ĺ�
					yanghui[i][j] = yanghui[i-1][j] + yanghui[i-1][j-1];
				}
			}
		}
		//ѭ������������
		for (i = 0;i < yanghui.length ; i++) {
			for (j = 0; j < yanghui[i].length;j++ ) {
				System.out.print(yanghui[i][j] + "\t");
			}
			
			System.out.print("\n");
		}
	}
}