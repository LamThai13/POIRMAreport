/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMAreport;

/**
 *
 * @author Kevin
 */
public class keywordGroup {
    String groupName;
    String category;

    public keywordGroup(String groupName, String category) {
        this.groupName = groupName;
        this.category = category;
    }

    public keywordGroup() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    
}
