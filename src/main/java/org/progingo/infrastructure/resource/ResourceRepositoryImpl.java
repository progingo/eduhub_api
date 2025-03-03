package org.progingo.infrastructure.resource;

import org.progingo.dao.ResourceDao;
import org.progingo.domain.resource.Resource;
import org.progingo.domain.resource.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ResourceRepositoryImpl implements ResourceRepository {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public boolean save(Resource resource) {
        resource.setGtmCreate(new Date());
        resource.setGtmUpdate(new Date());
        int r = resourceDao.insert(resource);
        return r == 1;

    }
}
