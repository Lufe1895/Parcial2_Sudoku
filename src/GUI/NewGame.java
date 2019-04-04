/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Objects.Matrix;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.BorderUIResource;

/**
 *
 * @author luisl
 */
public class NewGame extends JFrame{
    private JTextField [][]components = new JTextField[9][9];
    
    private JPanel [][]panels = new JPanel[9][9];
    private JPanel pnlCenter;
    private JPanel pnlSouth;
    
    private JButton btnFinish;
    private JButton btnCheck;
    private JButton btnQuit;
    
    private TitledBorder border;
    
    private Boolean fail;
    
    private Matrix sudoku;
    
    public NewGame(int random){
        
        //----------------------------------------------------------------------Definición de todas las funciones de la ventana
        super("Sudoku");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(880, 850);
        super.setVisible((true));
        pnlCenter = new JPanel(new GridLayout(9,9));
        super.setLayout(new BorderLayout());
        
        this.fail=false;
        
        border = new TitledBorder(new BorderUIResource.EtchedBorderUIResource(10,Color.BLACK,Color.BLACK));
        sudoku = new Matrix(random);
        
        //----------------------------------------------------------------------Inicialización de las variables y todo el pedo
        
        for (int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                this.panels[i][j] = new JPanel(new FlowLayout());
                this.panels[i][j].setBorder(border);
                
                this.components[i][j] = new JTextField(1);
                pnlCenter.add(this.panels[i][j]);
                if(this.sudoku.getBoxes()[i][j].getShow()){
                    this.components[i][j].setText(String.valueOf(this.sudoku.getBoxes()[i][j].getValue()));
                    this.components[i][j].setEditable(false);
                    this.components[i][j].setForeground(Color.RED);
                    this.sudoku.getBoxes()[i][j].setInput(this.sudoku.getBoxes()[i][j].getValue());
                }
                this.components[i][j].setFont(new Font("Bahnschrift",0,50));
                this.panels[i][j].add(this.components[i][j]);
                this.panels[i][j].setBackground(Color.LIGHT_GRAY);
            }
        }
        
        this.paintIt();
        
        super.add(pnlCenter,BorderLayout.CENTER);
        
        //----------------------------------------------------------------------Para el panel de los botones
        
        btnFinish = new JButton("Give Up!");
        btnCheck = new JButton("Check!");
        btnQuit = new JButton("Quit!");
        btnFinish.setSize(new Dimension(40,60));
        btnCheck.setSize(new Dimension(40,60));
        
        pnlSouth = new JPanel(new FlowLayout());
        pnlSouth.add(btnCheck,BorderLayout.WEST);
        pnlSouth.add(btnFinish,BorderLayout.EAST);
        pnlSouth.setPreferredSize(new Dimension(0,50));
        
        super.add(pnlSouth,BorderLayout.SOUTH);
        
        btnFinish.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                        sudoku.getBoxes()[i][j].setValue(sudoku.getBoxes()[i][j].getValue());
                        components[i][j].setText(String.valueOf(sudoku.getBoxes()[i][j].getValue()));
                        components[i][j].setEditable(false);
                    }
                    btnFinish.setVisible(false);
                    btnCheck.setVisible(false);
                    btnQuit.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            dispose();
                        } 
                    });
                    pnlSouth.add(btnQuit);
                }
            }
            
        });
        
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    fail=false;
                    for(int i=0;i<9;i++){
                        for(int j=0;j<9;j++){
                            sudoku.getBoxes()[i][j].setInput(Integer.valueOf(components[i][j].getText()));
                            if(!sudoku.getBoxes()[i][j].check()){
                                components[i][j].setBackground(Color.red);
                                fail=true;
                            }else if(!sudoku.getBoxes()[i][j].getShow()){
                                components[i][j].setBackground(Color.GREEN);
                                components[i][j].setEditable(false);
                            }
                        }
                    }
                    if(fail){
                        JOptionPane.showMessageDialog(null,"OOPS! You've made some mistakes","OOPS!",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"You are the WINNER!","CONGRATULATIONS!",JOptionPane.WARNING_MESSAGE);
                        btnCheck.setVisible(false);
                        btnFinish.setVisible(false);
                        btnQuit.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                dispose();
                            } 
                        });
                    pnlSouth.add(btnQuit);
                    }
                }catch(NumberFormatException d){
                    JOptionPane.showMessageDialog(null,"OOPS! Seems like you're missing some expresions.","OOPS!",JOptionPane.ERROR_MESSAGE);
                }
                
            }
            
        });
        
        //btnExit
    }
    
    private void paintIt(){
        this.panels[0][3].setBackground(Color.WHITE);
        this.panels[0][4].setBackground(Color.WHITE);
        this.panels[0][5].setBackground(Color.WHITE);
        this.panels[1][3].setBackground(Color.WHITE);
        this.panels[1][4].setBackground(Color.WHITE);
        this.panels[1][5].setBackground(Color.WHITE);
        this.panels[2][3].setBackground(Color.WHITE);
        this.panels[2][4].setBackground(Color.WHITE);
        this.panels[2][5].setBackground(Color.WHITE);
        this.panels[3][0].setBackground(Color.WHITE);
        this.panels[3][1].setBackground(Color.WHITE);
        this.panels[3][2].setBackground(Color.WHITE);
        this.panels[4][0].setBackground(Color.WHITE);
        this.panels[4][1].setBackground(Color.WHITE);
        this.panels[4][2].setBackground(Color.WHITE);
        this.panels[5][0].setBackground(Color.WHITE);
        this.panels[5][1].setBackground(Color.WHITE);
        this.panels[5][2].setBackground(Color.WHITE);
        this.panels[4][6].setBackground(Color.WHITE);
        this.panels[4][7].setBackground(Color.WHITE);
        this.panels[4][8].setBackground(Color.WHITE);
        this.panels[3][6].setBackground(Color.WHITE);
        this.panels[3][7].setBackground(Color.WHITE);
        this.panels[3][8].setBackground(Color.WHITE);
        this.panels[5][6].setBackground(Color.WHITE);
        this.panels[5][7].setBackground(Color.WHITE);
        this.panels[5][8].setBackground(Color.WHITE);
        this.panels[6][3].setBackground(Color.WHITE);
        this.panels[6][4].setBackground(Color.WHITE);
        this.panels[6][5].setBackground(Color.WHITE);
        this.panels[7][3].setBackground(Color.WHITE);
        this.panels[7][4].setBackground(Color.WHITE);
        this.panels[7][5].setBackground(Color.WHITE);
        this.panels[8][3].setBackground(Color.WHITE);
        this.panels[8][4].setBackground(Color.WHITE);
        this.panels[8][5].setBackground(Color.WHITE);
    }
}
