public class VarParameterExercise{
	public static void main(String[] ages){
		VarParaneterMethod A = new VarParaneterMethod();
		System.out.println( A.ShowScore("��÷",22,56,77,100,55.4));
	}
}
class VarParaneterMethod{
	public String ShowScore(String name,double... scores){
		double totalScores = 0 ;
		for (int i=0; i<scores.length; i++) {
			 totalScores +=scores[i];
		}
		return name+scores.length+"�ŵ��ܷ��ǣ�"+totalScores;
	}
}