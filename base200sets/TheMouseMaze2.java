public class TheMouseMaze2{
	public static void main(String[] args){
		int i = 1;
		int j = 1;//初始位置
		MyTools2 A = new MyTools2();
		int[][] map = A.Init();
		boolean temp = A.find(map,i,j);
		A.print(map);
	}
}

class MyTools2{
	public int[][] Init(){
		int [][] map =new int [8][7];
		//初始化迷宫
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
		//1是障碍物  2是可走路径 4是死路
		if (map[6][5]==2) {
			//递的终止条件
			return true;
		}else if (map[i][j]==0) {
			map[i][j] = 2 ;
			if (find(map,i+1,j)) {
				//向下探路
				return true ;
			}else if (find(map,i,j+1)) {
				//向右探路
				return true ;
			}else if (find(map,i,j-1)){
				//向左探路
				return true ;
			}else if (find(map,i-1,j)) {
				//向上探路
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
		//输出当前地图
		//打印棋盘
		System.out.println("=======当前地图=======");
		for (int i =0; i<map.length;i++ ) {
			for (int j =0; j<map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}