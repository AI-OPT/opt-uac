package com.ai.opt.uac.api.account.interfaces;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ai.opt.base.exception.BusinessException;
import com.ai.opt.base.exception.SystemException;
import com.ai.opt.uac.api.account.param.IndustryQueryResponse;

@Path("/industrymanage")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
public interface IIndustryManageSV {

	/**
     * 查询所有行业类型
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL industrymanage/queryIndustryList
     */
    @GET
    @Path("/queryIndustryList")
    List<IndustryQueryResponse> queryIndustryList() throws BusinessException,SystemException;
    /**
     * 根据行业编码查询单个行业类型
     * @param industryCode
     * @return
     * @throws BusinessException
     * @throws SystemException
     * @author zhanglh
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL industrymanage/queryByIndustryCode
     */
    @GET
    @Path("/queryByIndustryCode")
    IndustryQueryResponse queryByIndustryCode(String industryCode)throws BusinessException,SystemException;
}
