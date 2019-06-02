/*
 * 5.1 Longest Common Substring
 * 2019-06-02
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

	for(int i = 0; i < arr1.length; i++){
		for(int j = 0; j < arr2.length; j++){
			if(arr1[i] == arr2[i]){
				if(i > 0 && j > 0){
					temp[i][j] = temp[i - 1][j - 1] + 1;
				}
				else{
					temp[i][j] = 1;
				}
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
