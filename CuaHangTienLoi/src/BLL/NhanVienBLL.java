package BLL;

import GUI.NhanVienView;
import DTO.nhanVien;
import javax.swing.JOptionPane;
import DAL.DALnhanVien;
import java.util.ArrayList;

public class NhanVienBLL implements BLLinterface<nhanVien> {

    private NhanVienView nvView;
    private DALnhanVien dalnv = new DALnhanVien();

    private ArrayList<nhanVien> list = new ArrayList<>();

    public NhanVienBLL(NhanVienView nvView) {
        this.nvView = nvView;
    }

    @Override
    public ArrayList<nhanVien> getALL() {
        return dalnv.selectAll();
    }

    @Override
    public void add(nhanVien nv) {
        list = dalnv.selectAll();
        boolean flag = false;
        for (nhanVien tmp : list) {
            if (tmp.getManv().equals(nv.getManv())) {
                flag = true;
            }
        }
        if (flag) {
            JOptionPane.showMessageDialog(nvView, "Mã nhân viên đã tồn tại");
            return;
        }
        try {
            if (dalnv.insert(nv) > 0) {
                JOptionPane.showMessageDialog(nvView, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(nvView, "Thêm thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(nhanVien nv) {
        try {
            if (dalnv.delete(nv) > 0) {
                JOptionPane.showMessageDialog(nvView, "Xóa thành công");
            } else {
                JOptionPane.showMessageDialog(nvView, "Xóa thất bại");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void update(nhanVien nv, String maOld) {
        list = dalnv.selectAll();
        boolean found = false;
        if (!nv.getManv().equals(maOld)) {
            for (nhanVien tmp : list) {
                if (tmp.getManv().equals(nv.getManv())) {
                    found = true;
                    break;
                }
            }
        }
        if (found) {
            JOptionPane.showMessageDialog(nvView, "Mã nhân viên đã tồn tại");
        } else {
            try {
                if (dalnv.updateALL(nv, maOld) > 0) {
                    JOptionPane.showMessageDialog(nvView, "Sửa thành công");
                } else {
                    JOptionPane.showMessageDialog(nvView, "Sửa thất bại");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public ArrayList<nhanVien> search(String keyword, String byWhat) {
        return dalnv.selectByCondition(keyword, byWhat);
    }

    
}
