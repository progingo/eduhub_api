package org.progingo.controller;

import io.minio.errors.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.progingo.domain.user.UserBO;
import org.progingo.service.FileService;
import org.progingo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload/{prefix}")
    @RequiresAuthentication
    public JsonResult uploadImage(@RequestBody MultipartFile file, @PathVariable("prefix") String prefix) throws ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, InvalidExpiresRangeException {
        UserBO user = (UserBO) SecurityUtils.getSubject().getPrincipal();
        return fileService.uploadFile(user,file,prefix);
    }
}
