import java.util.Scanner;

public class SeqBalance {

	/**
	 * @param args
	 */
	public static boolean groupCheck(String s) {
		int seqlen = s.length();

		if (seqlen == 0)
			return true;
		else if (seqlen % 2 != 0)
			return false;
		else 
		{
			int mididx = 0;
			int[] markIdx=new int[seqlen];
			
			for (int i=0;i<seqlen;i++)
				markIdx[i]=0;
			
			while (mididx<seqlen) 
			{
				if (markIdx[mididx]==0)
				{
					markIdx[mididx]=1;
					if (s.charAt(mididx)=='(')
						isGroupMatched(mididx,'(',')',s,markIdx);
					else if (s.charAt(mididx)=='{')
						isGroupMatched(mididx,'{','}',s,markIdx);
					else if (s.charAt(mididx)=='[')
						isGroupMatched(mididx,'[',']',s,markIdx);
				}
				
				mididx++;
			}

			int opencount=0,closecount=0;
			
			for (int i=0;i<seqlen;i++)
				 if (markIdx[i]==1)
					 opencount++;
				 else if (markIdx[i]==2)
					 closecount++;
			
			if (opencount==closecount)
				return true;
			else
				return false;
		}
	}

	private static int isGroupMatched(int mididx, char c, char d, String s, int[] markIdx) {
		
		int openidx=0,closeidx = 0;
		
		if (mididx==-1)
			return mididx;		
		else
		{
			markIdx[mididx]=1;
					
			isGroupMatched(s.indexOf(c, mididx + 1), c, d, s, markIdx);
			
			if (mididx + 1<s.length())
				if (s.charAt(mididx + 1)==d && markIdx[mididx + 1]==0){
					markIdx[mididx + 1]=2;
					return mididx + 1;
			}
			
			openidx=mididx+1;
			while(true)
			{
				closeidx=s.indexOf(d,openidx+1);
				if (closeidx==-1)
					break;
				
				if (markIdx[closeidx]==0){
					markIdx[closeidx] = 2;
					break;
				}
				openidx=closeidx;
			}
			
			
			return closeidx;	
		}
						
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println(groupCheck(sc.next()));

	}

}
