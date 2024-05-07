package GUI;


import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import DTO.*;
import BLL.*;
import java.util.*;
import javax.swing.*;


public class doanhthu extends javax.swing.JPanel {
    private DefaultTableModel modelhd;
    private DefaultTableModel modelpn;
    private ArrayList<HoaDon> listhd = new ArrayList<>();
    private ArrayList<PhieuNhap> listpn = new ArrayList<>();
    private doanhthuBLL dtBLL = new doanhthuBLL();
    
    private String thangtmp1 , thangtmp2 , namtmp;
    private int namxetInt;
    private long[] tongthu = new long[500] ;
    private long[] tongchi = new long[500];
    
    private long tongthuFinal = 0;
    private long tongchiFinal = 0;
    
    private int indexhd = 1;
    private int indexpn = 1;
    public doanhthu() {
        initComponents();
        
        modelhd = (DefaultTableModel) table_hoadon.getModel();
        
        modelhd.setColumnIdentifiers(new Object[]{
            "DD/MM/YY" ,"Mã hóa đơn", "Tổng tiền"
        });
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table_hoadon.getColumnModel().getColumnCount(); i++) {
            table_hoadon.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
            table_hoadon.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        modelpn = (DefaultTableModel) table_phieunhap.getModel();
        
        modelpn.setColumnIdentifiers(new Object[]{
            "DD/MM/YY" ,"Mã phiếu nhập", "Tổng tiền"
        });
        
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table_phieunhap.getColumnModel().getColumnCount(); i++) {
            table_phieunhap.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
            table_phieunhap.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    public void clearTable() {
        modelhd.setRowCount(0);
        modelpn.setRowCount(0);
    }

    public void getTableHD(int thangx, int thangy, int nam) {
        listhd = dtBLL.getALLHD(thangx, thangy, nam);
        tongthu = new long[500];
        try {
            int i = 0;
            for (HoaDon row : listhd) {
                modelhd.addRow(new Object[]{
                    row.getNgaytao() , row.getMahd() , row.getTongtien()
                });
                
                tongthu[i] = row.getTongtien(); // Đưa giá trị Tongtien vào mảng tongthu
                indexhd++; // Tăng chỉ mục lên 1 sau khi đưa giá trị vào mảng
                i++;
            }
            table_hoadon.setModel(modelhd);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void getTablePN(int thangx, int thangy, int nam) {
        listpn = dtBLL.getALLPN(thangx, thangy, nam);
        tongchi = new long[500];
        try {
            int i = 0;
            for (PhieuNhap row : listpn) {
                modelpn.addRow(new Object[]{
                    row.getNgaytao() , row.getMapn() , row.getTongtien()
                });
                
                tongchi[i] = row.getTongtien(); // Đưa giá trị Tongtien vào mảng tongthu
                indexpn++; // Tăng chỉ mục lên 1 sau khi đưa giá trị vào mảng
                i++;
            }
            table_phieunhap.setModel(modelpn);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_phieunhap = new javax.swing.JTable();
        combobox_quy = new javax.swing.JComboBox<>();
        btn_xacnhan_quy = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        nam_xet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_hoadon = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        doanhthu_txt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thống Kê Doanh Thu");

        table_phieunhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_phieunhap.getTableHeader().setResizingAllowed(false);
        table_phieunhap.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_phieunhap);

        combobox_quy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combobox_quy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quý 1 (1-3)", "Quý 2 (4-6)", "Quý 3 (7-9)", "Quý 4 (10-12)" }));

        btn_xacnhan_quy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xacnhan_quy.setText("Xác nhận");
        btn_xacnhan_quy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacnhan_quyActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Reset");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Năm xét:");

        table_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_hoadon.getTableHeader().setResizingAllowed(false);
        table_hoadon.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(table_hoadon);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setText("Doanh thu cửa hàng:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combobox_quy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_xacnhan_quy)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nam_xet, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doanhthu_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combobox_quy, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_xacnhan_quy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nam_xet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(doanhthu_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xacnhan_quyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacnhan_quyActionPerformed
        doanhthu_txt.setText("");
        String quy = (String) combobox_quy.getSelectedItem();
        String namxet = nam_xet.getText().trim();
        boolean isNumeric = true;
        if (namxet.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập năm xét");
            return;
        }
        
        try {
            namxetInt = Integer.parseInt(namxet);
        } catch (NumberFormatException e) {
            isNumeric = false;
        }

        if (isNumeric) {
            System.out.println("namxet là một số nguyên.");
        } else {
            JOptionPane.showMessageDialog(this, "Năm xét không hợp lệ");
        }
        switch (quy) {
            case "Quý 1 (1-3)" -> {
                tongthuFinal = 0;
                tongchiFinal = 0;
                long tongdoanhthu = 0;
                System.out.println("OKKKKK");
                int thangx = 1;
                int thangy = 3;
                clearTable();
                getTableHD(thangx, thangy, namxetInt);
                getTablePN(thangx, thangy, namxetInt);
                System.out.println(namxetInt);
                for (int i = 0 ; i < indexhd ; i++) {
                    tongthuFinal += tongthu[i];
                }
                System.out.println(tongthuFinal);
                for (int i = 0 ; i < indexpn ; i++) {
                    tongchiFinal += tongchi[i];
                }
                System.out.println(tongchiFinal);
                tongdoanhthu = tongthuFinal - tongchiFinal;
                String tongdoanhthuTXT = String.valueOf(tongdoanhthu);
                doanhthu_txt.setText(tongdoanhthuTXT + "đ");
                tongthu = new long[500];
                tongchi = new long[500];
            }
            case "Quý 2 (4-6)" -> {
                tongthuFinal = 0;
                tongchiFinal = 0;
                long tongdoanhthu = 0;
                System.out.println("OKKKKK");
                int thangx = 4;
                int thangy = 6;
                clearTable();
                getTableHD(thangx, thangy, namxetInt);
                getTablePN(thangx, thangy, namxetInt);
                System.out.println(namxetInt);
                for (int i = 0 ; i < indexhd ; i++) {
                    tongthuFinal += tongthu[i];
                }
                System.out.println(tongthuFinal);
                for (int i = 0 ; i < indexpn ; i++) {
                    tongchiFinal += tongchi[i];
                }
                System.out.println(tongchiFinal);
                tongdoanhthu = tongthuFinal - tongchiFinal;
                String tongdoanhthuTXT = String.valueOf(tongdoanhthu);
                doanhthu_txt.setText(tongdoanhthuTXT + "đ");
                tongthu = new long[500];
                tongchi = new long[500];
            }
            
            case "Quý 3 (7-9)" -> {
                tongthuFinal = 0;
                tongchiFinal = 0;
                long tongdoanhthu = 0;
                System.out.println("OKKKKK");
                int thangx = 7;
                int thangy = 9;
                clearTable();
                getTableHD(thangx, thangy, namxetInt);
                getTablePN(thangx, thangy, namxetInt);
                System.out.println(namxetInt);
                for (int i = 0 ; i < indexhd ; i++) {
                    tongthuFinal += tongthu[i];
                }
                System.out.println(tongthuFinal);
                for (int i = 0 ; i < indexpn ; i++) {
                    tongchiFinal += tongchi[i];
                }
                System.out.println(tongchiFinal);
                tongdoanhthu = tongthuFinal - tongchiFinal;
                String tongdoanhthuTXT = String.valueOf(tongdoanhthu);
                doanhthu_txt.setText(tongdoanhthuTXT + "đ");
                tongthu = new long[500];
                tongchi = new long[500];
            }
            
            case "Quý 4 (10-12)" -> {
                tongthuFinal = 0;
                tongchiFinal = 0;
                long tongdoanhthu = 0;
                System.out.println("OKKKKK");
                int thangx = 10;
                int thangy = 12;
                clearTable();
                getTableHD(thangx, thangy, namxetInt);
                getTablePN(thangx, thangy, namxetInt);
                for (int i = 0 ; i < indexhd ; i++) {
                    tongthuFinal += tongthu[i];
                }
                System.out.println(tongthuFinal);
                for (int i = 0 ; i < indexpn ; i++) {
                    tongchiFinal += tongchi[i];
                }
                System.out.println(tongchiFinal);
                tongdoanhthu = tongthuFinal - tongchiFinal;
                String tongdoanhthuTXT = String.valueOf(tongdoanhthu);
                doanhthu_txt.setText(tongdoanhthuTXT + "đ");
                tongthu = new long[500];
                tongchi = new long[500];
            }
        }
    }//GEN-LAST:event_btn_xacnhan_quyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_xacnhan_quy;
    private javax.swing.JComboBox<String> combobox_quy;
    private javax.swing.JTextField doanhthu_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nam_xet;
    public javax.swing.JTable table_hoadon;
    public javax.swing.JTable table_phieunhap;
    // End of variables declaration//GEN-END:variables
}
