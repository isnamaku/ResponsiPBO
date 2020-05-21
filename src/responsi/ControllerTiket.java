
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ControllerTiket {
ViewTiket view;
Model model;

    ControllerTiket(Model model, ViewTiket view) {
         this.view = view;
         this.model = model;
         
         if (model.getBanyakDataTiket() != 0) {
            String dataTiket[][] = (String[][]) model.readTiket();
            view.tabel.setModel((new JTable(dataTiket, view.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tiket Masih Kosong");
        }
        
              String[] kereta = model.readNamaKereta();
               view.keretaBox.setModel(new JComboBox (kereta).getModel());
              String [] stasiun = model.readNamaStasiun();
              view.stasiunBox.setModel(new JComboBox (stasiun).getModel());
          
    view.btnTambah.addActionListener(new ActionListener (){
             @Override
             public void actionPerformed(ActionEvent ae) {
                 String nama = view.getTfNama();
                 String gender = (String) view.genderBox.getSelectedItem(); 
                 String kereta = (String) view.keretaBox.getSelectedItem(); 
                 String stasiun = (String) view.stasiunBox.getSelectedItem(); 

                 
                 
                 model.insertTiket(nama, gender, stasiun, kereta);
                 String dataTiket[][] = (String[][]) model.readTiket();
                view.tabel.setModel(new JTable (dataTiket, view.namaKolom).getModel());
             }

    });
    
    view.btnEdit.addActionListener(new ActionListener (){
             @Override
             public void actionPerformed(ActionEvent ae) {
                int baris = view.tabel.getSelectedRow();
            
                String dataterpilih = (String)  view.tabel.getValueAt(baris, 0);
                String nama = (String)  view.tabel.getValueAt(baris, 1);
                String gender = (String)  view.tabel.getValueAt(baris, 2);
                String stasiun = (String)  view.tabel.getValueAt(baris, 3);
                String kereta = (String)  view.tabel.getValueAt(baris, 4);
                
                view.tfId.setText(dataterpilih);
                 view.tfNama.setText(nama);
                 view.tfNama.setEnabled(false);
                 view.genderBox.setSelectedItem(gender);
                 view.stasiunBox.setSelectedItem(stasiun);
                 view.keretaBox.setSelectedItem(kereta);
             

                String dataTiket[][] = (String[][]) model.readTiket();
                view.tabel.setModel(new JTable (dataTiket, view.namaKolom).getModel());
             }

    });
    
     view.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 int baris = view.tabel.getSelectedRow();
                 String dataterpilih = view.getTfId();
                 String nama = view.getTfNama();
                 String gender = (String) view.genderBox.getSelectedItem(); 
                 String kereta = (String) view.keretaBox.getSelectedItem(); 
                 String stasiun = (String) view.stasiunBox.getSelectedItem(); 
                 view.tfNama.setEnabled(false);
                 
              model.updateTiket(dataterpilih,nama,gender,stasiun,kereta);
 
                String dataKereta[][] = (String[][]) model.readTiket();
                view.tabel.setModel(new JTable (dataKereta, view.namaKolom).getModel());
            }
        } );
     
     
         view.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 int baris = view.tabel.getSelectedRow();
                String dataterpilih = (String) view.tabel.getValueAt(baris, 0);
               
                
                model.deleteTiket(dataterpilih);
  
                String dataTiket[][] = model.readTiket();
                view.tabel.setModel(new JTable (dataTiket, view.namaKolom).getModel());
            }
        } );
         
           view.btnkosong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                view.stasiunBox.setSelectedIndex(0);
                view.genderBox.setSelectedIndex(0);
                view.keretaBox.setSelectedIndex(0);
               view.tfNama.setText("");
          
        
                JOptionPane.showMessageDialog(null,"Berhasil di kosongkan");

                String dataKereta[][] = model.readTiket();
                 view.tabel.setModel(new JTable (dataKereta,  view.namaKolom).getModel());
            }
        } );
    view.btnKembali.addActionListener(new  ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
               view.frame.setVisible(false);
                MVCHome back = new MVCHome();
            }
        });
  
    
         
        
                  
                  
                
    }
    
}
