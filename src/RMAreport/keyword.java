/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMAreport;

/**
 *
 * @author Thai
 */
public class keyword {
    private String Customerfoundissue;
    private String Rootcause;

    public keyword(String Customerfoundissue, String Rootcause) {
        this.Customerfoundissue = Customerfoundissue;
        this.Rootcause = Rootcause;
    }

    keyword() {
        
    }

    public String getCustomerfoundissue() {
        return Customerfoundissue;
    }

    public void setCustomerfoundissue(String Customerfoundissue) {
        this.Customerfoundissue = Customerfoundissue;
    }

    public String getRootcause() {
        return Rootcause;
    }

    public void setRootcause(String Rootcause) {
        this.Rootcause = Rootcause;
    }
    
    
    
    
}
