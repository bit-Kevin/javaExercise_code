public class pyramid {
	public static  void main( String[] arge) {
		int Tierlimit=10;
		int i=0;
		int j=0;
		int k=0;
		for (i=1;i<=Tierlimit ;i++ ) {
			//��ո�
			for (k=1;k<=Tierlimit-i ;k++ ) {
			System.out.print(" ");				
			}
			//��ӡ*
			for (j=1;j<=i*2-1 ;j++ ) {
			//�ο�
				if(j==1 || j==i*2-1 || i==Tierlimit){
				System.out.print("*");
				}
				else{
				System.out.print(" ");
				}			
			}
			System.out.print("\n");

		}
	}
}