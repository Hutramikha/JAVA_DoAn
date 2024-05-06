
package BLL;
import DTO.sanPham;
import javax.swing.JOptionPane;
import DAL.DALsanPham;
import GUI.SanPhamView;
import java.util.ArrayList;

public class SanPhamBLL implements BLLinterface<sanPham>{
    private SanPhamView spView;
    private DALsanPham dalsp = new DALsanPham();
    private ArrayList<sanPham> list = new ArrayList<>();
    
    
     public SanPhamBLL(SanPhamView spView) {
        this.spView = spView;
    }
     
    @Override
    public ArrayList<sanPham> getALL() {
        return dalsp.selectAll();
    }
     
     public ArrayList<sanPham> getALLmaLoai(String maLoai) {
        return dalsp.selectAll(maLoai);
    }
     
    public void updateSL(sanPham sp) {
        try {
            if (dalsp.update(sp) > 0) {
                System.out.println("Số lượng thay đổi");
            } else {
                System.out.println("Số lượng không đổi");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void add(sanPham sp) {
        list = dalsp.selectAll();
        try {
            if (dalsp.insert(sp) > 0) {
                JOptionPane.showMessageDialog(spView, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(spView, "Thêm thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
     
    @Override
     public void delete(sanPham sp) {
         try {
             if (dalsp.delete(sp) > 0) {
                JOptionPane.showMessageDialog(spView, "Xóa thành công");
             } else {
                 JOptionPane.showMessageDialog(spView, "Xóa thất bại");
             }
         } catch (Exception ex) {
             System.out.println(ex);
         }
     }
     
    @Override
    public void update(sanPham sp, String maOld) {
        list = dalsp.selectAll();
        boolean found = false;
        if (!sp.getMasp().equals(maOld)) {
            for (sanPham tmp : list) {
                if (tmp.getMasp().equals(sp.getMasp())) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(spView, "Mã sản phẩm đã tồn tại");
        } else {
            try {
                if (dalsp.updateALL(sp, maOld) > 0) {
                    JOptionPane.showMessageDialog(spView, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(spView, "Sửa thất bại");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public ArrayList<sanPham> search(String keyword, String byWhat) {
        return dalsp.selectByCondition(keyword, byWhat);
    }
}
