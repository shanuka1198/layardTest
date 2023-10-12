package lk.ijse.anjana.dao;

import lk.ijse.anjana.entity.CustomerEntity;

import java.util.List;

public interface CrudDao <T,ID> extends SupperDao{
    boolean save(T customerEntity)throws Exception;

    boolean delete(T customerEntity) throws Exception;

    boolean update(T customerEntity) throws Exception;

    T search (ID id)throws Exception;

    List<T> getall() throws Exception;
}
