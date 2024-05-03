/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import BLL.NhaCungCapBLL;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import DTO.nhaCungCap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;



public class NhaCungCap extends javax.swing.JPanel {
    DefaultTableModel model;
    nhaCungCap ncc = new nhaCungCap();
    private ArrayList<nhaCungCap> list = new ArrayList<>();
    NhaCungCapBLL khBll = new NhaCungCapBLL(this);
    private int count = 0;
    private String matmp, tentmp,tennddtmp, sdttmp, dchitmp;
    public NhaCungCap() {
        initComponents();
        btn_luu.setEnabled(false);
        ma_ncc.setEditable(false);
        ten_ncc.setEditable(false);
        sdt_ncc.setEditable(false);
        dchi_ncc.setEditable(false);

        model = (DefaultTableModel) table_ncc.getModel();

        model.setColumnIdentifiers(new Object[]{
            "Mã nhà cung cấp", "Tên nhà cung cấp", "Tên người đại diện", "Số điện thoại", "Địa chỉ"
        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table_ncc.getColumnModel().getColumnCount(); i++) {
            table_ncc.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
            table_ncc.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRow = table_ncc.getSelectedRow();

                    if (selectRow != -1) {
                        Object data1 = table_ncc.getValueAt(selectRow, 0);
                        Object data2 = table_ncc.getValueAt(selectRow, 1);
                        Object data3 = table_ncc.getValueAt(selectRow, 2);
                        Object data4 = table_ncc.getValueAt(selectRow, 3);
                        Object data5 = table_ncc.getValueAt(selectRow, 4);

                        ma_ncc.setText(data1.toString());
                        ten_ncc.setText(data2.toString());
                        ten_ndd.setText(data3.toString());
                        sdt_ncc.setText(data4.toString());
                        dchi_ncc.setText(data5.toString());
                    }
                }
            }
        };

