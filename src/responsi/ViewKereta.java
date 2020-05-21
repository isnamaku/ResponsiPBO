
package responsi;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;


public class ViewKereta extends JFrame {
       JLabel lTitle = new JLabel ("Data Kereta");
        JLabel lTitle2 = new JLabel ("Daftar Kereta");
        JLabel lId = new JLabel ("ID Kereta");
        JLabel lNama = new JLabel ("Nama Kereta");
        JLabel lKelas = new JLabel ("Kelas");
        
        JFrame frame = new JFrame("Kereta");
        
        JTextField tfId = new JTextField ();
        JTextField tfNama= new JTextField ();
        JTextField tfKelas = new JTextField ();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        JButton btnTambah = new JButton("Tambah");
        JButton btnHapus = new JButton("Hapus");
        JButton btnEdit = new JButton ("Edit");
        JButton btnUpdate = new JButton ("Update");
        JButton btnkosong = new JButton ("Batal");
        JButton btnKembali = new JButton ("Kembali");
        
        JTable tabel;
        DefaultTableModel tableModel;
        JScrollPane scrollPane;  //buat scroll
        Object namaKolom[] = {"ID","Nama Kereta ","Kelas"}; //membuat kolom dalam array
    
    public ViewKereta () {
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
      
         frame.add(lTitle);
            lTitle.setBounds(290, 15, 200, 20);
         frame.add(lTitle2);    
        lTitle2.setBounds(290, 220, 200, 20);
         frame.add(lId);
        
            lId.setBounds(10, 50, 90, 20);
                 frame.add(tfId);
                    tfId.setBounds(220, 50, 200, 20);
         frame.add(lNama);
             lNama.setBounds(10, 80, 200, 20);
                 frame.add(tfNama);
                    tfNama.setBounds(220, 80, 200, 20);
        frame. add(lKelas);
            lKelas.setBounds(10, 110, 200, 20);
                 frame.add(tfKelas);
                    tfKelas.setBounds(220, 110, 200, 20);
  
         frame.add(btnTambah);
        btnTambah.setBounds(550, 50, 120, 20);
//      
         frame.add(btnHapus);
        btnHapus.setBounds(550, 80, 120, 20);
        
         frame.add(btnEdit);
        btnEdit.setBounds(550, 110, 120, 20);
        
         frame.add(btnUpdate);
        btnUpdate.setBounds(550, 140, 120, 20);
        
         frame.add(btnkosong);
        btnkosong.setBounds(550, 170, 120, 20);
          frame.add (btnKembali);   
         btnKembali.setBounds(550,200,120,20);
        }
    
   
    

    public String getTfId() {
        return tfId.getText();
    }

    public String getTfNama() {
        return tfNama.getText();
    }

    public String getTfKelas() {
        return tfKelas.getText();
    }

  
    
}
