package com.lhb.demo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @author lhb
 * @date 2021/2/15 13:26
 */
@RestController
public class FileController {
    @Value("${filepath}")
    private String filepath;

    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile multipartFile){
        String filename = multipartFile.getOriginalFilename();
        File file = new File(filepath + filename);
        try {
            multipartFile.transferTo(file);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }

    @RequestMapping("download")
    public String download(String filename, HttpServletResponse response){
        try {
            // 清空response
            response.reset();
            // 设置response的Header
            response.setCharacterEncoding("UTF-8");
            // Content-Disposition的作用：告知浏览器以何种方式显示响应返回的文件，用浏览器打开还是以附件的形式下载到本地保存
            // filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
            response.setContentType("application/octet-stream");
            // 获取输出流，向浏览器写出文件
            OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
            // 获取输入流，将硬盘中的文件读入内存
            InputStream fis = new BufferedInputStream(new FileInputStream(new File(filepath + filename)));
            // 缓冲区大小
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            outputStream.flush();
            fis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
