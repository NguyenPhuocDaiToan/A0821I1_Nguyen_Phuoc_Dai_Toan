package service;

import common.AppContant;
import common.CSVHelper;
import exception.NotFoundProductException;
import model.HandedProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandedProductService {
    private List<HandedProduct> handedProducts = new ArrayList<>();
    private CSVHelper<HandedProduct> csvHelper = new CSVHelper<>();

    public HandedProductService() {
        handedProducts = getFromFile();
    }

    public void add(HandedProduct handed) {
        int id = (handedProducts.size() == 0) ? 1 : handedProducts.get(handedProducts.size() - 1).getId() + 1;
        handed.setId(id);
        handedProducts.add(handed);
        csvHelper.writeFile(AppContant.Path.handedProduct, handedProducts, false);
    }

    public void delete(int id) throws NotFoundProductException {
        if(!handedProducts.removeIf(e-> e.getId() == id)) {
            throw new NotFoundProductException("This ID is not exists");
        }
        csvHelper.writeFile(AppContant.Path.handedProduct, handedProducts, true);
    }

    public List<HandedProduct> search(String name) {
        return handedProducts.stream().filter(e-> e.getName().contains(name)).collect(Collectors.toList());
    }

    public List<HandedProduct> getAll() {
        return handedProducts;
    }

    private List<HandedProduct> getFromFile() {
        List<HandedProduct> res = new ArrayList<>();
        List<String> lines = csvHelper.readFile(AppContant.Path.handedProduct);
        if(lines.size() > 0) {
            for (String line : lines) {
                String[] temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                String name = temp[1];
                String manufacturer = temp[2];
                int price = Integer.parseInt(temp[3]);
                String warranty_period = temp[4];
                HandedProduct handleProduct = new HandedProduct(id, name, manufacturer, price, warranty_period);
                res.add(handleProduct);
            }
        }
        return res;
    }
}
