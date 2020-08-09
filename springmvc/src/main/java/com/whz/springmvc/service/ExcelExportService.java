package com.whz.springmvc.service;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

public interface ExcelExportService {
    /**
     * 生成excel文件规则
     * @param model 数据模型
     * @param workbook excel
     */
    public void makeWorkBook(Map<String, Object> model, Workbook workbook);
}
