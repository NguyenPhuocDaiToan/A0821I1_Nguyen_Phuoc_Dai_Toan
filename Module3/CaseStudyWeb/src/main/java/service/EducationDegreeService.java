package service;


import dao.EducationDegreeDAO;
import model.EducationDegree;

import java.util.List;

public class EducationDegreeService {
    private EducationDegreeDAO educationDegreeDAO = new EducationDegreeDAO();

    public List<EducationDegree> getAll() {
        return educationDegreeDAO.getAll();
    }
}
