/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Objects.Matrix;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author luisl
 */
public class StartGame extends JFrame{
    private JPanel pnlNorth;
    private JPanel pnlCenter;
    private JPanel pnlSouth;
    private JPanel pnlInstruction;
    private JPanel pnlEasy;
    private JPanel pnlMedium;
    private JPanel pnlHard;
    private JPanel pnlEmpty;
    private JPanel pnlButton;
    
    private JLabel title;
    private JLabel lblInstruction;
    
    private JButton btnEasy;
    private JButton btnMedium;
    private JButton btnHard;
    private JButton btnExit;
    
    public StartGame(){
        super("Select Difficulty");//-------------------------------------------Definición de los parámetros de la ventana
        super.setVisible(true);
        super.setSize(400,400);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pnlNorth = new JPanel(new FlowLayout());//------------------------------Definición de la imagen de título
        ImageIcon fondo1 = new ImageIcon(getClass().getResource("../Images/Sudoku.png"));
        ImageIcon fondo2 = new ImageIcon(fondo1.getImage().getScaledInstance(400, 100, Image.SCALE_DEFAULT));
        title = new JLabel(fondo2);
        pnlNorth.add(title);
        pnlNorth.setPreferredSize(new Dimension(0,100));
        
        super.add(pnlNorth,BorderLayout.NORTH);
        
        pnlCenter = new JPanel(new GridLayout(4,1));//--------------------------Definición de la parte de los botones
        lblInstruction = new JLabel("Select Difficulty");
        lblInstruction.setFont(new Font("Bahnschrift",0,30));
        pnlInstruction=new JPanel(new FlowLayout());
        pnlInstruction.add(lblInstruction);
        pnlCenter.add(pnlInstruction);
        super.add(pnlCenter,BorderLayout.CENTER);
        
        pnlEasy=new JPanel(new FlowLayout());
        pnlMedium=new JPanel(new FlowLayout());
        pnlHard=new JPanel(new FlowLayout());
        
        btnEasy = new JButton("Easy");
        btnMedium = new JButton("Medium");
        btnHard = new JButton("Hard");
        pnlEasy.add(btnEasy);
        pnlMedium.add(btnMedium);
        pnlHard.add(btnHard);
        
        btnEasy.setPreferredSize(new Dimension(100,30));
        btnMedium.setPreferredSize(new Dimension(100,30));
        btnHard.setPreferredSize(new Dimension(100,30));
        
        pnlCenter.add(pnlEasy);
        pnlCenter.add(pnlMedium);
        pnlCenter.add(pnlHard);
        
        pnlSouth = new JPanel(new GridLayout(2,1));//------------------------------Definición del botón salir
        pnlEmpty = new JPanel();
        pnlSouth.setPreferredSize(new Dimension(0,100));
        super.add(pnlSouth,BorderLayout.SOUTH);
        btnExit = new JButton("Exit!");
        btnExit.setPreferredSize(new Dimension(100,30));
        pnlSouth.add(pnlEmpty);
        pnlButton = new JPanel(new FlowLayout());
        pnlButton.add(btnExit);
        pnlSouth.add(pnlButton);
        
        //----------------------------------------------------------------------Definición de las funciones
        btnEasy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new NewGame(70);
                    }
                });
            }
            
        });
        
        btnMedium.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new NewGame(45);
                    }
                });
            }
            
        });
        
        btnHard.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new NewGame(25);
                    }
                });
            }
            
        });
        
        btnExit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            
        });
    }
}
