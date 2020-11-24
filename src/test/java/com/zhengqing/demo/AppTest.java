package com.zhengqing.demo;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.youbenzi.md2.export.FileFactory;
import com.zhengqing.demo.config.Constants;
import com.zhengqing.demo.utils.MyFileUtil;

/**
 * <p>
 * 小测试$
 * </p>
 *
 * @author : zhengqing
 * @description :
 * @date : 2020/7/10$ 11:02$
 */

public class AppTest {

    private final String WORD_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.doc";
    private final String HTML_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.html";
    private final String EXCEL_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.xlsx";
    private final String MD_FILE_PATH = Constants.DEFAULT_FOLDER_TMP + "/test.md";

    @Test // 【 https://gitee.com/cevin15/MD2File 】 【 注：转换格式不是太完善，存在一定问题！ 】
    public void markdown2Html() throws Exception {
        FileFactory.produce(new File(MD_FILE_PATH), Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test-md.html");
    }

    @Test
    public void testWord2Html() throws Exception {
        File htmlFile =
            MyFileConvertUtil.word2Html(new File(WORD_FILE_PATH), Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test.html");
        System.out.println(htmlFile);
    }

    @Test
    public void testHtml2Word() throws Exception {
        File wordFile = MyFileConvertUtil.html2Word(MyFileUtil.readBytes(HTML_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test.doc");
        System.out.println(wordFile);
    }

    @Test
    public void testDoc2Docx() throws Exception {
        File docxFile =
            MyFileConvertUtil.doc2Docx(new File(WORD_FILE_PATH), Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test.docx");
        System.out.println(docxFile);
    }

    @Test
    public void testHtml2Pdf() throws Exception {
        File pdfFile = MyFileConvertUtil.html2Pdf(MyFileUtil.readBytes(HTML_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test-html.pdf");
        System.out.println(pdfFile);
    }

    @Test
    public void testExcel2Pdf() throws Exception {
        File pdfFile = MyFileConvertUtil.excel2Pdf(MyFileUtil.readBytes(EXCEL_FILE_PATH),
            Constants.DEFAULT_FOLDER_TMP_GENERATE + "/test-excel.pdf");
        System.out.println(pdfFile);
    }

    @Test
    public void testWord2Jpg() throws Exception {
        byte[] wordFileBytes = MyFileUtil.readBytes(WORD_FILE_PATH);
        List<File> jpgFileList = MyFileConvertUtil.word2Jpeg(wordFileBytes, Constants.DEFAULT_FOLDER_TMP_GENERATE);
        System.out.println(jpgFileList);
    }

}