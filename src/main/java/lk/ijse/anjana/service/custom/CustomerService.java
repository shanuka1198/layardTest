package lk.ijse.anjana.service.custom;

import lk.ijse.anjana.dto.CustomerDto;
import lk.ijse.anjana.entity.CustomerEntity;
import lk.ijse.anjana.service.SuperService;

public interface CustomerService extends SuperService {


    void searchCustom(CustomerEntity customerEntity) ;



    boolean save(CustomerDto customerDto) throws Exception;

    boolean update(CustomerDto customerDto) throws Exception;

    CustomerEntity search(String custID) throws Exception;
}
