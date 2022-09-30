package practise;

import org.junit.*;

public class C02_JUnit {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("before class");//her classta ilk calisir.1kere calisir

    }
    @Before
    public void before(){
        System.out.println("Before");//her methodtan once calisir method sayisinca
    }

    @After
    public void after(){
        System.out.println("after");//her testten sonra calisir
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("afterclass");
    }
    @Test
    public void test01(){
        System.out.println("Test 01");
    }
    @Test
    public void test02(){
        System.out.println("Test 02");
    }
    @Test
    public void test03(){
        System.out.println("Test 03");
    }
}
