import java.io.*;
import java.util.*;

public class Chaining{
	static int p=1000000007;
	static int x=263;
	static int m;
	public static long calcHash(String s){
		long hashval=0;
		for(int i=s.length()-1;i>=0;i--){
			hashval=(hashval*263+(int)s.charAt(i))%p;
		}
			hashval=(hashval%p)%m;
			return hashval;
	}
			
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		m=sc.nextInt();
		ArrayList<String>[] hash=new ArrayList[m];
		for(int i=0;i<m;i++){
			hash[i]=new ArrayList<String>();
		}
		int n=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++){
			String ip=sc.nextLine();
			StringTokenizer st=new StringTokenizer(ip);
			String query=st.nextToken();
			
			if(query.equals("add")){
				String s=st.nextToken();
				int h=(int)calcHash(s);
				if(!hash[h].contains(s))
					hash[h].add(s);
			}
			if(query.equals("del")){
				String s=st.nextToken();
				int h=(int)calcHash(s);
				hash[h].remove(s);
			}
			if(query.equals("find")){
				String s=st.nextToken();
				int h=(int)calcHash(s);
				if(hash[h].contains(s))
					System.out.println("yes");
				else
					System.out.println("no");
			}
			if(query.equals("check")){
				int no=Integer.parseInt(st.nextToken());
				if(hash[no].isEmpty())
					System.out.println();
				else{
					String op="";
					Iterator it = hash[no].iterator();
					while(it.hasNext())
						op=it.next()+" "+op;
					System.out.println(op);
				}
			}
		}
	}
}