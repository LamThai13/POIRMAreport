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
public class keywordGroup extends keyword{
    String group;
    String groupMem;

    public keywordGroup(String group, String groupMem, String Customerfoundissue, String Rootcause) {
        super(Customerfoundissue, Rootcause);
        this.group = group;
        this.groupMem = groupMem;
    }

    public keywordGroup(String group, String groupMem) {
        this.group = group;
        this.groupMem = groupMem;
    }

    public keywordGroup() {
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroupMem() {
        return groupMem;
    }

    public void setGroupMem(String groupMem) {
        this.groupMem = groupMem;
    }
    
    
}
