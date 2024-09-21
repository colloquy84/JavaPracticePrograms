package com.pandeyar.spring;

import java.util.HashMap;
import java.util.Map;

public class StockValueFetcher {

    private final Map<String, String> stockSymbolsAndValues;

    private String symbolName;
    private String symbolValue;

    public StockValueFetcher() {
        stockSymbolsAndValues = new HashMap<String, String>();
        stockSymbolsAndValues.put("ABC", "10");
        stockSymbolsAndValues.put("DEF", "20");
        stockSymbolsAndValues.put("GHI", "30");
        stockSymbolsAndValues.put("JKL", "40");
    }

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public String getSymbolValue() {
        return symbolValue;
    }

    public void setSymbolValue(String symbolValue) {
        this.symbolValue = symbolValue;
    }

    public String findStockValue(){
        boolean symbolFound = stockSymbolsAndValues.containsKey(symbolName);
        if (symbolFound){
            symbolValue = stockSymbolsAndValues.get(symbolName);
            return "stockOutputSuccess";
        }else{
            return "stockOutputFailure";
        }
    }
}

