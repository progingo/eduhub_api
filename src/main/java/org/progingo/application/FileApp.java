package org.progingo.application;

import org.progingo.dao.FileUploadRecordDao;
import org.progingo.domain.FileUploadRecord;
import org.progingo.domain.FileUploadRecordExample;
import org.progingo.domain.user.ActionResult;
import org.progingo.domain.user.UserBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileApp {

    @Autowired
    private FileUploadRecordDao fileUploadRecordDao;

    public FileUploadRecord findFileById(UserBO user, long id) {
        FileUploadRecordExample fileUploadRecordExample = new FileUploadRecordExample();
        fileUploadRecordExample.createCriteria()
                .andIdEqualTo(id)
                .andUsernameEqualTo(user.getUsername());

        FileUploadRecord fileUploadRecord = fileUploadRecordDao.selectByExample(fileUploadRecordExample).stream().findFirst().orElse(null);

        return fileUploadRecord;
    }
}
