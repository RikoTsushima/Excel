import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tiyan on 2017/5/18.
 */
public class MyTableModel extends AbstractTableModel {
    private List<Student> List= new ArrayList<Student>();

    @Override
    public int getRowCount() {
        return List.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student stu=List.get(rowIndex);
        switch (columnIndex){
            case 0: return stu.getNo();
            case 1: return stu.getName();
            case 2: return stu.getAge();
            case 3: return stu.getScore();
            default: break;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "No";
            case 1: return "Name";
            case 2: return "Age";
            case 3: return "Score";
            default: break;
    }
        return null;
    }

    public void addRow(Student rowData) {

    }
    public void setData(List<Student> List){
        if (List == null)
            throw new IllegalArgumentException("参数data不能为null。");
        this.List=List;
    fireTableDataChanged();
    }
}
