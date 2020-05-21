
package responsi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class ControllerKereta {
    Model modelkereta;
    ViewKereta viewkereta;
    public ControllerKereta(Model modelkereta, ViewKereta viewkereta) {
        this.modelkereta = modelkereta;
        this.viewkereta =  viewkereta;
        
         if (modelkereta.getBanyakData() != 0) {
            String dataKereta[][] = modelkereta.readKereta();
            viewkereta.tabel.setModel((new JTable(dataKereta, viewkereta.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Kereta Tidak Ada");
        }
         
          viewkereta.btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = viewkereta.getTfId();
                String nama = viewkereta.getTfNama();
                String kelas = viewkereta.getTfKelas();

                
                modelkereta.insertKereta(id,nama,kelas);

                String dataKereta[][] = modelkereta.readKereta();
                viewkereta.tabel.setModel(new JTable (dataKereta, viewkereta.namaKolom).getModel());
            }
        } );
            
          
           viewkereta.btnkosong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               viewkereta.tfId.setEnabled(true);
                viewkereta.tfId.setText("");
               viewkereta.tfNama.setText("");
                viewkereta.tfKelas.setText("");
        
                JOptionPane.showMessageDialog(null,"Berhasil di kosongkan");

                String dataKereta[][] = modelkereta.readKereta();
                 viewkereta.tabel.setModel(new JTable (dataKereta,  viewkereta.namaKolom).getModel());
            }
        } );
            
           
             viewkereta.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 int baris =  viewkereta.tabel.getSelectedRow();
                String id = (String)  viewkereta.tabel.getValueAt(baris, 0);
                String nama = (String)  viewkereta.tabel.getValueAt(baris, 1);
                String kelas = (String)  viewkereta.tabel.getValueAt(baris, 2);
               
              
                 viewkereta.tfId.setText(id);
                 viewkereta.tfId.setEnabled(false);
                 viewkereta.tfNama.setText(nama);
                 viewkereta.tfKelas.setText(kelas);
            
             

                String dataKereta[][] = modelkereta.readKereta();
                viewkereta.tabel.setModel(new JTable (dataKereta, viewkereta.namaKolom).getModel());
            }
        } );
            
               viewkereta.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 String id = viewkereta.getTfId();
                String nama = viewkereta.getTfNama();
                String kelas = viewkereta.getTfKelas();

              modelkereta.updateKereta(id,nama,kelas);
 
                String dataKereta[][] = modelkereta.readKereta();
                viewkereta.tabel.setModel(new JTable (dataKereta, viewkereta.namaKolom).getModel());
            }
        } );
          
       viewkereta.btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                 int baris = viewkereta.tabel.getSelectedRow();
                String dataterpilih = (String) viewkereta.tabel.getValueAt(baris, 0);
               
                
                modelkereta.deleteKereta(dataterpilih);
  
                String dataKereta[][] = modelkereta.readKereta();
                viewkereta.tabel.setModel(new JTable (dataKereta,viewkereta.namaKolom).getModel());
            }
        } );
       
       viewkereta.btnKembali.addActionListener(new  ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                viewkereta.frame.setVisible(false);
                MVCHome back = new MVCHome();
            }
        });
          
       
      
  
        
          
//          
//                   

    }


   


    
}
