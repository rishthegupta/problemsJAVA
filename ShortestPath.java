import java.util.Scanner;

class ShortestPath
{
    
    //utility function to calculate minimum of 3
    static int min(int x, int y, int z)
    {
        if(x<y && y<z)
            return x;
        else if(y<x && x<z)
                return y;
            else 
                return z;
        
    }
    
    //This function will generate a matrix of the shortest distance form (0,0)

    static int shortestPath(int cost[][], int m, int n,int di, int dj)
    {
        int temp[][]=new int[m][n];
        int i,j;
        m=m-1;
        n=n-1;
        

        temp[0][0]=cost[0][0];
        for(i=1;i<=m;i++)
            temp[i][0]=temp[i-1][0]+cost[i][0];

        for(j=1;j<=n;j++)
            temp[0][j]=temp[0][j-1]+cost[j][0];

        for(i=1;i<=m;i++)
        {
            for(j=1;j<=n;j++)
            {
                temp[i][j]=min(cost[i-1][j-1],cost[i-1][j],cost[i][j-1]) + cost[i][j];
            }
        }
        

        return temp[di][dj];

    }
    
    
    public static void main(String args[])
    {
        int r,c,i,j,di,dj,op;
        
        System.out.println("enter the num of rows and columns ");
        Scanner scan =new Scanner(System.in);
        r=scan.nextInt();
        c=scan.nextInt();
        int cost[][]=new int[r][c];

        System.out.println("Enter the cost of every hop");
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                cost[i][j]=scan.nextInt();
            }
        }

        System.out.println("this is your cosr matrix");
        for(i=0;i<r;i++)
        {
            for(j=0;j<c;j++)
            {
                System.out.print(" "+cost[i][j]);
            }
            System.out.println();
        }

        System.out.println("enter the value of row and column you wannna reach");
        di=scan.nextInt();
        dj=scan.nextInt();

        op=shortestPath(cost,r,c,di,dj);

        System.out.print("Shortest distance is "+op);





    }
}