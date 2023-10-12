package lk.ijse.anjana.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.ijse.anjana.dto.CustomerDto;
import lk.ijse.anjana.entity.CustomerEntity;
import lk.ijse.anjana.service.custom.CustomerService;
import lk.ijse.anjana.service.serviceFactory.FactoryType;
import lk.ijse.anjana.service.serviceFactory.ServiceFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerFormController {
    public TextField txtCustId;
    public TextField txtCustName;
    public TextField txtCustAdd;
    public TextField txtCustTel;

    private CustomerService customerService= ServiceFactory.getService(FactoryType.CUSTOMER);

    public void btnCustSaveOnAction(ActionEvent actionEvent) throws Exception {

        String custID= txtCustId.getText();
        String custName=txtCustName.getText();
        String custAddress=txtCustAdd.getText();
        String custTp=txtCustTel.getText();

        CustomerDto customerDto=new CustomerDto(custID,custName,custAddress,custTp);

        customerService.save(customerDto);
        clear();
    }

    private void clear() {
        txtCustId.setText("");
        txtCustName.setText("");
        txtCustAdd.setText("");
        txtCustTel.setText("");
    }



    public void btnCustClearOnAction(ActionEvent actionEvent) {
        clear();
    }

    public void btnCustUpdateOnAction(ActionEvent actionEvent) throws Exception {
        String custID= txtCustId.getText();
        String custName=txtCustName.getText();
        String custAddress=txtCustAdd.getText();
        String custTp=txtCustTel.getText();

        CustomerDto customerDto=new CustomerDto(custID,custName,custAddress,custTp);


        customerService.update(customerDto);
    }

    public void txtBtnCustIdOnAction(ActionEvent actionEvent) throws Exception {
        String custID= txtCustId.getText();

        customerService.search(custID);
    }

    public void btnCustDeleteOnAction(ActionEvent actionEvent) {

    }

    public void searchCustomer(CustomerDto customerDto) {
        txtCustTel.setText(customerDto.getId());
        txtCustName.setText(customerDto.getName());
        txtCustAdd.setText(customerDto.getAddress());
        txtCustTel.setText(customerDto.getTelephone());
    }
}
