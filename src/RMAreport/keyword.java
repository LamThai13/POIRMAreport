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
public class keyword extends keywordGroup{
    String keyword;

    public keyword(String keyword) {
        this.keyword = keyword;
    }

    public keyword() {
    }
    

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    
}
