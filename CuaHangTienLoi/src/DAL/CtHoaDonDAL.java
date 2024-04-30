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
import java.time.LocalDate;


/**
 *
 * @author votru
 */
public class CtHoaDonDAL implements DALinterface<CtHoaDon>{
    public static CtHoaDonDAL getintance() {
		return new CtHoaDonDAL();
}
    		

    @Override
    public int insert(CtHoaDon t) {
        int ketqua = 0;
		try {
			Connection con = Connect.getConnection();
			String sql = "INSERT INTO cthoadon (mahd, masp, soluong, dongia, thanhtien) " + " VALUES (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getMahd());
			pst.setInt(2, t.getMasp());
			pst.setInt(3, t.getSoluong());
			pst.setInt(4, t.getDongia());
                        pst.setInt(5, t.getThanhtien());
			ketqua = pst.executeUpdate();
			Connect.closeConnection(con);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketqua;
    }

    @Override
    public int update(CtHoaDon t) {
        int ketqua = 0;
		try {
			Connection con = Connect.getConnection();
			String sql = "UPDATE cthoadon "+
						"SET "+
						"MaHoadon=? "+
						",MaSanpham=? "+
						",Soluong=? "+
						",Dongia=? "+
						",Thanhtien=? "+
						"WHERE MaHoadon = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getMahd());
			pst.setInt(2, t.getMasp());
			pst.setInt(3, t.getSoluong());
			pst.setInt(4, t.getDongia());
                        pst.setInt(5, t.getThanhtien());
			
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
			
			String sql = "DELETE FROM cthoadon "+
						"WHERE MaHoadon = ?";
			PreparedStatement pts = c.prepareStatement(sql);
			pts.setInt(1, t.getMahd());
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public ArrayList<CtHoaDon> selectByCondition(String condition) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateALL(CtHoaDon t, String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    