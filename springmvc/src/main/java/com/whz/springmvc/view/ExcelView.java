package com.whz.springmvc.view;

import com.whz.springmvc.service.ExcelExportService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Map;

public class ExcelView extends AbstractXlsxView {
    private String fileName;

    private ExcelExportService excelExportService;

    public ExcelView(String fileName, ExcelExportService excelExportService) {
        this.fileName = fileName;
        this.excelExportService = excelExportService;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (!StringUtils.isEmpty(fileName)) {
            response.setHeader("content-disposition", "attachment;filename=" + fileName);
        }

        // 回调接口方法，使用自定义生成excel的方法
        excelExportService.makeWorkBook(model, workbook);
    }
}
