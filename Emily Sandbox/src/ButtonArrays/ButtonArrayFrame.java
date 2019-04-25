package ButtonArrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hsa.TextInputFile;
import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.blue;
import static java.awt.Color.cyan;
import static java.awt.Color.green;
import static java.awt.Color.magenta;
import static java.awt.Color.orange;
import static java.awt.Color.red;
import static java.awt.Color.white;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Emily
 */
public class ButtonArrayFrame extends javax.swing.JFrame {
//declaration and initialization of global variables (buttons, labels, strings, fonts, and colour)
int size = 5;
JButton[][] jb = new JButton[size][size];
JButton[]props = new JButton[4];
JButton[]levels= new JButton[3];
JLabel[][] nums = new JLabel[2][size];
String [][] col = new String [size][size];
JLabel title = new JLabel();
JLabel instruct = new JLabel();
JLabel win = new JLabel();
String level = new String();
String text = " ";
Color colour = white;
Font cent = new Font ("Century Gothic",Font.BOLD,18);
Font comic = new Font ("Comic Sans", Font.PLAIN, 14);

    /**
     * Creates new form ButtonArrayFrame
     */

    //calls the methods that the program uses   
    public ButtonArrayFrame() {
        initComponents();
        setText();
        levelSelect();
        makeGrid();
        sideButtons();
        makeNumbers();
    }

