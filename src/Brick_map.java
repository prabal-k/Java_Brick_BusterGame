import java.awt.*;

public class Brick_map {
    int map[][];
    int width;
    int height;
    Brick_map()
    {
        map=new int[5][7];
        for(int i=0;i< map.length;i++)
        {
            for(int j=0;j<map[i].length;j++)
            {
                map[i][j]=1;                                                  //cOLLISION DETERMINE GARNA KO LAGI
            }
        }
        width=740/8;
        height=250/8;
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
                   g.setColor(Color.BLACK);
                   g.fillRect(j * width+90,i*height+50,width+20,height+20);

                   g.setStroke(new BasicStroke(3));
                   g.setColor(Color.white);
                   g.drawRect(j * width+90,i*height+50,width+20,height+20);
               }
            }
        }

    }

}
