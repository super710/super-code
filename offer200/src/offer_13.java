import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Jinshihong
 * @Date 2020/11/11 10:08
 * @Version 1.0
 */
public class offer_13 {
    public int movingCount(int m, int n, int k) {

        boolean[][] visited=new boolean[m][n];
        return DFS(0,0,m,n,k,visited);



    }
    int DFS(int i,int j,int m,int n,int k,boolean[][] visited){
        if (i<0||i>=m||j<0||j>=n||count(i,j)>k||visited[i][j])
            return 0;
//        访问过的就不能+1了
        visited[i][j]=true;
        return 1+DFS(i+1,j,m,n,k,visited)+DFS(i-1,j,m,n,k,visited)
               +DFS(i,j-1,m,n,k,visited)+DFS(i,j+1,m,n,k,visited);


    }

    public int movingCount2(int m, int n, int k) {
        if(k==0) return 1;
        Queue<int[]> queue=new LinkedList<>();
        int[] dx={0,1};
        int[] dy={1,0};
        boolean[][] vis=new boolean[m][n];
        queue.offer(new int[]{0,0});
        int ans=1;
        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int x=cell[0],y=cell[1];
            for (int i=0;i<2;i++){
                int tx=dx[i]+x;
                int ty=dy[i]+y;
                if (tx<0||tx>=m||ty<0||ty>=n||vis[tx][ty]||count(tx,ty)>k){
                    continue;
                }
                queue.offer(new int[]{tx,ty});
                vis[tx][ty]=true;
                ans++;
            }

        }
        return ans;


    }



    int count(int m,int n){
        int sum=0;
        while(m!=0){
            sum+=m%10;
            m/=10;
        }
        while(n!=0){
            sum+=n%10;
            n/=10;
        }
        return sum;

    }




}
