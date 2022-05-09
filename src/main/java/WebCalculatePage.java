import org.openqa.selenium.By;

public class WebCalculatePage {
    public static void pressSix(){
        DriverSingleton.getDriverInstance().findElement(By.id("six")).click();
    }
    public static void pressPlus(){
        DriverSingleton.getDriverInstance().findElement(By.id("add")).click();
    }
    public static void pressEquals(){
        DriverSingleton.getDriverInstance().findElement(By.id("equal")).click();
    }
    public static String returnResults(){
        return DriverSingleton.getDriverInstance().findElement(By.id("screen")).getText();

}

}
