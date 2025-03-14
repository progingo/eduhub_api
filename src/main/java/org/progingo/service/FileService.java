
package org.progingo.service;

import io.minio.errors.*;
import org.progingo.dao.FileUploadRecordDao;
import org.progingo.domain.FileUploadRecord;
import org.progingo.domain.user.UserBO;
import org.progingo.util.JsonResult;
import org.progingo.util.MinioUtils;
import org.progingo.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class FileService {

    @Autowired
    private MinioUtils minioUtils;
    @Autowired
    private MyUtil myUtil;
    @Value("${minio.bucketName}")
    private String bucketName;
    @Value("${spring.profiles.active}")
    private String env;
    @Autowired
    private FileUploadRecordDao fileUploadRecordDao;

    public JsonResult uploadFile(UserBO user, MultipartFile file, String prefix) throws IOException, ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, InvalidExpiresRangeException {
        if (user.isTourist()){
            return JsonResult.fail(401, "请重新登陆");
        }
        if (file == null){
            return JsonResult.ok(402,"","文件为空");
        }
        String fileName = myUtil.nextId(prefix) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));

        minioUtils.uploadFile(fileName,file.getContentType(),file.getInputStream());
        String filePath ="/" + bucketName + "/" + fileName;
        //String url = minioUtils.getUrl(fileName);

        FileUploadRecord uploadRecord = FileUploadRecord.builder()
                .username(user.getUsername())
                .env(env)
                .url(filePath)
                .createTime(new Date())
                .build();
        fileUploadRecordDao.insert(uploadRecord);

        return JsonResult.ok(filePath);
    }
}
