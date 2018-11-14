package com.example.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;

import java.util.List;
import java.util.Map;

/**
 * POI 工具类
 * @author sheamus.ren
 */
public class POIUtils {
    /**
     * 设置默认head样式
     * @param cs
     * @param font
     * @return
     */
     public HSSFCellStyle getHeadCS(HSSFCellStyle cs, HSSFFont font){
         font.setFontName("Verdana");
         font.setFontHeightInPoints((short) 12);
         font.setBoldweight((short) 80);
         font.setFontHeight((short) 250);
         font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); 	// 粗体字
         font.setColor(HSSFColor.BLACK.index);
         cs.setFont(font);
         cs.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
         cs.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         cs.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
         cs.setWrapText(true);
         cs.setBorderBottom(HSSFCellStyle.BORDER_THIN); 	// 下边框
         cs.setBorderLeft(HSSFCellStyle.BORDER_THIN); 	// 左边框
         cs.setBorderTop(HSSFCellStyle.BORDER_THIN); 	// 上边框
         cs.setBorderRight(HSSFCellStyle.BORDER_THIN); 	// 右边框
         return cs;
     }

    /**
     * 设置默认普通样式
     * @param cs
     * @param font
     * @return
     */
    public HSSFCellStyle getContentCS(HSSFCellStyle cs, HSSFFont font) {
        cs.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cs.setWrapText(true);
        cs.setBorderBottom(HSSFCellStyle.BORDER_THIN); 	// 下边框
        cs.setBorderLeft(HSSFCellStyle.BORDER_THIN); 	// 左边框
        cs.setBorderTop(HSSFCellStyle.BORDER_THIN); 	// 上边框
        cs.setBorderRight(HSSFCellStyle.BORDER_THIN); 	// 右边框
        return cs;
    }
    /**
     * 导出
     */
    public void exportExcel(String sheetName, List dataList, List headList, String[] contentList){
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hSSFSheet = hssfWorkbook.createSheet(sheetName);
    }

    /**
     * 表头
     * @param sheet sheet
     * @param xIndex 起点x坐标
     * @param yIndex 起点y坐标
     * @param headList 表头数据
     * @param cs 表头样式
     */
    public void exortHead(HSSFSheet sheet, int xIndex, int yIndex, String[] headList, HSSFCellStyle cs){
        HSSFRow row = sheet.createRow(yIndex);
        row.setHeightInPoints(16);
        for(int i=xIndex; i < xIndex + headList.length; i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(headList[i-xIndex]);
            cell.setCellStyle(cs);
        }
    }

    /**
     * 内容
     * @param sheet sheet
     * @param xIndex 起点x坐标
     * @param yIndex 起点y坐标
     * @param dataList 内容数据
     * @param contentList 内容数据标题
     * @param cs 内容样式
     */
    public void exortContent(HSSFSheet sheet, int xIndex, int yIndex, List dataList, String[] contentList, HSSFCellStyle cs){
        for(int i = 0; i < dataList.size(); i++){
            HSSFRow row = sheet.createRow(yIndex + i);
            row.setHeightInPoints(16);
            for (int j = xIndex; j < xIndex + contentList.length; j++){
                HSSFCell cell = row.createCell(j);
                cell.setCellStyle(cs);
                Map dataMap = (Map)dataList.get(i);
                Object data = dataMap.get(contentList[j - xIndex]);
                cell.setCellValue((String) data);
            }
        }
    }


}
