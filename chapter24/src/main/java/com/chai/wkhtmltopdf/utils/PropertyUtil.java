package com.chai.wkhtmltopdf.utils;

import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    public static String tempUrl;
    public static String jsUrl;
    public static String printUrl;

    // Wkhtmltox路径
    public static String wkhtmltopdf;
    public static String wkhtmltoimage;
    public static String wkTemplateFolder;
    static {
        Properties ps = new Properties();
        String     os = System.getProperty("os.name");
        try {
            ps.load(PropertyUtil.class.getResourceAsStream("/file.properties"));
            tempUrl = ps.getProperty("fileUtils.tempUrl");
            jsUrl = ps.getProperty("fileUtils.jsUrl");
            printUrl = ps.getProperty("fileUtils.printUrl");

            if (os.toLowerCase().startsWith("win")) {
                wkhtmltopdf = ps.getProperty("windows.wkhtmltopdf");
                wkhtmltoimage = ps.getProperty("windows.wkhtmltoimage");
                wkTemplateFolder = ClassUtils.getDefaultClassLoader().getResource("")
                        .getPath().substring(1) + "ftl/";
            } else {
				wkhtmltopdf = ps.getProperty("linux.wkhtmltopdf");
				wkhtmltoimage = ps.getProperty("linux.wkhtmltoimage");
                wkTemplateFolder = ps.getProperty("linux.wkhtmltopdf.template.floder");
			}
        } catch (IOException e) {
        }
    }


}
