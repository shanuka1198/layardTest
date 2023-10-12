package lk.ijse.anjana.dao.daoFactory;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_EXCLUSIONPeer;
import lk.ijse.anjana.dao.daoImpl.CustomerDaoImpl;

public class FactoryDao {
    public static <T>T getDao(DaoType type){
        switch (type){
            case CUSTOMER:
                return(T)new CustomerDaoImpl();
            default:
                return null;
        }
    }
}
