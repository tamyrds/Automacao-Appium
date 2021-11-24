package br.com.chronosAcademy.appium;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraTest {

    DriverFactory driverFactory;

    @BeforeEach
    public void inicializarDriver() throws MalformedURLException {
        driverFactory = new DriverFactory();
        driverFactory.setCapabilities("Android","ChronosMobile","uiautomator2","com.android.calculator2",
                "com.android.calculator2.Calculator");
        driverFactory.setDriver();

    }

    @AfterEach
    public void finalizaDrive() {
        driverFactory.getDriver().quit();
    }

    @Test
    public void validarMultiplicacao() {
        this.clickId("digit_7");
        this.clickId("op_mul");
        this.clickId("digit_9");
        this.clickId("eq");
        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();
        assertEquals("63",resultado);
    }

    @Test
    public void validarsubtracao()  {
        this.clickId("digit_8");
        this.clickId("op_sub");
        this.clickId("digit_5");
        this.clickId("eq");
        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();
        assertEquals("3",resultado);
    }

    @Test
    public void validardivisao()  {
        this.clickId("digit_8");
        this.clickId("op_div");
        this.clickId("digit_5");
        this.clickId("eq");
        String resultado = driverFactory.getDriver().findElement(MobileBy.id("result")).getText();
        assertEquals("1.6",resultado);
    }
    public void clickId(String id){
        driverFactory.getDriver().findElement(MobileBy.id(id)).click();

    }
}
