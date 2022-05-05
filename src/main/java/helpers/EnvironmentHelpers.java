package main.java.helpers;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class EnvironmentHelpers {
    public static String ENV = ((System.getProperty("ENV") == null || System.getProperty("ENV").isEmpty()) ? "https://api.staging.biddano.com" : System.getProperty("ENV"));
    public static String ACCESS_TOKEN = System.getProperty("ACCESS_TOKEN");

    @BeforeSuite(groups = {"sanity", "regression"})
    public void setUpBasePaths() {
        System.out.println("Setting up base paths as :" + ENV);
        RestAssured.baseURI = ENV;
        ACCESS_TOKEN = "jwt eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2FhMjIxMWItN2I0Ni00Yjg1LTg3ODAtOTIyZmI1MTgxMDMzIiwiZXhwIjoxNjQ5MjIzODM2LCJ1c2VyX3R5cGUiOiJpbnRlcm5hbCIsInJvbGVzIjpbImFkbWluIiwiYnVzaW5lc3NfdW5pdF9tYW5hZ2VyIl19.Ar8NaAnFso5pV1O_RVE2L2lABZVI7vosHK3n7hFDLMY";
    }

}
