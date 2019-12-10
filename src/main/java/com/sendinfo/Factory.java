package com.sendinfo;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.IOException;
import java.util.ArrayList;

public interface Factory {

    public void sendDataFirstFile();
    public void sendDataSecondFile() throws IOException, InvalidFormatException;
}
