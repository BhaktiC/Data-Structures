import java.util.*;

public class Phoneb{

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		String[] contacts=new String[10000000];
		for(int i=0;i<n;i++){
			String ip=sc.nextLine();
			StringTokenizer st=new StringTokenizer(ip);
			String query=st.nextToken();
			
			if(query.equals("add")){
				int num=Integer.parseInt(st.nextToken());
				String name=st.nextToken();
				contacts[num]=name;
			}
			else if(query.equals("find")){
				int num=Integer.parseInt(st.nextToken());
				String val=contacts[num];
				if(val!=null)
					System.out.println(val);
				else
					System.out.println("not found");
			}
			else if(query.equals("del")	){
				int num=Integer.parseInt(st.nextToken());
				contacts[num]=null;
			}
		}
	}
}