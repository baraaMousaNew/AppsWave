package com.dataprovider;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;

public class DataProviderClass {

    private static String testCaseName = "NA";

    private static final String LOGIN_FILE = "src/test/java/com/datafiles/visa_150023_application_data.json";

    /**
     * extractData_JSON - method to extract JSON data from a file
     * @param file
     * @return
     * @throws Exception
     */
    public static JSONObject extractData_JSON (String file) throws Exception{
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();

        return (JSONObject) jsonParser.parse(reader);
    }

    @DataProvider(name = "visa_150023_valid_data")
    public static Object[][] fetchFromJSON (Method method) throws Exception {

        Object [] [] result;

        JSONObject object = (JSONObject) extractData_JSON(LOGIN_FILE).get("application_info");

        object = (JSONObject) object.get("valid");

        result = new Object[1][object.size()];

        result[0] = new Object[]{object};

        return result;
    }
}
