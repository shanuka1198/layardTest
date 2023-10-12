package lk.ijse.anjana.service.serviceImpl;

import lk.ijse.anjana.controller.CustomerFormController;
import lk.ijse.anjana.dao.custom.CustomerDao;
import lk.ijse.anjana.dao.daoFactory.DaoType;
import lk.ijse.anjana.dao.daoFactory.FactoryDao;
import lk.ijse.anjana.dto.CustomerDto;
import lk.ijse.anjana.entity.CustomerEntity;
import lk.ijse.anjana.service.custom.CustomerService;


public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao= FactoryDao.getDao(DaoType.CUSTOMER);


    @Override
    public void searchCustom(CustomerEntity customerEntity) {
        CustomerDto customerDto=new CustomerDto(
                customerEntity.getId(),
                customerEntity.getName(),
                customerEntity.getAddress(),
                customerEntity.getTelephone());

        CustomerFormController customerFormController=new CustomerFormController();

        customerFormController.searchCustomer(customerDto);
    }


    @Override
    public boolean save(CustomerDto customerDto) throws Exception {
        CustomerEntity customerEntity=new CustomerEntity(
                customerDto.getId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getTelephone());


        return customerDao.save(customerEntity);

    }

    @Override
    public boolean update(CustomerDto customerDto) throws Exception {
        CustomerEntity customerEntity=new CustomerEntity(
                customerDto.getId(),
                customerDto.getName(),
                customerDto.getAddress(),
                customerDto.getTelephone());

        return customerDao.update(customerEntity);

    }

    @Override
    public CustomerEntity search(String custID) throws Exception {
        return customerDao.search(custID);
    }
}
