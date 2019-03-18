import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BiggerNum {

	public static void main(String[] args) {
		long n=2017;
		List<Integer> digits=new ArrayList<Integer>();
		while(n>0){
			digits.add((int) (n%10));
			n/=10;
		}
		Integer[] digarr=new Integer[digits.size()];
		if (biggerNum(digits.toArray(digarr)))
	      {
	        StringBuilder sb=new StringBuilder();
	        for (int k=digits.size()-1;k>=0;k--)
	            sb.append(digits.get(k));
	            
	        System.out.println(Long.valueOf(sb.toString()));
	      }
	      else
	    	  System.out.println(-1);
	}

	private static boolean biggerNum(Integer[] digits) {
		boolean isBigger=false;
		int len=digits.length-1;
		if (digits.length>2){
			for (int i=1;i<=len;i++){
				if (digits[i-1]>digits[i]){
					int temp=digits[i];
					Arrays.sort(digits, 0, i+1, new Comparator<Integer>(){
						@Override
						public int compare(Integer o1, Integer o2) {
							return -1*o1.compareTo(o2);
						}
						
					});
					smallBigInt(digits,temp,i);
					isBigger=true;
					break;
				}
			}
		}
		else{
			if (digits[0]>digits[1]){
				int temp=digits[0];
				digits[0]=digits[1];
				digits[1]=temp;
				isBigger=true;
			}
		}
		return isBigger;
		
	}

	private static void smallBigInt(Integer[] digits, int i, int t_idx) {
		int idx=0;
        int temp;
        while(idx<=t_idx){	
            if (digits[idx]==i){
                temp=digits[idx-1];
                for (int j=idx-1;j<t_idx;j++)
                    digits[j]=digits[j+1];

                digits[t_idx]=temp;
                break;
            }
            idx++;
        }
	}

}
