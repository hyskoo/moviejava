package data;

public class Except {
	// 로그인 되어있는 유저의 정보를 저장
	public static int exceptionInt(String str){
		try {
			if (str != null || !str.trim().equals("")) {
				return Integer.parseInt(str);
			}
		} catch (Exception e) {
			str = null;
		}
		return 0;
	}
	public static String exceptionString(String str){
		try {
			if (str != null || !str.trim().equals("")) {
				return str;
			}
		} catch (Exception e) {
			str = null;
		}
		return str;
	}
	
	public static void main(String[] args) {
	}
}
