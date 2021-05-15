package com.company.repository;

public interface IRepository {
    void readFromFile(String fileName);
    boolean validation(String[] input);
}
