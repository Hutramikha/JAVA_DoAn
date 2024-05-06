/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DanhMuc;
import Database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DALdanhMuc implements DALinterface<DanhMuc> {
    
    public static DALdanhMuc getinstance() {
	return new DALdanhMuc();
    }

    @Override
    public int insert(DanhMuc t) {
        int count = 0;
        try {
            Connection conn = Connect.getConnection();
            String sql = "INSERT INTO danhmuc (maloai,tenloai,img) "
                    + " VALUES (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaloai());
            pst.setString(2, t.getTenloai());
            pst.setString(3, t.getImg());


            count = pst.executeUpdate();

            Connect.closeConnection(conn);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return count;
    }

    @Override
    public int update(DanhMuc t) {
        int count = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE danhmuc "
                    + "SET "
                    + "tenloai=? "
                    + "WHERE maloai = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenloai());
            pst.setString(2, t.getMaloai());

            count = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return count;
    }
    
    @Override
     public int updateALL(DanhMuc t , String maOld) {
        int kq = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE danhmuc "
                    + "SET "
                    + "maloai=? "
                    + ",tenloai=? "
                    + ",img=? "
                    + "WHERE maloai = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaloai());
            pst.setString(2, t.getTenloai());
            pst.setString(3, t.getImg());
            pst.setString(4, maOld);

            kq = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return kq;
    }

    @Override
    public int delete(DanhMuc t) {
       int count = 0;
        try {
            Connection conn = Connect.getConnection();
            String sql = "DELETE FROM danhmuc WHERE maloai = ?";
            PreparedStatement pts = conn.prepareStatement(sql);
            pts.setString(1, t.getMaloai());
            count = pts.executeUpdate();
            Connect.closeConnection(conn);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }

    @Override
    public int delete(String t) {
        return 0;
    }

    @Override
    public ArrayList<DanhMuc> selectAll() {
        ArrayList<DanhMuc> dms = new ArrayList<>();
        try {
            Connection conn = Connect.getConnection();
            String sql = "select * from danhmuc";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maloai = rs.getString("maloai");
                String tenloai = rs.getString("tenloai");
                String img = rs.getString("img");
                DanhMuc dm = new DanhMuc(maloai,tenloai,img);
                dms.add(dm);
            }
            Connect.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return dms;
    }

    @Override
    public DanhMuc selectById(DanhMuc t) {
        DanhMuc ncc = new DanhMuc();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from danhmuc where maloai = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaloai());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maloai = rs.getString("maloai");
                String tenloai = rs.getString("tenloai");
                String img = rs.getString("img");
                ncc = new DanhMuc(maloai,tenloai,img);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ncc;
    }

    @Override
    public DanhMuc selectById(String T) {   
        return null;
    }

    @Override
    public ArrayList<DanhMuc> selectByCondition(String keyword, String byWhat) {
        ArrayList<DanhMuc> dms = new ArrayList<>();
         try {
            Connection conn = Connect.getConnection();
             if (byWhat.equals("Theo mã")) {
                 String sql = "select * from danhmuc where maloai like '%' ? '%'";
                 PreparedStatement pst = conn.prepareStatement(sql);
                 pst.setString(1, keyword);
                 ResultSet rs = pst.executeQuery();
                 while (rs.next()) {
                    String maloai = rs.getString("maloai");
                    String tenloai = rs.getString("tenloai");
                    String img = rs.getString("img");
                    DanhMuc dm = new DanhMuc(maloai,tenloai,img);
                    dms.add(dm);
                 }
             }else if (byWhat.equals("Theo tên")) {
                 String sql = "select * from danhmuc where tenloai like '%' ? '%'";
                 PreparedStatement pst = conn.prepareStatement(sql);
                 pst.setString(1, keyword);
                 ResultSet rs = pst.executeQuery();
                 while (rs.next()) {
                    String maloai = rs.getString("maloai");
                    String tenloai = rs.getString("tenloai");
                    String img = rs.getString("img");
                    DanhMuc dm = new DanhMuc(maloai,tenloai,img);
                    dms.add(dm);
                 }
             }
        Connect.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return dms;
    }
    
}
