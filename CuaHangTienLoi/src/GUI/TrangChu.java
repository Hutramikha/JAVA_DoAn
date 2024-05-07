package GUI;

import java.awt.Color;
import javax.swing.*;
import java.awt.CardLayout;
import java.awt.Cursor;
import BLL.NhanVienBLL;
import BLL.UserBLL;
import BLL.SanPhamBLL;
import DTO.*;

public final class TrangChu extends JFrame {

    CardLayout cardlayout;
    private boolean isMenuVisible;
    NhanVienView nvView = new NhanVienView();
    SanPhamView spView = new SanPhamView();
    KhachHangView khView = new KhachHangView();
    NhaCungCap nccView = new NhaCungCap();
    DanhMucView dmView = new DanhMucView();
    phieuNhap pnView = new phieuNhap();
    HoaDonView hdView = new HoaDonView();
    CTHoaDonView ctHDView = new CTHoaDonView();
    HELLO helloView = new HELLO();
    XemThongTin ttView = new XemThongTin();
    doanhthu dtView = new doanhthu();
    
    NhanVienBLL nvBLL = new NhanVienBLL(null);
    SanPhamBLL spBLL = new SanPhamBLL(null);;
    UserBLL userBLL = new UserBLL();
    nhanVien nv = new nhanVien();
    user user = new user();

    
    public TrangChu(String username) {
        initComponents();
        lTenTK.setText("Xin chào: " + username);
        helloView.hello_field.setText("Mừng trở lại " + username);
        hdView.ma_nv.setText(username);
        
        nv = nvBLL.getOne(username);
        ttView.ma_nv.setText(nv.getManv());
        ttView.ho_nv.setText(nv.getHo());
        ttView.ten_nv.setText(nv.getTen());
        ttView.gioitinh_nv.setText(nv.getGioitinh());
        ttView.sdt_nv.setText(nv.getSdt());
        ttView.ngaysinh_nv.setText(nv.getNgaySinh());
        ttView.chucvu_nv.setText(nv.getChucVu());
        String luongTxt = String.valueOf(nv.getLuong());
        ttView.luong_nv.setText(luongTxt);
        
        user = userBLL.getOne(username);
        ttView.pass_nv.setText(user.getPassword());
    }

