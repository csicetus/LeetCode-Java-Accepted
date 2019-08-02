/*
 * 406. Queue Reconstruction by Height
 * Target: Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
 *         where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 
 *         Write an algorithm to reconstruct the queue.
 * Difficulty：Medium
 * Classification：Greedy
 */
 
 /*
 * Solution 1
 * 2019-08-02  Runtime: 7 ms
 * Algorithm: => Greedy. Sort the people to make them stand from the highest to shortest and the count of people before them.
 * Time Complexity: O(n^2). Space Conplexity: O(n). 
 */
 
 class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                 if (a[0] == b[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        for (int i = 0; i < n; i++) {
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        return tmp.toArray(new int[n][2]);
    }
}
