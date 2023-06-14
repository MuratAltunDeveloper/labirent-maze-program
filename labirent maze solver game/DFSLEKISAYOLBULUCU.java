package prolabikideneme2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSLEKISAYOLBULUCU {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<coordinate> solve(Labirent maze) {
        List<coordinate> path = new ArrayList<>();
        if (explore(maze, maze.getEntry()
            .getX(),
            maze.getEntry()
                .getY(),
            path)) {
            return path;
        }
        return Collections.emptyList();
    }

    private boolean explore(Labirent maze, int row, int col, List<coordinate> path) {
    	int bakıcı=0;
        if (!maze.gecerlikonum(row, col,bakıcı) || maze.isWall(row, col) || maze.isExplored(row, col)) {
            return false;
        }

        path.add(new coordinate(row, col));
        maze.setVisited(row, col, true,maze.yukseklıkgetir(),maze.genislikgetir());

        if (maze.isExit(row, col)) {
            return true;
        }

        
        for (int[] direction : DIRECTIONS) {
            coordinate coordinate = getNextCoordinate(row, col, direction[0], direction[1]);
            if (explore(maze, coordinate.getX(), coordinate.getY(), path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    private coordinate getNextCoordinate(int satır, int sutun, int i, int j) {
        return new coordinate(satır+ i+0,sutun + j+0);
    }
}
