package prolabikideneme2;

	    
import java.io.File;
import java.util.List;

public class labirentANAKISIM {
public static long zaman;	
static long start;	

    public static void main(String[] args) throws Exception {
     
start=System.currentTimeMillis();
Labirent.atamacı();

	

	File maze1 = new File("C:\\Users\\murat\\OneDrive\\Masaüstü\\maze.txt");
         execute(maze1);
       
    }

    private static void execute(File file) throws Exception {
        Labirent maze = new Labirent(file);
        dfs(maze);
        bfs(maze); 
    }


     private static void bfs(Labirent maze) {
         BFSMazeSolver bfs = new BFSMazeSolver();
         List<coordinate> path = bfs.solve(maze);
         maze.printPath(path);
         
         
         //for(int i=0;i<path.)
    //  Labirent.yollarciz(maze.yukseklıkgetir(),maze.genislikgetir());
         
         maze.reset();
     }

	

    private static void dfs(Labirent maze) {
        DFSLEKISAYOLBULUCU dfs = new DFSLEKISAYOLBULUCU();
        List<coordinate> path = dfs.solve(maze);
        maze.printPath(path); 
         long end=System.currentTimeMillis();
    	long total=(-1)*((start-end)/1000);
    	System.out.println("total:"+total);
    	zaman=total;
        Labirent.yollarciz(maze.yukseklıkgetir(),maze.genislikgetir());
       
        maze.reset();
    }
}