package org.hcneed.server.common.service;

import org.hcneed.server.common.repository.BaseRepository;
import org.hcneed.server.utils.ConvertUtil;

import java.lang.reflect.ParameterizedType;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractCRUDService<T, ID extends Serializable, DTO, Repository extends BaseRepository<T, ID>> extends AbstractBaseService<T, ID, Repository> implements CRUDService<T, ID, DTO> {
    protected Class<DTO> DTO;
    protected Class<DTO> currentDtoClass() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<DTO>) genericSuperclass.getActualTypeArguments()[2];
    }

    protected DTO toDTO(T t) {
        return ConvertUtil.sourceToTarget(
                t, currentDtoClass()
        );
    }

    protected List<DTO> toDTO(List<T> data) {
        return ConvertUtil.sourceToTarget(
                data, currentDtoClass()
        );
    }

    @Override
    public DTO getById(ID id) {
        return this.toDTO(this.findById(id));
    }

    @Override
    public List<DTO> all() {
        return this.toDTO(this.findAll());
    }

    @Override
    public DTO add(T t) {
        return this.toDTO(this.save(t));
    }
}
