import java.math.BigInteger;
import java.util.Scanner;

public class GreenNums {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int count=1;
		int num=2;
		while(count<=n){
			if (isGreen(BigInteger.valueOf(num)))
				count++;
			num++;
		}

	}

	private static boolean isGreen(BigInteger bigint) {
		String square=bigint.pow(2).toString();
		String bigstr=bigint.toString();
		return square.substring(square.length()-bigstr.length()).equals(bigstr);
	}

}
