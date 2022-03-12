public class TheMouseMaze{
	public static void main(String[] args){
		MyTools A = new MyTools();
		int[][] map = A.init();
		//开始移动
		int i = 1 ;
		int j = 1 ;//设置初始位置
		A.begin(map,i,j);
	}
}

class MyTools{
	public int[][] init(){
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
		return map ;

	}
	public void begin(int map[][],int i ,int j){
		while(true){
			if (map[i+1][j] == 1 && map[i][j+1] == 1) {
				System.out.println("游戏胜利");
				print(map,i,j);
				return ;
			}else if (map[i+1][j] == 1) {
				//向下碰墙往右走
				j++;
				print(map,i,j);
			}else{
				//没碰墙往下走
				i++;
				print(map,i,j);
			}
		}
	}
	public void print(int map[][],int row,int col ){
		//输出当前地图
		//打印棋盘
		System.out.println("=======当前地图=======");
		for (int i =0; i<map.length;i++ ) {
			for (int j =0; j<map[i].length; j++) {
				if (i==row && j == col) {
					//打印老鼠
					System.out.print("#"+ " ");
				}else{
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}

	}
}