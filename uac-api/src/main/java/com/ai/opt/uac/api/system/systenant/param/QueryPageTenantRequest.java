package com.ai.opt.uac.api.system.systenant.param;

import com.ai.opt.base.vo.BaseInfo;

public class QueryPageTenantRequest extends BaseInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 状态
     */
    private String state;
    
    private Integer pageNo;
    
    private Integer pageSize;

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

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
