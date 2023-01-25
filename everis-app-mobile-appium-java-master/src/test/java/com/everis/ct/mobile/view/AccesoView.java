package com.everis.ct.mobile.view;

import com.everis.ct.mobile.base.MobileBase;
import com.everis.ct.mobile.service.constans.Platform;
import com.everis.ct.mobile.service.util.ReadProperties;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import java.util.Locale;

public class AccesoView extends MobileBase {


    @iOSXCUITFindBy(accessibility = "Allow")
    protected MobileElement btnAllow;

    @iOSXCUITFindBy(accessibility = "Bienvenido a Bar Manager")
    @AndroidFindBy(id = "com.damm.dammbars:id/appCompatTextView3_1")
    protected MobileElement tituloBienvenida;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"SIGUIENTE\"`]")
    @AndroidFindBy(id = "com.damm.dammbars:id/next_button_view")
    protected MobileElement botonSiguiente;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"¿Ya tienes una cuenta? Accede aquí.\"`]")
    @AndroidFindBy(id = "com.damm.dammbars:id/bottom_button_view")
    protected MobileElement enlaceYaTengoCuenta;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"REGISTRA TU ESTABLECIMIENTO\"`]")
    @AndroidFindBy(id = "com.damm.dammbars:id/next_button_view")
    protected MobileElement botonRegistrarEstablecimiento;

    @iOSXCUITFindBy(accessibility = "Introduce tu código de acceso")
    @AndroidFindBy(id = "com.damm.dammbars:id/appCompatTextView")
    protected MobileElement tituloIntroduceTuCodigo;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Escribe el código de acceso\"`]")
    @AndroidFindBy(id = "com.damm.dammbars:id/input_text")
    protected MobileElement campoCodigoAcceso;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Hecho\"`]")
    protected MobileElement btnHechoTecladoIOS;

    @iOSXCUITFindBy(accessibility = "¡Oh, vaya!")
    @AndroidFindBy(id = "com.damm.dammbars.pre:id/title_text_view")
    protected MobileElement tituloErrorCodigo;


    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"ACEPTAR\"`]")
    @AndroidFindBy(id = "com.damm.dammbars.pre:id/accept_text_view")
    protected MobileElement botonAceptar;

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "(//*[contains(@class,'androidx.appcompat.app.ActionBar$Tab')])[3]")
    protected MobileElement botonSlide;

    @iOSXCUITFindBy()
    @AndroidFindBy(id = "android:id/alertTitle")
    protected MobileElement tituloAlertaAnd;

    @iOSXCUITFindBy()
    @AndroidFindBy(id = "android:id/button1")
    protected MobileElement botonOkAlertaAnd;



    public void tapAllowNotifications() {
        try {
            waitUntilElementIsVisible(btnAllow, 15);
            tap(btnAllow);
        } catch (Exception ignore) {}
    }

    public void verificarAperturaAplicacion() {
        waitUntilElementIsVisible(tituloBienvenida, 30);
    }

    public void tapSiguiente() {
        waitUntilElementIsVisible(botonSiguiente, 50);
        tap(botonSiguiente);
    }

    public void slideUlt(){
        waitUntilElementIsVisible(botonSlide,20);
        tap(botonSlide);
    }

    public void tapRegistrarEstablecimiento() {
        waitUntilElementIsVisible(botonRegistrarEstablecimiento, 15);
        tap(botonRegistrarEstablecimiento);
    }

    public void verificarPantallaIntroduccionCodigo() {
        waitUntilElementIsVisible(tituloIntroduceTuCodigo, 15);
    }

    public void sendCodigoAcceso() {
        ReadProperties properties = new ReadProperties();
        waitUntilElementIsVisible(campoCodigoAcceso, 15);
        campoCodigoAcceso.sendKeys(properties.pinCode());
        if(isIOS()) {
            tap(btnHechoTecladoIOS);
        }
    }


    public void verificarErrorCodigo() {
        waitUntilElementIsVisible(tituloAlertaAnd, 10);
    }

    public void tapAceptar() {
        waitUntilElementIsVisible(botonOkAlertaAnd, 10);
        tap(botonOkAlertaAnd);
    }

    public void tapYaTengoCuenta() {
        waitUntilElementIsVisible(enlaceYaTengoCuenta, 10);
        tap(enlaceYaTengoCuenta);
    }

//    public void writeAndSearch(String data) {
//        waitUntilElementIsVisible(inputSearch, 15);
//        type(inputSearch, data);
//        if (isAndroid())
//            android().pressKey(AndroidKey.ENTER);
//        else
//            ios().iosDriver().getKeyboard().pressKey("\n");
//    }
}
