/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.HoaDon;
import Database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Date;


public class HoaDonDAL implements DALinterface<HoaDon> {

    public static HoaDonDAL getintance() {
        return new HoaDonDAL();
    }

    @Override
    public int insert(HoaDon t) {
        int ketqua = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "INSERT INTO hoadon (mahd, makh, manv, ngaytao, tongtien) " + " VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMahd());
            pst.setString(2, t.getMakh());
            pst.setString(3, t.getManv());
            pst.setDate(4, new java.sql.Date(t.getNgaytao().getTime()));
            pst.setLong(5, t.getTongtien());

            ketqua = pst.executeUpdate();
            Connect.closeConnection(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int update(HoaDon t) {
        int ketqua = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE hoadon "
                    + "SET "
                    + ",makh=? "
                    + ",manv=? "
                    + ",ngaytao=? "
                    + ",tongtien=? "
                    + "WHERE mahd = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMakh());
            pst.setString(2, t.getManv());
            pst.setDate(3, (java.sql.Date) t.getNgaytao());
            pst.setLong(4, t.getTongtien());
            pst.setString(5, t.getMahd());

            ketqua = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public int delete(HoaDon t) {

        int kq = 0;
        try {
            Connection c = Connect.getConnection();

            String sql = "DELETE FROM hoadon WHERE mahd = ?";
            PreparedStatement pts = c.prepareStatement(sql);
            pts.setString(1, t.getMahd());
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
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> ketqua = new ArrayList<>();
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM hoadon";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                String mhd = rs.getString("mahd");
                String mkh = rs.getString("makh");
                String mnv = rs.getString("manv");
                Date ngaytao = rs.getDate("ngaytao");
                long tt = rs.getLong("tongtien");

                HoaDon hd = new HoaDon(mhd, mkh, mnv, ngaytao, tt);
                ketqua.add(hd);
            }
            Connect.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public HoaDon selectById(HoaDon t) {

        HoaDon kq = new HoaDon();
        try {
            Connection con = Connect.getConnection();
            String sql = "select * from hoadon where mahd = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMahd());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String mhd = rs.getString("mahd");
                String mkh = rs.getString("makh");
                String mnv = rs.getString("manv");
                Date ngaytao = rs.getDate("ngaytao");
                String tt = rs.getString("tongtien");
                kq = new HoaDon(mhd, mkh, mnv, ngaytao, 0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public HoaDon selectById(String T) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateALL(HoaDon t, String ma) {
        int ketqua = 0;
        try {
            Connection con = Connect.getConnection();
            String sql = "UPDATE hoadon "
                    + "SET "
                    + "mahd=? "
                    + ",makh=? "
                    + ",manv=? "
                    + ",ngaytao=? "
                    + ",tongtien=? "
                    + "WHERE mahd = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getMahd());
            pst.setString(2, t.getMakh());
            pst.setString(3, t.getManv());
            pst.setDate(4, (java.sql.Date) t.getNgaytao());
            pst.setLong(5, t.getTongtien());
            pst.setString(6, t.getMahd());

            ketqua = pst.executeUpdate();

            Connect.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public ArrayList<HoaDon> selectByCondition(String keyword, String byWhat) {
       
        return null;
       
    }
    
    
//    public void insertHD (HoaDon hd) {
//        int ketqua = 0;
//        try {
//            Connection conn = Connect.getConnection();
//            String sql = "INSERT INTO hoadon (mahd,makh,manv,ngaytao,tongtien) " + "VALUES(?,?,?,?,?)";
//            PreparedStatement pst = conn.prepareStatement(sql);
//           
//           pst.setString(1, hd.getMahd());
//           pst.setString(2, hd.getMakh());
//           pst.setString(3, hd.getManv());
//           pst.setDate(4, (java.sql.Date) hd.getNgaytao());
//           pst.setLong(5, hd.getTongtien());
//
//           ketqua = pst.executeUpdate();
//
//           Connect.closeConnection(conn);
//        } catch (Exception ex) {
//            
//        }       
//    }
}
