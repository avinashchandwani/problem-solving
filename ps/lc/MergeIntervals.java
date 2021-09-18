class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> mergedIntervals = new ArrayList<>();
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));
        for(int[] interval : intervals) {
            if(mergedIntervals.isEmpty() || interval[0] > mergedIntervals.get(mergedIntervals.size()-1)[1]) {
                mergedIntervals.add(interval);
            } else {
                int []previousIntervals = mergedIntervals.get(mergedIntervals.size()-1);
                if(previousIntervals[1] < interval[1]) {
                    previousIntervals[1] = interval[1];
                }
            }
        }
        int [][]mergedIntervalArray = new int[mergedIntervals.size()][2];
        int currentIndex = 0;
        for(int []mergedInterval : mergedIntervals) {
            mergedIntervalArray[currentIndex++] = mergedInterval;
        }
        return mergedIntervalArray;
    }
}
