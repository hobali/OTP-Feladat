package com.company;

import com.company.logic.ReportMaker;

public class Main {

    public static void main(String[] args) {
        ReportMaker rm = new ReportMaker();
        rm.makeReport01("report01.csv");
        rm.makeReport02("report02.csv");
    }
}
