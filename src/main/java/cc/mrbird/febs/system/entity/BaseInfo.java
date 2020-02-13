package cc.mrbird.febs.system.entity;

/***
 * @ClassName: BaseInfo
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/12 下午6:17
 * @version : V1.0
 */
public class BaseInfo {


    private String id;//企业id

    private String name;  //企业名

    private String type; // 法人类型，1 人 2 公司

    private String isMicroEnt; // 是否是小微企业 0不是 1是

    private String regNumber;//注册号

    private String regLocation;//注册地址

    private String taxNumber;//纳税人识别号

    private String alias;//简称

    private String orgNumber;//组织机构代码

    private String regStatus;//企业状态

    private String legalPersonName;//法人

    private String companyOrgType;//企业类型

    private String creditCode;//统一社会信用代码

    private String historyNames;//曾用名

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsMicroEnt() {
        return isMicroEnt;
    }

    public void setIsMicroEnt(String isMicroEnt) {
        this.isMicroEnt = isMicroEnt;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRegLocation() {
        return regLocation;
    }

    public void setRegLocation(String regLocation) {
        this.regLocation = regLocation;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getOrgNumber() {
        return orgNumber;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgNumber = orgNumber;
    }

    public String getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }

    public String getLegalPersonName() {
        return legalPersonName;
    }

    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    public String getCompanyOrgType() {
        return companyOrgType;
    }

    public void setCompanyOrgType(String companyOrgType) {
        this.companyOrgType = companyOrgType;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getHistoryNames() {
        return historyNames;
    }

    public void setHistoryNames(String historyNames) {
        this.historyNames = historyNames;
    }
}
