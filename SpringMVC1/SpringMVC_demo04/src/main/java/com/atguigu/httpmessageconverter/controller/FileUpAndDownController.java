package com.atguigu.httpmessageconverter.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUpAndDownController {


    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
//获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        String realPath = servletContext.getRealPath("/static/img/A.jpg");
        System.out.println(realPath);

//创建输入流
        InputStream is = new FileInputStream(realPath);
//创建字节数组
        byte[] bytes = new byte[is.available()];
//将流读到字节数组中
        is.read(bytes);
//创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
//设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
//设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
//创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
//关闭输入流
        is.close();
        return responseEntity;
    }

    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpServletRequest req) throws IOException {
//       选择的文件不能直接转换为MultipartFile类型，需要在SpringMVC中配置文件上传的解析器
        String fileName=photo.getOriginalFilename();
        //截取后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//       将UUID作为文件名
        String uuid= UUID.randomUUID().toString().replace("-","");
//      将UUID和后缀名拼接作为最后的文件名
        fileName=uuid+suffixName;

        System.out.println(photo.getName());
        System.out.println(photo.getOriginalFilename());
        ServletContext servletContext = req.getServletContext();
        String a = servletContext.getRealPath("photo");
        System.out.println(a);
        File file = new File(a);
        if(!file.exists()){
            file.mkdir();
        }
        String finalPath=a+file.separator+fileName;
        photo.transferTo(new File(finalPath));
        System.out.println(finalPath);
        
        return "success";
    }
}
