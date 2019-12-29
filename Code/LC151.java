////////// sol 1

class Solution {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        s += " ";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (temp.length() != 0) {
                    stack.push(temp.toString());
                    temp = new StringBuilder();
                }
            } else {
                temp.append(s.charAt(i));
            }
        }
        if (stack.isEmpty()) return "";
        StringBuilder res = new StringBuilder();
        res.append(stack.pop());
        while (!stack.isEmpty()) {
            res.append(" ");
            res.append(stack.pop());
        }
        return res.toString();
    }
}


////////// sol 2

class Solution {
    public String reverseWords(String s) {
        if (s == "") return s;
        char chs[] = s.toCharArray();
        int n = chs.length;
        reverse(chs, 0, n - 1);
        reverseWord(chs, n);
        return cleanSpace(chs, n);
    }
    
    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            char c = chs[i];
            chs[i++] = chs[j];
            chs[j--] = c;
        }
    }
    
    private void reverseWord(char[] chs, int n) {
        int i = 0, j = 0;
        while (i < n) {
            // skip space
            while (i < j || i < n && chs[i] == ' ') {
                i++;
            }
            // skip no space
            while (j < i || j < n && chs[j] != ' ') {
                j++;
            }
            reverse(chs, i, j - 1);
            //System.out.println("======" + i + " " + j);
        }
    }
    
    private String cleanSpace(char[] chs, int n) {
        int i = 0, j = 0;
        for (char c : chs) {
            System.out.println(c);
        }
        
        while (j < n) {
            // skip space
            while (j < n && chs[j] == ' ') {
                j++;
            }
            // keep no space
            while (j < n && chs[j] != ' ') {
                chs[i++] = chs[j++];
            }
            // skip space
            while (j < n && chs[j] == ' ') {
                j++;
            }
            if (j < n) {
                chs[i++] = ' ';
            }
        }
        return new String(chs).substring(0, i);
    }
}
