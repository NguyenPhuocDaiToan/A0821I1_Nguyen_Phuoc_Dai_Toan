package service;

import common.AppContant;
import common.CSVHelper;
import exception.NotFoundProductException;
import model.GenuineProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenuineProductService {
    private List<GenuineProduct> genuineProducts = new ArrayList<>();
    private CSVHelper<GenuineProduct> csvHelper = new CSVHelper<>();

    public GenuineProductService() {
        genuineProducts = getFromFile();
    }

    public void add(GenuineProduct genuine) {
        genuine.setId(genuineProducts.size() + 1);
        genuineProducts.add(genuine);
        csvHelper.writeFile(AppContant.Path.genuineProduct, genuineProducts, false);
    }

    public void delete(int id) throws NotFoundProductException {
        if(!genuineProducts.removeIf(e -> e.getId() == id))
            throw new NotFoundProductException("This ID is not exists");
        csvHelper.writeFile(AppContant.Path.genuineProduct, genuineProducts, true);
    }

    public List<GenuineProduct> search(String name) {
        return genuineProducts.stream().filter(e->e.getName().contains(name)).collect(Collectors.toList());
    }

    public List<GenuineProduct> getAll() {
        return genuineProducts;
    }

    private List<GenuineProduct> getFromFile() {
        List<GenuineProduct> res = new ArrayList<>();
        List<String> lines = csvHelper.readFile(AppContant.Path.genuineProduct);
        if(lines.size() > 0) {
            for (String line : lines) {
                String[] temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                String name = temp[1];
                String manufacturer = temp[2];
                int price = Integer.parseInt(temp[3]);
                String nation = temp[4];
                String status = temp[5];
                GenuineProduct genuineProduct = new GenuineProduct(id, name, manufacturer, price, nation, status);
                res.add(genuineProduct);
            }
        }
        return res;
    }
}
