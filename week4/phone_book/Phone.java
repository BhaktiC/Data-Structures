import java.util.*;

public class Phone{

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		sc.nextLine();
		HashMap<Integer,String> contacts=new HashMap<Integer,String>();
		for(int i=0;i<n;i++){
			String ip=sc.nextLine();
			StringTokenizer st=new StringTokenizer(ip);
			String query=st.nextToken();
			
			if(query.equals("add")){
				int num=Integer.parseInt(st.nextToken());
				String name=st.nextToken();
				contacts.put(num,name);
			}
			else if(query.equals("find")){
				int num=Integer.parseInt(st.nextToken());
				String val=contacts.get(num);
				if(val!=null)
					System.out.println(val);
				else
					System.out.println("not found");
			}
			else if(query.equals("del")	){
				int num=Integer.parseInt(st.nextToken());
				contacts.remove(num);
			}
		}
	}
}
				