package com.company.repository;

public interface IRepository {
    public void readFromFile(String fileName);
    public boolean validation(String[] input);
}
