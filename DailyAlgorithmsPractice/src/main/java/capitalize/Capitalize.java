package capitalize;

public class Capitalize {

	public static void main(String[] args) {
		String string = "hello you need to capitalize each word of this string";
		capitalizeEach(string);		
	}

	public static void capitalizeEach(String s) {
		String[] arr = s.split(" ");
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
		}
		for(String str: arr) {
			System.out.print(str + " ");
		}
	}
}
