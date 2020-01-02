////////// sol 1: BFS

// Time: O(m*n); Space: O(m*n). m is the length of words and n is the number of words
import javafx.util.Pair;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        int n = beginWord.length();
        HashMap<String, ArrayList<String>> adjDict = new HashMap<>();
        // find adj words of each word of wordList
        for (String word : wordList) {
            for (int i = 0; i < n; i++) {
                String curWord = word.substring(0, i) + '*' + word.substring(i + 1, n);
                ArrayList<String> adjWords = adjDict.getOrDefault(curWord, new ArrayList<String>());
                adjWords.add(word);
                adjDict.put(curWord, adjWords);
            }
        }
        
        // Queue for BFS that stores words level
        Queue<Pair<String, Integer>> q = new LinkedList<Pair<String, Integer>>();
        q.add(new Pair(beginWord, 1));
        
        // store visited words
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.poll();
            String word = node.getKey();
            int level = node.getValue();
            
            for (int i = 0; i < n; i++) {
                String curWord = word.substring(0, i) + '*' + word.substring(i + 1, n);
                
                for (String adjWord : adjDict.getOrDefault(curWord, new ArrayList<String>())) {
                    if (adjWord.equals(endWord)) {
                        return level + 1;
                    }
                    // if not visited, add to q and marked visited
                    if (!visited.containsKey(adjWord)) {
                        visited.put(adjWord, true);
                        q.add(new Pair(adjWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}

////////// sol 2: Bidirectional(双向) BFS

// Time: O(m*n); Space: O(m*n). m is the length of words and n is the number of words
import javafx.util.Pair;

class Solution {

  private int L;
  private HashMap<String, ArrayList<String>> allComboDict;

  Solution() {
    this.L = 0;

    // Dictionary to hold combination of words that can be formed,
    // from any given word. By changing one letter at a time.
    this.allComboDict = new HashMap<String, ArrayList<String>>();
  }

  private int visitWordNode(
      Queue<Pair<String, Integer>> Q,
      HashMap<String, Integer> visited,
      HashMap<String, Integer> othersVisited) {
      Pair<String, Integer> node = Q.remove();
      String word = node.getKey();
      int level = node.getValue();

    for (int i = 0; i < this.L; i++) {

      // Intermediate words for current word
      String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

      // Next states are all the words which share the same intermediate state.
      for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
        // If at any point if we find what we are looking for
        // i.e. the end word - we can return with the answer.
        if (othersVisited.containsKey(adjacentWord)) {
          return level + othersVisited.get(adjacentWord);
        }

        if (!visited.containsKey(adjacentWord)) {

          // Save the level as the value of the dictionary, to save number of hops.
          visited.put(adjacentWord, level + 1);
          Q.add(new Pair(adjacentWord, level + 1));
        }
      }
    }
    return -1;
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    if (!wordList.contains(endWord)) {
      return 0;
    }

    // Since all words are of same length.
    this.L = beginWord.length();

    wordList.forEach(
        word -> {
          for (int i = 0; i < L; i++) {
            // Key is the generic word
            // Value is a list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
            ArrayList<String> transformations =
                this.allComboDict.getOrDefault(newWord, new ArrayList<String>());
            transformations.add(word);
            this.allComboDict.put(newWord, transformations);
          }
        });

        // Queues for birdirectional BFS
        // BFS starting from beginWord
        Queue<Pair<String, Integer>> Q_begin = new LinkedList<Pair<String, Integer>>();
        // BFS starting from endWord
        Queue<Pair<String, Integer>> Q_end = new LinkedList<Pair<String, Integer>>();
        Q_begin.add(new Pair(beginWord, 1));
        Q_end.add(new Pair(endWord, 1));

        // Visited to make sure we don't repeat processing same word.
        HashMap<String, Integer> visitedBegin = new HashMap<String, Integer>();
        HashMap<String, Integer> visitedEnd = new HashMap<String, Integer>();
        visitedBegin.put(beginWord, 1);
        visitedEnd.put(endWord, 1);

        while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

              // One hop from begin word
              int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
              if (ans > -1) {
                return ans;
              }

              // One hop from end word
              ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
              if (ans > -1) {
                return ans;
              }
        }

        return 0;
      }
}
