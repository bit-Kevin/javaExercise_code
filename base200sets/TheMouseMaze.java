public class TheMouseMaze{
	public static void main(String[] args){
		MyTools A = new MyTools();
		int[][] map = A.init();
		//��ʼ�ƶ�
		int i = 1 ;
		int j = 1 ;//���ó�ʼλ��
		A.begin(map,i,j);
	}
}

class MyTools{
	public int[][] init(){
		int [][] map =new int [8][7];
		//��ʼ���Թ�
		for (int j = 0; j<7; j++) {
			map[0][j] = 1 ;
			map[7][j] = 1 ;
		}
		for (int i =0; i<8;i++ ) {
			map[i][0] = 1 ;
			map[i][6] = 1 ;
		}
		map[3][1] = 1 ;
		map[3][2] = 1 ;
		return map ;

	}
	public void begin(int map[][],int i ,int j){
		while(true){
			if (map[i+1][j] == 1 && map[i][j+1] == 1) {
				System.out.println("��Ϸʤ��");
				print(map,i,j);
				return ;
			}else if (map[i+1][j] == 1) {
				//������ǽ������
				j++;
				print(map,i,j);
			}else{
				//û��ǽ������
				i++;
				print(map,i,j);
			}
		}
	}
	public void print(int map[][],int row,int col ){
		//�����ǰ��ͼ
		//��ӡ����
		System.out.println("=======��ǰ��ͼ=======");
		for (int i =0; i<map.length;i++ ) {
			for (int j =0; j<map[i].length; j++) {
				if (i==row && j == col) {
					//��ӡ����
					System.out.print("#"+ " ");
				}else{
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}

	}
}