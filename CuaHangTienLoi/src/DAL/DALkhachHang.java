
package DAL;

import DTO.khachHang;
import DTO.nhanVien;
import Database.Connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DALkhachHang implements DALinterface<khachHang> {
    
    public static DALkhachHang getinstance() {
	return new DALkhachHang();
    }

    @Override
    public int insert(khachHang t) {
        int count = 0;
        try {
            Connection conn = Connect.getConnection();
            String sql = "INSERT INTO khachhang (makh,ten,sdt,email) "
                    + " VALUES (?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMakh());
            pst.setString(2, t.getTen());
            pst.setString(3, t.getSdt());
            pst.setString(4, t.getEmail());

            count = pst.executeUpdate();

            Connect.closeConnection(conn);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return count;
    }

    @Override
    public int update(khachHang t) {
        int count = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE khachhang "
                    + "SET "
                    + "ten=? "
                    + ",sdt=? "
                    + ",email=? "
                    + "WHERE makh = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTen());
            pst.setString(2, t.getSdt());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getMakh());

            count = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return count;
    }
    
    @Override
     public int updateALL(khachHang t , String maOld) {
        int kq = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE khachhang "
                    + "SET "
                    + "makh=? "
                    + ",ten=? "
                    + ",sdt=? "
                    + ",email=? "
                    + "WHERE makh = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMakh());
            pst.setString(2, t.getTen());
            pst.setString(3, t.getSdt());
            pst.setString(4, t.getEmail());
            pst.setString(5, maOld);

            kq = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return kq;
    }

    @Override
    public int delete(khachHang t) {
       int count = 0;
        try {
            Connection conn = Connect.getConnection();
            String sql = "DELETE FROM khachhang WHERE makh = ?";
            PreparedStatement pts = conn.prepareStatement(sql);
            pts.setString(1, t.getMakh());
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
    public ArrayList<khachHang> selectAll() {
        ArrayList<khachHang> khs = new ArrayList<>();
        try {
            Connection conn = Connect.getConnection();
            String sql = "select * from khachhang";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String makh = rs.getString("makh");
                String ten = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String email = rs.getString("email");
                khachHang kh = new khachHang(makh,ten,sdt,email);
                khs.add(kh);
            }
            Connect.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return khs;
    }

    @Override
    public khachHang selectById(khachHang t) {
        khachHang kh = new khachHang();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from khachhang where makh = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMakh());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String makh = rs.getString("makh");
                String ten = rs.getString("ten");
                String sdt = rs.getString("sdt");
                String email = rs.getString("email");
                kh = new khachHang(makh,ten,sdt,email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kh;
    }

    @Override
    public khachHang selectById(String T) {   
        return null;
    }

    @Override
    public ArrayList<khachHang> selectByCondition(String condition) {
        return null;
    }
    
}
