import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataBaseDAOImpl implements DataBaseDAO{

    @Override
    public boolean insertComputer(Computer computer)
    {
        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO COMPUTERS(USER_ID, VENDOR, MODEL, DEFFECT, PRICE, REPAIRED) VALUE(?, ?, ?, ?, ?, ?)");)
        {
            statement.setLong(1, computer.getUserId());
            statement.setString(2, computer.getVendor());
            statement.setString(3, computer.getModel());
            statement.setString(4, computer.getDefect());
            statement.setLong(5, computer.getPrice());
            statement.setBoolean(6, computer.isRepaired());

            int i = statement.executeUpdate();
            if (i == 1)
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
        return false;
    }

    @Override
    public boolean updateComputer(Computer computer)
    {
        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE COMPUTERS set USER_ID = ?, VENDOR = ?, MODEL = ?, DEFFECT = ?, PRICE = ?, REPAIRED = ? WHERE COMPUTER_ID = ?");)
        {
            statement.setLong(1, computer.getUserId());
            statement.setString(2, computer.getVendor());
            statement.setString(3, computer.getModel());
            statement.setString(4, computer.getDefect());
            statement.setLong(5, computer.getPrice());
            statement.setBoolean(6, computer.isRepaired());
            statement.setLong(7, computer.getComputerId());

            int i = statement.executeUpdate();
            if (i == 1)
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
        return false;
    }
    @Override
    public boolean deleteComputer(int id)
    {
        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM COMPUTERS WHERE COMPUTER_ID = ?");)
        {
            statement.setLong(1, id);
            int i = statement.executeUpdate();
            if (i == 1)
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
        return false;
    }

    @Override
    public List<Computer> getAllComputers()
    {
        try (Connection connection = SQLConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM COMPUTERS"))
        {
            List<Computer> computerList = new ArrayList<>();
            while(result.next())
            {
                Computer computer = extractComputers(result);
                computerList.add(computer);
            }
            return computerList;
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    @Override
    public boolean insertUser(User user)
    {
        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO users(SURNAME, FIRSTNAME, PHONE) VALUE(?, ?, ?)");)
        {
            statement.setString(1, user.getSurname());
            statement.setString(2, user.getFirstName());
            statement.setLong(3, user.getPhone());
            int i = statement.executeUpdate();
            if (i == 1)
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
        return false;
    };
    @Override
    public boolean updateUser(User user)
    {
        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE USERS set SURNAME = ?, FIRSTNAME = ?, PHONE = ? WHERE USER_ID = ?");)
        {
            statement.setString(1, user.getSurname());
            statement.setString(2, user.getFirstName());
            statement.setLong(3, user.getPhone());
            statement.setLong(4, user.getUserId());

            int i = statement.executeUpdate();
            if (i == 1)
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
        return false;
    };

    @Override
    public boolean deleteUser(int Id)
    {
        try (Connection connection = SQLConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM USERS WHERE USER_ID = ?");)
        {
            statement.setLong(1, Id);
            int i = statement.executeUpdate();
            if (i == 1)
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return false;
        }
        return false;
    };
    @Override
    public List<User> getAllUsers()
    {
        try (Connection connection = SQLConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery("SELECT * FROM USERS"))
        {
            List<User> userslist = new ArrayList<>();
            while(result.next())
            {
                User user = extractUser(result);
                userslist.add(user);
            }
            return userslist;
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    private User extractUser(ResultSet usr) throws SQLException
    {
        User user = new User();
        user.setUserId(usr.getInt("USER_ID"));
        user.setSurname(usr.getString("SURNAME"));
        user.setFirstName(usr.getString("FIRSTNAME"));
        user.setPhone(usr.getInt("PHONE"));
        return user;
    }
    private Computer extractComputers(ResultSet comp) throws SQLException
    {
        Computer computer = new Computer();
        computer.setComputerId(comp.getInt("COMPUTER_ID"));
        computer.setUserId(comp.getInt("USER_ID"));
        computer.setVendor(comp.getString("VENDOR"));
        computer.setModel(comp.getString("MODEL"));
        computer.setDefect(comp.getString("DEFFECT"));
        computer.setPrice(comp.getInt("PRICE"));
        computer.setRepaired(comp.getBoolean("REPAIRED"));
        return computer;
    }
}
