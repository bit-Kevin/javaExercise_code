public class EightQueens{
	public static void main(String[] args){
		QueensTools A = new QueensTools();
//��ʼ������
		int[][] map = A.Init();
		int queens = 8 ;
		boolean temp = A.find(map,queens);
		A.print(map);
	}
}
//0��δ����  2���Ѳ���ʺ�
class QueensTools{
	public int[][] Init(){
		int rowmax = 8 ;
		int colmax = 8 ;
		int[][] map = new int[rowmax][colmax];
		//��ʼ���̳�ʼ��
		for (int i = 0; i<rowmax;i++ ) {
			for (int j = 0;j<colmax;j++ ) {
				map[i][j] = 0 ;
			}
		}
		return map;
	}

	public boolean find(int[][] map,int queens){
		print(map);
		//��ֹ����
		if (queens==0) {
			return true;
		}else{
			int row = queens-1;//�����̶�
			int col = 0;//���㿪ʼ�жϵ�ǰ����һ�п��Է�
			int colmax = 8;
			int rowmax = 8;
			for (col=0;col<colmax ;col++ ) {
				//�жϵ�ǰ����
				for (int i = 0;i<rowmax ;i++ ) {
				//�����ǰ���лʺ��м�һ���ж���һ��
					if(map[i][col]==2){
					col++;
					i = 0;
					}
				}
				//���ж���ϣ���ʼ�ж�б��
				if (deside(map,row,col)) {
					//�ʺ�������һ
					queens--;
					break;
				}
			}
			//��ʼ�ݹ�����һ���ʺ�
			find(map,queens);
			return true;
		}
	}


	public boolean deside(int[][] map,int row,int col){
		int rowmax = 8 ;
		int colmax = 8 ;
		int i = 0;
		//�жϵ�ǰλ�����ϵ�����б��
		//����������ʱ�У�������������б��
	
		int tempcol1 = col;
		int tempcol2 = col;
		for (i=row;i>=0 ;i-- ) {//��ʼ���ϱ���
			if (map[i][tempcol1]==2) {
				//��������б��
				return false;
			}
			if(map[i][tempcol2]==2){
				//��������б��
				return false;
			}
			//�ı���ʱ�У�����Ѿ����������̱�Եֹͣ�ı���ʱ��
			if (tempcol1 > 0) {
				tempcol1--;
			}
			if (tempcol2 < colmax-1) {
				tempcol2++;
			}
			
		}
		//�жϵ�ǰλ�����µ�����б��
		//�ٴγ�ʼ��������ʱ�У�������������б��
		tempcol1 = col;
		tempcol2 = col;
		for (i=row;i< rowmax ;i++ ) {//��ʼ���±���
			if (map[i][tempcol1]==2) {
				//��������б��
				return false;
			}
			if(map[i][tempcol2]==2){
				//��������б��
				return false;
			}
			//�ı���ʱ�У�����Ѿ����������̱�Եֹͣ�ı���ʱ��
			if (tempcol1 > 0) {
				tempcol1--;
			}
			if (tempcol2 < colmax-1) {
				tempcol2++;
			}
			
		}
		//��������δ�����ʺ�Ͳ���ʺ󷵻�TRUE
		map[row][col] = 2;
		return true;
		
	}
	public void print(int map[][]){
		//��ӡ����
		System.out.println("=======��ǰ����=======");
		for (int i =0; i<map.length;i++ ) {
			for (int j =0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}