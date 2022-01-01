package service;

import common.AppConstant.*;
import exception.NotFoundBankAccountException;
import model.AccountBank;
import model.AccountPayment;
import model.AccountSaving;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountService {
    private List<AccountBank> accountBanks = new ArrayList<>();

    public AccountService() {
        read(Path.account);
    }

    public void add(AccountBank accountBank) {
        int id = (accountBanks.size() == 0) ? 1 : accountBanks.get(accountBanks.size() - 1).getId() + 1;
        accountBank.setId(id);
        accountBanks.add(accountBank);
        write(Path.account, true);
    }

    public void delete(int id) throws NotFoundBankAccountException{
        if(accountBanks.removeIf(e->e.getId() == id)) {
            write(Path.account, false);
        }
        else    throw new NotFoundBankAccountException ("Not exist id");
    }

    public List<AccountBank> search(String name) {
        return accountBanks.stream().filter(e->e.getName().toUpperCase().contains(name.toUpperCase())).collect(Collectors.toList());
    }

    public List<AccountBank> getAll() {
        return accountBanks;
    }

    public void read(String path) {
        creatFileNotExist(path);

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String line = "";
            while((line = reader.readLine()) != null) {
                if(line.equals("")) break;
                String[] temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                String account = temp[1];
                String name = temp[2];
                String dateCreat = temp[3];
                if(temp.length == 6) {
                    String card = temp[4];
                    double ammount = Double.parseDouble(temp[5]);
                    AccountPayment accountPayment = new AccountPayment(id, account, name, dateCreat, card, ammount);
                    accountBanks.add(accountPayment);
                }
                else {
                    double amount_of_savings = Double.parseDouble(temp[4]);
                    String dateSaving = temp[5];
                    float interest_rate = Float.parseFloat(temp[6]);
                    int month = Integer.parseInt(temp[7]);
                    AccountSaving accountSaving = new AccountSaving(id, account, name, dateCreat, amount_of_savings, dateSaving, interest_rate, month);
                    accountBanks.add(accountSaving);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String path, boolean isAppend) {
        creatFileNotExist(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, isAppend))){
            if(isAppend) {
                writer.write(accountBanks.get(accountBanks.size() - 1).toString());
                writer.newLine();
            }
            else {
                for(AccountBank accountBank : accountBanks) {
                    writer.write(accountBank.toString());
                    writer.newLine();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void creatFileNotExist(String path) {
        File file = new File(path);
        try {
            if(!file.exists())
                file.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
