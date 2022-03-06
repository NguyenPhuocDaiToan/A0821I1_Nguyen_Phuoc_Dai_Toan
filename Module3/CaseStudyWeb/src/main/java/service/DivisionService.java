package service;

import dao.DivisionDAO;
import model.Division;

import java.util.List;

public class DivisionService {
    private DivisionDAO divisionDAO = new DivisionDAO();

    public List<Division> getAll() {
        return divisionDAO.getAll();
    }
}
