////////// sol 1: dfs + bfs

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        // if endWord didn't exist in wordList, return null
        if (!wordList.contains(endWord)) {
            return res;
        }
        // use bfs() to find all neighbors and corresbonding depth
        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, wordList, map, distance);
        
        // use temp to store the dfs path
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, map, distance, temp, res);
        return res;
    }
    
    public void findLaddersHelper(String beginWord, String endWord, HashMap<String, List<String>> map, HashMap<String, Integer> distance, List<String> temp, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<String>(temp));
            return;
        }
        List<String> neighbors = map.getOrDefault(beginWord, new ArrayList<String>());
        for (String neighbor : neighbors) {
            if (distance.get(beginWord) + 1 == distance.get(neighbor)) {
                temp.add(neighbor);
                findLaddersHelper(neighbor, endWord, map, distance, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, List<String>> map, HashMap<String, Integer> distance) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        distance.put(beginWord, 0);
        int depth = 0;
        boolean isFound = false;
        Set<String> list = new HashSet<>(wordList);
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            for (int i = 0; i < size; i++) {
                String curNode = q.poll();
                // get all of neighbors
                List<String> neighbors = getNeighborNode(curNode, list);
                map.put(curNode, neighbors);
                // test neighbors one by one
                for (String neighbor : neighbors) {
                    // if it's new word, add to map
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, depth);
                        if (neighbor == endWord) {
                            isFound = true;
                        }
                        q.offer(neighbor);
                    }
                }
            }
            if (isFound) {
                break;
            }
        }
    }
    
    private List<String> getNeighborNode(String node, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char ch[] = node.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < ch.length; i++) {
                if (c == ch[i]) continue;
                char oldch = ch[i];
                ch[i] = c;
                if (dict.contains(String.valueOf(ch))) {
                    res.add(String.valueOf(ch));
                }              
                ch[i] = oldch;
            }
        }
        return res;
    }
}
