package day_14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    /*
    belirtilen satir ve sutun nosunu parametre olarak alip o cellde ki datayi konsola yazdiralim
    sonucun konsolda olanla ayni oldugunu dogrulayin
     */

    @Test
    public void readTest() throws IOException {


        int satirNo = 12;
        int sutun = 2;

        String dosyaYolu = "src/resources/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData=workbook.getSheet("Sayfa1").getRow(satirNo-1).getCell(sutun-1).toString();
        //index sifirdan basladigidn bizden istedigi dataya ulasabilmek icin bir eksiginden baslariz
        System.out.println(actualData);
        String expectedData="Baku";
        Assert.assertEquals(expectedData,actualData);


    }
}
