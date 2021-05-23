package com.practice.spring.springselenium.page.google;

import com.practice.spring.springselenium.page.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResult extends Base {

    @FindBy(css = "div.tF2Cxc")
    private List<WebElement> results;

    public int getResultsCount(){
        return this.results.size();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> !this.results.isEmpty());
    }
}
