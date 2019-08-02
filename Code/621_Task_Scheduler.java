/*
 * 621. Task Scheduler
 * Target: Given a char array representing tasks CPU need to do. 
 *         It contains capital letters A to Z where different letters represent different tasks. 
 *         Tasks could be done without original order. Each task could be done in one interval. 
 *         For each interval, CPU could finish one task or just be idle.
 *         However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 *         You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * Difficulty：Medium
 * Classification：Linked List, Sort
 */
 
 /*
 * Solution 1
 * 2019-08-01  Runtime: 76 ms
 * Algorithm: => ProrityQueue.CPU has to wait for time n before do the same task, so regard n + 1 as a cycle.
 * Time Complexity: O(n*logn). Space Conplexity: O(1). 
 */
 
 class Solution {
    public int leastInterval(char[] tasks, int n) {
        int res = 0;
        int cycle = n + 1;
        Map<Character, Integer> counter = new HashMap<>();
        for (char t : tasks) {
            counter.put(t, counter.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(counter.values());
        while (!pq.isEmpty()) {
            int workTime = 0;
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    tmp.add(pq.poll());
                    workTime++;
                }
            }
            for (int cnt : tmp) {
                if (--cnt > 0) {
                    pq.offer(cnt);
                }
            }
            res += !pq.isEmpty() ? cycle : workTime;
        }
        return res;
    }
}


/*
 * Solution 2
 * 2019-08-01  Runtime: 3 ms
 * Algorithm: => Greedy. Details: https://leetcode.com/problems/task-scheduler/discuss/104500/Java-O(n)-time-O(1)-space-1-pass-no-sorting-solution-with-detailed-explanation.
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 
 class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int maxCnt = 0;
        int maxFeq = 0;
        for (char t : tasks) {
            counter[t - 'A']++;
            if (maxCnt == counter[t - 'A']) {
                maxFeq++;
            } else if (maxCnt < counter[t - 'A']) {
                maxCnt = counter[t - 'A'];
                maxFeq = 1;
            }
        }
        int partCnt = maxCnt - 1;
        int partLen = n - (maxFeq - 1);
        int emptySlots = partCnt * partLen;
        int availableTasks = tasks.length - maxCnt * maxFeq;
        int idle = Math.max(0, emptySlots - availableTasks);
        return tasks.length + idle;
    }
}


/*
 * Solution 3
 * 2019-08-01  Runtime: 2 ms
 * Algorithm: => Greedy. Details: https://leetcode.com/problems/task-scheduler/discuss/104496/concise-Java-Solution-O(N)-time-O(26)-space
 * Time Complexity: O(n). Space Conplexity: O(1). 
 */
 
 class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        for (char t : tasks) {
            counter[t - 'A']++;
        }
        Arrays.sort(counter);
        int i = 25;
        while (i >= 0 && counter[i] == counter[25]) i--;
        return Math.max(tasks.length, ((counter[25] - 1) * n) + counter[25] + (25 - i - 1));
    }
}
