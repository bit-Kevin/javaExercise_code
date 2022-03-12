public class EightQueens{
	public static void main(String[] args){
		QueensTools A = new QueensTools();
//初始化棋盘
		int[][] map = A.Init();
		int queens = 8 ;
		boolean temp = A.find(map,queens);
		A.print(map);
	}
}
//0是未下子  2是已部署皇后
class QueensTools{
	public int[][] Init(){
		int rowmax = 8 ;
		int colmax = 8 ;
		int[][] map = new int[rowmax][colmax];
		//开始棋盘初始化
		for (int i = 0; i<rowmax;i++ ) {
			for (int j = 0;j<colmax;j++ ) {
				map[i][j] = 0 ;
			}
		}
		return map;
	}

	public boolean find(int[][] map,int queens){
		print(map);
		//终止条件
		if (queens==0) {
			return true;
		}else{
			int row = queens-1;//行数固定
			int col = 0;//从零开始判断当前行那一列可以放
			int colmax = 8;
			int rowmax = 8;
			for (col=0;col<colmax ;col++ ) {
				//判断当前整列
				for (int i = 0;i<rowmax ;i++ ) {
				//如果当前列有皇后列加一，判断下一列
					if(map[i][col]==2){
					col++;
					i = 0;
					}
				}
				//列判断完毕，开始判断斜线
				if (deside(map,row,col)) {
					//皇后数量减一
					queens--;
					break;
				}
			}
			//开始递归找下一个皇后
			find(map,queens);
			return true;
		}
	}


	public boolean deside(int[][] map,int row,int col){
		int rowmax = 8 ;
		int colmax = 8 ;
		int i = 0;
		//判断当前位置向上的两条斜线
		//定义两个临时列，控制左右两条斜线
	
		int tempcol1 = col;
		int tempcol2 = col;
		for (i=row;i>=0 ;i-- ) {//开始向上遍历
			if (map[i][tempcol1]==2) {
				//遍历左上斜线
				return false;
			}
			if(map[i][tempcol2]==2){
				//遍历右上斜线
				return false;
			}
			//改变临时列，如果已经遍历到棋盘边缘停止改变临时列
			if (tempcol1 > 0) {
				tempcol1--;
			}
			if (tempcol2 < colmax-1) {
				tempcol2++;
			}
			
		}
		//判断当前位置向下的两条斜线
		//再次初始化两个临时列，控制左右两条斜线
		tempcol1 = col;
		tempcol2 = col;
		for (i=row;i< rowmax ;i++ ) {//开始向下遍历
			if (map[i][tempcol1]==2) {
				//遍历左下斜线
				return false;
			}
			if(map[i][tempcol2]==2){
				//遍历右下斜线
				return false;
			}
			//改变临时列，如果已经遍历到棋盘边缘停止改变临时列
			if (tempcol1 > 0) {
				tempcol1--;
			}
			if (tempcol2 < colmax-1) {
				tempcol2++;
			}
			
		}
		//遍历结束未碰到皇后就部署皇后返回TRUE
		map[row][col] = 2;
		return true;
		
	}
	public void print(int map[][]){
		//打印棋盘
		System.out.println("=======当前棋盘=======");
		for (int i =0; i<map.length;i++ ) {
			for (int j =0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}