
package DAL;

import Database.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import DTO.*;
import java.util.Date;

public class doanhThuDAL {
     public ArrayList<HoaDon> selectAllHD(int thangx , int thangy , int nam) {
        ArrayList<HoaDon> hds = new ArrayList<>();
        try {
            Connection conn = Connect.getConnection();
            String sql = "SELECT * FROM hoadon WHERE YEAR(ngaytao) = ? AND MONTH(ngaytao) BETWEEN ? AND ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, nam);
            pst.setInt(2, thangx);
            pst.setInt(3, thangy);
            ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                String mahd = rs.getString("mahd");
                String makh = rs.getString("makh");
                String manv = rs.getString("manv");
                Date ngaytao = rs.getDate("ngaytao");
                long tt = rs.getLong("tongtien");

                HoaDon hd = new HoaDon(mahd, makh, manv, ngaytao, tt);
                hds.add(hd);
            }
            Connect.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return hds;
    }
     
      public ArrayList<PhieuNhap> selectAllPN(int thangx , int thangy , int nam) {
        ArrayList<PhieuNhap> pns = new ArrayList<>();
        try {
            Connection conn = Connect.getConnection();
            String sql = "SELECT * FROM phieunhap WHERE YEAR(ngaytao) = ? AND MONTH(ngaytao) BETWEEN ? AND ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, nam);
            pst.setInt(2, thangx);
            pst.setInt(3, thangy);
            ResultSet rs = pst.executeQuery();
             while (rs.next()) {
                String mapn = rs.getString("mapn");
                String mancc = rs.getString("mancc");
                String manv = rs.getString("manv");
                Date ngaytao = rs.getDate("ngaytao");
                long tt = rs.getLong("tongtien");

                PhieuNhap pn = new PhieuNhap(mapn, mancc, manv, ngaytao, tt);
                pns.add(pn);
            }
            Connect.closeConnection(conn);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return pns;
    }
}
