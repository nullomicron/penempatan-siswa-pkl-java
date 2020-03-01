package aplikasi;

import java.awt.Component;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public final class tampilan_pemilihan extends javax.swing.JFrame {

    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection con = Koneksi.Koneksi();
    tampilan_penerimaan t = new tampilan_penerimaan();
    
    public tampilan_pemilihan() {
        initComponents();
        tampilDataPKL();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cTempatPKL = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        btnProses = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        cTempatPKL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silahkan pilih tempat pkl anda  :" }));

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("SILAHKAN PILIH TEMPAT PKL ANDA  :");

        btnProses.setText("PROSES");
        btnProses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProsesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(cTempatPKL, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(258, 258, 258)
                        .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel18)
                .addGap(74, 74, 74)
                .addComponent(cTempatPKL, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE)
                .addComponent(btnProses, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(670, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void tampilDataPKL() {
        try {
          st = con.createStatement();
          rs = st.executeQuery("SELECT nama_tempat FROM tb_tempat");
          
          while (rs.next()) {
              cTempatPKL.addItem(rs.getString("nama_tempat"));
          }
      } catch(SQLException e) {
          
      }
    }
    
    public void pilihanTempat() {
        String kode = Session.getKode_tempat();
        String nama = (String) cTempatPKL.getSelectedItem();
        String jurusan = Session.getJurusan();
        String alamat = Session.getAlamatPKL();
        
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM tb_tempat WHERE nama_tempat='" + nama + "'");
            
            while (rs.next()) {
                kode = rs.getString("kode_tempat");
                nama = rs.getString("nama_tempat");
                alamat = rs.getString("alamat");
                jurusan = rs.getString("jurusan");
            }
            
            rs.last(); //mengecek jumlah baris pada hasil query
            if (rs.getRow()==1){
                Session.setKode_tempat(kode);
                Session.setNama_tempat(nama);
                Session.setAlamatPKL(alamat);
                Session.setJurusan(jurusan);
            }
            
        } catch(SQLException e) {
            
        }
    }

    public void judul() {
        Object[] judul = {
            "Nama","NIS","Jurusan","Alamat","Tempat PKL","Alamat PKL"
        };
        tabModel = new DefaultTableModel(null, judul);
        t.tbSiswa.setModel(tabModel);
    }
    
    public void insertPilihan() {
        try {
            
            st = con.createStatement();
            st.executeUpdate("INSERT INTO tb_penerimaan(nama,nis,jurusan,alamat,tempat,alamat_pkl) VALUES('"
                                                              + Session.getNama()
                                                              + "','" + Session.getNis()
                                                              + "','" + Session.getJurusan() + "','" 
                                                              + Session.getAlamat() + "','" 
                                                              + Session.getNama_tempat() + "','"
                                                              + Session.getAlamatPKL() + "')");
            JOptionPane.showMessageDialog(null, Session.getNama() + " kamu diterima");
            
            
        } catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Sudah terdaftar di tempat lain");
        }
    }
    
    public void tampilkanData() {
        try {
            st = con.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tb_penerimaan WHERE nis = " + Session.getNis());
            
            while (rs.next()) {
                Object[] data = {
                    rs.getString("nama"),
                    rs.getString("nis"),
                    rs.getString("jurusan"),
                    rs.getString("alamat"),
                    rs.getString("tempat"),
                    rs.getString("alamat_pkl")
                };
                
                tabModel.addRow(data);
                sesuaikanKolom();
            }
            
        } catch(SQLException e) {
            
        }
        
    }
    
    public void sesuaikanKolom() {
	        //cara untuk menyesuaikan kolom dari tabel adalah mengambil
	        // lebar kolom yang ada kemudian sesuaikan
	        TableColumnModel modelKolom = t.tbSiswa.getColumnModel();

	        for (int kol = 0; kol < modelKolom.getColumnCount(); kol++) {
	            int lebarKolomMax = 0;
	            for (int baris = 0; baris < t.tbSiswa.getRowCount(); baris++) {
	                TableCellRenderer rend = t.tbSiswa.getCellRenderer(baris, kol);
	                Object nilaiTablel = t.tbSiswa.getValueAt(baris, kol);
	                Component comp = rend.getTableCellRendererComponent(t.tbSiswa, nilaiTablel, false, false, baris, kol);
	                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
	            }//akhir for baris
	            TableColumn kolom = modelKolom.getColumn(kol);
	            kolom.setPreferredWidth(lebarKolomMax);
	        }//akhir for kolom
    }
    
    private void btnProsesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProsesActionPerformed
        
        pilihanTempat();
        insertPilihan();
        judul();
        tampilkanData();
       
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnProsesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProses;
    private javax.swing.JComboBox<String> cTempatPKL;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
