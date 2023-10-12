package lk.ijse.anjana.service.serviceFactory;

import lk.ijse.anjana.service.serviceImpl.CustomerServiceImpl;

public class ServiceFactory {
    public static <T>T getService(FactoryType type){
        switch (type){
            case CUSTOMER:
                return(T)new CustomerServiceImpl();
            default:
                return null;
        }
    }
}
