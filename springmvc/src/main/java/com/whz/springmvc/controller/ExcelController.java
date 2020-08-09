package com.whz.springmvc.controller;

import com.whz.springmvc.entity.User;
import com.whz.springmvc.service.ExcelExportService;
import com.whz.springmvc.view.ExcelView;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/excel")
public class ExcelController {

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public ModelAndView export() {
        // 模型和视图
        ModelAndView mv = new ModelAndView();
        // excel视图
        ExcelView excelView = new ExcelView("user_excel.xlsx", userExcelExportService());

        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId("1");
        user.setName("whz");
        user.setAge("18");

        mv.addObject("userList", userList);
        mv.setView(excelView);
        return mv;
    }

    /**
     * 生成的excel无法打开,为毛？
     * @return
     */
    private ExcelExportService userExcelExportService() {
        return (Map<String, Object> model, Workbook workbook) -> {
            // 获取用户列表
            List<User> userList = (List<User>) model.get("userList");
            if (CollectionUtils.isEmpty(userList)) {
                return;
            }

            // 生成sheet
            Sheet sheet = workbook.createSheet("user");
            // 设置表头
            Row title = sheet.createRow(0);
            title.createCell(0).setCellValue("id");
            title.createCell(1).setCellValue("name");
            title.createCell(2).setCellValue("age");
            // 设置用户数据
            User user = userList.get(0);
            Row row = sheet.createRow(1);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getName());
            row.createCell(2).setCellValue(user.getAge());
        };
    }
}
