 public class counter{
 	public static void main(String[] args){
 		counterTools A = new counterTools(10,0);
 		System.out.println("���ǣ�"+ A.add());
 		System.out.println("���ǣ�"+ A.minus());
 		System.out.println("���ǣ�"+ A.mul());
 		Double temp = A.div();
 		if (temp==null) {
 			System.out.println("��������Ϊ�㣡");
 		}else{
 			System.out.println("���ǣ�"+temp);
 		}
 	}	
 }

 class counterTools{
 	double num1;
 	double num2;
 	public counterTools(double num1,double num2){
 		this.num1 = num1;
 		this.num2 = num2;
 	}
 	public double add(){
 		return num1 + num2 ;
 	}
 	public double minus(){
 		return num1 - num2 ;
 	}
 	public double mul(){
 		return num1 * num2;
 	}
 	public Double div(){
 		if (num2==0) {
 			return null; 
 		}
 		return num1/num2;
 	} 
 }
