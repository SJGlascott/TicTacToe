/**
 * Game Class:
 * This class had all the methods and logic for playing the game.
 */
package project7;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author crazytrain
 */
public class Game extends JPanel
{
    String[][] cells = new String[3][3];
    int[][] magicsquare = {{8,1,6},{3,5,7},{4,9,2}}; 
    //temp variable
    String winner = "";
    boolean playing = true;
    boolean player = true;
    int counter; 
    int setcount; //the number of times "set" has been called. 

    public Game()
    {
      
      counter = 0; 
      for(int i = 0; i<cells.length; i++)
       {
           for(int j = 0; j<3; j++)
           cells[i][j] = "";
       }
    }
    /**
     * Returns the winner string
     * @return String
     */
    public String getWinner(){return winner;}
    /**
     * Clears the board for a new game to be played.
     */
    public void newGame()
    {
        for(int i = 0; i<cells.length; i++)
       {
           for(int j = 0; j<3; j++)
           {
                cells[i][j] = "";
                setSymbol(i,j,2);
           }
       }
    }
    
    /**
     * An attempt at a hard level CPU
     */
    public void CPUHard()
    {
        counter++; 
        int step = 0;
        boolean cpuTurn = true;
        while(cpuTurn)
        {
            if(counter == 5)
            {
                break; 
            }
            
            
            if (step == 0)
            {
                if(cells[0][0].equals(""))
                {
                    step++;
                    setSymbol(0,0,0); 
                    cpuTurn = false;
                }
                else if(cells[0][2].equals(""))
                {
                    step++;
                    setSymbol(0,2,0);
                    cpuTurn = false;
                }
                else if(cells[2][0].equals(""))
                {
                    step++;
                    setSymbol(2,0,0);
                    cpuTurn = false;
                }
                else if(cells[2][2].equals(""))
                {
                    step++;
                    setSymbol(2,2,0);
                    cpuTurn = false;
                }
                else
                {
                    
                    step++;
                }
            
            }
            if(step == 2)
            {
                
            
                if(cells[0][0].equals("O") && cells[0][2].equals("O"))
                {
                    
                    setSymbol(0,1,0);
                    cpuTurn = false;
                }
                else if(cells[2][2].equals("O") && cells[0][2].equals("O"))
                {
                    
                    setSymbol(1,2,0);
                    cpuTurn = false;
                }
                else if(cells[2][0].equals("O") && cells[2][2].equals("O"))
                {   
                    
                    setSymbol(2,1,0);
                    cpuTurn = false;
                }
                else if(cells[0][0].equals("O") && cells[2][0].equals("O"))
                {   
                    
                    setSymbol(1,0,0);
                    cpuTurn = false;
                }
                else if(cells[0][0].equals("O")&& cells[2][2].equals("O"))
                {   
                    
                    setSymbol(1,1,0);
                    cpuTurn = false;
                }
                else if(cells[0][2].equals("O")&& cells[2][0].equals("O"))
                {   
                    
                    setSymbol(1,1,0);
                    cpuTurn = false;
                } 
                else
                    step--;
            }
        }
    }
    
        
    
    
    /**
     * CPUEASY creates a random number for coords and if the spot isnt taken
     * it draws its move.
     */
    public void CPUEasy()
    {
        int whitespace = 0; 
        for(int i = 0; i<3; i++)
        {
            for(int j = 0; j<3; j++)
            {
                if(cells[i][j].equals(""))
                {
                    whitespace++; 
                }
            }
        }
        counter++; 
        boolean cpuTurn = true;
        while(cpuTurn && whitespace>0)
        {
            System.out.println("Infinite!?>?");
            if(counter == 4)
            {
                //if()
                //break; 
            }
            
            int row = (int)(Math.random()*3);
            int col = (int)(Math.random()*3);
            
            if(cells[row][col].equals(""))
            {
                setSymbol(row,col,0);
                cpuTurn = false;
            }
        }
        if(whitespace == 0)
        {
            if(gameWindow.status.getText().
                    equals("The final result will be here"))
            {
                gameWindow.status.setText("Tie");
            }
        }
        
    }
    
