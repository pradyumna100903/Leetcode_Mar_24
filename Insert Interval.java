class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];

        for (int i = 0; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currEnd < start) {
                list.add(new int[]{currStart, currEnd});
            } else if (currStart <= end) {
                start = Math.min(currStart, start);
                end = Math.max(end, currEnd);
            } else {
                list.add(new int[]{start, end});
                start = currStart;
                end = currEnd;
            }
        }

        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][2]);
    }
}

