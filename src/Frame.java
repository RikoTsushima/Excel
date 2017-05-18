import org.apache.poi.ss.usermodel.Table;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by tiyan on 2017/5/18.
 */
public class Frame extends JFrame{
    private MyTableModel tableModel;
    private JTable table;
    public Frame(List<Student> list){
      super("表格");
      setBounds(100,100,510,510);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      final JScrollPane scrollPane = new JScrollPane();
      getContentPane().add(scrollPane,BorderLayout.CENTER);
      tableModel = new MyTableModel();
      tableModel.setData(list);
      table = new JTable(tableModel);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      scrollPane.setViewportView(table);
      setVisible(true);
    }
}
