
package BLL;

import java.util.ArrayList;


public interface BLLinterface <T>{
    public ArrayList<T> getALL();
    
    public void add(T t);
	
    public void delete(T t);
	
    public void update(T t , String ma);
    
    public  ArrayList<T> search(String keyword , String byWhat);
}
