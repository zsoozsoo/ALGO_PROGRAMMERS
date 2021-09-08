import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2021_KAKAO_BLIND_RECRUITMENT1_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String temp = str.toLowerCase();
		
		temp = temp.replaceAll("[^-_.a-z0-9]","");
		temp = temp.replaceAll("[.]{2,}",".");
		temp = temp.replaceAll("^[.]|[.]$","");
		
		if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        str=temp;
        System.out.println(str);
	}
}
