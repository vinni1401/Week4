// ListManager.java
import java.util.List;

public class ListManager {
    public void addElement(List<Integer> list, int e) { list.add(e); }
    public void removeElement(List<Integer> list, int e) { list.remove(Integer.valueOf(e)); }
    public int getSize(List<Integer> list) { return list.size(); }
}
