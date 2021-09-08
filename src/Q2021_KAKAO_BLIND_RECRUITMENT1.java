import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q2021_KAKAO_BLIND_RECRUITMENT1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		 List<Character> list = new ArrayList<>();
			
			//1. 대문자 소문자로
			str = str.toLowerCase();
			
			//2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if((ch-48>=0 && ch-48<=9) ||(ch-97>=0 && ch-97<=25) || ch=='-' || ch=='_' || ch=='.' ) list.add(ch);
			}
			if(list.size()==0) list.add('a');
			
			
			//3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
			int idx = 0, size = list.size(); boolean flg = false;
			for (int i = size-1; i >=0; i--) {
				char ch = list.get(i);
				
				if(ch=='.') { 
					idx++; flg = true;
					if(i==0 && flg && idx >1) {
						for (int j = idx-1; j >=1; j--) list.remove(i+j);
					}
				}else {
					if(flg) {
						if(idx>1) {
							for (int j = idx-1; j >=1; j--) list.remove(i+j);
						}
						flg = false; idx = 0;
					}
				}
			}
			
			if(list.size()==0) list.add('a');
			
			//4.처음이나 끝이면 제거
			if(list.get(list.size()-1)=='.') list.remove(list.size()-1);
			if(list.size()==0) list.add('a');
			
			if(list.get(0)=='.') list.remove(0);
			if(list.size()==0) list.add('a');
			
			//6. 길이 16자 이상일 경우 15문자 이후에는 제거 + 마침표 제거
			size = list.size();
			if(list.size()>15) {
				for (int i = size-1; i >=15 ; i--) list.remove(i);
			}
			if(list.size()==0) list.add('a');
			
			if(list.get(list.size()-1)=='.') list.remove(list.size()-1);
			if(list.size()==0) list.add('a');
			
			//7. 길이가 2자 이하라면, 길이 3될때까지 마지막 문자 한 번 더
			char endCh = list.get(list.size()-1);
			if(list.size()<=2) {
				while(list.size()<=2) {
					list.add(endCh);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
			}
		
		System.out.println(sb.toString());
	}
	
}
