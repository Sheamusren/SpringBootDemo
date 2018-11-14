package com.example.web;

import com.example.util.excel.DownloadUtil;
import com.example.util.excel.UserExcelExport;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class TestController {

    @Autowired
    public UserExcelExport userExcelExport;
    @Autowired
    public DownloadUtil downloadUtil;

    @GetMapping("/exportUser")
    public void index(HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = userExcelExport.exportUser();
        String fileName = "用户列表" + ".xls";
        downloadUtil.downloadExcel(response,workbook,fileName);
    }

}
