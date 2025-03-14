package org.progingo.config;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    /**
     * 连接url
     */
    @Value("${minio.endpoint}")
    private String endpoint;
    /**
     * 用户名
     */
    @Value("${minio.accesskey}")
    private String accesskey;
    /**
     * 密码
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(endpoint, accesskey, secretKey);

    }
}
