package dao;

import model.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO {
    private final String SELECT_POSITION = "SELECT * FROM POSITION";

    public List<Position> getAll() {
        List<Position> positions = new ArrayList<>();
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_POSITION);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                positions.add(new Position(id, name));
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positions;
    }
}
