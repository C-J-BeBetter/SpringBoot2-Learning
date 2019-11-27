package com.chai.wkhtmltopdf.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Map;

public class ReportCreateUtils {
	
    private static final Logger logger = LoggerFactory.getLogger(ReportCreateUtils.class);

	/**
	 * 导出PDF文档，响应到请求端
	 * 处理流程：获取html模板 >> 填充模板, 生成临时html >> 转换成pdf文件 >> 下载
	 * @param templateName，模板名称
	 * @param fileName，导出文档名称
	 * @param dataMap，模板中变量数据
	 * @return 生成pdf的路径
	 */
	public static File exportHtmlToPDFWithWK(String templateName, String fileName, Map<?, ?> dataMap) {
		// 模板路径
		String templatePath = PropertyUtil.wkTemplateFolder + "html/";
		logger.info("模板路径：" + templatePath);
		// html临时路径
		String srcPath = PropertyUtil.wkTemplateFolder + "tmp/" + templateName;;
		logger.info("html临时路径：" + srcPath);
		// pdf临时路径
		String destPath = PropertyUtil.wkTemplateFolder + "tmp/" + fileName;
		logger.info("pdf临时路径：" + destPath);

		File tmpHtml = new File(srcPath);
		//如果pdf保存路径不存在，则创建路径
		if(!tmpHtml.getParentFile().exists()){
			tmpHtml.getParentFile().mkdirs();
		}

		// 填充模板, 生成临时html
		Configuration configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		try {
			configuration.setDirectoryForTemplateLoading(new File(templatePath));
			Template template = configuration.getTemplate(templateName);
			if (!tmpHtml.exists()) {
				tmpHtml.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(tmpHtml);
			template.process(dataMap, fileWriter);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

		convertHtmlToPdf(srcPath, destPath);
		// 转换完成，删除html临时文件
		tmpHtml.delete();
		return new File(destPath);
	}

	/**
	 * html文件转pdf
	 * @param htmlPath
	 * @param pdfPath
	 */
	public static void convertHtmlToPdf (String htmlPath, String pdfPath) {
		// html转成pdf
		StringBuilder cmd = new StringBuilder();
		cmd.append(PropertyUtil.wkhtmltopdf);
		cmd.append(" ");
		cmd.append("  --header-line");//页眉下面的线
		cmd.append("  --header-center 这里是页眉这里是页眉这里是页眉这里是页眉 ");//页眉中间内容
		//cmd.append("  --margin-top 30mm ");//设置页面上边距 (default 10mm)
		cmd.append(" --header-spacing 10 ");//    (设置页眉和内容的距离,默认0)
		cmd.append(" --orientation Landscape "); //横向
		cmd.append(htmlPath);
		cmd.append(" ");
		cmd.append(pdfPath);

		try {
			Process              proc   = Runtime.getRuntime().exec(cmd.toString());
			HtmlToPdfInterceptor error  = new HtmlToPdfInterceptor(proc.getErrorStream());
			HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
			error.start();
			output.start();
			proc.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 记录wkhtmltopdf将html转pdf的日志
	 */
	public static class HtmlToPdfInterceptor extends Thread {
		private InputStream is;

		public HtmlToPdfInterceptor(InputStream is){
			this.is = is;
		}

		public void run(){
			try{
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line.toString()); //输出内容
				}
			}catch (IOException e){
				e.printStackTrace();
			}
		}
	}
}
