public class RotatedSortedArrayPivot {

    private int findPivot(int[] a, int startIndex, int endIndex) {
        if (startIndex > endIndex) return -1;
        if (startIndex == endIndex) return startIndex;
        int midIndex = (startIndex + endIndex) / 2;
        if (midIndex > startIndex && a[midIndex] < a[midIndex - 1])
            return midIndex - 1;
        if (midIndex < endIndex && a[midIndex] > a[midIndex + 1])
            return midIndex;
        if (a[startIndex] >= a[midIndex])
            return findPivot(a, startIndex, midIndex - 1);
        return findPivot(a, midIndex + 1, endIndex);
    }
}
