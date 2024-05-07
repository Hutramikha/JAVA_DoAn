
package BLL;
import GUI.*;
import DAL.*;
import DTO.*;
import java.util.ArrayList;

public class doanhthuBLL {
    
    private doanhThuDAL dtdal = new doanhThuDAL();
    
    public doanhthuBLL() {
    }
    
    
    public ArrayList<HoaDon> getALLHD(int thangx , int thangy , int nam) {
        return dtdal.selectAllHD(thangx, thangy , nam);
    }
    
    public ArrayList<PhieuNhap> getALLPN(int thangx , int thangy , int nam) {
        return dtdal.selectAllPN(thangx, thangy , nam);
    }
    
    
}
