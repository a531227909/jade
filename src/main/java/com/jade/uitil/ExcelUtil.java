package com.jade.uitil;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.xssf.usermodel.XSSFPictureData;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil<T> {
	 /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     *
     * @param title  表格标题名
     *            
     * @param headers  表格属性列名数组
     *            
     * @param dataset
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out
     *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern
     *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings("unchecked")
    public void exportExcel(String title, String[] headers, Collection<T> dataset, OutputStream out, String pattern) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        // HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        // style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        // style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        // style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        // HSSFFont font = workbook.createFont();
        // font.setColor(HSSFColor.VIOLET.index);
        // font.setFontHeightInPoints((short) 12);
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        // style.setFont(font);
        // 生成并设置另一个样式
        // HSSFCellStyle style2 = workbook.createCellStyle();
        // style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        // style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        // style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        // style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        // style2.setFont(font2);

        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        // comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        // comment.setAuthor("leno");

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            // cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                // cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                     if (value instanceof Integer) {
                     int intValue = (Integer) value;
                     cell.setCellValue(intValue);
                     }  else if (value instanceof Long) {
                     long longValue = (Long) value;
                     cell.setCellValue(longValue);
                     }
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else if (value instanceof byte[]) {
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short) (35.7 * 80));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, index, (short) 6, index);
                        anchor.setAnchorType(2);
                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
                            // HSSFFont font3 = workbook.createFont();
                            // font3.setColor(HSSFColor.BLUE.index);
                            // richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }
                    }
                } catch (SecurityException e) {

                    e.printStackTrace();
                } catch (NoSuchMethodException e) {

                    e.printStackTrace();
                } catch (IllegalArgumentException e) {

                    e.printStackTrace();
                } catch (IllegalAccessException e) {

                    e.printStackTrace();
                } catch (InvocationTargetException e) {

                    e.printStackTrace();
                } finally {
                    // 清理资源
                }
            }

        }
        try {
            workbook.write(out);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    /**
     * 
     * <p>将MAP对象导出到EXCEL表格。</p>
     * @param String title  标题
     * @param headers   表头  ，String[]
     * @param fields    字段名 ，String[]
     * @param dataset   数据集  MAP<String,Object> 
     * @param out   文件流  OutputStream
     * @param pattern 日期格式   
     */
    public void exportExcel(String title, String[] headers, String[] fields, Collection<Map<String, Object>> dataset, OutputStream out, String pattern) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        // style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        // style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        // style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        // style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        // style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        // /HSSFFont font = workbook.createFont();
        // font.setColor(HSSFColor.VIOLET.index);
        // font.setFontHeightInPoints((short) 12);
        // font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        // style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);

        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("leno");

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<Map<String, Object>> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            Map map = it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值

            for (int i = 0; i < fields.length; i++) {
                HSSFCell cell = row.createCell(i);
                // cell.setCellStyle(style2);

                try {

                    Object value = map.get(fields[i]);
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Integer) {
                        int intValue = (Integer) value;
                        cell.setCellValue(intValue);
                    } else if (value instanceof Float) {
                        float fValue = (Float) value;

                        cell.setCellValue(fValue);
                    } else if (value instanceof Double) {
                        double dValue = (Double) value;

                        cell.setCellValue(dValue);
                    } else if (value instanceof Long) {
                        long longValue = (Long) value;
                        cell.setCellValue(longValue);
                    }

                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                        cell.setCellValue(textValue);
                    } else if (value instanceof byte[]) {
                        // 有图片时，设置行高为60px;
                        row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(i, (short) (35.7 * 80));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 6, index, (short) 6, index);
                        anchor.setAnchorType(2);
                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else if (value instanceof String) {
                        textValue = value.toString();
                        cell.setCellValue(textValue);
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        // textValue = value.toString();
                        textValue = value != null ? value.toString() : "";
                        cell.setCellValue(textValue);
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
                            // HSSFFont font3 = workbook.createFont();
                            // font3.setColor(HSSFColor.BLUE.index);
                            // richString.applyFont(font3);

                            // cell.setCellValue(richString);
                        }
                    }
                } catch (SecurityException e) {

                    e.printStackTrace();
                } catch (IllegalArgumentException e) {

                    e.printStackTrace();

                } finally {
                    // 清理资源
                }
            }

        }
        try {
            workbook.write(out);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
    
    private static void savePic(int i, PictureData pic,String imgUrl) throws Exception {  
    	  
        String ext = pic.suggestFileExtension();  
  
        byte[] data = pic.getData();  
        if (ext.equals("jpg")) {  
            FileOutputStream out = new FileOutputStream(  
            		imgUrl+"pict" + i + ".jpg");  
            out.write(data);  
            out.close();  
        }  
        if (ext.equals("png")) {  
            FileOutputStream out = new FileOutputStream(  
            		imgUrl+"pict" + i + ".png");  
            out.write(data);  
            out.close();  
        }  
    }  
  
    
public static HSSFSheet read(String url) throws Exception, IOException{
			
	System.out.println(url);
	BufferedInputStream in = new BufferedInputStream(new FileInputStream(url));
     POIFSFileSystem fs = new POIFSFileSystem(in);
        HSSFWorkbook workbook = new HSSFWorkbook(fs);  
        //HSSFSheet sheet = workbook.getSheet("��һҳ");  
        List<HSSFPictureData> pictures = workbook.getAllPictures(); 
        HSSFSheet sheet = workbook.getSheetAt(0);  
        //int sheetmergerCount = sheet.getLastRowNum();
       
   
 
      
        
		return sheet;
	}
public static XSSFSheet read2007(String url) throws Exception, IOException{
	
	System.out.println(url);
	BufferedInputStream in = new BufferedInputStream(new FileInputStream(url));

        XSSFWorkbook workbook = new XSSFWorkbook(OPCPackage.open(in));  
        //HSSFSheet sheet = workbook.getSheet("��һҳ");  
        List<XSSFPictureData> pictures = workbook.getAllPictures(); 
        XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);  
        //int sheetmergerCount = sheet.getLastRowNum();
        
		return sheet;
	}


    public static void main(String[] args) throws Exception {

        // 测试学生
        ExcelUtil<Map<String, Object>> ex = new ExcelUtil<Map<String, Object>>();
        String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" ,"图片"};
        Collection<Map<String, Object>> dataset = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("学号", "1000000" + i);
            map.put("姓名", "张三");
            map.put("年龄", 15 + i);
            map.put("性别", "男");
            map.put("出生日期", new Date());
            dataset.add(map);
        }
        // 测试图书

        OutputStream out = new FileOutputStream("D://a.xls");

        ex.exportExcel("abc", headers, headers, dataset, out, "yyyy-mm-dd");

        out.close();
        JOptionPane.showMessageDialog(null, "导出成功!");
        System.out.println("excel导出成功！");
    }
	
}