    //method that places the text at the top of the program
    public void setText(){
        //sets text of the title label
        title.setText("Welcome to Super Nonograms!");
        //sets font and colour of the title label
        title.setFont(cent);
        title.setForeground(blue);
        //tells program where to add the title
        getContentPane().add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        //sets text, font, colour, and positioning of instruction label
        instruct.setText("Select a puzzle to play:");
        instruct.setFont(comic);
        instruct.setForeground(magenta);
        getContentPane().add(instruct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 35, -1, -1));
    }
    
    //method that places number labels around the grid
    public void makeNumbers(){
        //number of labels created and placed based off size of grid
        for(int i=0;i<size;i++){
            //label array is declared and initialized
            nums[0][i] = new JLabel();
            //labels are added/placed around the grid
            getContentPane().add(nums[0][i], new org.netbeans.lib.awtextra.AbsoluteConstraints(12, i*50+212, -1, -1));
            nums[1][i] = new JLabel();
            getContentPane().add(nums[1][i], new org.netbeans.lib.awtextra.AbsoluteConstraints(12 + (i+1)*50, 190, -1, -1));
        }
    }
    
    //method that allows user to select what level they want to play
    public void levelSelect(){
        for (int i=0; i<3; i++){
             //initialization and declaration of level select button array
             levels[i] = new JButton();
             //sets text of each button based on which button it is
             switch(i){
                 case 0 : levels[0].setText("Puzzle 1"); break;
                 case 1 : levels[1].setText("Puzzle 2"); break;
                 case 2 : levels[2].setText("Puzzle 3"); break;
             }
             //places buttons on program   
             getContentPane().add(levels[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(10+i*100, 10+100, -1, -1));
//when one of the level buttons are pressed            
 levels[i].addActionListener(new java.awt.event.ActionListener() {
     //method that runs the jButtonLevelAction method       
     public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLevelAction(evt);
            }
        });
            pack();
        }
    }
    
    //method that creates button grid
    public void makeGrid(){
        //loops run as many times as there are boxes on the grid
        for (int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                //declaration and initilization of grid buttons
                jb[i][j] = new JButton();
                //sets size, colour, and initial text of buttons
                jb[i][j].setSize(50, 50);
                jb[i][j].setBackground(colour);
                jb[i][j].setText(" ");
                //places/adds buttons at certain places
                getContentPane().add(jb[i][j], new org.netbeans.lib.awtextra.AbsoluteConstraints(10 + (j+1)*50, 10+i*50+200, -1, -1));
 //when a grid button is pressed
 jb[i][j].addActionListener(new java.awt.event.ActionListener() {
            //runs jButtonActionPerformed method
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
            }
            pack();
        }
    }
    
    //method that creates grid property changing buttons
    public void sideButtons(){
        //there are four button options
        for (int i=0; i<4; i++){
             //declaration and initialization of property button array
             props[i] = new JButton();
             //sets text of change property buttons based on how they change the appearance of the grid
             switch(i){
                 case 0 : props[0].setText("Blank"); break;
                 case 1 : props[1].setText("Shade"); break;
                 case 2 : props[2].setText("Star"); break;
                 case 3 : props[3].setText("Cross out"); break;
             }
             //places buttons   
             getContentPane().add(props[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(10 + 6*50, 10+i*50+200, -1, -1));
 //when property button pressed runs jButtonAction method            
 props[i].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAction(evt);
            }
        });
            pack();
        }
    }
    
    public void jButtonActionPerformed(java.awt.event.ActionEvent evt){
        //determines which button was pressed
        JButton source = (JButton)evt.getSource();
        //sets text and colour of grid button pressed (based off of last property button pressed)
        source.setText(text);
        source.setBackground(colour);
        //checks to see if puzzle is properly completed
        checkSolution();
    }
    
    public void jButtonAction(java.awt.event.ActionEvent evt){
        //determines which button was pressed
        JButton source = (JButton)evt.getSource();
        //changes properties based on button pressed (affects grid once specific grid button is pressed afterwards)
                if (source == props[0]){
                    text = (" ");
                    colour = (white);
                }
                else if(source == props[1]){
                    text = (" ");
                    colour=(black);
                }
                else if(source == props[2]){
                    text=("*");
                    colour=(white);
                }
                else if(source == props[3]){
                    text=("X");
                    colour=(white);
                }
            }
    
    public void jButtonLevelAction(java.awt.event.ActionEvent evt){
        //determines which button was pressed
        JButton source = (JButton)evt.getSource();
        //changes level based on button selected
        if(source==levels[0]){
            level = ("1");
        }
        else if(source==levels[1]){
            level = ("2");
        }
        else if(source == levels[2]){
            level = ("3");
        }
        //places new puzzle numbers on grid
        putNumbers();
        //clears grid
        clearGrid();
    }
    
    //method that clears grid
    public void clearGrid(){
        //gets rid of win message
        win.setText(" ");
        //sets all buttons in grid to white and gets rid of any text
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                jb[i][j].setBackground(white);
                jb[i][j].setText(" ");
            }
        }
    }
    
    //method that checks if solution is correct
    public void checkSolution(){ 
    //declaration of loop integers and initialization of correct boxes counter
    int i,j,correct=0;
    //inputs solutions file
    TextInputFile easyS = new TextInputFile("EasySolution.txt");
    //skips over first solution(s) based on level selected
    if(level.equals("2")){
        for(int x=0;x<size;x++){
            String row = easyS.readLine();
        }
    }
    else if(level.equals("3")){
        for(int x=0;x<(size*2);x++){
        String row = easyS.readLine();
    }
    }
    for(i=0;i<size;i++){
        //reads solution for that line
        String row = easyS.readLine();
        //separates solutions into a new array
        String [] delimRow = row.split(",");
        //numbers are entered into a new String array based on answers put into grid
        for(j=0;j<size;j++){
           if(jb[i][j].getBackground()==black){
               col[i][j]="1";
           }
           else{
               col[i][j]="0";
           }
           //if the answer in grid matches up with solution in file then correct counter goes up
           if(col[i][j].equals(delimRow[j])){
               correct++;
           }
           //when entire grid is correctly filled out
           if(correct==(size*size))
               //displays win message (text, font, colour, and position are set)
               win.setText("You win! Select another puzzle to play again :)");
           win.setFont(comic);
           win.setForeground(red);
            getContentPane().add(win, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        }
    }
    }
    
    //method that reads numbers to go around grid
    public void putNumbers(){
        //reads file based on level selected and places numbers in new array
        TextInputFile horizNums = new TextInputFile("EasyNumbersHorizontal.txt");
        TextInputFile vertNums = new TextInputFile("EasyNumbersVertical.txt");
        if(level.equals("2")){
            horizNums.readLine();
            vertNums.readLine();
        }
        else if(level.equals("3")){
            horizNums.readLine();
            horizNums.readLine();
            vertNums.readLine();
            vertNums.readLine();
        }
        String horizNumbers = horizNums.readLine();
        String [] delimHNums = horizNumbers.split(","); 
        String vertNumbers = vertNums.readLine();
        String [] delimVNums = vertNumbers.split(","); 
        for(int i=0;i<size;i++){
            //assigns read numbers in arrays to labels around grid
            nums[0][i].setText(delimHNums[i]);
            nums[1][i].setText(delimVNums[i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ButtonArrayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ButtonArrayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ButtonArrayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ButtonArrayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ButtonArrayFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
