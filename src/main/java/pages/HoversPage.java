package pages;

import static com.codeborne.selenide.Selenide.*;

public class HoversPage {

    public HoversPage openPage(){
        open("/hovers");
        return this;
    }

    public HoversPage hoverOnAvatar(int index){
        $$(".figure").get(index).hover();
        return this;
    }

    public String getCaptionText(int index){
        return $$(".figure").get(index).find(".figcaption h5").getText();
    }
}
