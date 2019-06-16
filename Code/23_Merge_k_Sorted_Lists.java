/*
 * 23. Merge k Sorted Lists
 * Target: Given n pairs of parentheses, generate all combinations of well-formed parentheses.
 * Difficulty：Medium
 * Classification：String, Backtracking
 */
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /*
 * Solution 1
 * 2019-06-15  Runtime: 7 ms
 * Algorithm: => Brute Force.
 * Time complexity: O(N*logN). Space complexity: O(N).
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodes = new ArrayList<>();
        ListNode head = new ListNode(0);
        ListNode point = head;
        for (ListNode l : lists){
            while (l != null){
                nodes.add(l.val);
                l = l.next;
            }           
        }
        Collections.sort(nodes);
        for (int k : nodes) {
            point.next = new ListNode(k);
            point = point.next;
        }
        return head.next;
    }
}

 
/*
 * Solution 2
 * 2019-06-15  Runtime: 322 ms
 * Algorithm: => Compare one by one.
 * Time complexity: O(k*N). Space complexity: O(1).
 */
 
 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int minIndex = 0;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(true){
            boolean isBreak = true;
            int minVal = Integer.MAX_VALUE;
            
            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null) {
                    if (lists[i].val < minVal){
                        minIndex = i;
                        minVal = lists[i].val;
                    } 
                    isBreak = false;
                }        
            }
            
            if (isBreak){
                break;
            }
            
            cur.next = lists[minIndex];
            cur = cur.next;
            lists[minIndex] = lists[minIndex].next;
        }
        
        
        cur.next = null;
        return head.next;
    }
}
 
 
/*
 * Solution 3
 * 2019-06-15  Runtime: 5 ms
 * Algorithm: => Optimize solution 2 by Priority Queue.
 * Time complexity: O(N log(k)). Space complexity: O(k).
 */
 
 class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2){
                return (l1.val - l2.val);
            }
        };
        
        Queue<ListNode> q = new PriorityQueue<ListNode>(cmp);
        for (ListNode l : lists) {
            if (l != null) {
                q.add(l);
            }
        }
        
        ListNode head = new ListNode(0);
        ListNode cur = head;
        
        while (!q.isEmpty()){
            cur.next = q.poll();
            cur = cur.next;
            ListNode next = cur.next;
            if (next != null){
                q.add(next);
            }
        }
        
        return head.next;
    }
}
 
 
/*
 * Solution 4
 * 2019-06-15  Runtime: 302 ms
 * Algorithm: => Merge lists one by one.
 * Time complexity: O(k * N). Space complexity: O(1).
 */

class Solution {
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null){
            if (l1.val > l2.val){
                ListNode temp = l1;
                l1 = l2;
                l2 = temp;
            }
            l1.next = mergeTwoLists(l1.next, l2);
        }
        return (l1 != null) ? l1 : l2;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }
        ListNode head = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++){
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }
}
 
/*
 * Solution 5
 * 2019-06-15  Runtime: 3 ms
 * Algorithm: => Recursion. The length of res is 2 * n.
 * Time complexity: O(N log(k)). Space complexity: O(k).
 */
