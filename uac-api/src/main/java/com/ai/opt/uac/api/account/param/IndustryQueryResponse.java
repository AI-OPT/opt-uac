package com.ai.opt.uac.api.account.param;

public class IndustryQueryResponse {
    /**
     * 行业类型编码
     */
    private String IndustryCode;

    /**
     * 行业类型名称
     */
    private String IndustryName;

    /**
     * 行业描述
     */
    private String IndustryDesc;

    public String getIndustryCode() {
        return IndustryCode;
    }

    public void setIndustryCode(String industryCode) {
        IndustryCode = industryCode;
    }

    public String getIndustryName() {
        return IndustryName;
    }

    public void setIndustryName(String industryName) {
        IndustryName = industryName;
    }

    public String getIndustryDesc() {
        return IndustryDesc;
    }

    public void setIndustryDesc(String industryDesc) {
        IndustryDesc = industryDesc;
    }

}
