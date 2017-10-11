import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			System.out.println(getLongestUnRepeatedSubStr(in.nextLine()));
		}
	}
	public static int getLongestUnRepeatedSubStr(String str) {
		// int hashTable[256]={0};
		int[] hashTable = new int[256];
		int start = 0;
		int mstart = 0;
		int mlen = 0;
		int idx = 0;
		int len = 0;
		while (idx != str.length()) {
			if (hashTable[str.charAt(idx)] == 1) {
				if (len > mlen) {
					mstart = start;
					mlen = len;
				}
				while (str.charAt(start) != str.charAt(idx)) {
					hashTable[str.charAt(start)] = 0;
					start++;
					len--;
				}
				start++;
			} else {
				hashTable[str.charAt(idx)] = 1;
				len++;
			}
			idx++;
		}

		if (len > mlen) {
			mlen = len;
			mstart = start;
		}

		return mlen;
	}

}
