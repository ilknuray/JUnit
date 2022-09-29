package day_15;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test() throws IOException {


        //dosya yolunu bir stringe atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";

        //fileinputsrtream objesi olusturup dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //worbook objesi olusturalim
        Workbook workbook = WorkbookFactory.create(fis);

        //excel tablosundaki tum tabloy konsola yazdirin
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();
        String tablo = "";
        for (int i = 0; i <= sonSatir; i++) {
            tablo = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString() + " "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + " "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + " "
                    + workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(tablo);


        }


    }
}