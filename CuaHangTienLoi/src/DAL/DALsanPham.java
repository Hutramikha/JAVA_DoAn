package DAL;

import DTO.sanPham;
import Database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author votru
 */
public class DALsanPham implements DALinterface<sanPham> {

    public static DALsanPham getintance() {
        return new DALsanPham();
    }

    @Override
    public int insert(sanPham t) {
        int ketqua = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "INSERT INTO sanpham (masp,tensp, maloaisp, soluong, dongia, img) " + " VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMasp());
            pst.setString(2, t.getTensp());
            pst.setString(3, t.getMaloaisp());
            pst.setInt(4, t.getSoluong());
            pst.setLong(5, t.getDongia());
            pst.setString(6, t.getImg());
            
            ketqua = pst.executeUpdate();
            Connect.closeConnection(con);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return ketqua;
    }

    @Override
    public int update(sanPham t) {
        int ketqua = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE sanpham "
                    + "SET "
                    + "soluong=? "
                    + "WHERE masp = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getSoluong());
            pst.setString(2, t.getMasp());

            ketqua = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ketqua;
    }
    
    @Override
    public int updateALL(sanPham t, String maOld) {
        int kq = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE sanpham "
                    + "SET "
                    + "masp=? "
                    + ",tensp=? "
                    + ",maloaisp=? "
                    + ",soluong=? "
                    + ",dongia=? "
                    + ",img=? "
                    + "WHERE masp = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMasp());
            pst.setString(2, t.getTensp());
            pst.setString(3, t.getMaloaisp());
            pst.setInt(4, t.getSoluong());
            pst.setLong(5, t.getDongia());
            pst.setString(6, t.getImg());
            pst.setString(7, maOld);

            kq = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return kq;
    }

    @Override
    public int delete(sanPham t) {
        int kq = 0;
        try {
            Connection c = Connect.getConnection();

            String sql = "DELETE FROM sanpham WHERE masp = ?";
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setString(1, t.getMasp());
            kq = pts.executeUpdate();

            Connect.closeConnection(c);

        } catch (SQLException e) {
            System.out.println(e);
        }
        return kq;
    }

    @Override
    public int delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<sanPham> selectAll() {
        ArrayList<sanPham> sps = new ArrayList<>();
        try {
            Connection conn = Connect.getConnection();
            String sql = "select * from sanpham";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                String maloai = rs.getString("maloaisp");
                int soluong = rs.getInt("soluong");
                long dongia = rs.getLong("dongia");
                String img = rs.getString("img");
                sanPham sp = new sanPham(masp,tensp,maloai,soluong,dongia,img);
                sps.add(sp);
            }
            Connect.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sps;
    }
    
    public ArrayList<sanPham> selectAll(String maLoai) {
        ArrayList<sanPham> sps = new ArrayList<>();
        try {
            Connection conn = Connect.getConnection();
            String sql = "select * from sanpham where maloaisp=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, maLoai);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                String maloai = rs.getString("maloaisp");
                int soluong = rs.getInt("soluong");
                long dongia = rs.getLong("dongia");
                String img = rs.getString("img");
                sanPham sp = new sanPham(masp,tensp,maloai,soluong,dongia,img);
                sps.add(sp);
            }
            Connect.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sps;
    }
    
    @Override
    public sanPham selectById(sanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public sanPham selectById(String T) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<sanPham> selectByCondition(String keyword , String byWhat) {
        ArrayList<sanPham> sps = new ArrayList<>();
         try {
            Connection conn = Connect.getConnection();
             if (byWhat.equals("Theo mã")) {
                 String sql = "select * from sanpham where masp like '%' ? '%'";
                 PreparedStatement pst = conn.prepareStatement(sql);
                 pst.setString(1, keyword);
                 ResultSet rs = pst.executeQuery();
                 while (rs.next()) {
                     String masp = rs.getString("masp");
                     String tensp = rs.getString("tensp");
                     String maloai = rs.getString("maloaisp");
                     int soluong = rs.getInt("soluong");
                     long dongia = rs.getLong("dongia");
                     String img = rs.getString("img");
                     sanPham sp = new sanPham(masp, tensp, maloai, soluong, dongia, img);
                     sps.add(sp);
                 }
             }else if (byWhat.equals("Theo tên")) {
                 String sql = "select * from sanpham where tensp like '%' ? '%'";
                 PreparedStatement pst = conn.prepareStatement(sql);
                 pst.setString(1, keyword);
                 ResultSet rs = pst.executeQuery();
                 while (rs.next()) {
                     String masp = rs.getString("masp");
                     String tensp = rs.getString("tensp");
                     String maloai = rs.getString("maloaisp");
                     int soluong = rs.getInt("soluong");
                     long dongia = rs.getLong("dongia");
                     String img = rs.getString("img");
                     sanPham sp = new sanPham(masp, tensp, maloai, soluong, dongia, img);
                     sps.add(sp);
                 }
             }
        Connect.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return sps;
    }

}
