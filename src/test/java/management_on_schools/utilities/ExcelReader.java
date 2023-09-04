package management_on_schools.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    Workbook workbook;
    Sheet sheet;
    public ExcelReader(String dosyaYolu, String sayfaismi) {
        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            workbook=WorkbookFactory.create(fis);
            sheet=workbook.getSheet(sayfaismi);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //Satır ve sütun sayısını girdiğimizde , O hücredeki veriyi return eden method
    public String getCellData(int satir, int sutun){
        Cell cell=sheet.getRow(satir).getCell(sutun);
        return cell.toString();
    }
    //Excel'deki satır sayısını return eden method
    public int rowCount(){
        return  sheet.getLastRowNum();
    }
}
