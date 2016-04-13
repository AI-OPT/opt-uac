package com.ai.opt.uac.api.system.systenant.param;

import com.ai.opt.base.vo.BaseResponse;
import com.ai.opt.base.vo.PageInfo;

public class QueryPageTenantResponse extends BaseResponse{

	private static final long serialVersionUID = 1L;

	private PageInfo<QueryPageTenantData> pageInfo;

	public PageInfo<QueryPageTenantData> getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(PageInfo<QueryPageTenantData> pageInfo) {
		this.pageInfo = pageInfo;
	}
}
