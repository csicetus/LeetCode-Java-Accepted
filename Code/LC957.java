class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int n = cells.length;
        if (n == 0 || cells == null || N <= 0) {
            return cells;
        }
        boolean hasSeen = false;
        HashSet<String> set = new HashSet<>();
        // count cycle
        int count = 0;
        for (int i = 0; i < N; i++) {
            int[] next = updatedCells(cells);
            String key = Arrays.toString(next);
            if (!set.contains(key)) {
                set.add(key);
                count++;
            } else {
                hasSeen = true;
                break;
            }
            // each loop update cells
            cells = next;
        }
        if (hasSeen) {
            N %= count;
            for (int j = 0; j < N; j++) {
                cells = updatedCells(cells);
            }
        }
        return cells;
    }
    
    private int[] updatedCells(int[] cells) {
        int[] next = new int[cells.length];
        next[0] = 0;
        next[next.length - 1] = 0;
        for (int i = 1; i < cells.length - 1; i++) {
            next[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return next;
    }
}
