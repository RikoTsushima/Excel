/**
 * Created by tiyan on 2017/5/18.
 */
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class WriteExcel {
    /**
     *
     * @param xls
     *           实体类的一个对象
     * @throws Exception
     *
     */
    public  WriteExcel(List<Student> xls) throws Exception {
        int CountColumnNum = xls.size();
        Student stu=null;
        XSSFWorkbook xwb = new XSSFWorkbook();
        XSSFSheet sheet = xwb.createSheet("workbooks");
        XSSFRow firstrow = sheet.createRow(0);
        XSSFCell[] firstcell = new XSSFCell[4];
        String[] names = new String[4];
        names[0]= "NO";
        names[1] ="Name";
        names[2] = "age";
        names[3] = "score";
        for(int j=0;j<4;j++){
            firstcell[j] = firstrow.createCell(j);
            firstcell[j].setCellValue(new XSSFRichTextString(names[j]));
        }
        XSSFCellStyle style = xwb.createCellStyle();
        style.setBorderBottom(XSSFCellStyle.BORDER_DOTTED);
        for(int i=0;i<xls.size();i++){
            XSSFRow row = sheet.createRow(i+1);
            stu=xls.get(i);
            for(int colu=0;colu<4;colu++){
                XSSFCell no = row.createCell(0);
                no.setCellValue(stu.getNo());
                XSSFCell name = row.createCell(1);
                name.setCellValue(stu.getName());
                XSSFCell age = row.createCell(2);
                age.setCellValue(stu.getAge());
                XSSFCell score = row.createCell(3);
                score.setCellValue(stu.getScore());
                score.setCellStyle(style);
            }
        }
        OutputStream out = new FileOutputStream("lib/output.xlsx");
        xwb.write(out);
        out.close();
        System.out.println("输出成功！");
    }
}
