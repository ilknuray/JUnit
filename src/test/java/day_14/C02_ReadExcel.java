package day_14;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {
    @Test
    public void ReadExcelTest() throws IOException {
        //. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);//olusturdugumuz dosyayi sisteme alir

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        Workbook workbook= WorkbookFactory.create(fis);//dosyamiza bir excel create ettik

        //11.sheet objesi olusturun workbook.getSheetAt(index)


        //12. Row objesi olusturun sheet.getRow(index)

        //13. Cell objesi olusturun row.getCell(index

        String actualData=workbook.getSheet("Sayfa1").getRow(3).getCell(3).toString();
        System.out.println(actualData);
    }
}
