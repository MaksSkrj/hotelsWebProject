package ua.nure.skrypnyk.DAO.impl;

public class SQLs {
    public static final String SELECT_ALL = "Select * from %s";

    public static final String FIND_BY_ID = "Select * from %s where id = ?";
    public static final String FIND_BY = "Select * from %s where %s = ?";

    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";

    public static final String INSERT_EMPLOYEE = "Insert into employee (name, last_name, DOB, aducation, position_id, sallary) values (?,?,?,?,?,?)";
    public static final String UPDATE_EMPLOYEE = "UPDATE employee SET name = ?, last_name = ?, DOB = ?, education = ?, position_id = ?, sallary = ?, WHERE id = ?";

    public static final String INSERT_BOOKING = "Insert into booking (user_id, status) values (?,?)";
    public static final String UPDATE_BOOKING = "UPDATE booking SET user_id = ?, status = ?, WHERE id = ?";

    public static final String INSERT_POSITION = "Insert into position (name) values (?)";
    public static final String UPDATE_POSITION = "UPDATE position SET name = ?, WHERE id = ?";

    public static final String INSERT_PREFERENCES = "Insert into preferences (name) values (?)";
    public static final String UPDATE_PREFERENCES = "UPDATE preferences SET name = ?, WHERE id = ?";

    public static String INSERT_ROOM_CLASSIFICATION = "Insert into room_classification " +
            "(classification, capacity, additional_information, pictures, daily_price) values (?,?,?,?,?)";

    public static String UPDATE_ROOM_CLASSIFICATION = "UPDATE room_classification SET " +
            "classification = ?, capacity = ?, additional_information = ?, pictures = ?, daily_price = ?, WHERE id = ?";

    public static final String INSERT_ROOM = "Insert into room (room_classification_id) values (?)";
    public static final String UPDATE_ROOM = "UPDATE room SET room_classification_id = ?, WHERE id = ?";

    public static final String INSERT_ROOM_STATUS = "Insert into room_status (room_id, booking_id, arrival, departure, employee_id, full_price) values (?,?,?,?,?,?)";
    public static final String UPDATE_ROOM_STATUS = "UPDATE room_status SET room_id = ?, booking_id = ?, arrival = ?, departure = ?, employee_id = ?, full_price = ?, WHERE id = ?";

    public static final String INSERT_USER = "Insert into user (login, name, last_name, DOB, sex, pregerences_id, booking_id, password) values (?,?,?,?,?,?,?)";
    public static final String UPDATE_USER = "UPDATE user SET login = ?, name = ?, last_name = ?, DOB = ?, sex = ?, preferences_id = ?, booking_id = ?, password = ? WHERE id = ?";


}
