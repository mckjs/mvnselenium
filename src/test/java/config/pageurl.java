package config;

public class pageurl extends env {
    public String setSeleniumEasy(){
        String url = "https://"+ env() + "/test/";
       return url;
    }
}
