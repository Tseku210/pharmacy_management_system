package com.example.pharmacy_management_system.DAO;

import com.example.pharmacy_management_system.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    private static UserDAOImpl instance = null;
    private Connection connection;

    private UserDAOImpl() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "tseku", "password");
    }

    public static UserDAOImpl getInstance() {
        if (instance == null) {
            try {
                instance = new UserDAOImpl();
            } catch(SQLException e) {
                throw new RuntimeException();
            }
        }

        return instance;
    }

    @Override
    public boolean addUser(User user) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("INSERT INTO users (username, password, first_name, last_name, email, phone, role, address, staff_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getMail());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getRole());
            statement.setString(8, user.getAddress());
            statement.setString(9, user.getStaffId());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean removeUser(int id) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean updateUser(User user) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE users SET username = ?, password = ?, first_name = ?, last_name = ?, email = ?, phone = ?, role = ?, address = ?, staff_id = ? WHERE id = ?");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFirstName());
            statement.setString(4, user.getLastName());
            statement.setString(5, user.getMail());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getRole());
            statement.setString(8, user.getAddress());
            statement.setString(9, user.getStaffId());
            statement.setInt(10, user.getId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public User getUserByUsername(String username) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String staffId = resultSet.getString("staff_id");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");

                return new User(id, firstName, lastName, address, staffId, email, phone, username, password, role);
            } else {
                return null;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM users");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String staffId = resultSet.getString("staff_id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");

                User user = new User(id, firstName, lastName, address, staffId, email, phone, username, password, role);
                users.add(user);
            }

            return users;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getManagers() {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM users where role = ?");
            statement.setString(1, "manager");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String staffId = resultSet.getString("staff_id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");

                User user = new User(id, firstName, lastName, address, staffId, email, phone, username, password, role);
                users.add(user);
            }

            return users;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getPharmacists() {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        System.out.println("i'm outside");
        try {
            statement = connection.prepareStatement("SELECT * FROM users where role = ?");
            statement.setString(1, "pharmacist");
            resultSet = statement.executeQuery();

            System.out.println("im inside");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String staffId = resultSet.getString("staff_id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");

                User user = new User(id, firstName, lastName, address, staffId, email, phone, username, password, role);
                System.out.println(user);
                users.add(user);
            }

            return users;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<User> getCashiers() {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT * FROM users where role = ?");
            statement.setString(1, "cashier");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String staffId = resultSet.getString("staff_id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phone");
                String role = resultSet.getString("role");
                String password = resultSet.getString("password");

                User user = new User(id, firstName, lastName, address, staffId, email, phone, username, password, role);
                users.add(user);
            }

            return users;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
