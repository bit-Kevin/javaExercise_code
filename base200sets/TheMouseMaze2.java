public class TheMouseMaze2{
	public static void main(String[] args){
		int i = 1;
		int j = 1;//��ʼλ��
		MyTools2 A = new MyTools2();
		int[][] map = A.Init();
		boolean temp = A.find(map,i,j);
		A.print(map);
	}
}

class MyTools2{
	public int[][] Init(){
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
		map[5][6] = 1 ;
		map[5][5] = 1 ;
		map[5][4] = 1 ;
		map[5][3] = 1 ;

		return map ;
	}
	public boolean find(int [][] map,int i, int j){
		//1���ϰ���  2�ǿ���·�� 4����·
		if (map[6][5]==2) {
			//�ݵ���ֹ����
			return true;
		}else if (map[i][j]==0) {
			map[i][j] = 2 ;
			if (find(map,i+1,j)) {
				//����̽·
				return true ;
			}else if (find(map,i,j+1)) {
				//����̽·
				return true ;
			}else if (find(map,i,j-1)){
				//����̽·
				return true ;
			}else if (find(map,i-1,j)) {
				//����̽·
				return true ;
			}else{
				map[i][j] = 4 ;
				return false ;
			}
		}else{
			return false ;
		}
	}
	public void print(int map[][]){
		//�����ǰ��ͼ
		//��ӡ����
		System.out.println("=======��ǰ��ͼ=======");
		for (int i =0; i<map.length;i++ ) {
			for (int j =0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}