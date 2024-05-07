/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.*;
import DTO.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class CTHoaDonView extends javax.swing.JPanel {
    
    private ArrayList<CtHoaDon> listct = new ArrayList<>();
    private ArrayList<CtHoaDon> listct2 = new ArrayList<>();
        private ArrayList<CtHoaDon> listct3 = new ArrayList<>();
    private ArrayList<HoaDon> listhd = new ArrayList<>();
    private ArrayList<sanPham> listsp = new ArrayList<>();
    
    
    private HoaDonBLL hdBLL = new HoaDonBLL();
    private CTHoaDonBLL cthdBLL = new CTHoaDonBLL();
    private SanPhamBLL spBLL = new SanPhamBLL(null);
    
    DefaultTableModel modelHD;
    DefaultTableModel modelCThd;
    
    private String mactspXet;
    private long thanhtiencthd;
    private int soluongcthd;
    private int soluongspmoi = 0;
    private int soluongmoiInt;
    private long thanhtiencthdmoi;
    
    private String tempMahd;
    
    public CTHoaDonView() {
        initComponents();
        
        listsp = spBLL.getALL();
        
        ma_hd.setEditable(false);
        ma_nv.setEditable(false);
        ngaytao_hd.setEditable(false);
        tt_hoadon.setEditable(false);
        ten_sp.setEditable(false);
        dongia_sp.setEditable(false);
        tt_sp.setEditable(false);
        
        modelHD = (DefaultTableModel) table_hd.getModel();
        modelHD.setColumnIdentifiers(new Object[]{
            "Mã hóa đơn" , "Mã khách hàng" , "Mã nhân viên" , "Ngày tạo" ,"Tổng tiền"
        });
        
        

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table_hd.getColumnModel().getColumnCount(); i++) {
            table_hd.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
            table_hd.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        modelCThd = (DefaultTableModel) table_cthd.getModel();
        modelCThd.setColumnIdentifiers(new Object[]{
            "Mã sản phẩm", "Tên sản phẩm", "Số lượng mua", "Đơn giá", "Thành tiền"
        });

        for (int i = 0; i < table_cthd.getColumnModel().getColumnCount(); i++) {
            table_cthd.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
            table_cthd.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRow = table_hd.getSelectedRow();

                    if (selectRow != -1) {
                        Object data1 = table_hd.getValueAt(selectRow, 0);
                        Object data3 = table_hd.getValueAt(selectRow, 2);
                        Object data4 = table_hd.getValueAt(selectRow, 3);
                        Object data5 = table_hd.getValueAt(selectRow, 4);

                        ma_hd.setText(data1.toString());
                        ngaytao_hd.setText(data4.toString());
                        ma_nv.setText(data3.toString());
                        tt_hoadon.setText(data5.toString());
                        
                        clearTableCThd();
                        getTableCThd((String) data1);
                        
                        tempMahd = (String) data1;
                        ten_sp.setText("");
                        dongia_sp.setText("");
                        soluong_sp.setText("");
                        tt_sp.setText("");
                    }
                }
            }
        };
        table_hd.addMouseListener(mouseAdapter);
        
        MouseAdapter mouseAdapterCT = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRow = table_cthd.getSelectedRow();

                    if (selectRow != -1) {
                        Object data1 = table_cthd.getValueAt(selectRow, 0);
                        Object data2 = table_cthd.getValueAt(selectRow, 1);
                        Object data3 = table_cthd.getValueAt(selectRow, 2);
                        Object data4 = table_cthd.getValueAt(selectRow, 3);
                        Object data5 = table_cthd.getValueAt(selectRow, 4);

                        ten_sp.setText(data2.toString());
                        dongia_sp.setText((String) data4.toString());
                        String soluongTxt = String.valueOf(data3);
                        soluong_sp.setText(soluongTxt);
                        String thanhtienTxt = String.valueOf(data5);
                        tt_sp.setText(thanhtienTxt);
                        
                        
                        mactspXet = (String) data1;
                        soluongcthd = (int) data3;
                        thanhtiencthd = (long) data5;
                    }
                }
            }
        };
        table_cthd.addMouseListener(mouseAdapterCT);
        
        
    }

    public void getTableHD() {
        listhd = hdBLL.getALL();
        try {
            for (HoaDon row : listhd) {
                modelHD.addRow(new Object[]{
                   row.getMahd() , row.getMakh() , row.getManv() , row.getNgaytao() , row.getTongtien()
                });
            }
            table_hd.setModel(modelHD);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void getTableCThd(String ma) {
        listct = cthdBLL.getALL2(ma);
        try {
            for (CtHoaDon row : listct) {
                modelCThd.addRow(new Object[]{
                   row.getMasp() , row.getTensp() , row.getSoluong() , row.getDongia() , row.getThanhtien()
                });
            }
            table_cthd.setModel(modelCThd);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void getTableCThd2(ArrayList<CtHoaDon> list) {
        try {
            for (CtHoaDon row : list) {
                modelCThd.addRow(new Object[]{
                   row.getMasp() , row.getTensp() , row.getSoluong() , row.getDongia() , row.getThanhtien()
                });
            }
            table_cthd.setModel(modelCThd);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void clearTableHD() {
        modelHD.setRowCount(0);
    }
    
    public void clearTableCThd() {
        modelCThd.setRowCount(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_hd = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_cthd = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        ma_hd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ma_nv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tt_hoadon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dongia_sp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        soluong_sp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tt_sp = new javax.swing.JTextField();
        btn_capnhat = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        ten_sp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ngaytao_hd = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Lịch Sử Hóa Đơn");

        table_hd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_hd.getTableHeader().setResizingAllowed(false);
        table_hd.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_hd);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Chi Tiết Hóa Đơn");

        table_cthd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table_cthd);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Mã hóa đơn:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setText("Nhân viên:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("Tổng tiền:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("Tên sản phẩm:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));
        jLabel7.setText("Đơn giá:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setText("Số lượng mua:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 0));
        jLabel9.setText("Thành tiền:");

        btn_capnhat.setBackground(new java.awt.Color(0, 51, 153));
        btn_capnhat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_capnhat.setText("Cập nhật SL");
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(153, 0, 0));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 0));
        jLabel10.setText("Ngày tạo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel9)
                        .addComponent(jLabel8)
                        .addComponent(jLabel7)
                        .addComponent(soluong_sp, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addComponent(tt_sp)
                        .addComponent(ten_sp)
                        .addComponent(tt_hoadon)
                        .addComponent(jLabel10)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_xoa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_capnhat)))
                    .addComponent(jLabel6)
                    .addComponent(dongia_sp, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ma_hd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                        .addComponent(ma_nv, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ngaytao_hd, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ma_hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ma_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ngaytao_hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addComponent(tt_hoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ten_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dongia_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soluong_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tt_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        CtHoaDon chitiet = null;
        listct2 = listct;
        for (CtHoaDon tmp : listct2) {
            if (tmp.getMasp().equals(mactspXet) && tmp.getSoluong() == soluongcthd && tmp.getThanhtien() == thanhtiencthd) {
                chitiet = tmp;
                System.out.println("đã tìm thấy");
                break;
            }
        }
        boolean remove = listct2.remove(chitiet);
        if (remove) {
            try {
                cthdBLL.delete(chitiet);
                for (sanPham sp : listsp) {
                    if (sp.getMasp().equals(mactspXet)) {
                        int soluonghientai = sp.getSoluong() - soluongcthd;
                        soluongspmoi = soluonghientai + soluongcthd;
                        System.out.println(soluongspmoi);
                        sanPham spmoi = new sanPham(mactspXet, soluongspmoi);
                        spBLL.updateSL(spmoi);
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            clearTableCThd();
            getTableCThd2(listct2);
            ten_sp.setText("");
            dongia_sp.setText("");
            soluong_sp.setText("");
            tt_sp.setText("");
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        CtHoaDon chitiet = null;
        String soluongmuamoi = soluong_sp.getText().trim();
        listct2 = listct;
        try {
            soluongmoiInt = Integer.parseInt(soluongmuamoi);
            System.out.println("Chuyển thành công");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng mua không hợp lệ");
            return;
        }
        
        if (soluongmoiInt == soluongcthd) {
            int confirm = JOptionPane.showConfirmDialog(this, "Số lượng vẫn như cũ , bạn có muốn tiếp tục ?");
            if (confirm == JOptionPane.YES_OPTION) {
                return;
            }
        }

        try {
            for (CtHoaDon tmp : listct2) {
                if (tmp.getMasp().equals(mactspXet) && tmp.getSoluong() == soluongcthd && tmp.getThanhtien() == thanhtiencthd) {
                    thanhtiencthdmoi = tmp.getDongia() * soluongmoiInt;
                    chitiet = tmp;
                    cthdBLL.updateSL(chitiet, soluongmoiInt , thanhtiencthdmoi);
                    System.out.println("đã tìm thấy");
                    break;
                }
            }
            for (sanPham sp : listsp) {
                if (sp.getMasp().equals(mactspXet)) {
                    soluongspmoi = sp.getSoluong() - (soluongmoiInt - soluongcthd);
                    System.out.println(soluongspmoi);
                    sanPham spmoi = new sanPham(mactspXet, soluongspmoi);
                    spBLL.updateSL(spmoi);
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        clearTableCThd();
        getTableCThd(tempMahd);
        ten_sp.setText("");
        dongia_sp.setText("");
        soluong_sp.setText("");
        tt_sp.setText("");
    }//GEN-LAST:event_btn_capnhatActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JTextField dongia_sp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField ma_hd;
    private javax.swing.JTextField ma_nv;
    private javax.swing.JTextField ngaytao_hd;
    private javax.swing.JTextField soluong_sp;
    private javax.swing.JTable table_cthd;
    private javax.swing.JTable table_hd;
    private javax.swing.JTextField ten_sp;
    private javax.swing.JTextField tt_hoadon;
    private javax.swing.JTextField tt_sp;
    // End of variables declaration//GEN-END:variables
}
