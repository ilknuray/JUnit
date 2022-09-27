package day_14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {
        //dosya yolunu bir stringe atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //fileinputsrtream objesi olusturup dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //worbook objesi olusturalim
        Workbook workbook= WorkbookFactory.create(fis);

        //turkce baskentler sutunun yazdiralim
        int sonSatir=workbook.getSheet("Sayfa1").getLastRowNum();
        //excel deki tum satir numarasini verir
        System.out.println(sonSatir);

        String turkceBaskentler="";
        for (int i = 0; i <=sonSatir ; i++) {
            turkceBaskentler=workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            System.out.println(turkceBaskentler);

        }


    }
}
