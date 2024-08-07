import java.util.List;

public interface DataBaseDAO {
    List<User> getAllUsers();
    List<Computer> getAllComputers();

    boolean insertComputer(Computer computer);
    boolean updateComputer(Computer computer);
    boolean deleteComputer(int Id);

    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int Id);
};
