import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.net.http.HttpClient.Redirect;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

class TileFrame extends JFrame implements ActionListener{
    
    
    private ArrayList<TilePanel>tileList; // creates an array list
	public TileFrame(){
       
        //frame settings
        setSize(600,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //creating jpanel and setting it to flowlayout
        JPanel randomizePanel = new JPanel();
        randomizePanel.setLayout(new FlowLayout());

        //creating jbutton and adding it to panel
        JButton randomizeButton = new JButton("Randomize!");
        randomizePanel.add(randomizeButton);
        randomizeButton.addActionListener(this);

        //creating border layout and passing that in
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(randomizePanel,  BorderLayout.SOUTH);
        
        //Grid 12 by 12
        JPanel grid = new JPanel();
        contentPane.add(grid, BorderLayout.CENTER);
        grid.setLayout(new GridLayout(12,12));

        tileList = new ArrayList<TilePanel>();

        for (int i = 0; i < 144; i ++){
            TilePanel tile = new TilePanel();
            grid.add(tile);
            tileList.add(tile);

        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        for( TilePanel tile: tileList){
            tile.SetRandomValue();   
            System.out.println(tile.toString());   
        }

        repaint();            
    }

    
    }

    



    


