public class bubblesort {
	public static  void main( String[] arge) {
		int [] bubble = {22,33,44,55,66} ;
		int i = 0;
		int j = 0;
		for (i=0;i<5-1 ;i++ ) {
			for (j=0; j<5-i-1; j++) {
				int temp = 0 ;
				if (bubble[j]>bubble[j+1]) {
					temp = bubble[j];
					bubble[j] = bubble[j+1];
					bubble[j+1] = temp;
				}
			}
		}
		for (i=0; i<5; i++) {
			System.out.print(bubble[i]);
		}
	}
}