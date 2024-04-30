package GUI;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import BLL.KhachHangBLL;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import DTO.khachHang;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class KhachHangView extends javax.swing.JPanel {

    DefaultTableModel model;
    khachHang kh = new khachHang();
    private ArrayList<khachHang> list = new ArrayList<>();
    ;
   KhachHangBLL khBll = new KhachHangBLL(this);
    private int count = 0;
    private String matmp, tentmp, sdttmp, emailtmp;

    public KhachHangView() {
        initComponents();
        btn_luu.setEnabled(false);

        ma_kh.setEditable(false);
        ten_kh.setEditable(false);
        sdt_kh.setEditable(false);
        email_kh.setEditable(false);

        model = (DefaultTableModel) table_kh.getModel();

        model.setColumnIdentifiers(new Object[]{
            "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ email"
        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table_kh.getColumnModel().getColumnCount(); i++) {
            table_kh.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
            table_kh.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRow = table_kh.getSelectedRow();

                    if (selectRow != -1) {
                        Object data1 = table_kh.getValueAt(selectRow, 0);
                        Object data2 = table_kh.getValueAt(selectRow, 1);
                        Object data3 = table_kh.getValueAt(selectRow, 2);
                        Object data4 = table_kh.getValueAt(selectRow, 3);

                        ma_kh.setText(data1.toString());
                        ten_kh.setText(data2.toString());
                        sdt_kh.setText(data3.toString());
                        email_kh.setText(data4.toString());
                    }
                }
            }
        };

        table_kh.addMouseListener(mouseAdapter);

    }

    public void loadTable(ArrayList<khachHang> list) {
        khachHang kh2 = list.get(list.size() - 1);
        model.addRow(new Object[]{
            kh2.getMakh(), kh2.getTen(), kh2.getSdt(), kh2.getEmail()
        });
    }

    public void clearTable() {
        model.setRowCount(0);
    }

    public void getTable() {
        list = khBll.getALL();
        try {
            for (khachHang row : list) {
                model.addRow(new Object[]{
                    row.getMakh(), row.getTen(), row.getSdt(), row.getEmail()
                });
            }
            table_kh.setModel(model);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void ResetFieldText() {
        ma_kh.setText("");
        ten_kh.setText("");
        sdt_kh.setText("");
        email_kh.setText("");
    }

    public void Editable() {
        btn_luu.setEnabled(true);
        ma_kh.setEditable(true);
        ten_kh.setEditable(true);
        sdt_kh.setEditable(true);
        email_kh.setEditable(true);
    }

    public void UnEditable() {
        btn_luu.setEnabled(false);
        ma_kh.setEditable(false);
        ten_kh.setEditable(false);
        sdt_kh.setEditable(false);
        email_kh.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_kh = new javax.swing.JTable();
        sdt_kh = new javax.swing.JTextField();
        email_kh = new javax.swing.JTextField();
        ma_kh = new javax.swing.JTextField();
        ten_kh = new javax.swing.JTextField();
        btn_reset = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(980, 650));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Khách Hàng");

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Tìm kiếm");
        jButton1.setToolTipText("");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Mã khách hàng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Tên khách hàng:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Địa chỉ email:");

        btn_them.setBackground(new java.awt.Color(51, 255, 0));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_luu.setBackground(new java.awt.Color(51, 255, 0));
        btn_luu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(51, 255, 0));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(51, 255, 0));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        table_kh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_kh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table_kh.setOpaque(false);
        table_kh.getTableHeader().setResizingAllowed(false);
        table_kh.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_kh);

        sdt_kh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sdt_kh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        email_kh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email_kh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        ma_kh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ma_kh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        ten_kh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ten_kh.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        btn_reset.setBackground(new java.awt.Color(51, 255, 0));
        btn_reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ten_kh))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ma_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sdt_kh)
                                    .addComponent(email_kh, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ma_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(sdt_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ten_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(email_kh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        Editable();
        ResetFieldText();
        count = 1;
        btn_them.setEnabled(false);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        switch (count) {
            case 1 -> {
                // Thêm
                String ma = ma_kh.getText().trim();
                String ten = ten_kh.getText().trim();
                String sdt = sdt_kh.getText().trim();
                String email = email_kh.getText().trim();
                for (khachHang tmp : list) {
                    if (tmp.getMakh().equals(ma)) {
                        JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại");
                        return;
                    }
                }

                if (ma.isEmpty() || ten.isEmpty() || sdt.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng diền đầy đủ thông tin");
                    return;
                }
                if (!sdt.matches("^0\\d{9}$")) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                    return;
                }
                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$")) {
                    JOptionPane.showMessageDialog(this, "Địa chỉ email không hợp lệ");
                    return;
                }

                try {
                    kh = new khachHang(ma, ten, sdt, email);
                    list.add(kh);
                    khBll.add(kh);
                    ResetFieldText();
                    UnEditable();
                    loadTable(list);
                    btn_them.setEnabled(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            case 2 -> {
                // Sửa
                boolean found = false;
                String ma = ma_kh.getText().trim();
                String ten = ten_kh.getText().trim();
                String sdt = sdt_kh.getText().trim();
                String email = email_kh.getText().trim();
                if (!matmp.equals(ma)) {
                    for (khachHang tmp : list) {
                        if (tmp.getMakh().equals(ma)) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại");
                    return;
                }
                if (!sdt.matches("^0\\d{9}$")) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                    return;
                }
                if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$")) {
                    JOptionPane.showMessageDialog(this, "Địa chỉ email không hợp lệ");
                    return;
                }
                if (matmp.equals(ma) && tentmp.equals(ten) && sdttmp.equals(sdt) && emailtmp.equals(email)) {
                    int confirm = JOptionPane.showConfirmDialog(this, "Chưa có thông tin nào được sửa đổi, bạn có muốn tiếp tục ?");
                    if (confirm == JOptionPane.YES_OPTION) {
                        return;
                    } else {
                        ResetFieldText();
                        UnEditable();
                        btn_sua.setEnabled(true);
                        return;
                    }
                }

                try {
                    kh = new khachHang(ma, ten, sdt, email);
                    khBll.update(kh, matmp);
                    ResetFieldText();
                    UnEditable();
                    clearTable();
                    getTable();
                    btn_sua.setEnabled(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        String ma = ma_kh.getText();
        matmp = ma_kh.getText();
        String ten = ten_kh.getText();
        tentmp = ten_kh.getText();
        String sdt = sdt_kh.getText();
        sdttmp = sdt_kh.getText();
        String email = email_kh.getText();
        emailtmp = email_kh.getText();
        if (ma.isEmpty() && ten.isEmpty() && sdt.isEmpty() && email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần sửa");
        } else {
            Editable();
            count = 2;
            btn_sua.setEnabled(false);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        String ma = ma_kh.getText();
        String ten = ten_kh.getText();
        String sdt = sdt_kh.getText();
        String email = email_kh.getText();
        if (ma.isEmpty() && ten.isEmpty() && sdt.isEmpty() && email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần xóa");
        } else {
            try {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa ?");

                if (confirm == JOptionPane.YES_OPTION) {
                    kh = new khachHang(ma, ten, sdt, email);
                    list.remove(kh);
                    khBll.delete(kh);
                    ResetFieldText();
                    clearTable();
                    getTable();
                } else {
                    JOptionPane.showMessageDialog(this, "Hủy xóa");
                    ResetFieldText();
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        ResetFieldText();
        UnEditable();
        if (btn_luu.isEnabled()) {
            btn_luu.setEnabled(false);
        }
        if (!btn_them.isEnabled()) {
            btn_them.setEnabled(true);
        }
        if (!btn_sua.isEnabled()) {
            btn_sua.setEnabled(true);
        }
        clearTable();
        getTable();
    }//GEN-LAST:event_btn_resetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_luu;
    public javax.swing.JButton btn_reset;
    public javax.swing.JButton btn_sua;
    public javax.swing.JButton btn_them;
    public javax.swing.JButton btn_xoa;
    public javax.swing.JTextField email_kh;
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTextField ma_kh;
    public javax.swing.JTextField sdt_kh;
    public javax.swing.JTable table_kh;
    public javax.swing.JTextField ten_kh;
    // End of variables declaration//GEN-END:variables
}
