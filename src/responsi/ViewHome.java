/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

/**
 *
 * @author asus
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author PC
 */
public class ViewHome extends JFrame {
    public JButton btnKereta = new JButton("Daftar Kereta");
    public JButton btnTiket = new JButton ("Daftar Tiket");
    JLabel lblTitle = new JLabel ("HALAMAN AWAL STASIUN");
    JFrame frame = new JFrame("Tiket");
    
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 

    public ViewHome (){
        
      Container wadah = frame.getContentPane();
      wadah.setBackground(Color.decode("#cde9f4"));
       frame.setSize(400, 400);
      frame.setVisible(true);
      frame.setLayout(null);
  
      frame.setLocation(
    (screenSize.width - frame.getSize().width) / 2,
    (screenSize.height - frame.getSize().height) /2);

  
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        frame.add (lblTitle);
            lblTitle.setBounds(120,80,200,20);
        frame.add (btnKereta);
            btnKereta.setBounds(100,120,200,20);
        frame.add (btnTiket);
            btnTiket.setBounds(100,150,200,20);
 
}

 
    
}