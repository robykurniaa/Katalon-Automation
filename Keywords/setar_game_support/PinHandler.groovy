package setar_game_support


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import setar_game_support.SetarGameLocatorPaths as Locator
import internal.GlobalVariable

public class PinHandler {

    /**
     * Memasukkan PIN secara dinamis ke kotak input web
     * @param pin (String) PIN yang akan dimasukkan
     */
    @Keyword
    static void inputDynamicPin(String pin) {
        for (int i = 0; i < pin.length(); i++) {
            String digit = pin.charAt(i).toString()
            
            String dynamicXpath = Locator.getPinLocator(i)
            
            TestObject dynamicPinBox = new TestObject("PinBox_${i}")
            dynamicPinBox.addProperty("xpath", ConditionType.EQUALS, dynamicXpath)
            
            WebUI.click(dynamicPinBox)
            WebUI.sendKeys(dynamicPinBox, digit)
        }
    }
}
