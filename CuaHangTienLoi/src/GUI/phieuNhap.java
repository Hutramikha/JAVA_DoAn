package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class phieuNhap extends JPanel {

    public phieuNhap() {
        initComponents();
    }

    // Variables declaration - do not modify                     
    public javax.swing.JButton btTimKiem;
    public javax.swing.JComboBox<String> cbLoc;
    public javax.swing.JComboBox<String> cbSapXep;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lLoc;
    public javax.swing.JLabel lSapXep;
    public javax.swing.JLabel lMaPhieuNhap;
    public javax.swing.JLabel lMaNhaCC;
    public javax.swing.JLabel lMaNhanVien;
    public javax.swing.JLabel lNgayTao;
    public javax.swing.JLabel lTongTien;
    public javax.swing.JTextField tMaPhieuNhap;
    public javax.swing.JTextField tMaNhaCC;
    public javax.swing.JTextField tMaNhanVien;
    public javax.swing.JTextField tNgayTao;
    public javax.swing.JTextField tTongTien;
    public javax.swing.JTextField thanhTimKiem;
    public javax.swing.JTable tbPhieuNhap;
    public javax.swing.JPopupMenu menu;
    public javax.swing.JMenuItem chiTiet;
    public javax.swing.JMenuItem them;
    public javax.swing.JMenuItem sua;
    public javax.swing.JMenuItem xoa;
    public javax.swing.JDialog dialogThem;
    public javax.swing.JDialog dialogSua;
    public javax.swing.JButton luu;
    // End of variables declaration                   

    // Code của initComponents() được copy từ class khác
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhieuNhap = new javax.swing.JTable();
        thanhTimKiem = new javax.swing.JTextField();
        btTimKiem = new javax.swing.JButton();
        cbSapXep = new javax.swing.JComboBox<>();
        lSapXep = new javax.swing.JLabel();
        cbLoc = new javax.swing.JComboBox<>();
        lLoc = new javax.swing.JLabel();
        menu = new JPopupMenu();
        them = new JMenuItem("Thêm");
        sua = new JMenuItem("Sửa");
        xoa = new JMenuItem("Xóa");
        chiTiet = new JMenuItem("Chi tiết");

        tMaPhieuNhap = new javax.swing.JTextField();
        tMaNhaCC = new javax.swing.JTextField();
        tMaNhanVien = new javax.swing.JTextField();
        tNgayTao = new javax.swing.JTextField();
        tTongTien = new javax.swing.JTextField();
        lMaPhieuNhap = new javax.swing.JLabel();
        lMaNhaCC = new javax.swing.JLabel();
        lMaNhanVien = new javax.swing.JLabel();
        lNgayTao = new javax.swing.JLabel();
        lTongTien = new javax.swing.JLabel();
        luu = new JButton("Lưu");
        
        tMaPhieuNhap.setBounds(320, 30, 200, 22);
        tMaNhaCC.setBounds(320, 60, 200, 22);
        tMaNhanVien.setBounds(320, 90, 200, 22);
        tNgayTao.setBounds(320, 120, 200, 22);
        tTongTien.setBounds(320, 150, 200, 22);
        
        lMaPhieuNhap.setBounds(50, 30, 250, 22);
        lMaPhieuNhap.setText("Mã phiếu nhập:");
        
        lMaNhaCC.setBounds(50, 60, 250, 22);
        lMaNhaCC.setText("Mã nhà cung cấp:");
        
        lMaNhanVien.setBounds(50, 90, 250, 22);
        lMaNhanVien.setText("Mã nhân viên:");
        
        lNgayTao.setBounds(50, 120, 250, 22);
        lNgayTao.setText("Ngày tạo:");
        
        lTongTien.setBounds(50, 150, 250, 22);
        lTongTien.setText("Tổng tiền:");
        
        luu.setBounds(460, 180, 60, 25);

        // Thêm các menu item vào JPopupMenu
        menu.add(them);
        menu.add(sua);
        menu.add(xoa);
        menu.add(chiTiet);

        setBackground(new java.awt.Color(255,255,255));

        tbPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày tạo", "Tổng tiền"
                }
        ));
        jScrollPane1.setViewportView(tbPhieuNhap);

        btTimKiem.setText("Tìm kiếm");

        cbSapXep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Tăng dần", "Giảm dần"}));

        lSapXep.setForeground(new java.awt.Color(255, 255, 255));
        lSapXep.setText("Sắp xếp:");

        cbLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Mã phiếu nhập", "Mã nhà cung cấp", "Mã nhân viên", "Ngày tạo", "Tổng tiền", " "}));

        lLoc.setForeground(new java.awt.Color(255, 255, 255));
        lLoc.setText("Lọc theo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(140, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(thanhTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btTimKiem)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lLoc)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lSapXep)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(89, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(thanhTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btTimKiem)
                                        .addComponent(cbSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lSapXep)
                                        .addComponent(cbLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lLoc))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70))
        );
        

        tbPhieuNhap.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    int row = tbPhieuNhap.rowAtPoint(e.getPoint());
                    int column = tbPhieuNhap.columnAtPoint(e.getPoint());
                    if (row >= 0 && column >= 0) {
                        menu.show(e.getComponent(), e.getX(), e.getY());
                        // Xử lý sự kiện click chuột phải tại dòng và cột tương ứng
                        System.out.println("Right clicked on row: " + row + ", column: " + column);
                    }
                }
            }
        });

        them.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDialogThem();
            }
        });

        // Thêm ActionListener cho sua
        sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDialogSua();
            }
        });

        // Thêm ItemListener cho xoa
        xoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc chắn muốn xóa?",
                        "Xác nhận xóa",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Xóa dòng được chọn khỏi bảng
                }
            }
        });
        
        chiTiet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Mở chi tiết phiếu nhập
            }
        });
    }
    private void showDialogThem() {
        dialogThem = new JDialog();
        dialogThem.setSize(600, 250);
        dialogThem.setLayout(null);
        dialogThem.setTitle("Thêm dữ liệu");
        
        // ... Thêm các thành phần giao diện người dùng và logic xử lý thêm dữ liệu vào dialogThem
        dialogThem.add(lMaPhieuNhap);
        dialogThem.add(lMaNhaCC);
        dialogThem.add(lMaNhanVien);
        dialogThem.add(lNgayTao);
        dialogThem.add(lTongTien);
        dialogThem.add(tMaPhieuNhap);
        dialogThem.add(tMaNhaCC);
        dialogThem.add(tMaNhanVien);
        dialogThem.add(tNgayTao);
        dialogThem.add(tTongTien);
        dialogThem.add(luu);
        
        dialogThem.setModal(true);
        dialogThem.setLocationRelativeTo(null);
        dialogThem.setVisible(true);
    }
    
    private void showDialogSua() {
        dialogSua = new JDialog();
        dialogSua.setSize(600, 250);
        dialogSua.setLayout(null);
        dialogSua.setTitle("Sửa dữ liệu");
        
        // ... Thêm các thành phần giao diện người dùng và logic xử lý sửa dữ liệu vào dialogSua
        dialogSua.add(lMaPhieuNhap);
        dialogSua.add(lMaNhaCC);
        dialogSua.add(lMaNhanVien);
        dialogSua.add(lNgayTao);
        dialogSua.add(lTongTien);
        dialogSua.add(tMaPhieuNhap);
        dialogSua.add(tMaNhaCC);
        dialogSua.add(tMaNhanVien);
        dialogSua.add(tNgayTao);
        dialogSua.add(tTongTien);
        dialogSua.add(luu);
        
        dialogSua.setModal(true);
        dialogSua.setLocationRelativeTo(null);
        dialogSua.setVisible(true);
    }
}
