package service;


import dao.PositionDAO;
import model.Position;

import java.util.List;

public class PositionService {
    private PositionDAO positionDAO = new PositionDAO();

    public List<Position> getAll() {
        return positionDAO.getAll();
    }
}
