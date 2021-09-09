import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2021_KAKAO_BLIND_RECRUITMENT3 {
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		int[] answer = new int[query.length];
		StringTokenizer st;
		
		String[][] arr = new String[info.length][5];
		for (int i = 0; i < info.length; i++) {
			String str = info[i];
			st = new StringTokenizer(str);
			
			for (int j = 0; j < 5; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		
		for (int i = 0; i < query.length; i++) {
			String str = query[i];
			//str = str.replaceAll(" ", "");
			st = new StringTokenizer(str);
			
			String[] check = str.split("and");
			str = String.join("", check);
			
			int res = 0;
			for (int j = 0; j <arr.length ; j++) {
				int idx = 0;
				st = new StringTokenizer(str);
				for (int k = 0; k < 5; k++) {
					String chk = st.nextToken();
					if(k!=4 && (arr[j][k].equals(chk) || chk.equals("-"))) idx++;
					if(k==4 && Integer.parseInt(arr[j][4])>=Integer.parseInt(chk)) idx++;
				}
				if(idx==5) res++;
			}
			answer[i] = res;
		}
		System.out.println(Arrays.toString(answer));
	}
}