    @Override
    public void paint(Graphics g)
    {

       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D)g; 
       //g2.drawString("John", 50, 50);
       
       //lines going down
       g2.drawLine(142, 0, 142, 425);
       g2.drawLine(284, 0, 284, 425);
       
       //draw lines going across
       g2.drawLine(0, 142, 425, 142);
       g2.drawLine(0, 284, 425, 284);
       
       //label the boxes
       
       g2.drawString(cells[0][0], 66, 63 ); 
       g2.drawString(cells[0][1], 66, 216 ); 
       g2.drawString(cells[0][2], 66, 357 ); 
       g2.drawString(cells[1][0], 200, 63 ); 
       g2.drawString(cells[1][1], 200, 216 ); 
       g2.drawString(cells[1][2], 200, 357 ); 
       g2.drawString(cells[2][0], 352, 63 ); 
       g2.drawString(cells[2][1], 352, 216 ); 
       g2.drawString(cells[2][2], 352, 357 ); 
       
       //temp stuff
       
       //g2.drawString(winner, 352, 357 ); 
      
    }
    
    
    /**
     * Gets the perferred size
     * @return dimension
     */
   public Dimension getPreferredSize()
    {
        
        return new Dimension(425,425);
    }
   
   
    /**
     * Getter used for getting the symbol at a location
     * @param where x 
     * @param where2 y 
     * @return X or O
     */
    public String getSymbol(int where, int where2)
    {
        
        return cells[where][where2];
    }
    
    /**
     * This methods places the symbol of who's turn it is onto the board.
     * It then sends a check to winner to see if it was a winning move.
     * @param where x-coord
     * @param where2 y-coord
     * @param pchuman whos trun it is. 0 = pc. 1 = human. 2 = clearing.
     */
    public void setSymbol(int where, int where2, int pchuman)
    {
            setcount++; 
            //checking for tie
        if(gameWindow.status.getText().equals(
                            "The final result will be here") && setcount != 10)
        {
            if(pchuman == 0)
                cells[where][where2] = "O"; 
            if(winnercheck(where, where2, "O") )
            {
                     winner = "The Computer Won";
                     gameWindow.status.setText(winner);
                     this.repaint();
            }
            else if(pchuman == 1)
            {
                cells[where][where2] = "X";
                this.repaint();
                
                if(winnercheck(where, where2, "X"))
                {
                       winner = "You Win!";
                       gameWindow.status.setText(winner);
                }
                
                
            }

        }
    else if(pchuman ==2)
        {
           cells[where][where2] = "";
           this.repaint();
        }
    }
    
    /**
     * The code scans through the array and logs where X's or O's have
     * been placed. If a winning move has been placed then it returns true.
     * @param row of the board
     * @param column of the board
     * @param xoro What is being placed at the given coords. X or O
     * @return True or False depending on if the past move was a winning move
     */

    public boolean winnercheck(int row, int column, String xoro)
    {
        
       // String XORO = xoro2; 
        //check horizontal
        int rowcount = 0; 
        int columncount = 0; 
        int rightdiag = 0; 
        int leftdiag = 0; 
        int j = 0; 
        int k = 2; 
        //probably not right usage of magic square, though I think it could be
        //used in a better algorithm, perhaps could be used for PC AI.
        //could probably just use a counter for x,o..
        for(int i = 0; i<3; i++)
        {
            //check the column
            if(xoro.equals(cells[row][i]))
            {
                rowcount +=magicsquare[row][i];
            }
            //check the row
            if(xoro.equals(cells[i][column]))
            {
                columncount += magicsquare[i][column]; 
            }
            //check diagonals
   
            if(xoro.equals(cells[i][j]))
                    leftdiag += magicsquare[i][j];
 
            if(xoro.equals(cells[i][k]))
                    rightdiag += magicsquare[i][j];
            j++; 
            k--;
            
        }
        return rowcount == 15 || columncount == 15 || 
                rightdiag == 15 || leftdiag == 15;
 
        
    }
}
