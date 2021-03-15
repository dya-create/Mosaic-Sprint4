import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.util.Random;

public class TilePanel extends JPanel {

    public int red;
    public int green;
    public int blue;
    public String letter; 


    // getters setters
    public int getRed(){return red;}

    public void setRed(int red){this.red =red;}

    public int getGreen(){return green;}

    public void setGreen(int green){this.green =green;}

    public int getBlue(){return blue;}

    public void setBlue(int blue){this.blue =blue;}

    public String getLetter(){return letter;}

    public void setLetter(int letter){this.letter =letter;}

    // non default constructor
    public TilePanel(int red, int green, int blue){
        this.red = red;
        this.blue = blue;
        this.green = green;
    }
    

    // default constuctor
    TilePanel(){
        super();
        SetRandomValue();
    }

    
    final public void SetRandomValue()
    {
        red = RandomNumberBetween(0,255);
        green = RandomNumberBetween(0,255);
        blue = RandomNumberBetween(0,255);
    }

    // teach tile to paint 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int panelWidth = getWidth();
        int panelHeight = getHeight();
        g.setColor(new Color(red,green,blue));

        // fill rect if 1 oterwise fill circle
        if(RandomNumberBetween(0,1)==1)
            g.fillRect(0,0,panelWidth, panelHeight);
        else
            g.fillOval(0,0,panelWidth-0,panelHeight-0);
        
        g.setColor(new Color(ContrastingColor(red),ContrastingColor(green),ContrastingColor(blue)));
        

        //setting font and stle to write the letters on screen
        final int fontSize =20;
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN,fontSize));
       
        int stringX = (panelWidth/2)-5;
        int stringY = (panelWidth/2)+5;

        // get random capital letters from A to Z
        g.drawString(String.valueOf(RandomNumberBetween(65,90)), stringX, stringY);
        
   }

    // getting constratsing Color
    private static int ContrastingColor(int colorIn){
        return((colorIn +128)%256);

    }
    
    // method that returns random numbers
    private static char RandomNumberBetween(int min, int max){
        Random random = new Random();
        return (char)(min+random.nextInt(max-min+1));
        
    }

    @Override
    public String toString(){

        return"Tile{" + "Red:" +getRed()+ "," + "Blue:"+ getBlue()+","+"Green:"+getGreen()+"}";}
         
        


}