    public void ClearTableALL() {
        nvView.clearTable();
        spView.clearTable();
        khView.clearTable();
        nccView.clearTable();
        dmView.clearTable();
       ctHDView.clearTableHD();
       dtView.clearTable();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        MenuPanel = new javax.swing.JPanel();
        Pane_cover = new javax.swing.JPanel();
        Pane_content = new javax.swing.JPanel();
        pHoaDon = new javax.swing.JPanel();
        lHoaDon = new javax.swing.JLabel();
        pChiTietHD = new javax.swing.JPanel();
        lChiTietHD = new javax.swing.JLabel();
        pDanhMuc = new javax.swing.JPanel();
        lDanhMuc = new javax.swing.JLabel();
        pSanPham = new javax.swing.JPanel();
        lSanPham = new javax.swing.JLabel();
        pDoanhThu = new javax.swing.JPanel();
        lDoanhThu = new javax.swing.JLabel();
        pNhanVien = new javax.swing.JPanel();
        lNhanVien = new javax.swing.JLabel();
        pQuanLyKH = new javax.swing.JPanel();
        lQuanLyKH = new javax.swing.JLabel();
        pNhaCC = new javax.swing.JPanel();
        lNhaCC = new javax.swing.JLabel();
        pDangXuat = new javax.swing.JPanel();
        lDangXuat = new javax.swing.JLabel();
        pTaiKhoan = new javax.swing.JPanel();
        lTaiKhoan = new javax.swing.JLabel();
        pPhieuNhap = new javax.swing.JPanel();
        lPhieuNhap = new javax.swing.JLabel();
        lTenTK = new javax.swing.JLabel();
        

        cardlayout = new CardLayout();
        Pane_content.setLayout(cardlayout);
        
        Pane_content.add(helloView, "hello");
        Pane_content.add(nvView, "QL Nhân Viên");
        Pane_content.add(spView, "QL Sản Phẩm");
        Pane_content.add(khView, "QL Khách Hàng");
        Pane_content.add(pnView, "Phiếu Nhập");
        Pane_content.add(nccView, "Nhà Cung Cấp");
        Pane_content.add(dmView, "Danh Mục");
        Pane_content.add(hdView, "Hóa Đơn");
        Pane_content.add(ctHDView, "Chi Tiết HĐ");
        Pane_content.add(ttView, "Tài Khoản");
        Pane_content.add(dtView,"Doanh Thu");
        
        
        isMenuVisible = true;
        Pane_content.setVisible(isMenuVisible);
        
        
        this.setSize(1240, 690);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        MenuPanel.setLayout(null);

        MenuPanel.setBackground(new java.awt.Color(29, 117, 109));

        Pane_cover.setSize(1240, 690);
        Pane_cover.setBackground(Color.white);
        Pane_content.setBackground(Color.white);
        MenuPanel.setBounds(0, 0, 200, 690);
        Pane_content.setBounds(205, 0, 1015, 690);

        Pane_cover.setLayout(null);
        this.setLayout(null);

        lTenTK.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lTenTK.setForeground(new java.awt.Color(255, 255, 255));
        lTenTK.setBounds(0, 20, 200, 30);
        //lTenTK.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        lTenTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTenTK.setText("Xin chào:");

        pHoaDon.setLayout(null);
        pHoaDon.setBackground(new java.awt.Color(29, 117, 109));
        pHoaDon.setBounds(0, 75, 200, 50);
        pHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableALL();
                isMenuVisible = true;
                Pane_content.setVisible(isMenuVisible);
                cardlayout.show(Pane_content, "Hóa Đơn");
                hdView.comboBox();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pHoaDon.setBackground(new Color(64, 164, 156));
                pHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pHoaDon.setBackground(new Color(29, 117, 109));
            }
        });

        lHoaDon.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        //lHoaDon.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        lHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lHoaDon.setText("Hóa Đơn");
        int labelX = (pHoaDon.getWidth() - lHoaDon.getPreferredSize().width) / 2;
        int labelY = (pHoaDon.getHeight() - lHoaDon.getPreferredSize().height) / 2;
        lHoaDon.setBounds(labelX, labelY, lHoaDon.getPreferredSize().width, lHoaDon.getPreferredSize().height);

        pChiTietHD.setLayout(null);
        pChiTietHD.setBackground(new java.awt.Color(29, 117, 109));
        pChiTietHD.setBounds(0, 125, 200, 50);
        pChiTietHD.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableALL();
                isMenuVisible = true;
                Pane_content.setVisible(isMenuVisible);
                cardlayout.show(Pane_content, "Chi Tiết HĐ");
                ctHDView.getTableHD();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pChiTietHD.setBackground(new Color(64, 164, 156));
                pChiTietHD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pChiTietHD.setBackground(new Color(29, 117, 109));
            }
        });

        lChiTietHD.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lChiTietHD.setForeground(new java.awt.Color(255, 255, 255));
        lChiTietHD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lChiTietHD.setText("Chi Tiết HĐ");
        labelX = (pHoaDon.getWidth() - lChiTietHD.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lChiTietHD.getPreferredSize().height) / 2;
        lChiTietHD.setBounds(labelX, labelY, lChiTietHD.getPreferredSize().width, lChiTietHD.getPreferredSize().height);

        pDanhMuc.setLayout(null);
        pDanhMuc.setBackground(new java.awt.Color(29, 117, 109));
        pDanhMuc.setBounds(0, 175, 200, 50);
        pDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableALL();
                isMenuVisible = true;
                Pane_content.setVisible(isMenuVisible);
                cardlayout.show(Pane_content, "Danh Mục");
                dmView.revalidate();
                dmView.repaint();
                dmView.getTable();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pDanhMuc.setBackground(new Color(64, 164, 156));
                pDanhMuc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pDanhMuc.setBackground(new Color(29, 117, 109));
            }
        });

        lDanhMuc.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lDanhMuc.setForeground(new java.awt.Color(255, 255, 255));
        lDanhMuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDanhMuc.setText("Danh Mục");
        labelX = (pHoaDon.getWidth() - lDanhMuc.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lDanhMuc.getPreferredSize().height) / 2;
        lDanhMuc.setBounds(labelX, labelY, lDanhMuc.getPreferredSize().width, lDanhMuc.getPreferredSize().height);

        pSanPham.setLayout(null);
        pSanPham.setBackground(new java.awt.Color(29, 117, 109));
        pSanPham.setBounds(0, 225, 200, 50);

        // Nút hiện QL Sản Phẩm
        pSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableALL();
                isMenuVisible = true;
                Pane_content.setVisible(isMenuVisible);
                cardlayout.show(Pane_content, "QL Sản Phẩm");
                spView.getTable();
                spView.comboBox();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pSanPham.setBackground(new Color(64, 164, 156));
                pSanPham.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pSanPham.setBackground(new Color(29, 117, 109));
            }
        });

        lSanPham.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lSanPham.setText("QL Sản Phẩm");
        labelX = (pHoaDon.getWidth() - lSanPham.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lSanPham.getPreferredSize().height) / 2;
        lSanPham.setBounds(labelX, labelY, lSanPham.getPreferredSize().width, lSanPham.getPreferredSize().height);

        pDoanhThu.setLayout(null);
        pDoanhThu.setBackground(new java.awt.Color(29, 117, 109));
        pDoanhThu.setBounds(0, 275, 200, 50);
        pDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (user.getStatus() == 0) {
                    ClearTableALL();
                    isMenuVisible = true;
                    Pane_content.setVisible(isMenuVisible);
                    cardlayout.show(Pane_content, "Doanh Thu");
                } else {}
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pDoanhThu.setBackground(new Color(64, 164, 156));
                pDoanhThu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pDoanhThu.setBackground(new Color(29, 117, 109));
            }
        });

        lDoanhThu.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        lDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDoanhThu.setText("Doanh Thu");
        labelX = (pHoaDon.getWidth() - lDoanhThu.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lDoanhThu.getPreferredSize().height) / 2;
        lDoanhThu.setBounds(labelX, labelY, lDoanhThu.getPreferredSize().width, lDoanhThu.getPreferredSize().height);

        pNhanVien.setLayout(null);
        pNhanVien.setBackground(new java.awt.Color(29, 117, 109));
        pNhanVien.setBounds(0, 325, 200, 50);

        // Nút hiện QL Nhân Viên
        pNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (user.getStatus() == 0) {
                    ClearTableALL();
                    isMenuVisible = true;
                    Pane_content.setVisible(isMenuVisible);
                    cardlayout.show(Pane_content, "QL Nhân Viên");
                    nvView.getTable();
                } else {}
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pNhanVien.setBackground(new Color(64, 164, 156));
                pNhanVien.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pNhanVien.setBackground(new Color(29, 117, 109));
            }
        });

        lNhanVien.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lNhanVien.setText("QL Nhân Viên");
        labelX = (pHoaDon.getWidth() - lNhanVien.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lNhanVien.getPreferredSize().height) / 2;
        lNhanVien.setBounds(labelX, labelY, lNhanVien.getPreferredSize().width, lNhanVien.getPreferredSize().height);

        pNhaCC.setLayout(null);
        pNhaCC.setBackground(new java.awt.Color(29, 117, 109));
        pNhaCC.setBounds(0, 375, 200, 50);
        pNhaCC.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableALL();
                isMenuVisible = true;
                Pane_content.setVisible(isMenuVisible);
                cardlayout.show(Pane_content, "Nhà Cung Cấp");
                nccView.getTable();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pNhaCC.setBackground(new Color(64, 164, 156));
                pNhaCC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pNhaCC.setBackground(new Color(29, 117, 109));
            }
        });

        lNhaCC.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lNhaCC.setForeground(new java.awt.Color(255, 255, 255));
        lNhaCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lNhaCC.setText("Nhà Cung Cấp");
        labelX = (pHoaDon.getWidth() - lNhaCC.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lNhaCC.getPreferredSize().height) / 2;
        lNhaCC.setBounds(labelX, labelY, lNhaCC.getPreferredSize().width, lNhaCC.getPreferredSize().height);

        pQuanLyKH.setLayout(null);
        pQuanLyKH.setBackground(new java.awt.Color(29, 117, 109));
        pQuanLyKH.setBounds(0, 425, 200, 50);

        // Nút hiện QL Khách Hàng
        pQuanLyKH.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableALL();
                isMenuVisible = true;
                Pane_content.setVisible(isMenuVisible);
                cardlayout.show(Pane_content, "QL Khách Hàng");
                khView.getTable();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pQuanLyKH.setBackground(new Color(64, 164, 156));
                pQuanLyKH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pQuanLyKH.setBackground(new Color(29, 117, 109));
            }
        });

        lQuanLyKH.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lQuanLyKH.setForeground(new java.awt.Color(255, 255, 255));
        lQuanLyKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lQuanLyKH.setText("QL Khách Hàng");
        labelX = (pHoaDon.getWidth() - lQuanLyKH.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lQuanLyKH.getPreferredSize().height) / 2;
        lQuanLyKH.setBounds(labelX, labelY, lQuanLyKH.getPreferredSize().width, lQuanLyKH.getPreferredSize().height);

        pPhieuNhap.setLayout(null);
        pPhieuNhap.setBackground(new java.awt.Color(29, 117, 109));
        pPhieuNhap.setBounds(0, 475, 200, 50);
        pPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableALL();
                isMenuVisible = true;
                Pane_content.setVisible(isMenuVisible);
                cardlayout.show(Pane_content, "QL Phiếu Nhập");
