package com.chai.wkhtmltopdf.service.impl;

import com.chai.wkhtmltopdf.model.PDFDataTest;
import com.chai.wkhtmltopdf.service.PdfService;
import com.chai.wkhtmltopdf.utils.DownloadUtils;
import com.chai.wkhtmltopdf.utils.ReportCreateUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: pdf服务实现类
 * @author: chaijin
 * @create: 2019-11-19 17:50:46
 * @version: 1.0.0
 */
@Service
public class PdfServiceImpl implements PdfService {

    @Override
    public void exportHtmlToPdf(HttpServletResponse response) throws FileNotFoundException {
        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("curr", 1);
        dataMap.put("one", 2);
        dataMap.put("two", 1);
        dataMap.put("three", 6);

        List<PDFDataTest> detailList = new ArrayList<>();
        detailList.add(new PDFDataTest(123456, "测试", "测试", "测试", "测试"));
        detailList.add(new PDFDataTest(111111, "测试", "测试", "测试", "测试"));
        detailList.add(new PDFDataTest(222222, "测试", "测试", "测试", "测试"));
        dataMap.put("detailList", detailList);

        Map<String, String> mapPic = new HashMap<>();
        mapPic.put("1-1", "功夫熊猫.jpg");
        dataMap.put("mapPic", mapPic);

        String templateName = "pdf测试模板.html";
        String filename     = "pdf测试模板.pdf";
        List<File> files = new ArrayList<>();
        File   file         = ReportCreateUtils.exportHtmlToPDFWithWK(templateName, filename, dataMap);
        files.add(file);
        try {
            DownloadUtils.downLoadFiles("测试模板", files, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
