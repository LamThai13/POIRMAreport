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
public class RMA_report {
    private String Serial;
    private String RMA;
    private String inWarranty;
    private String Status;
    private String Model;
    private String customerProblem;
    private String customerFoundissue;
    private String receivedDate;
    private String shippingDate;
    private String Company;
    private String customer;   
    private String supplyer;
    private String returnDate;
    private String repairNote;
    private String rootCause;
    private String routeType;
    private String Symptom;
    private String problem;
    private String Distribution;
    private String category;
    private String repairDate;
    private String partSN;
    private String TAT;
    private String repairer;
    private String cusRMANo;
    private String BU;
    private String More;
    private String requestDate;

    public RMA_report(String Serial, String RMA, String inWarranty, String customerProblem, String customerFoundissue, String receivedDate, String returnDate, String repairNote, String rootCause) {
        this.Serial = Serial;
        this.RMA = RMA;
        this.inWarranty = inWarranty;
        this.customerProblem = customerProblem;
        this.customerFoundissue = customerFoundissue;
        this.receivedDate = receivedDate;
        this.returnDate = returnDate;
        this.repairNote = repairNote;
        this.rootCause = rootCause;
    }

    public RMA_report(String Serial, String RMA, String inWarranty, String Status, String Model, String customerProblem, String customerFoundissue, String receivedDate, String shippingDate, String Company, String customer, String supplyer, String returnDate, String repairNote, String rootCause, String routeType, String Symptom, String problem, String Distribution, String category, String repairDate, String partSN, String TAT, String repairer, String cusRMANo, String BU, String More, String requestDate) {
        this.Serial = Serial;
        this.RMA = RMA;
        this.inWarranty = inWarranty;
        this.Status = Status;
        this.Model = Model;
        this.customerProblem = customerProblem;
        this.customerFoundissue = customerFoundissue;
        this.receivedDate = receivedDate;
        this.shippingDate = shippingDate;
        this.Company = Company;
        this.customer = customer;
        this.supplyer = supplyer;
        this.returnDate = returnDate;
        this.repairNote = repairNote;
        this.rootCause = rootCause;
        this.routeType = routeType;
        this.Symptom = Symptom;
        this.problem = problem;
        this.Distribution = Distribution;
        this.category = category;
        this.repairDate = repairDate;
        this.partSN = partSN;
        this.TAT = TAT;
        this.repairer = repairer;
        this.cusRMANo = cusRMANo;
        this.BU = BU;
        this.More = More;
        this.requestDate = requestDate;
    }

    public RMA_report() {
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String Serial) {
        this.Serial = Serial;
    }

    public String getRMA() {
        return RMA;
    }

    public void setRMA(String RMA) {
        this.RMA = RMA;
    }

    public String getInWarranty() {
        return inWarranty;
    }

    public void setInWarranty(String inWarranty) {
        this.inWarranty = inWarranty;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSupplyer() {
        return supplyer;
    }

    public void setSupplyer(String supplyer) {
        this.supplyer = supplyer;
    }

    public String getSymptom() {
        return Symptom;
    }

    public void setSymptom(String Symptom) {
        this.Symptom = Symptom;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getDistribution() {
        return Distribution;
    }

    public void setDistribution(String Distribution) {
        this.Distribution = Distribution;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public String getPartSN() {
        return partSN;
    }

    public void setPartSN(String partSN) {
        this.partSN = partSN;
    }

    public String getTAT() {
        return TAT;
    }

    public void setTAT(String TAT) {
        this.TAT = TAT;
    }

    public String getRepairer() {
        return repairer;
    }

    public void setRepairer(String repairer) {
        this.repairer = repairer;
    }

    public String getCusRMANo() {
        return cusRMANo;
    }

    public void setCusRMANo(String cusRMANo) {
        this.cusRMANo = cusRMANo;
    }

    public String getBU() {
        return BU;
    }

    public void setBU(String BU) {
        this.BU = BU;
    }

    public String getMore() {
        return More;
    }

    public void setMore(String More) {
        this.More = More;
    }

    public String getCustomerProblem() {
        return customerProblem;
    }

    public void setCustomerProblem(String customerProblem) {
        this.customerProblem = customerProblem;
    }

    public String getCustomerFoundissue() {
        return customerFoundissue;
    }

    public void setCustomerFoundissue(String customerFoundissue) {
        this.customerFoundissue = customerFoundissue;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getRepairNote() {
        return repairNote;
    }

    public void setRepairNote(String repairNote) {
        this.repairNote = repairNote;
    }

    public String getRootCause() {
        return rootCause;
    }

    public void setRootCause(String rootCause) {
        this.rootCause = rootCause;
    }

    public String getRouteType() {
        return routeType;
    }

    public void setRouteType(String routeType) {
        this.routeType = routeType;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
    
    
    
    
}
