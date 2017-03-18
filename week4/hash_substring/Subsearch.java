import java.io.*;
import java.util.*;

public class Subsearch{
	static int p=1000000007;
	static int x=263;
	static int[] hashes;
	
	public static long calcHash(String s){
		long hashval=0;
		for(int i=s.length()-1;i>=0;i--){
			hashval=(hashval*263+(int)s.charAt(i))%p;
		}
			return(hashval%p);
			
	}
	
	public static void preCalcHash(String s, String pt){
		int y=1;
		int plen=pt.length();
		long hashval=calcHash(s.substring(s.length()-plen,s.length()));
		hashes=new int[s.length()-plen+1];
		hashes[s.length()-plen]=(int)hashval;
		for(int i=1;i<=plen;i++)
			y=(y*x)%p;
		for(int i=s.length()-plen-1;i>=0;i--){
			hashes[i]=(hashes[i+1]*263+(int)s.charAt(i)-y*(int)s.charAt(i+plen))%p;
			//hashes[i]=((int)hashval);
		}
			
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String pt=sc.next();
		String t=sc.next();
		ArrayList<Integer> result=new ArrayList<Integer>();
		long phash=calcHash(pt);
		preCalcHash(t,pt);
		int tlen=t.length();
		int plen=pt.length();
		//System.out.println(phash);
		//System.out.println(hashes[4]);
		for(int i=0;i<=tlen-plen;i++){
			//long thash=calcHash(t.substring(i,i+plen));
			if(hashes[i]!=phash)
				continue;
			if(t.substring(i,i+plen).equals(pt))
				result.add(i);
		}
		Iterator it = result.iterator();
		while(it.hasNext())
			System.out.print(it.next()+" ");
	}
}
