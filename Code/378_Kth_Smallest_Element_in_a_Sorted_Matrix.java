/*
 * 378. Kth Smallest Element in a Sorted Matrix
 * Target: Given a n x n matrix where each of the rows and columns are sorted in ascending order, 
 *         find the kth smallest element in the matrix.
 *         Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Difficulty：Medium
 * Classification：Binary Search, Heap
 */

/*
 * Solution 1
 * 2019-09-04  Runtime: 50 ms
 * Algorithm: => Min Heap. 
 * Time Complexity: O(min(K,N)+K∗logN). Space Conplexity: O(K)
 */

import java.util.*;

class Node {
    int row;
    int col;
    
    Node(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
        int res = 0, cnt = 0;
        // because of the rules of matrix, we just need to put every 1st number to the heap
        for (int i = 0; i < matrix.length && i < k; i++) {
            minHeap.add(new Node(i, 0));
        }
        while (!minHeap.isEmpty()) {
            // take the smallest (top) element form the min heap
            Node node = minHeap.poll();
            res = matrix[node.row][node.col];
            // if cnt equal to k, return
            if (++cnt == k) {
                break;
            }
            // if the row of the top element has more elements, add the next element to the heap
            node.col++;
            if (node.col < matrix[0].length) {
                minHeap.add(node);
            }
        }
        return res;
    }
}
