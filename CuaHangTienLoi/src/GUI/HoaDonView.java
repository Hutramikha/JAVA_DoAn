/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.*;
import DTO.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class HoaDonView extends javax.swing.JPanel {

    private DefaultTableModel model;
    private DefaultTableModel modelAll = null;
    private DefaultTableModel modeldoan;
    private DefaultTableModel modelnuoc;
    private DefaultTableModel modelhoctap;
    private ArrayList<khachHang> listKH = new ArrayList<>();
    private KhachHangBLL khBLL = new KhachHangBLL(null);
    private CTHoaDonBLL ctHdBll = new CTHoaDonBLL();
    private HoaDonBLL hdBLL = new HoaDonBLL();
    private ArrayList<CtHoaDon> listct = new ArrayList<>();
    private ArrayList<CtHoaDon> listctXet = new ArrayList<>();
    private ArrayList<HoaDon> listhd = new ArrayList<>();
    
    private sanPham sp;
    private CtHoaDon cthd;
    private HoaDon hd;
    
    private ArrayList<sanPham> listspALL = new ArrayList<>();
    private ArrayList<sanPham> listspDA = new ArrayList<>();
    private ArrayList<sanPham> listspNU = new ArrayList<>();
    private ArrayList<sanPham> listspHT = new ArrayList<>();
    private SanPhamBLL spBLL = new SanPhamBLL(null);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    private long tongtien = 0, thanhtien = 0;
    
    private String maspct , tenspct;
    private int soluongmuaspct;
    private long thanhtienspct;

    public HoaDonView() {
        listspALL = spBLL.getALL();
        listspDA = spBLL.getALLmaLoai("doan");
        listspNU = spBLL.getALLmaLoai("nuoc");
        listspHT = spBLL.getALLmaLoai("hoctap");
        initComponents();
        
        ma_nv.setEnabled(false);
        ten_sp.setEditable(false);
        sl_con.setEditable(false);
        loai_sp.setEditable(false);
        dongia_sp.setEditable(false);

        model = (DefaultTableModel) table_chitiet.getModel();

        model.setColumnIdentifiers(new Object[]{
            "Mã sản phẩm", "Tên sản phẩm" ,"Số lượng mua", "Đơn giá", "Thành tiền"
        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table_chitiet.getColumnModel().getColumnCount(); i++) {
            table_chitiet.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
            table_chitiet.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        MouseAdapter mouseAdapterALL = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRowAll = table_sp_all.getSelectedRow();

                    if (selectRowAll != -1) {
                        Object data1 = table_sp_all.getValueAt(selectRowAll, 0);
                        Object data2 = table_sp_all.getValueAt(selectRowAll, 1);
                        Object data3 = table_sp_all.getValueAt(selectRowAll, 2);
                        Object data4 = table_sp_all.getValueAt(selectRowAll, 3);
                        Object data5 = table_sp_all.getValueAt(selectRowAll, 4);

                        ma_sp.setText(data1.toString());
                        ten_sp.setText(data2.toString());
                        dongia_sp.setText(data4.toString());
                        loai_sp.setText(data3.toString());
                        sl_con.setText(data5.toString());
                    }
                }
            }
        };

        MouseAdapter mouseAdapterdoan = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRowDoan = table_sp_doan.getSelectedRow();

                    if (selectRowDoan != -1) {
                        Object data1 = table_sp_doan.getValueAt(selectRowDoan, 0);
                        Object data2 = table_sp_doan.getValueAt(selectRowDoan, 1);
                        Object data3 = table_sp_doan.getValueAt(selectRowDoan, 2);
                        Object data4 = table_sp_doan.getValueAt(selectRowDoan, 3);
                        Object data5 = table_sp_doan.getValueAt(selectRowDoan, 4);

                        ma_sp.setText(data1.toString());
                        ten_sp.setText(data2.toString());
                        dongia_sp.setText(data4.toString());
                        loai_sp.setText(data3.toString());
                        sl_con.setText(data5.toString());
                    }

                }
            }
        };

        MouseAdapter mouseAdapternuoc = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRowNuocuong = table_sp_nuocuong.getSelectedRow();

                    if (selectRowNuocuong != -1) {
                        Object data1 = table_sp_nuocuong.getValueAt(selectRowNuocuong, 0);
                        Object data2 = table_sp_nuocuong.getValueAt(selectRowNuocuong, 1);
                        Object data3 = table_sp_nuocuong.getValueAt(selectRowNuocuong, 2);
                        Object data4 = table_sp_nuocuong.getValueAt(selectRowNuocuong, 3);
                        Object data5 = table_sp_nuocuong.getValueAt(selectRowNuocuong, 4);

                        ma_sp.setText(data1.toString());
                        ten_sp.setText(data2.toString());
                        dongia_sp.setText(data4.toString());
                        loai_sp.setText(data3.toString());
                        sl_con.setText(data5.toString());
                    }

                }
            }
        };

        MouseAdapter mouseAdapterhoctap = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRowHoctap = table_sp_hoctap.getSelectedRow();

                    if (selectRowHoctap != -1) {
                        Object data1 = table_sp_hoctap.getValueAt(selectRowHoctap, 0);
                        Object data2 = table_sp_hoctap.getValueAt(selectRowHoctap, 1);
                        Object data3 = table_sp_hoctap.getValueAt(selectRowHoctap, 2);
                        Object data4 = table_sp_hoctap.getValueAt(selectRowHoctap, 3);
                        Object data5 = table_sp_hoctap.getValueAt(selectRowHoctap, 4);

                        ma_sp.setText(data1.toString());
                        ten_sp.setText(data2.toString());
                        dongia_sp.setText(data4.toString());
                        loai_sp.setText(data3.toString());
                        sl_con.setText(data5.toString());
                    }
                }
            }
        };
        
        MouseAdapter mouseAdapterChiTiet = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRowHoctap = table_chitiet.getSelectedRow();

                    if (selectRowHoctap != -1) {
                        Object data1 = table_chitiet.getValueAt(selectRowHoctap, 0);
                        Object data2 = table_chitiet.getValueAt(selectRowHoctap, 1);
                        Object data3 = table_chitiet.getValueAt(selectRowHoctap, 2);
                        Object data5 = table_chitiet.getValueAt(selectRowHoctap, 4);
                        
                        maspct = (String) data1;
                        tenspct = (String) data2;
                        soluongmuaspct = (int) data3;
                        thanhtienspct = (long) data5;
                    }
                }
            }
        };
        
        table_sp_all.addMouseListener(mouseAdapterALL);
        table_sp_doan.addMouseListener(mouseAdapterdoan);
        table_sp_hoctap.addMouseListener(mouseAdapterhoctap);
        table_sp_nuocuong.addMouseListener(mouseAdapternuoc);
        table_chitiet.addMouseListener(mouseAdapterChiTiet);
    }

    public void comboBox() {
        listKH = khBLL.getALL();
        for (khachHang dataKH : listKH) {
            ma_kh_combo.addItem(dataKH.getMakh());
        }
    }

    public void getTablespAll(ArrayList<sanPham> listsp) {
        modelAll = (DefaultTableModel) table_sp_all.getModel();
        try {
            for (sanPham row : listsp) {
                modelAll.addRow(new Object[]{
                    row.getMasp(), row.getTensp(), row.getMaloaisp(), row.getDongia(), row.getSoluong()
                });
            }
            table_sp_all.setModel(modelAll);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void getTablespDoan(ArrayList<sanPham> listsp) {
        modeldoan = (DefaultTableModel) table_sp_doan.getModel();
        try {
            for (sanPham row : listsp) {
                modeldoan.addRow(new Object[]{
                    row.getMasp(), row.getTensp(), row.getMaloaisp(), row.getDongia(), row.getSoluong()
                });
            }
            table_sp_doan.setModel(modeldoan);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void getTablespNuoc(ArrayList<sanPham> listsp) {
        modelnuoc = (DefaultTableModel) table_sp_nuocuong.getModel();
        try {
            for (sanPham row : listsp) {
                modelnuoc.addRow(new Object[]{
                    row.getMasp(), row.getTensp(), row.getMaloaisp(), row.getDongia(), row.getSoluong()
                });
            }
            table_sp_nuocuong.setModel(modelnuoc);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void getTablespHocTap(ArrayList<sanPham> listsp) {
        modelhoctap = (DefaultTableModel) table_sp_hoctap.getModel();
        try {
            for (sanPham row : listsp) {
                modelhoctap.addRow(new Object[]{
                    row.getMasp(), row.getTensp(), row.getMaloaisp(), row.getDongia(), row.getSoluong()
                });
            }
            table_sp_hoctap.setModel(modelhoctap);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void ResetFieldText() {
        ma_sp.setText("");
        ten_sp.setText("");
        dongia_sp.setText("");
        sl_con.setText("");
        loai_sp.setText("");
        sl_mua.setText("");
    }

    public void clearTable() {
        model.setRowCount(0);
    }
    
    public void getTable(ArrayList<CtHoaDon> list) {
        try {
            for (CtHoaDon row : list) {
                model.addRow(new Object[]{
                    row.getMasp() , row.getTensp() , row.getSoluong() , row.getDongia() , row.getThanhtien()
                });
            }
           table_chitiet.setModel(model);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
     public void loadTable(ArrayList<CtHoaDon> list) {
        CtHoaDon ct = list.get(list.size() - 1);
        model.addRow(new Object[]{
            ct.getMasp() , ct.getTensp() , ct.getSoluong() , ct.getDongia() , ct.getThanhtien()
        });
    }
    
    public void setCurrentDate(JTextField textField) {
        String currentDate = dateFormat.format(new Date());
        textField.setText(currentDate);
    }

    private void updateTableData(DefaultTableModel tableModel, ArrayList<sanPham> listsp) {
        tableModel.setRowCount(0);

        for (sanPham sanPham : listsp) {
            Object[] rowData = {sanPham.getMasp(), sanPham.getTensp(), sanPham.getMaloaisp() , sanPham.getDongia() , sanPham.getSoluong()};
            tableModel.addRow(rowData);
        }
        tableModel.fireTableDataChanged();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabbpane_hd = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_sp_all = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_sp_doan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_sp_nuocuong = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_sp_hoctap = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_chitiet = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tongtien_hd = new javax.swing.JTextField();
        btn_xacnhan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_reset = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        ten_sp = new javax.swing.JTextField();
        ma_sp = new javax.swing.JTextField();
        sl_con = new javax.swing.JTextField();
        loai_sp = new javax.swing.JTextField();
        ma_nv = new javax.swing.JTextField();
        dongia_sp = new javax.swing.JTextField();
        sl_mua = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        ma_kh_combo = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        km_combo = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        ma_hd = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        ngaytao_txt = new javax.swing.JTextField();
        btn_getDate = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(985, 650));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("HÓA ĐƠN");

        tabbpane_hd.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbpane_hdStateChanged(evt);
            }
        });

        table_sp_all.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Mã loại", "Đơn giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_sp_all.getTableHeader().setResizingAllowed(false);
        table_sp_all.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(table_sp_all);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbpane_hd.addTab("Tất cả", jPanel1);

        table_sp_doan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Mã loại", "Đơn giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_sp_doan.getTableHeader().setResizingAllowed(false);
        table_sp_doan.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(table_sp_doan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbpane_hd.addTab("Đồ ăn", jPanel2);

        table_sp_nuocuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Mã loại", "Đơn giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_sp_nuocuong.getTableHeader().setResizingAllowed(false);
        table_sp_nuocuong.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(table_sp_nuocuong);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbpane_hd.addTab("Nước uống", jPanel3);

        table_sp_hoctap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Mã loại", "Đơn giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_sp_hoctap.getTableHeader().setResizingAllowed(false);
        table_sp_hoctap.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(table_sp_hoctap);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbpane_hd.addTab("Dụng cụ học tập", jPanel4);

        table_chitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_chitiet.setShowGrid(true);
        table_chitiet.getTableHeader().setResizingAllowed(false);
        table_chitiet.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_chitiet);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("Tổng tiền:");

        btn_xacnhan.setBackground(new java.awt.Color(0, 102, 0));
        btn_xacnhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_xacnhan.setForeground(new java.awt.Color(255, 255, 255));
        btn_xacnhan.setText("Xác nhận");
        btn_xacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacnhanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Tên sản phẩm:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 204));
        jLabel4.setText("Mã sản phẩm:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 204));
        jLabel5.setText("Số lượng còn:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 204));
        jLabel6.setText("Loại sản phẩm:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 204));
        jLabel7.setText("Nhân viên:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 204));
        jLabel8.setText("Đơn giá:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Số lượng mua:");

        btn_reset.setBackground(new java.awt.Color(102, 102, 102));
        btn_reset.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_reset.setForeground(new java.awt.Color(255, 255, 255));
        btn_reset.setText("Reset");
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(153, 0, 0));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa SP");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_them.setBackground(new java.awt.Color(0, 51, 153));
        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm SP");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 204));
        jLabel11.setText("Mã khách hàng:");

        ma_kh_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "null" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 204));
        jLabel10.setText("Khuyến mãi:");

        km_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không có", "10%", "15%", "20%" }));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("Mã hóa đơn:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("Ngày tạo:");

        btn_getDate.setText("Lấy ngày");
        btn_getDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_getDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btn_xoa)
                                .addGap(30, 30, 30)
                                .addComponent(btn_them))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dongia_sp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(ma_nv, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loai_sp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sl_con, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ma_sp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ten_sp, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sl_mua))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(km_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ma_kh_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btn_getDate)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel12))
                                                .addGap(6, 6, 6)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ma_hd)
                                                    .addComponent(ngaytao_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabbpane_hd, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tongtien_hd, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_xacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tabbpane_hd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(224, 224, 224)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(ten_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(ma_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(ma_hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(sl_con, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(ngaytao_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(loai_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_getDate))))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ma_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(ma_kh_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(dongia_sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(km_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(sl_mua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tongtien_hd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btn_xacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabbpane_hdStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabbpane_hdStateChanged
        int index = tabbpane_hd.getSelectedIndex();
        if (index == 0) {
            getTablespAll(listspALL);
            modeldoan = (DefaultTableModel) table_sp_doan.getModel();
            modelnuoc = (DefaultTableModel) table_sp_nuocuong.getModel();
            modelhoctap = (DefaultTableModel) table_sp_hoctap.getModel();
            ResetFieldText();
            int rowDoan = modeldoan.getRowCount();
            int rowNuoc = modelnuoc.getRowCount();
            int rowHoctap = modelhoctap.getRowCount();
            if (rowDoan > 0) {
                for (int i = rowDoan - 1; i >= 0; i--) {
                    modeldoan.removeRow(i);
                }
            }
            if (rowNuoc > 0) {
                for (int i = rowNuoc - 1; i >= 0; i--) {
                    modelnuoc.removeRow(i);
                }
            }
            if (rowHoctap > 0) {
                for (int i = rowHoctap - 1; i >= 0; i--) {
                    modelhoctap.removeRow(i);
                }
            }
        }

        if (index == 1) {
            getTablespDoan(listspDA);
            modelAll = (DefaultTableModel) table_sp_all.getModel();
            modelnuoc = (DefaultTableModel) table_sp_nuocuong.getModel();
            modelhoctap = (DefaultTableModel) table_sp_hoctap.getModel();
            ResetFieldText();
            int rowAll = modelAll.getRowCount();
            int rowNuoc = modelnuoc.getRowCount();
            int rowHoctap = modelhoctap.getRowCount();
            if (rowAll > 0) {
                for (int i = rowAll - 1; i >= 0; i--) {
                    modelAll.removeRow(i);
                }
            }
            if (rowNuoc > 0) {
                for (int i = rowNuoc - 1; i >= 0; i--) {
                    modelnuoc.removeRow(i);
                }
            }
            if (rowHoctap > 0) {
                for (int i = rowHoctap - 1; i >= 0; i--) {
                    modelhoctap.removeRow(i);
                }
            }
        }

        if (index == 2) {
            getTablespNuoc(listspNU);
            modelAll = (DefaultTableModel) table_sp_all.getModel();
            modelhoctap = (DefaultTableModel) table_sp_hoctap.getModel();
            modeldoan = (DefaultTableModel) table_sp_doan.getModel();
            ResetFieldText();
            int rowAll = modelAll.getRowCount();
            int rowDoan = modeldoan.getRowCount();
            int rowHoctap = modelhoctap.getRowCount();
            if (rowAll > 0) {
                for (int i = rowAll - 1; i >= 0; i--) {
                    modelAll.removeRow(i);
                }
            }
            if (rowDoan > 0) {
                for (int i = rowDoan - 1; i >= 0; i--) {
                    modeldoan.removeRow(i);
                }
            }
            if (rowHoctap > 0) {
                for (int i = rowHoctap - 1; i >= 0; i--) {
                    modelhoctap.removeRow(i);
                }
            }
        }

        if (index == 3) {
            getTablespHocTap(listspHT);
            modelAll = (DefaultTableModel) table_sp_all.getModel();
            modelnuoc = (DefaultTableModel) table_sp_nuocuong.getModel();
            modeldoan = (DefaultTableModel) table_sp_doan.getModel();
            ResetFieldText();
            int rowAll = modelAll.getRowCount();
            int rowDoan = modeldoan.getRowCount();
            int rowNuoc = modelnuoc.getRowCount();
            if (rowAll > 0) {
                for (int i = rowAll - 1; i >= 0; i--) {
                    modelAll.removeRow(i);
                }
            }
            if (rowDoan > 0) {
                for (int i = rowDoan - 1; i >= 0; i--) {
                    modeldoan.removeRow(i);
                }
            }
            if (rowNuoc > 0) {
                for (int i = rowNuoc - 1; i >= 0; i--) {
                    modelnuoc.removeRow(i);
                }
            }
        }
    }//GEN-LAST:event_tabbpane_hdStateChanged

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        ResetFieldText();
        tabbpane_hd.setSelectedIndex(0);
    }//GEN-LAST:event_btn_resetActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
       String mahd = ma_hd.getText().trim();
       String masp = ma_sp.getText().trim();
       String tensp = ten_sp.getText().trim();
       String soluongmuaTxt = sl_mua.getText().trim();
       String soluongconTxt = sl_con.getText();
       String dongiaTxt = dongia_sp.getText().trim();
       long dongia = Long.parseLong(dongiaTxt);
       int soluongcon = Integer.parseInt(soluongconTxt);
       
        listctXet = ctHdBll.getALL();
        boolean flag = false;
        for (CtHoaDon tmp : listctXet) {
            if (tmp.getMahd().equals(mahd)) {
                flag = true;
            }
        }
        if (flag) {
            JOptionPane.showMessageDialog(this, "Mã hóa đơn đã tồn tại");
            return;
        }
       
       
       if (mahd.isEmpty() || masp.isEmpty() || tensp.isEmpty() || soluongmuaTxt.isEmpty() || dongiaTxt.isEmpty()) {
           JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
           return;
       }
        
        if (!soluongmuaTxt.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Số lượng mua không hợp lệ");
            return;
        }
        
        int soluongmua = Integer.parseInt(soluongmuaTxt);
        
        if (soluongmua <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng mua không hợp lệ");
            return;
        }
        
        if (soluongcon < soluongmua) {
            JOptionPane.showMessageDialog(this, "Sản phẩm này đã hết hàng");
            return;
        }
        
        try {
            thanhtien = soluongmua * dongia;
            tongtien += thanhtien;
            cthd = new CtHoaDon(mahd, masp, tensp, soluongmua, dongia, thanhtien);
            listct.add(cthd);
            loadTable(listct);
            String tongtienTxt = String.valueOf(tongtien);
            tongtien_hd.setText(tongtienTxt);
            ResetFieldText();
            
            sanPham sanPhamCanMuaALL = null;
            sanPham sanPhamCanMuaDA = null;
            sanPham sanPhamCanMuaNU = null;
            sanPham sanPhamCanMuaHT = null;
            for (sanPham sptmp : listspALL) {
                if (sptmp.getMasp().equals(masp)) {
                    sanPhamCanMuaALL = sptmp;
                    listspALL.remove(sptmp);
                    break;
                }
            }
            
            for (sanPham sptmp : listspDA) {
                if (sptmp.getMasp().equals(masp)) {
                    sanPhamCanMuaDA = sptmp;
                    listspDA.remove(sptmp);
                    break;
                }
            }
            
            for (sanPham sptmp : listspNU) {
                if (sptmp.getMasp().equals(masp)) {
                    sanPhamCanMuaNU = sptmp;
                    listspNU.remove(sptmp);
                    break;
                }
            }
            
            for (sanPham sptmp : listspHT) {
                if (sptmp.getMasp().equals(masp)) {
                    sanPhamCanMuaHT = sptmp;
                    listspHT.remove(sptmp);
                    break;
                }
            }
            
            if (sanPhamCanMuaALL != null) {
                int soLuongHienTai = sanPhamCanMuaALL.getSoluong();
                int soLuongMoi = soLuongHienTai - soluongmua;
                sanPhamCanMuaALL.setSoluong(soLuongMoi);
                listspALL.add(sanPhamCanMuaALL);
                DefaultTableModel tableModel1 = (DefaultTableModel) table_sp_all.getModel();
                updateTableData(tableModel1, listspALL);
            }
            
            if (sanPhamCanMuaDA != null) {
                int soLuongHienTai = sanPhamCanMuaDA.getSoluong();
                int soLuongMoi = soLuongHienTai - soluongmua;
                sanPhamCanMuaDA.setSoluong(soLuongMoi);
                listspDA.add(sanPhamCanMuaDA);
                DefaultTableModel tableModel1 = (DefaultTableModel) table_sp_doan.getModel();
                updateTableData(tableModel1, listspDA);
            }
            
            if (sanPhamCanMuaNU != null) {
                int soLuongHienTai = sanPhamCanMuaNU.getSoluong();
                int soLuongMoi = soLuongHienTai - soluongmua;
                sanPhamCanMuaNU.setSoluong(soLuongMoi);
                listspNU.add(sanPhamCanMuaNU);
                DefaultTableModel tableModel1 = (DefaultTableModel) table_sp_nuocuong.getModel();
                updateTableData(tableModel1, listspNU);
            }
            
            if (sanPhamCanMuaHT != null) {
                int soLuongHienTai = sanPhamCanMuaHT.getSoluong();
                int soLuongMoi = soLuongHienTai - soluongmua;
                sanPhamCanMuaHT.setSoluong(soLuongMoi);
                listspHT.add(sanPhamCanMuaHT);
                DefaultTableModel tableModel1 = (DefaultTableModel) table_sp_hoctap.getModel();
                updateTableData(tableModel1, listspHT);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_getDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_getDateActionPerformed
        setCurrentDate(ngaytao_txt);
    }//GEN-LAST:event_btn_getDateActionPerformed

    private void btn_xacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacnhanActionPerformed
        String ngaytao = ngaytao_txt.getText().trim();
        String mahd = ma_hd.getText().trim();
        String makh = (String) ma_kh_combo.getSelectedItem();
        String manv = ma_nv.getText();
        Date ngaytaoDate;
        
        if (ngaytao.isEmpty() || mahd.isEmpty()) {
           JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
           return;
        }
        
        listhd = hdBLL.getALL();
        boolean flag = false;
        for (HoaDon tmp : listhd) {
            if (tmp.getMahd().equals(mahd)) {
                flag = true;
            }
        }
        if (flag) {
            System.out.println("Mã hóa đơn đã tồn tại");
            return;
        }
        
        try {
            ngaytaoDate = dateFormat.parse(ngaytao);
            System.out.println("Ngày tạo đã được chuyển đổi thành công: " + ngaytaoDate);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Ngày tạo không đúng định dạng dd/MM/yyyy.");
            return;
        }
        
        try {
            hd = new HoaDon(mahd, makh, manv, ngaytaoDate, tongtien);
            if (hdBLL.add2(hd) == 0) {
                return;
            }
            for (CtHoaDon cthdx : listct) {
                ctHdBll.add(cthdx);
            }
            for (sanPham sptmpx : listspALL) {
                spBLL.updateSL(sptmpx);
            }
            clearTable();
            ma_hd.setText("");
            ngaytao_txt.setText("");
            ma_kh_combo.setSelectedIndex(0);
            km_combo.setSelectedIndex(0);
            tongtien = 0;
            tongtien_hd.setText("");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
    }//GEN-LAST:event_btn_xacnhanActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        CtHoaDon chitiet = null;
        for (CtHoaDon tmp : listct) {
            if (tmp.getMasp().equals(maspct) && tmp.getTensp().equals(tenspct) && tmp.getSoluong() == soluongmuaspct && tmp.getThanhtien() == thanhtienspct) {
                chitiet = tmp;
                System.out.println("đã tìm thấy");
                break;
            }
        }
        boolean remove = listct.remove(chitiet);
        if (remove) {
            clearTable();
            getTable(listct);
            tongtien = tongtien - chitiet.getThanhtien();
            String tongtienTxt = String.valueOf(tongtien);
            tongtien_hd.setText(tongtienTxt);
            sanPham sanPhamCanMuaALL = null;
            sanPham sanPhamCanMuaDA = null;
            sanPham sanPhamCanMuaNU = null;
            sanPham sanPhamCanMuaHT = null;
            for (sanPham sptmp : listspALL) {
                if (sptmp.getMasp().equals(maspct)) {
                    sanPhamCanMuaALL = sptmp;
                    listspALL.remove(sptmp);
                    break;
                }
            }
            
            for (sanPham sptmp : listspDA) {
                if (sptmp.getMasp().equals(maspct)) {
                    sanPhamCanMuaDA = sptmp;
                    listspDA.remove(sptmp);
                    break;
                }
            }
            
            for (sanPham sptmp : listspNU) {
                if (sptmp.getMasp().equals(maspct)) {
                    sanPhamCanMuaNU = sptmp;
                    listspNU.remove(sptmp);
                    break;
                }
            }
            
            for (sanPham sptmp : listspHT) {
                if (sptmp.getMasp().equals(maspct)) {
                    sanPhamCanMuaHT = sptmp;
                    listspHT.remove(sptmp);
                    break;
                }
            }
            
            if (sanPhamCanMuaALL != null) {
                int soLuongHienTai = sanPhamCanMuaALL.getSoluong();
                int soLuongMoi = soLuongHienTai + soluongmuaspct;
                sanPhamCanMuaALL.setSoluong(soLuongMoi);
                listspALL.add(sanPhamCanMuaALL);
                DefaultTableModel tableModel1 = (DefaultTableModel) table_sp_all.getModel();
                updateTableData(tableModel1, listspALL);
            }
            
            if (sanPhamCanMuaDA != null) {
                int soLuongHienTai = sanPhamCanMuaDA.getSoluong();
                int soLuongMoi = soLuongHienTai + soluongmuaspct;
                sanPhamCanMuaDA.setSoluong(soLuongMoi);
                listspDA.add(sanPhamCanMuaDA);
                DefaultTableModel tableModel1 = (DefaultTableModel) table_sp_doan.getModel();
                updateTableData(tableModel1, listspDA);
            }
            
            if (sanPhamCanMuaNU != null) {
                int soLuongHienTai = sanPhamCanMuaNU.getSoluong();
                int soLuongMoi = soLuongHienTai + soluongmuaspct;
                sanPhamCanMuaNU.setSoluong(soLuongMoi);
                listspNU.add(sanPhamCanMuaNU);
                DefaultTableModel tableModel1 = (DefaultTableModel) table_sp_nuocuong.getModel();
                updateTableData(tableModel1, listspNU);
            }
            
            if (sanPhamCanMuaHT != null) {
                int soLuongHienTai = sanPhamCanMuaHT.getSoluong();
                int soLuongMoi = soLuongHienTai + soluongmuaspct;
                sanPhamCanMuaHT.setSoluong(soLuongMoi);
                listspHT.add(sanPhamCanMuaHT);
                DefaultTableModel tableModel1 = (DefaultTableModel) table_sp_hoctap.getModel();
                updateTableData(tableModel1, listspHT);
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_getDate;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xacnhan;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JTextField dongia_sp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JComboBox<String> km_combo;
    private javax.swing.JTextField loai_sp;
    private javax.swing.JTextField ma_hd;
    private javax.swing.JComboBox<String> ma_kh_combo;
    public javax.swing.JTextField ma_nv;
    private javax.swing.JTextField ma_sp;
    private javax.swing.JTextField ngaytao_txt;
    private javax.swing.JTextField sl_con;
    private javax.swing.JTextField sl_mua;
    private javax.swing.JTabbedPane tabbpane_hd;
    private javax.swing.JTable table_chitiet;
    public javax.swing.JTable table_sp_all;
    public javax.swing.JTable table_sp_doan;
    public javax.swing.JTable table_sp_hoctap;
    public javax.swing.JTable table_sp_nuocuong;
    private javax.swing.JTextField ten_sp;
    public javax.swing.JTextField tongtien_hd;
    // End of variables declaration//GEN-END:variables
}
