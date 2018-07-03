package ua.nure.skrypnyk.DAO;

import ua.nure.skrypnyk.DAO.api.DAO;
import ua.nure.skrypnyk.DAO.impl.*;
import ua.nure.skrypnyk.helper.PropertyHolder;
import ua.nure.skrypnyk.model.*;

public class DAOFactory {
    private static DAOFactory instance = null;

    private DAO<Integer, User> userDAO;
    private DAO<Integer, Booking> bookingDAO;
    private DAO<Integer, Employee> employeeDAO;
    private DAO<Integer, Position> positionDAO;
    private DAO<Integer, Preferences> preferencesDAO;
    private DAO<Integer, Room> roomDAO;
    private DAO<Integer, RoomClassification> roomClassificationDAO;
    private DAO<Integer, RoomStatus> roomStatusDAO;

    private DAOFactory(){
        loadDAOs();
    }

    public static DAOFactory getInstance(){
        if(instance == null){
            instance = new DAOFactory();
        }
        return instance;
    }

    private void loadDAOs() {
        if(PropertyHolder.getInstance().isInMemoryDB()){
            //inmemory daos
        }else{
            //jdbc daos
            bookingDAO = new BookingDAOImpl();
            employeeDAO = new EmployeeDAOImpl();
            positionDAO = new PositionDAOImpl();
            preferencesDAO = new PreferencesDAOImpl();
            roomClassificationDAO = new RoomClassificationDAOImpl();
            roomDAO = new RoomDAOImpl();
            roomStatusDAO = new RoomStatusDAOImpl();
            userDAO = new UserDAOImpl();
        }
    }

    public static void setInstance(DAOFactory instance) {
        DAOFactory.instance = instance;
    }

    public DAO<Integer, User> getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(DAO<Integer, User> userDAO) {
        this.userDAO = userDAO;
    }

    public DAO<Integer, Booking> getBookingDAO() {
        return bookingDAO;
    }

    public void setBookingDAO(DAO<Integer, Booking> bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public DAO<Integer, Employee> getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(DAO<Integer, Employee> employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public DAO<Integer, Position> getPositionDAO() {
        return positionDAO;
    }

    public void setPositionDAO(DAO<Integer, Position> positionDAO) {
        this.positionDAO = positionDAO;
    }

    public DAO<Integer, Preferences> getPreferencesDAO() {
        return preferencesDAO;
    }

    public void setPreferencesDAO(DAO<Integer, Preferences> preferencesDAO) {
        this.preferencesDAO = preferencesDAO;
    }

    public DAO<Integer, Room> getRoomDAO() {
        return roomDAO;
    }

    public void setRoomDAO(DAO<Integer, Room> roomDAO) {
        this.roomDAO = roomDAO;
    }

    public DAO<Integer, RoomClassification> getRoomClassificationDAO() {
        return roomClassificationDAO;
    }

    public void setRoomClassificationDAO(DAO<Integer, RoomClassification> roomClassificationDAO) {
        this.roomClassificationDAO = roomClassificationDAO;
    }

    public DAO<Integer, RoomStatus> getRoomStatusDAO() {
        return roomStatusDAO;
    }

    public void setRoomStatusDAO(DAO<Integer, RoomStatus> roomStatusDAO) {
        this.roomStatusDAO = roomStatusDAO;
    }
}
