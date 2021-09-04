import java.util.ArrayList;
import java.util.List;

public class UniquePaths {

    public List<String> getAllPaths(int N) {
        List<String> allPaths = new ArrayList<>();
        traverseAllPaths(N, 0, 0, "", 0, 0, allPaths);
        return allPaths;
    }

    private void traverseAllPaths(int N, int x, int y,
                                  String pathSoFar,
                                  int previousX, int previousY,
                                  List<String> allPaths) {
        if (x == N || y == N) return;
        if (x > 0 && previousX == x - 1) {
            pathSoFar += "R";
        }
        if (y > 0 && previousY == y - 1) {
            pathSoFar += "D";
        }
        if (x == N - 1 && y == N - 1) {
            allPaths.add(pathSoFar);
            return;
        }
        traverseAllPaths(N, x + 1, y, pathSoFar, x, y, allPaths);
        traverseAllPaths(N, x, y + 1, pathSoFar, x, y, allPaths);
    }
}
