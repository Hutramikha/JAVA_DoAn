package GUI;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import BLL.NhanVienBLL;
import DTO.nhanVien;
import DTO.user;
import BLL.UserBLL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class NhanVienView extends javax.swing.JPanel {

    DefaultTableModel model;
    private nhanVien nv = new nhanVien();
    private user user = new user();
    private ArrayList<nhanVien> list = new ArrayList<>();
    private ArrayList<user> listUser = new ArrayList<>();
    NhanVienBLL nvBll = new NhanVienBLL(this);
    UserBLL userBll = new UserBLL();
    private int count = 0;
    private int status = -1;
    private int role = -1;
    private long luong;
    private String matmp, hotmp, tentmp, gioitinhtmp, sdttmp, ngaysinhtmp, chucvutmp, luongTexttmp;

    public NhanVienView() {
        initComponents();

        btn_luu.setEnabled(false);

        ma_nv.setEditable(false);
        ho_nv.setEditable(false);
        ten_nv.setEditable(false);
        gioitinh_nv.setEnabled(false);
        ngaysinh_nv.setEditable(false);
        sdt_nv.setEditable(false);
        luong_nv.setEditable(false);
        pass_nv.setEditable(false);
        chucvu_nv.setEnabled(false);

        model = (DefaultTableModel) table_nv.getModel();
        model.setColumnIdentifiers(new Object[]{
            "Mã nhân viên", "Họ nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "Số điện thoại", "Chức vụ", "Lương"
        });

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table_nv.getColumnModel().getColumnCount(); i++) {
            table_nv.getColumnModel().getColumn(i).setHeaderRenderer(centerRenderer);
            table_nv.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        list = new ArrayList<>();
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int selectRow = table_nv.getSelectedRow();

                    if (selectRow != -1) {
                        Object data1 = table_nv.getValueAt(selectRow, 0);
                        Object data2 = table_nv.getValueAt(selectRow, 1);
                        Object data3 = table_nv.getValueAt(selectRow, 2);
                        Object data4 = table_nv.getValueAt(selectRow, 3);
                        Object data5 = table_nv.getValueAt(selectRow, 4);
                        Object data6 = table_nv.getValueAt(selectRow, 5);
                        Object data7 = table_nv.getValueAt(selectRow, 6);
                        Object data8 = table_nv.getValueAt(selectRow, 7);

                        ma_nv.setText(data1.toString());
                        ho_nv.setText(data2.toString());
                        ten_nv.setText(data3.toString());
                        gioitinh_nv.setSelectedItem(data4.toString());
                        ngaysinh_nv.setText(data5.toString());
                        sdt_nv.setText(data6.toString());
                        chucvu_nv.setSelectedItem(data7.toString());
                        luong_nv.setText(data8.toString());
                    }
                }
            }
        };

        table_nv.addMouseListener(mouseAdapter);
    }

    public void loadTable(ArrayList<nhanVien> list) {
        nhanVien nv2 = list.get(list.size() - 1);
        model.addRow(new Object[]{
            nv2.getManv(), nv2.getHo(), nv2.getTen(), nv2.getGioitinh(), nv2.getNgaySinh(), nv2.getSdt(), nv2.getChucVu(), nv2.getLuong()
        });
    }

    public void clearTable() {
        model.setRowCount(0);
    }

    public void getTable() {
        list = nvBll.getALL();
        try {
            for (nhanVien row : list) {
                model.addRow(new Object[]{
                    row.getManv(), row.getHo(), row.getTen(), row.getGioitinh(), row.getNgaySinh(), row.getSdt(), row.getChucVu(), row.getLuong()
                });
            }
            table_nv.setModel(model);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void ResetFieldText() {
        ma_nv.setText("");
        ho_nv.setText("");
        ten_nv.setText("");
        if (gioitinh_nv.getItemCount() > 0) {
            gioitinh_nv.setSelectedIndex(0);
        }
        ngaysinh_nv.setText("");
        sdt_nv.setText("");
        luong_nv.setText("");
        pass_nv.setText("");
        if (chucvu_nv.getItemCount() > 0) {
            chucvu_nv.setSelectedIndex(0);
        }
        if (combobox_search.getItemCount() > 0) {
            combobox_search.setSelectedIndex(0);
        }
        search_nv.setText("");
    }
    
    public void getTableSearch(String keyword , String byWhat){
        list = nvBll.search(keyword, byWhat);
        try {
            for (nhanVien row : list) {
                model.addRow(new Object[]{
                    row.getManv(), row.getHo(), row.getTen(), row.getGioitinh(), row.getNgaySinh(), row.getSdt(), row.getChucVu(), row.getLuong()
                });
            }
            table_nv.setModel(model);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void Editable() {
        btn_luu.setEnabled(true);
        ma_nv.setEditable(true);
        ho_nv.setEditable(true);
        ten_nv.setEditable(true);
        gioitinh_nv.setEnabled(true);
        ngaysinh_nv.setEditable(true);
        sdt_nv.setEditable(true);
        luong_nv.setEditable(true);
        chucvu_nv.setEnabled(true);
    }

    public void UnEditable() {
        btn_luu.setEnabled(false);
        ma_nv.setEditable(false);
        ho_nv.setEditable(false);
        ten_nv.setEditable(false);
        gioitinh_nv.setEnabled(false);
        ngaysinh_nv.setEditable(false);
        sdt_nv.setEditable(false);
        luong_nv.setEditable(false);
        chucvu_nv.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ma_nv = new javax.swing.JTextField();
        ho_nv = new javax.swing.JTextField();
        sdt_nv = new javax.swing.JTextField();
        ngaysinh_nv = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_nv = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        ten_nv = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        luong_nv = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        gioitinh_nv = new javax.swing.JComboBox<>();
        btn_reset = new javax.swing.JButton();
        chucvu_nv = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        pass_nv = new javax.swing.JTextField();
        combobox_search = new javax.swing.JComboBox<>();
        search_nv = new javax.swing.JTextField();

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
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Nhân Viên");

        btn_search.setBackground(new java.awt.Color(0, 102, 102));
        btn_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("Tìm kiếm");
        btn_search.setToolTipText("");
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_search.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Mã nhân viên:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Họ nhân viên:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Ngày sinh:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Giới tính:");

        ma_nv.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ma_nv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        ho_nv.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ho_nv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        sdt_nv.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        sdt_nv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        ngaysinh_nv.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ngaysinh_nv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

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

        table_nv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_nv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table_nv.getTableHeader().setResizingAllowed(false);
        table_nv.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table_nv);
        if (table_nv.getColumnModel().getColumnCount() > 0) {
            table_nv.getColumnModel().getColumn(0).setResizable(false);
            table_nv.getColumnModel().getColumn(1).setResizable(false);
            table_nv.getColumnModel().getColumn(2).setResizable(false);
            table_nv.getColumnModel().getColumn(3).setResizable(false);
            table_nv.getColumnModel().getColumn(4).setResizable(false);
            table_nv.getColumnModel().getColumn(5).setResizable(false);
            table_nv.getColumnModel().getColumn(6).setResizable(false);
            table_nv.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Tên nhân viên:");

        ten_nv.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ten_nv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Số điện thoại:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Lương:");

        luong_nv.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        luong_nv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setText("Chức vụ:");

        gioitinh_nv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gioitinh_nv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

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

        chucvu_nv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        chucvu_nv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên thu ngân", "Nhân viên tạp vụ" }));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel11.setText("Mật khẩu:");

        pass_nv.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        pass_nv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        combobox_search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        combobox_search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo mã", "Theo họ", "Theo tên" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 953, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ma_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ho_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ten_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(gioitinh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(10, 10, 10)
                                        .addComponent(ngaysinh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(luong_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(sdt_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chucvu_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pass_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(combobox_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(search_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(combobox_search, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(search_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(luong_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ma_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(ngaysinh_nv))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ho_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(sdt_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ten_nv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(gioitinh_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chucvu_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(pass_nv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        Editable();
        ResetFieldText();
        count = 1;
        pass_nv.setEditable(true);
        btn_them.setEnabled(false);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        listUser = userBll.getALL();
        switch (count) {
            case 1 -> {
                // Thêm
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                String ma = ma_nv.getText().trim();
                String ho = ho_nv.getText().trim();
                String ten = ten_nv.getText().trim();
                String gioitinh = (String) gioitinh_nv.getSelectedItem();
                String ngaysinh = ngaysinh_nv.getText().trim();
                String sdt = sdt_nv.getText().trim();
                String chucvu = (String) chucvu_nv.getSelectedItem();
                String luongText = luong_nv.getText().trim();

                for (nhanVien tmp : list) {
                    if (tmp.getManv().equals(ma)) {
                        JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
                        return;
                    }
                }

                if (ma.isEmpty() || ho.isEmpty() || ten.isEmpty() || ngaysinh.isEmpty() || sdt.isEmpty() || luongText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
                    return;
                }

                if (!ngaysinh.isEmpty()) {
                    try {
                        LocalDate date = LocalDate.parse(ngaysinh, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        // Kiểm tra tính hợp lệ của ngày tháng
                        // Ví dụ: kiểm tra ngày tháng không nằm trong tương lai
                        LocalDate currentDate = LocalDate.now();
                        if (date.isAfter(currentDate)) {
                            JOptionPane.showMessageDialog(this, "Ngày không hợp lệ. Vui lòng nhập ngày trong quá khứ hoặc hiện tại");
                            return;
                        }
                    } catch (DateTimeParseException ex) {
                        JOptionPane.showMessageDialog(this, "Ngày không hợp lệ. Vui lòng nhập theo định dạng DD/MM/YYYY");
                        return;
                    }
                }

                if (!sdt.matches("^0\\d{9}$")) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                    return;
                }

                if (!luongText.isEmpty()) {
                    try {
                        luong = Long.parseLong(luongText);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Lương không hợp lệ");
                        return;
                    }
                }

                if (!chucvu.equals(chucvutmp) && chucvu.equals("Quản lý")) {
                    role = 0;
                } else if (!chucvu.equals(chucvutmp) && chucvu.equals("Nhân viên thu ngân")) {
                    role = 1;
                } else {
                    role = 2;
                }

                switch (role) {
                    case 0 -> {
                        try {
                            String pass = pass_nv.getText().trim();
                            if (pass.isEmpty()) {
                                JOptionPane.showMessageDialog(this, "Đây là chức vụ được cấp tài khoản, vui lòng nhập mật khẩu");
                                return;
                            }
                            status = 0;
                            nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                            user = new user(ma, pass, status) {
                            };
                            list.add(nv);
                            nvBll.add(nv);
                            userBll.add(user);
                            ResetFieldText();
                            UnEditable();
                            loadTable(list);
                            btn_them.setEnabled(true);
                            pass_nv.setEditable(false);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    }
                    case 1 -> {
                        String pass = pass_nv.getText().trim();
                        if (pass.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Đây là chức vụ được cấp tài khoản, vui lòng nhập mật khẩu");
                            return;
                        }
                        status = 1;
                        nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                        user = new user(ma, pass, status) {
                        };
                        list.add(nv);
                        nvBll.add(nv);
                        userBll.add(user);
                        ResetFieldText();
                        UnEditable();
                        loadTable(list);
                        btn_them.setEnabled(true);
                        pass_nv.setEditable(false);
                    }
                    case 2 -> {
                        if (!pass_nv.getText().trim().isEmpty()) {
                            int confirm = JOptionPane.showConfirmDialog(this, "Chức vụ này không được cấp tài khoản, bạn có muốn đổi chức vụ ?");
                            if (confirm == JOptionPane.YES_OPTION) {
                                return;
                            }
                            status = 2;
                            nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                            list.add(nv);
                            nvBll.add(nv);
                            ResetFieldText();
                            UnEditable();
                            loadTable(list);
                            btn_them.setEnabled(true);
                            pass_nv.setEditable(false);
                        } else {
                            status = 2;
                            nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                            list.add(nv);
                            nvBll.add(nv);
                            ResetFieldText();
                            UnEditable();
                            loadTable(list);
                            btn_them.setEnabled(true);
                            pass_nv.setEditable(false);
                        }
                    }
                }
            }
            case 2 -> {
                // Sửa
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                boolean found = false;
                String ma = ma_nv.getText().trim();
                String ho = ho_nv.getText().trim();
                String ten = ten_nv.getText().trim();
                String gioitinh = (String) gioitinh_nv.getSelectedItem();
                String ngaysinh = ngaysinh_nv.getText().trim();
                String sdt = sdt_nv.getText().trim();
                String chucvu = (String) chucvu_nv.getSelectedItem();
                String luongText = luong_nv.getText().trim();

                if (!matmp.equals(ma)) {
                    for (nhanVien tmp : list) {
                        if (tmp.getManv().equals(ma)) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(this, "Mã nhân viên đã tồn tại");
                    return;
                }
                if (ma.isEmpty() || ho.isEmpty() || ten.isEmpty() || ngaysinh.isEmpty() || sdt.isEmpty() || luongText.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin");
                    return;
                }
                if (!ngaysinh.isEmpty()) {
                    try {
                        LocalDate date = LocalDate.parse(ngaysinh, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        // Kiểm tra tính hợp lệ của ngày tháng
                        // Ví dụ: kiểm tra ngày tháng không nằm trong tương lai
                        LocalDate currentDate = LocalDate.now();
                        if (date.isAfter(currentDate)) {
                            JOptionPane.showMessageDialog(this, "Ngày không hợp lệ. Vui lòng nhập ngày trong quá khứ hoặc hiện tại");
                            return;
                        }
                    } catch (DateTimeParseException ex) {
                        JOptionPane.showMessageDialog(this, "Ngày không hợp lệ. Vui lòng nhập theo định dạng DD/MM/YYYY");
                        return;
                    }
                }
                if (!sdt.matches("^0\\d{9}$")) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                    return;
                }
                if (!luongText.isEmpty()) {
                    try {
                        luong = Long.parseLong(luongText);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Lương không hợp lệ");
                        return;
                    }
                }
                if (matmp.equals(ma) && hotmp.equals(ho) && tentmp.equals(ten) && gioitinhtmp.equals(gioitinh) && ngaysinhtmp.equals(ngaysinh) && sdttmp.equals(sdt) && chucvutmp.equals(chucvu) && luongTexttmp.equals(luongText)) {
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

                if (!chucvu.equals(chucvutmp) && chucvu.equals("Quản lý")) {
                    role = 0;
                } else if (!chucvu.equals(chucvutmp) && chucvu.equals("Nhân viên thu ngân")) {
                    role = 1;
                } else {
                    role = 2;
                }

                switch (role) {
                    case 0 -> {
                        String pass = pass_nv.getText().trim();
                        status = 0;
                        boolean flag = false;
                        for (user tmp : listUser) {
                            if (tmp.getUsername().equals(ma)) {
                                flag = true;
                            }
                        }
                        if (flag) {
                            int confirm = JOptionPane.showConfirmDialog(this, "Đối tượng này đã có tài khoản, bạn có muốn tiếp tục");
                            if (confirm == JOptionPane.YES_OPTION) {
                                try {
                                    nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                                    nvBll.update(nv, matmp);
                                    ResetFieldText();
                                    UnEditable();
                                    clearTable();
                                    getTable();
                                    btn_sua.setEnabled(true);
                                    pass_nv.setEditable(false);
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                            }
                        } else {
                            if (pass.isEmpty()) {
                                JOptionPane.showMessageDialog(this, "Đây là chức vụ được cấp tài khoản, vui lòng nhập mật khẩu");
                                return;
                            }
                            try {
                                nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                                user = new user(ma, pass, status) {
                                };
                                nvBll.update(nv, matmp);
                                userBll.add(user);
                                ResetFieldText();
                                UnEditable();
                                clearTable();
                                getTable();
                                btn_sua.setEnabled(true);
                                pass_nv.setEditable(false);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    }
                    case 1 -> {
                        String pass = pass_nv.getText().trim();
                        status = 1;
                        boolean flag = false;
                        for (user tmp : listUser) {
                            if (tmp.getUsername().equals(ma)) {
                                flag = true;
                            }
                        }
                        if (flag) {
                            int confirm = JOptionPane.showConfirmDialog(this, "Đối tượng này đã có tài khoản, bạn có muốn tiếp tục");
                            if (confirm == JOptionPane.YES_OPTION) {
                                try {
                                    nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                                    nvBll.update(nv, matmp);
                                    ResetFieldText();
                                    UnEditable();
                                    clearTable();
                                    getTable();
                                    btn_sua.setEnabled(true);
                                    pass_nv.setEditable(false);
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                            }
                        } else {
                            if (pass.isEmpty()) {
                                JOptionPane.showMessageDialog(this, "Đây là chức vụ được cấp tài khoản, vui lòng nhập mật khẩu");
                                return;
                            }
                            try {
                                nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                                user = new user(ma, pass, status) {
                                };
                                nvBll.update(nv, matmp);
                                userBll.add(user);
                                ResetFieldText();
                                UnEditable();
                                clearTable();
                                getTable();
                                btn_sua.setEnabled(true);
                                pass_nv.setEditable(false);
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    }
                    case 2 -> {
                        boolean flag = false;
                        for (user tmp : listUser) {
                            if (tmp.getUsername().equals(ma)) {
                                flag = true;
                            }
                        }
                        if (flag) {
                            int confirm = JOptionPane.showConfirmDialog(this, "Đối tượng này đã có tài khoản, bạn có muốn xóa tài khoản đó không ?");
                            if (confirm == JOptionPane.YES_OPTION) {
                                try {
                                    nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                                    nvBll.update(nv, matmp);
                                    userBll.delete(ma);
                                    ResetFieldText();
                                    UnEditable();
                                    clearTable();
                                    getTable();
                                    btn_sua.setEnabled(true);
                                    pass_nv.setEditable(false);
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                            }
                        } else {
                            if (!pass_nv.getText().trim().isEmpty()) {
                                int confirm = JOptionPane.showConfirmDialog(this, "Chức vụ này không được cấp tài khoản, bạn có muốn đổi chức vụ ?");
                                if (confirm == JOptionPane.YES_OPTION) {
                                    return;
                                }
                                try {
                                    nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                                    nvBll.update(nv, matmp);
                                    ResetFieldText();
                                    UnEditable();
                                    clearTable();
                                    getTable();
                                    btn_sua.setEnabled(true);
                                    pass_nv.setEditable(false);
                                } catch (Exception ex) {
                                    System.out.println(ex);
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        String ma = ma_nv.getText();
        matmp = ma_nv.getText();
        String ho = ho_nv.getText();
        hotmp = ho_nv.getText();
        String ten = ten_nv.getText();
        tentmp = ten_nv.getText();
        gioitinhtmp = (String) gioitinh_nv.getSelectedItem();
        String ngaysinh = ngaysinh_nv.getText();
        ngaysinhtmp = ngaysinh_nv.getText();
        String sdt = sdt_nv.getText();
        sdttmp = sdt_nv.getText();
        chucvutmp = (String) chucvu_nv.getSelectedItem();
        String luongText = luong_nv.getText();
        luongTexttmp = luong_nv.getText();
        if (ma.isEmpty() && ho.isEmpty() && ten.isEmpty() && ngaysinh.isEmpty() && sdt.isEmpty() && luongText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần sửa");
        } else {
            Editable();
            count = 2;
            btn_sua.setEnabled(false);
            pass_nv.setEditable(true);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        String ma = ma_nv.getText().trim();
        String ho = ho_nv.getText().trim();
        String ten = ten_nv.getText().trim();
        String gioitinh = (String) gioitinh_nv.getSelectedItem();
        String ngaysinh = ngaysinh_nv.getText().trim();
        String sdt = sdt_nv.getText().trim();
        String chucvu = (String) chucvu_nv.getSelectedItem();
        String luongText = luong_nv.getText().trim();

        if (ma.isEmpty() && ho.isEmpty() && ten.isEmpty() && ngaysinh.isEmpty() && sdt.isEmpty() && luongText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đối tượng cần xóa");
        } else {
            try {
                int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa ?");

                if (confirm == JOptionPane.YES_OPTION) {
                    luong = Long.parseLong(luongText);
                    nv = new nhanVien(ma, ho, ten, gioitinh, sdt, ngaysinh, chucvu, luong);
                    list.remove(nv);
                    nvBll.delete(nv);
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

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
      String byWhat = (String) combobox_search.getSelectedItem();
      String keyword = search_nv.getText();
      clearTable();
      getTableSearch(keyword , byWhat);
    }//GEN-LAST:event_btn_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_luu;
    public javax.swing.JButton btn_reset;
    public javax.swing.JButton btn_search;
    public javax.swing.JButton btn_sua;
    public javax.swing.JButton btn_them;
    public javax.swing.JButton btn_xoa;
    public javax.swing.JComboBox<String> chucvu_nv;
    public javax.swing.JComboBox<String> combobox_search;
    public javax.swing.JComboBox<String> gioitinh_nv;
    public javax.swing.JTextField ho_nv;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField luong_nv;
    public javax.swing.JTextField ma_nv;
    public javax.swing.JTextField ngaysinh_nv;
    public javax.swing.JTextField pass_nv;
    public javax.swing.JTextField sdt_nv;
    public javax.swing.JTextField search_nv;
    public javax.swing.JTable table_nv;
    public javax.swing.JTextField ten_nv;
    // End of variables declaration//GEN-END:variables
}
