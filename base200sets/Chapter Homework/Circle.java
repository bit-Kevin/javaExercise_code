public class Circle{
	public static void main(String[] args){
		circleTools A = new circleTools();
		A.printAreas(A,5);

	}
}
class circleTools{
	double radius = 0;
	public void setRadius(int  radius){
		this.radius = radius;
	}
	public double findArea(double radius){
		return Math.PI*radius*radius;
	}
	public void printAreas(circleTools temp,int times){
		System.out.println("Radius"+"\t"+"Areas");
		for (int i = 1; i<=times;i++ ) {
			temp.setRadius(i);
			System.out.println(radius +"\t"+temp.findArea(radius));
			
		}
	}
}