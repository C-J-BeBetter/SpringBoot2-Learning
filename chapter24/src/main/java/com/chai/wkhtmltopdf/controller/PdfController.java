package com.chai.wkhtmltopdf.controller;

import com.chai.wkhtmltopdf.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * @description: pdf接口
 * @author: chaijin
 * @create: 2019-11-19 17:48:19
 * @version: 1.0.0
 */
@RestController
@RequestMapping("/pdf")
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @RequestMapping("/exportHtmlToPdf")
    public void exportHtmlToPdf(HttpServletResponse response) throws FileNotFoundException {
        pdfService.exportHtmlToPdf(response);
    }
}
