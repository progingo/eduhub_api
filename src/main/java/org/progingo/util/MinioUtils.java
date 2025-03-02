package org.progingo.util;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import io.minio.http.Method;
import lombok.SneakyThrows;
import org.progingo.config.MinioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MinioUtils {
    @Autowired
    private MinioClient minioClient;
    @Value("${minio.bucketName}")
    private String bucketName;
    @Autowired
    private MinioConfig configuration;

    @SneakyThrows
    @PostConstruct
    private void createBucket(){
        System.out.println("minio桶初始化");
        if (!minioClient.bucketExists(bucketName)){
            System.out.println("minio创建桶：" + bucketName);
            minioClient.makeBucket(bucketName);
        }
        System.out.println("桶初始化完成" + bucketName);
    }

    public void uploadFile(String fileName, String contentType, InputStream fileInputStream) throws IOException, ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                .bucket(bucketName)
                .object(fileName)
                .contentType(contentType)
                .stream(fileInputStream, fileInputStream.available(), -1)
                .build();
        minioClient.putObject(putObjectArgs);
    }

    public String getUrl(String objectName) throws ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, InvalidExpiresRangeException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String url = null;
        url = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(bucketName)
                .object(objectName)
                .build());
        return url;
    }
}
