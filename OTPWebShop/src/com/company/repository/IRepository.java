package com.company.repository;

public interface IRepository {
    void readFromFile(String fileName);
    void writeToFile(String fileName);
    boolean validation(String[] input);
}
