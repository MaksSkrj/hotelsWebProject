package ua.nure.skrypnyk.service.impl;

import ua.nure.skrypnyk.DAO.api.DAO;
import ua.nure.skrypnyk.DTO.UserDTO;
import ua.nure.skrypnyk.mapper.BeanMapper;
import ua.nure.skrypnyk.model.User;
import ua.nure.skrypnyk.service.api.Service;
import ua.nure.skrypnyk.DAO.DAOFactory;

import java.util.List;

public class UserServiceImpl  implements Service<Integer, UserDTO> {

    private static UserServiceImpl service;
    private DAO<Integer, User> userDAO;
    private BeanMapper beanMapper;

    private UserServiceImpl() {
        userDAO = DAOFactory.getInstance().getUserDAO();
        beanMapper = BeanMapper.getInstance();
    }

    public static synchronized UserServiceImpl getInstance() {
        if (service == null) {
            service = new UserServiceImpl();
        }
        return service;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userDAO.getAll();
        List<UserDTO> userDTOs = beanMapper.listMapToList(users, UserDTO.class);
        return userDTOs;
    }

    @Override
    public UserDTO getById(Integer id) {
        User user = userDAO.getById(id);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public void save(UserDTO UserDTO) {
        User user = beanMapper.singleMapper(UserDTO, User.class);
        userDAO.save(user);
    }

    public UserDTO getByLogin(String value){
        User user = userDAO.getBy("login", value);
        UserDTO userDTO = beanMapper.singleMapper(user, UserDTO.class);
        return userDTO;
    }

    @Override
    public void delete(Integer key) {

    }

    @Override
    public void update(UserDTO entity) {

    }
}
