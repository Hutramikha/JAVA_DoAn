package DTO;

public class khachHang{
    private String makh;
    private String ten;
    private String sdt;
    private String email;
//    public static String[]columnName = {"Mã khách hàng" , "Tên đăng nhập" , "Tên khách hàng" , "Số điện thoại" , "Email"};
    
    public String getMakh() {
        return makh;
    }

    public String getTen() {
        return ten;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public khachHang(String makh, String ten, String sdt, String email) {
        this.makh = makh;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
    }

    public khachHang() {
    }
    
    
     @Override
    public String toString() {
        return "khachHang{" + "makh=" + makh + ", ten=" + ten + ", sdt=" + sdt + ", email=" + email + '}';
    }
    

    
    
//    public void createKH(JPanel sa) {
//        String q1 = "INSERT INTO login(username,password,status)" + " VALUES (?, ?, ?)";
//        String q2 = "INSERT INTO khachhang(username,ten,sdt,email)" + " VALUES (?, ?, ?, ?)";
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
//            st2.setString(2, ten);
//            st2.setString(3, sdt);
//            st2.setString(4, email);
//            st2.execute();
//
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
//            }
//        }
//    }
//    
//    public void takeData() {
//        String query = "SELECT makh, username, ten, sdt, email FROM khachhang WHERE username=?";
//        Connection conn = null;
//        PreparedStatement st = null;
//        ResultSet rs = null;
//        System.out.println(query);
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(database.dburl, database.user, database.passwd);
//            st = conn.prepareStatement(query);
//            st.setString(1, tendn);
//            rs = st.executeQuery();
//            System.out.println("results received");
//            while (rs.next()) {
//                this.makh = rs.getInt("makh");
//                this.tendn = rs.getString("username");
//                this.ten = rs.getString("ten");
//                this.sdt = rs.getString("sdt");
//                this.email = rs.getString("email");
//            }
//        } catch (Exception ex) {
//            System.out.println("Exception: " + ex.getMessage());
//            ex.printStackTrace();
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
//                ex.printStackTrace();
//            }
//        }
//    }
//    
//    public void updateKH(String ten2 , String sdt2 , String email2) {
//        String query = "UPDATE `khachhang` SET `ten`='" + ten2 + "', `sdt`='" + sdt2 + "', `email`='" + email2 + "' WHERE `username`='" + this.username + "';";
//        Connection conn = null;
//        Statement st = null;
//        System.out.println(query);
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(database.dburl, database.user , database.passwd);
//            st = conn.createStatement();
//            st.executeUpdate(query);
//            System.out.println("data inserted");
//            JOptionPane.showMessageDialog(null, "ĐÃ CẬP NHẬT THÔNG TIN");
//            this.ten = ten2;
//            this.sdt = sdt2;
//            this.email = email2;
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
//     public void deleteKH() {
//        String query1 = "DELETE FROM `login` WHERE `username`='" + this.username + "';";
//        String query2 = "DELETE FROM `khachhang` WHERE `username`='" + this.username + "';";
//        Connection conn = null;
//        Statement st = null;
//        System.out.println(query1);
//        System.out.println(query2);
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(database.dburl, database.user , database.passwd);
//            st = conn.createStatement();
//            st.execute(query1);
//            st.execute(query2);
//            System.out.println("data deleted");
//            JOptionPane.showMessageDialog(null, "ĐÃ XÓA");
//            this.makh = 0;
//            this.tendn = "";
//            this.ten = "";
//            this.sdt = "";
//            this.email = "";
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
//     public static DefaultTableModel searchKH(String keyword) {
//        DefaultTableModel model = new DefaultTableModel();
//        model.setColumnIdentifiers(columnName);
//        
//        String query = "SELECT * FROM `khachhang` WHERE ";
//        String columnQuery = "";
//        columnQuery += "`makh` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`username` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`ten` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`email` LIKE '%" + keyword + "%' OR ";
//        columnQuery += "`diachi` LIKE '%" + keyword + "%' OR ";
//        columnQuery = columnQuery.substring(0, columnQuery.lastIndexOf(" OR "));// Loại bỏ " OR " cuối cùng
//        query += columnQuery + ";";
//        
//        Connection conn = null;
//        Statement st = null;
//        ResultSet rs = null;
//        System.out.println(query);
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(database.dburl, database.user, database.passwd);
//            st = conn.createStatement();
//            rs = st.executeQuery(query);
//            System.out.println("results received");
//            
//            while (rs.next()) {
//                model.addRow(new Object[]{rs.getInt("makh"), rs.getString("username"), rs.getString("ten"), rs.getString("sdt"), rs.getString("diachi")});
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