//                khView.getTable();
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pPhieuNhap.setBackground(new Color(64, 164, 156));
                pPhieuNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pPhieuNhap.setBackground(new Color(29, 117, 109));
            }
        });

        lPhieuNhap.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        lPhieuNhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPhieuNhap.setText("QL Phiếu Nhập");
        labelX = (pHoaDon.getWidth() - lPhieuNhap.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lPhieuNhap.getPreferredSize().height) / 2;
        lPhieuNhap.setBounds(labelX, labelY, lPhieuNhap.getPreferredSize().width, lPhieuNhap.getPreferredSize().height);

        pTaiKhoan.setLayout(null);
        pTaiKhoan.setBackground(new java.awt.Color(29, 117, 109));
        pTaiKhoan.setBounds(0, 525, 200, 50);
        pTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClearTableALL();
                isMenuVisible = true;
                Pane_content.setVisible(isMenuVisible);
                cardlayout.show(Pane_content, "Tài Khoản");
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pTaiKhoan.setBackground(new Color(64, 164, 156));
                pTaiKhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pTaiKhoan.setBackground(new Color(29, 117, 109));
            }
        });

        lTaiKhoan.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        lTaiKhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTaiKhoan.setText("Tài Khoản");
        labelX = (pHoaDon.getWidth() - lTaiKhoan.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lTaiKhoan.getPreferredSize().height) / 2;
        lTaiKhoan.setBounds(labelX, labelY, lTaiKhoan.getPreferredSize().width, lTaiKhoan.getPreferredSize().height);

        pDangXuat.setLayout(null);
        pDangXuat.setBackground(new java.awt.Color(29, 117, 109));
        pDangXuat.setBounds(0, 575, 200, 50);
        pDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất");
                if (confirm == JOptionPane.YES_OPTION) {
                    setVisible(false);
                    FrameLogin login = new FrameLogin();
                    login.setVisible(true);
                }
                else {
                }
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pDangXuat.setBackground(new Color(64, 164, 156));
                pDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pDangXuat.setBackground(new Color(29, 117, 109));
            }
        });

        lDangXuat.setFont(new java.awt.Font("Sitka Text", 0, 16)); // NOI18N
        lDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        lDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDangXuat.setText("Đăng Xuất");
        labelX = (pHoaDon.getWidth() - lDangXuat.getPreferredSize().width) / 2;
        labelY = (pHoaDon.getHeight() - lDangXuat.getPreferredSize().height) / 2;
        lDangXuat.setBounds(labelX, labelY, lDangXuat.getPreferredSize().width, lDangXuat.getPreferredSize().height);

        MenuPanel.add(pHoaDon);
        MenuPanel.add(pChiTietHD);
        MenuPanel.add(pDanhMuc);
        MenuPanel.add(pSanPham);
        MenuPanel.add(pDoanhThu);
        MenuPanel.add(pNhanVien);
        MenuPanel.add(pQuanLyKH);
        MenuPanel.add(pNhaCC);
        MenuPanel.add(pDangXuat);
        MenuPanel.add(pTaiKhoan);
        MenuPanel.add(pPhieuNhap);
        MenuPanel.add(lTenTK);

        pHoaDon.setFocusable(true);
        pChiTietHD.setFocusable(true);
        pDanhMuc.setFocusable(true);
        pSanPham.setFocusable(true);
        pDoanhThu.setFocusable(true);
        pNhanVien.setFocusable(true);
        pQuanLyKH.setFocusable(true);
        pNhaCC.setFocusable(true);
        pTaiKhoan.setFocusable(true);
        pDangXuat.setFocusable(true);
        pPhieuNhap.setFocusable(true);

        pHoaDon.add(lHoaDon);
        pChiTietHD.add(lChiTietHD);
        pDanhMuc.add(lDanhMuc);
        pSanPham.add(lSanPham);
        pDoanhThu.add(lDoanhThu);
        pNhanVien.add(lNhanVien);
        pQuanLyKH.add(lQuanLyKH);
        pNhaCC.add(lNhaCC);
        pTaiKhoan.add(lTaiKhoan);
        pDangXuat.add(lDangXuat);
        pPhieuNhap.add(lPhieuNhap);

        Pane_cover.add(MenuPanel);
        Pane_cover.add(Pane_content);
        this.add(Pane_cover);

    }

    // Variables declaration - do not modify 
    public javax.swing.JLabel lChiTietHD;
    public javax.swing.JLabel lDanhMuc;
    public javax.swing.JLabel lDoanhThu;
    public javax.swing.JLabel lHoaDon;
    public javax.swing.JLabel lNhaCC;
    public javax.swing.JLabel lNhanVien;
    public javax.swing.JLabel lSanPham;
    public javax.swing.JLabel lQuanLyKH;
    public javax.swing.JLabel lTaiKhoan;
    public javax.swing.JLabel lDangXuat;
    public javax.swing.JLabel lPhieuNhap;
    public javax.swing.JLabel lTenTK;
    public javax.swing.JPanel pChiTietHD;
    public javax.swing.JPanel pDanhMuc;
    public javax.swing.JPanel pDoanhThu;
    public javax.swing.JPanel pHoaDon;
    public javax.swing.JPanel pNhaCC;
    public javax.swing.JPanel pNhanVien;
    public javax.swing.JPanel pSanPham;
    public javax.swing.JPanel pQuanLyKH;
    public javax.swing.JPanel pTaiKhoan;
    public javax.swing.JPanel pDangXuat;
    public javax.swing.JPanel pPhieuNhap;
    public javax.swing.JPanel MenuPanel;
    public javax.swing.JPanel Pane_cover;
    public javax.swing.JPanel Pane_content;
    // End of variables declaration                   

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new TrangChu("Kahng").setVisible(true);
//            }
//        });
//    }
}
