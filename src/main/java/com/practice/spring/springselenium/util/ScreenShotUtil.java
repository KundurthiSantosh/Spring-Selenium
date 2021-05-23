package com.practice.spring.springselenium.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScreenShotUtil {

    @Autowired
    private TakesScreenshot driver;

    @Value("${screenshot.path}")
    private Path screenShotPath;

    private String fileName;

    @Autowired
    public void setFileName(){
        this.fileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmssyyyyMMdd"));
    }

    public void takeScreenShot() throws IOException {
        File file = this.driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, this.screenShotPath.resolve(this.fileName).toFile());
    }
}
