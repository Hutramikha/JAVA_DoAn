/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.CtHoaDon;
import Database.Connect;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author votru
 */
public class CtHoaDonDAL implements DALinterface<CtHoaDon> {

    public static CtHoaDonDAL getintance() {
        return new CtHoaDonDAL();
    }

    @Override
    public int insert(CtHoaDon t) {
        int ketqua = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "INSERT INTO cthoadon (mahd, masp, tensp ,soluong, dongia, thanhtien) " + " VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMahd());
            pst.setString(2, t.getMasp());
            pst.setString(3, t.getTensp());
            pst.setInt(4, t.getSoluong());
            pst.setLong(5, t.getDongia());
            pst.setLong(6, t.getThanhtien());

            ketqua = pst.executeUpdate();
            Connect.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    public int update2(CtHoaDon t , int soluong , long thanhtien) {
       int ketqua = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE cthoadon "
                    + "SET "
                    + "soluong = ? "
                    + ", thanhtien = ? "
                    + "WHERE mahd = ? AND masp = ? AND soluong = ? AND thanhtien = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, soluong);
             pst.setLong(2, thanhtien);
            pst.setString(3, t.getMahd());
            pst.setString(4, t.getMasp());
            pst.setInt(5, t.getSoluong());
            pst.setLong(6, t.getThanhtien());

            ketqua = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;

    }

    @Override
    public int delete(CtHoaDon t) {
        int kq = 0;
        try {
            Connection c = Connect.getConnection();

            String sql = "DELETE FROM cthoadon WHERE mahd = ? and masp = ? and soluong = ? and thanhtien = ?";
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setString(1, t.getMahd());
            pts.setString(2, t.getMasp());
            pts.setInt(3, t.getSoluong());
            pts.setLong(4, t.getThanhtien());
            kq = pts.executeUpdate();

            Connect.closeConnection(c);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;

    }

    @Override
    public int delete(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<CtHoaDon> selectAll() {
        ArrayList<CtHoaDon> ketqua = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM cthoadon";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                String mahd = rs.getString("mahd");
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                int soluongmua = rs.getInt("soluong");
                long dongia = rs.getLong("dongia");
                long thanhtien = rs.getLong("thanhtien");
               
                CtHoaDon hd = new CtHoaDon(mahd, masp, tensp, soluongmua, dongia, thanhtien);
                ketqua.add(hd);
            }
            Connect.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }
    
     public ArrayList<CtHoaDon> selectAll2(String ma) {
        ArrayList<CtHoaDon> ketqua = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM cthoadon where mahd = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ma);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String mahd = rs.getString("mahd");
                String masp = rs.getString("masp");
                String tensp = rs.getString("tensp");
                int soluongmua = rs.getInt("soluong");
                long dongia = rs.getLong("dongia");
                long thanhtien = rs.getLong("thanhtien");
               
                CtHoaDon hd = new CtHoaDon(mahd, masp, tensp, soluongmua, dongia, thanhtien);
                ketqua.add(hd);
            }
            Connect.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public CtHoaDon selectById(CtHoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CtHoaDon selectById(String T) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateALL(CtHoaDon t, String maOld) {
        int ketqua = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE cthoadon "
                    + "SET "
                    + "mahd=? "
                    + ",masp=? "
                    + ",soluong=? "
                    + ",dongia=? "
                    + ",thanhtien=? "
                    + "WHERE mahd = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMahd());
            pst.setString(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setLong(4, t.getDongia());
            pst.setLong(5, t.getThanhtien());
            pst.setString(6, maOld);

            ketqua = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<CtHoaDon> selectByCondition(String keyword, String byWhat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(CtHoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
