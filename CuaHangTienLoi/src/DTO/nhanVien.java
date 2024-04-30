package DTO;

public class nhanVien {
    private String manv;
    private String ho;
    private String ten;
    private String gioitinh;
    private String sdt;
    private String ngaySinh;
    private String chucVu;
    private long luong;
//    public static String[] columnNames = {"Mã nhân viên", "Họ", "Tên", "Số điện thoại", "Ngày sinh" , "Chức vụ" , "Lương"};
//    public static String[] chucVus = {"Tạm thời", "Chính thức"};

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }
    
    public String getManv() {
        return manv;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public long getLuong() {
        return luong;
    }
    
     public void setManv(String manv) {
        this.manv = manv;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }

    public nhanVien(String manv, String ho, String ten, String gioitinh, String sdt, String ngaySinh, String chucVu, long luong) {
        this.manv = manv;
        this.ho = ho;
        this.ten = ten;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.chucVu = chucVu;
        this.luong = luong;
    }
    
    public nhanVien() {
    }
    
    @Override
    public String toString() {
        return "nhanVien{" + "manv=" + manv + ", ho=" + ho + ", ten=" + ten + ", sdt=" + sdt + ", ngaySinh=" + ngaySinh + ", chucVu=" + chucVu + ", luong=" + luong + '}';
    }
    
    

//    public void createNV() {
//        String q1 = "INSERT INTO login (username, password, status)" + " VALUES (?, ?, ?)";
//        String q2 = "INSERT INTO nhanvien (manv, ho, ten, sdt, ngaysinh, chucvu, luong)" + " VALUES (?, ?, ?, ?, ?, ?, ?)";
//        Connection conn = null;
//        PreparedStatement st1 = null;
//        PreparedStatement st2 = null;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(database.dburl, database.user, database.passwd);
//
//            st1 = conn.prepareStatement(q1);
//            st1.setString(1, username);
//            st1.setString(2, password);
//            st1.setInt(3, status);
//            st1.execute();
//
//            st2 = conn.prepareStatement(q2);
//            st2.setString(1, username);
//            st2.setString(2, ho);
//            st2.setString(3, ten);
//            st2.setString(4, sdt);
//            st2.setDate(5, ngaySinh);
//            st2.setString(6, chucVu);
//            st2.setInt(7, luong);
//            st2.execute();
//
//            System.out.println("data inserted");
//            JOptionPane.showMessageDialog(null, "ĐÃ TẠO TÀI KHOẢN THÀNH CÔNG !");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "KHÔNG TẠO ĐƯỢC TÀI KHOẢN: " + ex.getMessage());
//        } finally {
//            try {
//                if (st1 != null) {
//                    st1.close();
//                }
//
//                if (st2 != null) {
//                    st2.close();
//                }
//
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//
//    public void takeData() {
//        String query = "SELECT manv, ho, ten, sdt, ngaysinh, chucvu, luong FROM nhanvien WHERE manv=?";
//        Connection conn = null;
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        System.out.println(query);
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(database.dburl, database.user, database.passwd);
//            st = conn.prepareStatement(query);
//            st.setString(1, username);
//            rs = st.executeQuery();
//            System.out.println("results received");
//            boolean f = false;
//            while (rs.next()) {
//                this.manv = rs.getString("manv");
//                this.ho = rs.getString("ho");
//                this.ten = rs.getString("ten");
//                this.sdt = rs.getString("sdt");
//                this.ngaySinh = rs.getDate("ngaysinh");
//                this.chucVu = rs.getString("chucvu");
//                this.luong = rs.getInt("luong");
//            }
//        } catch (Exception ex) {
//            System.out.println("Exception : " + ex.getMessage());
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//
//                if (st != null) {
//                    st.close();
//                }
//
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception ex) {
//                System.out.println("Exception: " + ex.getMessage());
//            }
//        }
//    }
//
//    public void updateNV(String manv2 , String ho2 , String ten2 , String sdt2, Date ngaySinh2 , String chucVu2 , int luong2) {
//        String query = "UPDATE `nhanvien` SET `manv`='" + manv + "', `ho`='" + ho + "', `ten`='" + ten + "', `sdt`='" + sdt + "', `ngaysinh`='" + ngaySinh + "', `chucvu`='" + chucVu +"',`luong`='" + luong + "' WHERE `manv`='" + this.username + "';";
//        Connection conn = null;
//        Statement st = null;
//        System.out.println(query);
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(database.dburl, database.user, database.passwd);
//            st = conn.createStatement();
//            st.executeUpdate(query);
//            System.out.println("data inserted");
//            JOptionPane.showMessageDialog(null, "ĐÃ CẬP NHẬT THÔNG TIN");
//            this.manv = manv2;
//            this.ho = ho2;
//            this.ten = ten2;
//            this.sdt = sdt2;
//            this.ngaySinh = ngaySinh2;
//            this.chucVu = chucVu2;
//            this.luong = luong2;
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "CẬP NHẬT THẤT BẠI");
//            System.out.println("Exception : " + ex.getMessage());
//        } finally {
//            try {
//                if (st != null) {
//                    st.close();
//                }
//
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception ex) {
//            }
//        }
//    }
//
//    public void deleteNV() {
//        String q1 = "DELETE FROM `login` WHERE `username`='" + this.username + "';";
//        String q2 = "DELETE FROM `nhanvien` WHERE `manv`='" + this.username + "';";
//        Connection conn = null;
//        Statement st = null;
//        System.out.println(q1);
//        System.out.println(q2);
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(database.dburl, database.user, database.passwd);
//            System.out.println("connection done");
//            st = conn.createStatement();
//            st.execute(q1);
//            st.execute(q2);
//            System.out.println("data deleted");
//            JOptionPane.showMessageDialog(null, "ĐÃ XÓA");
//            this.manv = "";
//            this.ho = "";
//            this.ten = "";
//            this.sdt = "";
//            this.ngaySinh = null;
//            this.chucVu = "";
//            this.luong = 0;
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "XÓA THẤT BẠI");
//            System.out.println("Exception : " + ex.getMessage());
//        } finally {
//            try {
//                if (st != null) {
//                    st.close();
//                }
//
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception ex) {
//            }
//        }
//    }
//
//    public static DefaultTableModel searchNV(String keyword, String byWhat) {
//        DefaultTableModel model = new DefaultTableModel();
//        model.setColumnIdentifiers(columnNames);
//        
//        String query = "SELECT * FROM `nhanvien` WHERE ";
//        String columnQuery = "";
//        columnQuery += "`manv` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`ho` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`ten` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`sdt` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`ngaysinh` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`chucvu` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`luong` LIKE '%" + keyword + "%' OR ";
//        columnQuery = columnQuery.substring(0, columnQuery.lastIndexOf(" OR "));// Loại bỏ " OR " cuối cùng
//        query += columnQuery + ";";
//        
//        Connection conn = null;
//        Statement st = null;
//        ResultSet rs = null;
//        System.out.println(query);
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("driver loaded");
//            conn = DriverManager.getConnection(database.dburl, database.user, database.passwd);
//            st = conn.createStatement();
//            rs = st.executeQuery(query);
//            System.out.println("results received");
//
//            while (rs.next()) {
//                model.addRow(new Object[]{rs.getString("manv"), rs.getString("ho"), rs.getString("ten"), rs.getString("sdt"), rs.getDate("ngaysinh"), rs.getString("chucvu"), rs.getInt("luong")});
//            }
//        } catch (Exception ex) {
//            System.out.println("Exception : " + ex.getMessage());
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//
//                if (st != null) {
//                    st.close();
//                }
//
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (Exception ex) {
//            }
//        }
//        return model;
//    }

   
}
