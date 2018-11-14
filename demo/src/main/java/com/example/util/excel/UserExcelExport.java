package com.example.util.excel;

import com.example.dao.UserDao;
import com.example.util.POIUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * 用户信息导出
 * @author sheamus.ren
 */
@Component
public class UserExcelExport extends POIUtils {

    @Autowired
    private UserDao userDao;
    public static String[] headList={
            "用户名","密码"
    };
    public static String[] contentList={
            "username","password"
    };
    /**
     * 导出用户信息
     * @return
     */
    public HSSFWorkbook exportUser(){
        List<Map<String, Object>> dataList = userDao.listUser();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("员工列表");
        HSSFFont font =workbook.createFont();
        HSSFCellStyle headCS = getHeadCS(workbook.createCellStyle(), font);
        HSSFCellStyle contentCS = getContentCS(workbook.createCellStyle(), font);
        exortHead(sheet,0,0,headList,headCS);
        exortContent(sheet ,0 ,1,dataList,contentList,contentCS);
        return workbook;
    }
}