        table_ncc.addMouseListener(mouseAdapter);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        table_ncc = new javax.swing.JTable();
        sdt_ncc = new javax.swing.JTextField();
        dchi_ncc = new javax.swing.JTextField();
        ma_ncc = new javax.swing.JTextField();
        ten_ncc = new javax.swing.JTextField();
        btn_reset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ten_ndd = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(980, 650));

        jLabel1.setFont(new java.awt.Font("Sitka Small", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ NHÀ CUNG CẤP");

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tìm kiếm");
        jButton1.setToolTipText("");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jTextField1.setFocusable(false);
        jTextField1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Mã nhà cung cấp:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Tên người đại diện:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Địa chỉ:");

        btn_them.setBackground(new java.awt.Color(102, 102, 102));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm");
        btn_them.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_luu.setBackground(new java.awt.Color(0, 102, 0));
        btn_luu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_luu.setForeground(new java.awt.Color(255, 255, 255));
        btn_luu.setText("Lưu");
        btn_luu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(102, 102, 102));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Sửa");
        btn_sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(153, 0, 0));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        table_ncc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_ncc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table_ncc.setOpaque(false);
        table_ncc.getTableHeader().setResizingAllowed(false);
        table_ncc.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_ncc);
        if (table_ncc.getColumnModel().getColumnCount() > 0) {
            table_ncc.getColumnModel().getColumn(0).setResizable(false);
            table_ncc.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        sdt_ncc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        sdt_ncc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        dchi_ncc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dchi_ncc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        ma_ncc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ma_ncc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        ten_ncc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ten_ncc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        btn_reset.setBackground(new java.awt.Color(102, 102, 102));
        btn_reset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Tên nhà cung cấp:");

        ten_ndd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ten_ndd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(ten_ncc, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(ten_ndd))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dchi_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(159, 159, 159))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ma_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(193, 193, 193)
                                        .addComponent(sdt_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(25, 25, 25)
                                        .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(75, 75, 75)
                                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 42, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ma_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(sdt_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ten_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(dchi_ncc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ten_ndd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 985, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

     public void loadTable(ArrayList<nhaCungCap> list) {
        nhaCungCap ncc2 = list.get(list.size() - 1);
        model.addRow(new Object[]{
            ncc2.getMaNCC(), ncc2.getTenNCC(), ncc2.getTenNDD(),ncc2.getSdt(), ncc2.getDiachi()
        });
    }

    public void clearTable() {
        model.setRowCount(0);
    }

    public void getTable() {
        list = khBll.getALL();
        try {
            for (nhaCungCap row : list) {
                model.addRow(new Object[]{
                    row.getMaNCC(), row.getTenNCC(), row.getTenNDD(), row.getSdt(), row.getDiachi()
                });
            }
            table_ncc.setModel(model);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void ResetFieldText() {
        ma_ncc.setText("");
        ten_ncc.setText("");
        ten_ndd.setText("");
        sdt_ncc.setText("");
        dchi_ncc.setText("");
    }

    public void Editable() {
        btn_luu.setEnabled(true);
        ma_ncc.setEditable(true);
        ten_ncc.setEditable(true);
        ten_ndd.setEditable(true);
        sdt_ncc.setEditable(true);
        dchi_ncc.setEditable(true);
    }

    public void UnEditable() {
        btn_luu.setEnabled(false);
        ma_ncc.setEditable(false);
        ten_ncc.setEditable(false);
        ten_ndd.setEditable(false);
        sdt_ncc.setEditable(false);
        dchi_ncc.setEditable(false);
    }
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
                String ma = ma_ncc.getText().trim();
                String tenncc = ten_ncc.getText().trim();
                String tenndd = ten_ndd.getText().trim();
                String sdt = sdt_ncc.getText().trim();
                String diachi = dchi_ncc.getText().trim();
                for (nhaCungCap tmp : list) {
                    if (tmp.getMaNCC().equals(ma)) {
                        JOptionPane.showMessageDialog(this, "Mã nhà cung cấp đã tồn tại");
                        return;
                    }
                }

                if (ma.isEmpty() || tenncc.isEmpty() || tenndd.isEmpty()|| sdt.isEmpty() || diachi.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng diền đầy đủ thông tin");
                    return;
                }
                if (!sdt.matches("^0\\d{9}$")) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                    return;
                }

                try {
                    ncc = new nhaCungCap(ma, tenncc, tenndd, sdt, diachi);
                    list.add(ncc);
                    khBll.add(ncc);
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
                String ma = ma_ncc.getText().trim();
                String tenncc = ten_ncc.getText().trim();
                String tenndd = ten_ndd.getText().trim();
                String sdt = sdt_ncc.getText().trim();
                String diachi = dchi_ncc.getText().trim();
                if (!matmp.equals(ma)) {
                    for (nhaCungCap tmp : list) {
                        if (tmp.getMaNCC().equals(ma)) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(this, "Mã nhà cung cấp đã tồn tại");
                    return;
                }
                if (!sdt.matches("^0\\d{9}$")) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                    return;
                }
       
                if (matmp.equals(ma) && tennddtmp.equals(tenndd) && tentmp.equals(tenncc)&& sdttmp.equals(sdt) && dchitmp.equals(diachi)) {
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
                    ncc = new nhaCungCap(ma, tenncc, tenndd, sdt, diachi);
                    khBll.update(ncc, matmp);
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
        String ma = ma_ncc.getText();
        matmp = ma_ncc.getText();
        String tenncc = ten_ncc.getText();
        tentmp = ten_ncc.getText();
        String tenndd = ten_ncc.getText();
        tennddtmp = ten_ndd.getText();
        String sdt = sdt_ncc.getText();
        sdttmp = sdt_ncc.getText();
        String diachi = dchi_ncc.getText();
        dchitmp = dchi_ncc.getText();
        if (ma.isEmpty() && tenncc.isEmpty()&& tenndd.isEmpty() && sdt.isEmpty() && diachi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần sửa");
        } else {
            Editable();
            count = 2;
            btn_sua.setEnabled(false);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        String ma = ma_ncc.getText();
        String tenncc = ten_ncc.getText();
        String tenndd = ten_ndd.getText();
        String sdt = sdt_ncc.getText();
        String diachi = dchi_ncc.getText();
        if (ma.isEmpty() && tenncc.isEmpty()&& tenndd.isEmpty() && sdt.isEmpty() && diachi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần xóa");
        } else {
            try {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa ?");

                if (confirm == JOptionPane.YES_OPTION) {
                    ncc = new nhaCungCap(ma, tenncc,tenndd, sdt, diachi);
                    list.remove(ncc);
                    khBll.delete(ncc);
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
    public javax.swing.JTextField dchi_ncc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTextField ma_ncc;
    public javax.swing.JTextField sdt_ncc;
    public javax.swing.JTable table_ncc;
    public javax.swing.JTextField ten_ncc;
    public javax.swing.JTextField ten_ndd;
    // End of variables declaration//GEN-END:variables
}
