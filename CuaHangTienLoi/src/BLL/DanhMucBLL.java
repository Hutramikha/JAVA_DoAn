
package BLL;

import java.util.ArrayList;
import DTO.DanhMuc;
import DAL.DALDanhMuc;


public class DanhMucBLL {
    DALDanhMuc dalDm = new DALDanhMuc();
    
//    
//     public DanhMucBLL(KhachHangView khView) {
//        this.khView = khView;
//    }
    
    public ArrayList<DanhMuc> getALL() {
        return dalDm.selectAll();
    }
}
