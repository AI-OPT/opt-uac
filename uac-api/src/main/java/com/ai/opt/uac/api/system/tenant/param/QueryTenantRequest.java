package com.ai.opt.uac.api.system.tenant.param;

import com.ai.opt.base.vo.BaseInfo;
import com.ai.opt.base.vo.PageInfo;

public class QueryTenantRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 状态
     */
    private String state;

    /**
     * 分页信息
     */
    private PageInfo<QueryTenantResponse> pageInfo;

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public PageInfo<QueryTenantResponse> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo<QueryTenantResponse> pageInfo) {
        this.pageInfo = pageInfo;
    }

}
