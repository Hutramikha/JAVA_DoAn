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
import java.time.LocalDate;

/**
 *
 * @author votru
 */
public class HoaDonDAL implements DALinterface<HoaDon>{
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
			pst.setInt(1, t.getMahd());
			pst.setString(2, t.getMakh());
			pst.setString(3, t.getManv());
			pst.setString(4, t.getNgaytao());
                        pst.setInt(5, t.getTongtien());
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
			String sql = "UPDATE hoadon "+
						"SET "+
						"MaHoadon=? "+
						",MaKhachhang=? "+
						",MaNhanvien=? "+
						",Ngaytao=? "+
						",Tongtien=? "+
						"WHERE MaHoadon = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getMahd());
			pst.setString(2, t.getMakh());
			pst.setString(3, t.getManv());
			pst.setString(4, t.getNgaytao());
                        pst.setInt(5, t.getTongtien());
			
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
			
			String sql = "DELETE FROM hoadon "+
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
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> ketqua = new ArrayList<HoaDon>();
        try {
//		BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
            Connection con = Connect.getConnection();
//		BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
            String sql = "SELECT * FROM hoadon";
            PreparedStatement pst = con.prepareStatement(sql);
//		BƯỚC 3: THỰC THI CÂU LỆNH SQL
//		System.out.println(sql);
            ResultSet rs = pst.executeQuery(sql);
            // BƯỚC 4 XỬ LÝ KẾT QUẢ
//		String manhacungcap, String tennhacungcap, String diachi, String sdt, String email
            while (rs.next()) {
                int mhd = rs.getInt("MaHoaDon");
                String mkh = rs.getString("MaKH");
                String mnv = rs.getString("MaNV");
                String ngaytao = rs.getString("NgayTao");
                int tt = rs.getInt("TongTien");

                HoaDon hd = new HoaDon(mhd, mkh, mnv, ngaytao, tt);
                ketqua.add(hd);
            }
//		BƯỚC 5: NGẮT KẾT NỐI
            Connect.closeConnection(con);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ketqua;

    }

    @Override
    public HoaDon selectById(HoaDon t) {
        
        
		
		HoaDon kq  = new HoaDon();
		try {
			Connection con = Connect.getConnection();
			String sql = "select * from hoadon where MaHoaDon = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, t.getMahd());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
                                int mhd = rs.getInt("MaHoaDon");
                                String mkh = rs.getString("MaKH");
                                String mnv = rs.getString("MaNV");
                                String ngaytao = rs.getString("NgayTao");
                                int tt = rs.getInt("TongTien");
			kq = new HoaDon(mhd, mkh, mnv, ngaytao, tt);
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
    public ArrayList<HoaDon> selectByCondition(String keyword, String byWhat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int updateALL(HoaDon t, String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
