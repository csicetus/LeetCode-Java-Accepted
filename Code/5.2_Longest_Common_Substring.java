/*
 * 5.2 Longest Common Substring
 * 2019-06-02
 * => 5.1 Longest Palindromic Substring version 2, to prevent if(i > 0 && j > 0) in internal loop, initialize first row&&column.
 * => 5. Longest Palindromic Substring helped file
 * Target:  Return the length of longest common substring of two strings
 * Algorithm: 1. Transfer two strings to one two-dimensional array; 
 *            2. Compare the row and column char corresponding to each point of the two-dimensional array,
 *               if equal, set it to 1, if not, set it to 0.
 *            3. Find the longest diagonal with the value of 1, which is Longest Common Substring.
 */
 
 /**
	 * Return the length of longest common substring of two strings.
	 * @param str1	first string
	 * @param str2	second string
	 * @return	If exists, return Longest Common Substring, if not, return 0.
	 */
public static int getLCSlen(String str1, String str2){
		int maxLen = 0;
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		int[][] temp = new int[arr1.length][arr2.length];	

		for(int m = 1; m < arr2.length; m++){
			temp[0][m] = (arr1[0] == arr2[m]) ? 1 : 0;
		}

		for(int n = 1; n < arr1.length; n++){
			temp[n][0] = (arr2[0] == arr1[n]) ? 1 : 0;
		}

		for(int i = 1; i < arr1.length; i++){
			for(int j = 1; j < arr2.length; j++){
				if(arr1[i] == arr2[j]){
					temp[i][j] = temp[i - 1][j - 1] + 1;
					if(temp[i][j] > maxLen){
						maxLen = temp[i][j];
					}
				}
				else{
					temp[i][j] = 0;
				}
			}
		}
		return maxLen;
	}
