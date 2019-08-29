import java.util.*;

class Hill
{
	public static void main(String a[])
	{
		String alp=new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		System.out.println("Enter 1 for encryption & 2 for decryption:\n");
		Scanner s=new Scanner(System.in);
		int c=s.nextInt();
		int l=(int)Math.sqrt(a[1].length());
		int[][] key=new int[l][l];
		int m=0;
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				key[i][j]=alp.indexOf(a[1].charAt(m));
				m++;
			}
		}
		if(c==2)
		{
		int d=key[0][0]*key[1][1]-key[0][1]*key[1][0];
		if(d<0)
			d=26-((int)Math.abs(d)%26);
		else
			d=d%26;
		int t=-1;
		for(int i=0;i<26;i++)
		{
		  if(d*i%26==1)
		  {
			  t=i;
			  break;
		  }
		}
		int tmp=key[0][0];
		key[0][0]=key[1][1];
		key[1][1]=tmp;
		key[0][1]=26-(key[0][1]%26);
		key[1][0]=26-(key[1][0]%26);
		for(int i=0;i<l;i++)
		{
			for(int j=0;j<l;j++)
			{
				key[i][j]*=t;
				key[i][j]%=26;
			}
		}
		}
		m=0;
		StringBuffer ans=new StringBuffer();
		for(int i=0;i<a[0].length()/l;i++)
		{
			ans.append(ansFinal(a[0].substring(m,m+l),key,alp));
			m=m+l;
		}
		if(c==1)
		System.out.println("\nEncrypted text: "+ans);
		else
		System.out.println("\nDecrypted text: "+ans);
	}
	public static String ansFinal(String ip,int[][] key,String alp)
	{
		int tmp;
		StringBuffer tmpAns=new StringBuffer();
		for(int i=0;i<key.length;i++)
		{
			tmp=0;
			for(int j=0;j<key[0].length;j++)
			{
				tmp+=(key[i][j]*alp.indexOf(ip.charAt(j)));
			}
			tmpAns.append(alp.charAt(tmp%26));
		}
		return tmpAns.toString();
	}
}