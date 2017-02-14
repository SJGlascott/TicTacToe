/**
 * This class creates the window The game is played in.
 */
package project7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class gameWindow extends JFrame
{
    Game game;
    JButton hard;
    JButton easy;
    JButton ng;
    boolean cpuEasy;
    JLabel winner;
    JLabel welcome; 
    JPanel buttons; 
    JButton quit; 
    public static JLabel status; 
    
    public gameWindow()
    {
        JFrame p = new JFrame(); 
        p.setSize(525,600);
        p.setTitle("Tic Tac Toe");
        p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        welcome = new JLabel("Welcome to Tic Tac Toe"); 
        welcome.setHorizontalAlignment(SwingConstants.CENTER); 
        hard = new JButton("Hard");
        easy = new JButton("Play Again"); //old easy button
        ng = new JButton("New Game");
        quit = new JButton("Quit"); 
        game = new Game(); 
        cpuEasy = true;
        status = new JLabel("The final result will be here"); 
        status.setHorizontalAlignment(SwingConstants.CENTER); 
        buttons = new JPanel();
        
        //another buttons panel so flowlayout is used
        JPanel buttons2 = new JPanel(); 
        buttons.setLayout(new GridLayout(0,1));
        
        
        buttons2.add(easy); 
        buttons2.add(quit);
        
        final JPanel jp1 = new JPanel(); 
        //panel.setSize(200,200); 
        jp1.add(game); 
        p.add(jp1, BorderLayout.CENTER); 
        buttons.add(status);
        buttons.add(buttons2);
        //buttons.add(hard);
        
        p.add(buttons , BorderLayout.SOUTH);
        p.add(welcome, BorderLayout.NORTH); 
        
        
        /**
         * Listener for easy difficulty
         */
        class EasyButton implements ActionListener
        {

            public void actionPerformed(ActionEvent e) 
            {
                game.newGame();
                status.setText("The final result will be here");
                cpuEasy = true;
            }
            
        }
        /**
         * Quit button will exit the program. 
         */
        
        class QuitButton implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        }
        /**
         * Listener for Hard Difficulty
         */
        class HardButton implements ActionListener
        {

            public void actionPerformed(ActionEvent e) 
            {
                game.newGame();
                status.setText("The final result will be here");
                cpuEasy = false;
            }
            
        }
        /**
         * Mouse Listener for human's turn.
         */
        class MouseMotionListener implements MouseListener
        {
            
            
            public void mouseClicked(MouseEvent me) 
            {
                
                /*check x, y coordinates.. 
                Modify array and repaint. */
                
               
                int x = me.getX(); 
                int y = me.getY();
                
                            if(x<142 && y<142)
                                {
                                    System.out.println("Box1");
                                    if(game.getSymbol(0,0).equals(""))
                                    {
                                        game.setSymbol(0,0,1);
                                        if(cpuEasy)
                                            game.CPUEasy();
                                        else
                                            game.CPUHard();
                                    }

                                }                
                            else if(x<142 && y<281)
                                {
                                System.out.println("Box2");
                                if(game.getSymbol(0,1).equals(""))
                                {
                                    game.setSymbol(0,1,1); 
                                
                                    if(cpuEasy)
                                        game.CPUEasy();
                                    else
                                        game.CPUHard();
                                }


                                }
                            else if(x<142 && y<425)
                                {
                                System.out.println("Box3");     
                                if(game.getSymbol(0,2).equals(""))
                                {
                                    game.setSymbol(0,2,1); 

                                    if(cpuEasy)
                                        game.CPUEasy();
                                    else
                                        game.CPUHard();
                                }
                                
                                }
                            else if(x>142&&x<283 && y<142)
                                {
                                if(game.getSymbol(1,0).equals(""))
                                {
                                    game.setSymbol(1,0,1); 
                                   System.out.println("Box4");
                                   //game.setSymbol(1,0,1);
                                   if(cpuEasy)
                                       game.CPUEasy();
                                   else
                                       game.CPUHard();
                                }

                                
                                }
                             else if(x>142&&x<283 && y>142&&y<281)
                                {
                                 if(game.getSymbol(1,1).equals(""))
                                 {
                                        game.setSymbol(1,1,1); 
                                        System.out.println("Box5");
                                       //game.setSymbol(1,1,1); 
                                       if(cpuEasy)
                                           game.CPUEasy();
                                       else
                                           game.CPUHard();
                                 }

                                
                                }
                            else if(x>142&&x<283 && y>281)
                                {
                                 if(game.getSymbol(1,2).equals(""))
                                 {
                                     game.setSymbol(1,2,1); 
                                     System.out.println("Box6");
                                     //game.setSymbol(1,2,1); 
                                     if(cpuEasy)
                                        game.CPUEasy();
                                     else
                                        game.CPUHard(); 
                                 }
                                
                                }
                            else if(x>285 && y<142)
                             {
                                if(game.getSymbol(2,0).equals(""))
                                {
                                    game.setSymbol(2,0,1); 
                                    System.out.println("Box7"); 
                                    //game.setSymbol(2,0,1); 
                                    if(cpuEasy)
                                        game.CPUEasy();
                                    else
                                        game.CPUHard();
                                }
          
                                
                             }
                            else if(x>285 && y>141&&y<286)
                             {
                                if(game.getSymbol(2,1).equals(""))
                                {
                                    game.setSymbol(2,1,1); 
                                    System.out.println("Box8");
                                    //game.setSymbol(2,1,1); 
                                    if(cpuEasy)
                                        game.CPUEasy();
                                    else
                                        game.CPUHard();
                                }
                        
                                
                             }
                            else if(x>285 && y>281)
                             {
                                if(game.getSymbol(2,2).equals(""))
                                {
                                    game.setSymbol(2,2,1); 
                                    System.out.println("Box9"); 
                                    //game.setSymbol(2,2,1); 
                                    if(cpuEasy)
                                        game.CPUEasy();
                                    else
                                        game.CPUHard();
                                }
                      
                                
                             }                    
                                                    
                //System.out.println("The mouse is at ("+x+", "+y+")");
                //game.repaint(); 
                
            }

            @Override
            public void mousePressed(MouseEvent me){}
            @Override
            public void mouseReleased(MouseEvent me) {}
            @Override
            public void mouseEntered(MouseEvent me) {}            
            @Override
            public void mouseExited(MouseEvent me) {}
            
        
        }
    
         easy.addActionListener(new EasyButton());
         hard.addActionListener(new HardButton());
         game.addMouseListener(new MouseMotionListener());
         quit.addActionListener(new QuitButton());
         p.setVisible(true);
    }
}
