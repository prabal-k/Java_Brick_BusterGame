import java.awt.*;

public class Brick_map {
    int map[][];
    int width;
    int height;
    Brick_map()
    {
        map=new int[4][9];
        for(int i=0;i< map.length;i++)
        {
            for(int j=0;j<map[i].length;j++)
            {
                map[i][j]=1;                                                  //COLLISION DETERMINE GARNA KO LAGI
            }
        }
        width=740/10;
        height=400/10;
    }

    //BRICKS DRAW GARNA KO LAGI

    public void draw(Graphics2D g)
    {

        for(int i=0;i< map.length;i++)
        {
            for(int j=0;j<map[0].length;j++)
            {
               if( map[i][j]>0)
               {
                //   g.setColor(Color.BLACK);
                   g.setColor(Color.cyan);
                   g.fillRect(j * width+80,i*height+80,width,height);

                   g.setStroke(new BasicStroke(3));
                   g.setColor(Color.BLACK);
                   g.drawRect(j * width+80,i*height+80,width,height);
               }
            }
        }

    }

    public void Brickscount(int val,int row,int col)
    {
        map[row][col]=val;
    }


}
