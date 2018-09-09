package com.charlie.cloud.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Author: Charie
 * 10/09/2018 00:08
 **/
@Controller
public class FileController {

    /**
     * 上传文件
     * 测试方法：
     * 有界面的测试：http://localhost:8050/index.html
     * 使用命令：
     *  curl -F "file=@文件全名" localhost:8050/upload
     *  curl -v -H "Transfer-Encoding: chunked" -F "file=@large.file" localhost:8040/zuul/microservice-file-upload/upload
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/upload")
    public String handleFileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        File fileToSave = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, fileToSave);
        String savePath = fileToSave.getAbsolutePath();
        return savePath;
    }
}
