package lk.ijse.anjana.dao.daoImpl;

import javafx.scene.control.Alert;
import lk.ijse.anjana.controller.CustomerFormController;
import lk.ijse.anjana.dao.custom.CustomerDao;
import lk.ijse.anjana.db.DbConnection;
import lk.ijse.anjana.entity.CustomerEntity;
import lk.ijse.anjana.service.custom.CustomerService;
import lk.ijse.anjana.service.serviceImpl.CustomerServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean save(CustomerEntity customerEntity) throws Exception {
        Connection connection = DbConnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES(?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,customerEntity.getId());
        pstm.setString(2, customerEntity.getName() );
        pstm.setString(3, customerEntity.getAddress());
        pstm.setString(4, customerEntity.getTelephone());

        boolean isSaved = pstm.executeUpdate() > 0;
        if(isSaved){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer is saved").show();
        }
        return isSaved;
    }

    @Override
    public boolean delete(CustomerEntity customerEntity) throws Exception {
        return false;
    }

    @Override
    public boolean update(CustomerEntity customerEntity) throws Exception {
        Connection connection=DbConnection.getInstance().getConnection();
        String sql="UPDATE customer SET Name=?,Address=?,Tel=? WHERE id=?";

        PreparedStatement pstm=connection.prepareStatement(sql);

        pstm.setString(1, customerEntity.getName());
        pstm.setString(2, customerEntity.getAddress());
        pstm.setString(3, customerEntity.getTelephone());
        pstm.setString(4, customerEntity.getId());

        boolean isUpdate=pstm.executeUpdate()>0;

        if(isUpdate){
            new Alert(Alert.AlertType.CONFIRMATION, "Customer Updated").show();;
        }
        return isUpdate;
    }

    @Override
    public CustomerEntity search(String id) throws Exception {
        Connection connection=DbConnection.getInstance().getConnection();
        String sql="SELECT * FROM customer WHERE id=?";

        PreparedStatement pstm= connection.prepareStatement(sql);
        pstm.setString(1,id);
        ResultSet resultSet=pstm.executeQuery();

        if(resultSet.next()){
            String cId=resultSet.getString(1);
            String cName=resultSet.getString(2);
            String cAdd=resultSet.getString(3);
            String cTp=resultSet.getString(4);

            CustomerEntity customerEntity=new CustomerEntity(cId,cName,cAdd,cTp);

            CustomerService customerService=new CustomerServiceImpl();
            customerService.searchCustom(customerEntity);
        }
return null;
    }

    @Override
    public List<CustomerEntity> getall() throws Exception {
        return null;
    }
}
