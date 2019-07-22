
public class BitWiseOperations {

	public static void main(String[] args) {

		//https://users.cs.cf.ac.uk/Dave.Marshall/PERL/control.gif
		int textAttr = 128;
		
		int opr1 = 128;
		int opr2 = 32;
		String binaryvalopr1 = Integer.toBinaryString(opr1);
		String binaryvalopr2 = Integer.toBinaryString(opr2);
		System.out.println("binaryvalopr1: " + binaryvalopr1);
		System.out.println("binaryvalopr2: " + binaryvalopr2);
		/////OR operator
		textAttr = opr1 |  opr2;
		
		System.out.println("result of ["+ opr1 + "|" + opr2 +" == " + textAttr);
		
		textAttr = textAttr ^ 128;
		
		System.out.println("result of ["+ opr1 + "^" + opr2 +" == " + textAttr);
		int val = 128 << 1;
		System.out.println("multiplication:" + val);
		
	}

}