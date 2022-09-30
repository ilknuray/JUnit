package practise;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_PomVarMi extends TestBaseBeforeAfter {
    @Test
    public void test(){
        //projemde pom.xml var mi?
        String path="C:\\Users\\fylmz\\IdeaProjects\\com.Batch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
