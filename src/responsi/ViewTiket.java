/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class ViewTiket extends JFrame{
         JLabel lTitle = new JLabel ("Data Tiket");
        JLabel lTitle2 = new JLabel ("Daftar Tiket");
        JLabel lNama = new JLabel ("Nama");
        JLabel lGender = new JLabel ("Jenis Kelamin");
        JLabel lStasiun = new JLabel ("Stasiun Tujuan");
        JLabel lKereta = new JLabel ("Kereta");
        
        

        
        JTextField tfNama = new JTextField ();
        JTextField tfId = new JTextField ();

        JFrame frame = new JFrame("Tiket");

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        JButton btnTambah = new JButton("Tambah");
        JButton btnHapus = new JButton("Hapus");
        JButton btnEdit = new JButton ("Edit Tiket");
        JButton btnUpdate = new JButton ("Update");
        JButton btnkosong = new JButton ("Batal");
        JButton btnKembali = new JButton ("Kembali");
        
        JTable tabel;
        DefaultTableModel tableModel;
        JScrollPane scrollPane;  //buat scroll
        String gender[] = {"Pria","Wanita"};
  
        JComboBox genderBox = new JComboBox<String>(gender); 
        
        JComboBox keretaBox = new JComboBox<String>(); 
        JComboBox stasiunBox = new JComboBox<String>(); 
        Object namaKolom[] = {"Id Tiket","Nama","Janis Kelamin ","Stasiun Tujuan","Kereta"}; //membuat kolom dalam array

    
    public ViewTiket () {
        tableModel = new DefaultTableModel(namaKolom,0); //0 baris
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        

 
      
      Container wadah = frame.getContentPane();
      wadah.setBackground(Color.decode("#cde9f4"));
// 
      frame.setSize(800, 800);
      frame.setVisible(true);
      frame.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      

             frame.setLocation(
    (screenSize.width - frame.getSize().width) / 2,
    (screenSize.height - frame.getSize().height) /2);

        
        
       frame.add(scrollPane);
        scrollPane.setBounds(20, 260, 700, 400);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tabel.setBackground(Color.WHITE);
       
      
        frame.add(lTitle);
            lTitle.setBounds(290, 15, 200, 20);
        frame.add(lTitle2);    
        lTitle2.setBounds(290, 220, 200, 20);
        frame.add(lNama);
        lNama.setBounds(10, 50, 90, 20);
                frame.add(tfNama);
                    tfNama.setBounds(220, 50, 200, 20);
         frame.add(tfId);
            tfId.setBounds(220, 50, 200, 20);
        frame.add(lGender);
             lGender.setBounds(10, 80, 200, 20);
                frame.add(genderBox);
                    genderBox.setBounds(220, 80, 200, 20);
        frame.add(lKereta);
            lKereta.setBounds(10, 140, 200, 20);
                frame.add(keretaBox);
                    keretaBox.setBounds(220, 140, 200, 20);
        frame.add(lStasiun);
            lStasiun.setBounds(10, 110, 200, 20);
                frame.add(stasiunBox);
                    stasiunBox.setBounds(220, 110, 200, 20);
                    
                    
                    
        frame.add(btnTambah);
        btnTambah.setBounds(550, 50, 100, 20);
//      
        frame.add(btnHapus);
        btnHapus.setBounds(550, 80, 100, 20);
        
        frame.add(btnEdit);
        btnEdit.setBounds(550, 110, 100, 20);
        
        frame.add(btnUpdate);
        btnUpdate.setBounds(550, 140, 100, 20);
        
        frame.add(btnkosong);
        btnkosong.setBounds(550, 170, 100, 20);
         frame.add (btnKembali);   
         btnKembali.setBounds(550,200,100,20);
        }
    
   
     public String getTfNama() {
        return tfNama.getText();
    }
     
        public String getTfId() {
        return tfId.getText();
    }

    private void setLayoutBackground(Color BLUE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  

  
    
}


