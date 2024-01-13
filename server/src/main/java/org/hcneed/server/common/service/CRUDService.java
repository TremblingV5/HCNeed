package org.hcneed.server.common.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<T, ID extends Serializable, DTO> extends BaseService<T, ID> {
    DTO getById(ID id);
    List<DTO> all();
    DTO add(T t);
}
