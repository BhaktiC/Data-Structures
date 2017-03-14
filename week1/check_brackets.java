import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class check_brackets {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
        int flag=0;
        int ans=0;
        Stack<Bracket> obstack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);
            Bracket b=new Bracket(next,position);
            if (next == '(' || next == '[' || next == '{') {
                obstack.push(b);
            }

            if (next == ')' || next == ']' || next == '}') {
                if(obstack.empty())
                {
                flag++; 
                ans=b.position+1;
                break;
            }
            else
            {
              Bracket temp=obstack.peek();
              if(temp.Match(next))
               obstack.pop();
               else
               {
                   flag++;
               ans=b.position+1;
                   break;
            }
            }
              
            }
        }
            if(flag==1)
            System.out.println(ans);
            else
            {
              if(!obstack.empty())
              {
                Bracket x=obstack.pop();
                System.out.println(x.position+1);
                }
                else
                System.out.println("Success");
            }
        // Printing answer, write your code here
    }
}
