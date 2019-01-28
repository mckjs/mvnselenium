package config;

public class pageurl extends env {
    public String setSeleniumEasy(){
        String url = "https://"+ env() + "/test/";
       return url;
    }

    public String setIlab(){
        String url = "https://www.ilabquality.com/";
        return url;
    }


    public String setPageUrl(String siteName){
        String site = siteName.toLowerCase();
        System.out.print(">>>> " + site);
        if(site == "seleniumeasy"){
            site = this.setSeleniumEasy();
        }else if(site == "ilab"){
            site = this.setIlab();
        }else{
            return null;
        }
        return site;
    }
}
