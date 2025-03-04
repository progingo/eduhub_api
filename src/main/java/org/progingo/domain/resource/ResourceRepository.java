package org.progingo.domain.resource;

public interface ResourceRepository {


    boolean save(Resource resource);

    boolean isEditor(String resourceKey, String username);
}
