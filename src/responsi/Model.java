
package responsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.Debug.id;


public class Model {
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/db_stasiun";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public Model (){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
     //   ------------------INSERT DATA SECTION---------------------------------    
        public void insertKereta(String id, String nama, String kelas){
        try {
           String query = "INSERT INTO `kereta`(`id`, `nama`, `kelas`) VALUES ('"+id+"','"+nama+"','"+kelas+"')";
           statement = (Statement) koneksi.createStatement();
           statement.executeUpdate(query); 
            System.out.println("Kereta Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Kereta Berhasil ditambahkan");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
        
         public void insertTiket(String nama, String gender, String stasiun, String kereta){
        try {
                   statement = (Statement) koneksi.createStatement();   

            if (getBanyakDataTiket()<=0){
                Random r = new Random();
                char c = (char)(r.nextInt(26) + 'a');
              
               String query = "INSERT INTO `tiket`(`id`, `nama`, `gender`, `stasiun`, `kereta`) VALUES ('"+c+"','"+nama+"','"+gender+"','"+stasiun+"','"+kereta+"')";
                 statement.executeUpdate(query); 
            }else {
               
//                   String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//                   String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//                    String fullalphabet = alphabet + alphabet.toLowerCase() + "123456789";
//                    Random random = new Random();
//
//                    char code = fullalphabet.charAt(random.nextInt(9));
                            RandomString a= new RandomString();
                              String kode =  a.getRandom();
                         String query = "INSERT INTO `tiket`(`id`, `nama`, `gender`, `stasiun`, `kereta`) VALUES ('"+kode+"','"+nama+"','"+gender+"','"+stasiun+"','"+kereta+"')"; 
               statement.executeUpdate(query); 
            }
            
            System.out.println("Tiket Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Tiket Berhasil ditambahkan");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
          //   ------------------ END OF READ DATA SECTION---------------------------------  



         
         public class RandomString {
    private char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
    private StringBuilder stringBuilder = new StringBuilder();
    private Random random = new Random();
    private String output;

    public String getRandom() {
        for (int lenght = 0; lenght < 10; lenght++) {
            Character character = chars[random.nextInt(chars.length)];
            stringBuilder.append(character);
        }
        output = stringBuilder.toString();
        stringBuilder.delete(0, 10);

        return output;
    }
}
        
  //   ------------------ READ DATA SECTION---------------------------------   
    public String[][] readKereta(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][3];
            
            String query = "Select * from`kereta`"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("id"); 
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("kelas"); 

         
                jmlData++; 
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
     public String[][] readTiket(){
        try{
            int jmlData = 0;
                        
            
            String data[][] = new String[getBanyakDataTiket()][5];
            
            String query = "Select * from`tiket`"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                data[jmlData][0] = resultSet.getString("id");
                data[jmlData][1] = resultSet.getString("nama"); 
                data[jmlData][2] = resultSet.getString("gender"); 
                data[jmlData][3] = resultSet.getString("stasiun"); 
                data[jmlData][4] = resultSet.getString("kereta"); 

         
                jmlData++; 
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
     public String[] readNamaKereta(){
        try{
            int jmlData = 0;
            
            String data[] = new String[getBanyakData()];
            
            String query = "Select * from`kereta`"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                
                data[jmlData] = resultSet.getString("nama"); 
                 
                jmlData++; 
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
     public String[] readNamaStasiun(){
        try{
            int jmlData = 0;
            
            String data[] = new String[getBanyakDataStasiun()];
            
            String query = "Select * from`stasiun`"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                
                data[jmlData] = resultSet.getString("stasiun"); 
                 
                jmlData++; 
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
     
     //   ------------------ END OF READ DATA SECTION---------------------------------     
     
     
//   ------------------COUNT SECTION--------------------------------- 
     
      public int getBanyakDataTiket(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `tiket`"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
      
       public int getBanyakDataStasiun(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `stasiun`"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `kereta`"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
 //-------------------------------END COUNT SECTION------------------------------- 
    
     public void deleteKereta (String dataterpilih) {
        try{
            String query = "DELETE FROM `kereta` WHERE `id` = '"+dataterpilih+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Kereta dengan id " +dataterpilih + " berhasil dihapus ");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
      
    void deleteTiket(String dataterpilih) {
         try{
            String query = "DELETE FROM `tiket` WHERE `id` = '"+dataterpilih+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Tiket dengan id " +dataterpilih + " berhasil dihapus ");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    
     
      //-------------------------------UPDATE SECTION------------------------------- 
    
      void updateKereta(String id, String nama, String kelas) { 
             try{
            String query = " UPDATE `kereta` set nama= '"+nama+"',kelas = '"+kelas+"' where id='"+id+"'";
            
            statement = koneksi.createStatement();
           
            statement.executeUpdate(query);
         
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
           
    }
     
  
    void updateTiket( String dataterpilih,String nama, String gender, String stasiun, String kereta) {
        

           try{
           
               System.out.println(dataterpilih);
            String query = " UPDATE `tiket` set gender = '"+gender+"',stasiun = '"+stasiun+"',kereta = '"+kereta+"' where id = '"+dataterpilih+"' ";
            
            statement = koneksi.createStatement();
           
            statement.executeUpdate(query);
         
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
       

        

         
     }
}
