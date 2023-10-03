package com.security.entity;

import java.util.List;

public interface DtoHelper<M, D> {

  public List<D> buildDtos(Iterable<M> models);

  public D buildDto(M model);

  public M build(D dto);

  public List<M> buildModels(Iterable<D> dtos);

}
