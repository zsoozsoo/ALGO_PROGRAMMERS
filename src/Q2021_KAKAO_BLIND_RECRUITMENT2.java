import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Q2021_KAKAO_BLIND_RECRUITMENT2 {
	
	public static void main(String[] args) {
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		
		List<String>[] listArr = new ArrayList[course.length];
		List<String> res = new ArrayList<String>();
		
		for (int i = 0; i < course.length; i++) {
			List<String> list = new ArrayList<>();
			listArr[i] = list;
		}
		
		for (int i = 0; i < orders.length; i++) {
			String str = orders[i];
			
			for (int j = 0; j < course.length; j++) {
				
				int size = course[j];
				char[] strArr = str.toCharArray();
				Arrays.sort(strArr);
				Permu(strArr,size,listArr[j],new char[size],0,0);
			}
		}
		
		for (int i = 0; i < listArr.length; i++) {
			List<String> list = listArr[i];
			
			HashMap<String, Integer> countMap = new HashMap<String, Integer>();

			for (int j = 0; j < list.size(); j++) {
				if(countMap.containsKey(list.get(j))) continue;
				else countMap.put(list.get(j),Collections.frequency(list, list.get(j)));
			}
			
			List<String> keyList = new ArrayList<>(countMap.keySet());
			Collections.sort(keyList, new Comparator<String>() {
				@Override
				public int compare (String o1, String o2) {
					return countMap.get(o2).compareTo(countMap.get(o1));
				}
	        });

			if(keyList.size()>0) {
				int max = countMap.get(keyList.get(0));
				
				for (int j = 0; j < countMap.size(); j++) {
					if(countMap.get(keyList.get(j))>=2 && countMap.get(keyList.get(j))==max) res.add(keyList.get(j));
				}
			}
			
		}
		
		String[] answer = res.toArray(new String[res.size()]);
		Arrays.sort(answer);
		System.out.println(Arrays.toString(answer));
		
	}

	private static void Permu(char[] strArr, int size, List<String> list, char[] charArr, int cur, int start) {
		if(cur==size) {
			Arrays.sort(charArr);
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<charArr.length; i++) sb.append(charArr[i]);
			list.add(sb.toString());
			return;
		}
		
		for (int i = start; i < strArr.length; i++) {
			charArr[cur] = strArr[i];
			Permu(strArr,size,list,charArr,cur+1,i+1);
		}
		
	}
}
