////////////// sol 1: stack

// Time: O(n); Space: O(n)
class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        String[] arr = input.split("\n");
        int maxLen = 0;
        // dummy null len
        stack.push(0);
        for (String s : arr) {
            //System.out.println(s);            
            int numOfTabs = s.lastIndexOf("\t") + 1;
            //System.out.println("numOfTabs " + numOfTabs);
            int level = numOfTabs + 1;
            //System.out.println("stack size " + stack.size());
            while (level < stack.size()) {
                //System.out.println("level: "+level + " size " + stack.size());
                stack.poll(); 
            }
            //System.out.println("peek "+stack.peek());
            // add previous string len by using peek()
            int curLen = stack.peek() + s.length() - numOfTabs + 1;
            //System.out.println("curLen "+curLen);
            stack.push(curLen);
            if (s.contains(".")) {
                // remove "/" at the end of file
                maxLen = Math.max(maxLen, curLen - 1);
            }
            //System.out.println("maxLen "+maxLen);
        }
        return maxLen;
    }
}
