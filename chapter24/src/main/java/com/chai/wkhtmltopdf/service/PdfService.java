package com.chai.wkhtmltopdf.service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * @description: pdf服务
 * @author: chaijin
 * @create: 2019-11-19 17:49:26
 * @version: 1.0.0
 */
public interface PdfService {

    void exportHtmlToPdf(HttpServletResponse response) throws FileNotFoundException;
}
