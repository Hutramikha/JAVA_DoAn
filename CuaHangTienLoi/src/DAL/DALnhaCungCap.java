/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.nhaCungCap;
import Database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DALnhaCungCap implements DALinterface<nhaCungCap> {
    
    public static DALnhaCungCap getinstance() {
	return new DALnhaCungCap();
    }

    @Override
    public int insert(nhaCungCap t) {
        int count = 0;
        try {
            Connection conn = Connect.getConnection();
            String sql = "INSERT INTO nhacungcap (mancc,tenncc,tenndd,sdt,diachi) "
                    + " VALUES (?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, t.getMaNCC());
            pst.setString(2, t.getTenNCC());
            pst.setString(3, t.getTenNDD());
            pst.setString(4, t.getSdt());
            pst.setString(5, t.getDiachi());

            count = pst.executeUpdate();

            Connect.closeConnection(conn);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return count;
    }

    @Override
    public int update(nhaCungCap t) {
        int count = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE nhacungcap "
                    + "SET "
                    + "tenncc=? "
                    + ",tenndd=? "
                    + ",sdt=? "
                    + ",diachi=? "
                    + "WHERE mancc = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenNCC());
            pst.setString(2, t.getTenNDD());
            pst.setString(3, t.getSdt());
            pst.setString(4, t.getDiachi());
            pst.setString(5, t.getMaNCC());

            count = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return count;
    }
    
    @Override
     public int updateALL(nhaCungCap t , String maOld) {
        int kq = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE nhacungcap "
                    + "SET "
                    + "mancc=? "
                    + ",tenncc=? "
                    + ",tenndd=? "
                    + ",sdt=? "
                    + ",diachi=? "
                    + "WHERE mancc = ?";
            PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1, t.getMaNCC());
            pst.setString(2, t.getTenNCC());
            pst.setString(3, t.getTenNDD());
            pst.setString(4, t.getSdt());
            pst.setString(5, t.getDiachi());
            pst.setString(6, maOld);

            kq = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return kq;
    }

    @Override
    public int delete(nhaCungCap t) {
       int count = 0;
        try {
            Connection conn = Connect.getConnection();
            String sql = "DELETE FROM nhacungcap WHERE mancc = ?";
            PreparedStatement pts = conn.prepareStatement(sql);
            pts.setString(1, t.getMaNCC());
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
    public ArrayList<nhaCungCap> selectAll() {
        ArrayList<nhaCungCap> nccs = new ArrayList<>();
        try {
            Connection conn = Connect.getConnection();
            String sql = "select * from nhacungcap";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String mancc = rs.getString("mancc");
                String tenncc = rs.getString("tenncc");
                String tenndd = rs.getString("tenndd");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");
                nhaCungCap ncc = new nhaCungCap(mancc,tenncc,tenndd,sdt,diachi);
                nccs.add(ncc);
            }
            Connect.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return nccs;
    }

    @Override
    public nhaCungCap selectById(nhaCungCap t) {
        nhaCungCap ncc = new nhaCungCap();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from nhacungcap where mancc = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMaNCC());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String mancc = rs.getString("mancc");
                String tenncc = rs.getString("tenncc");
                String tenndd = rs.getString("tenndd");
                String sdt = rs.getString("sdt");
                String diachi = rs.getString("diachi");
                ncc = new nhaCungCap(mancc,tenncc,tenndd,sdt,diachi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ncc;
    }

    @Override
    public nhaCungCap selectById(String T) {   
        return null;
    }

    @Override
    public ArrayList<nhaCungCap> selectByCondition(String condition) {
        return null;
    }
    
}
