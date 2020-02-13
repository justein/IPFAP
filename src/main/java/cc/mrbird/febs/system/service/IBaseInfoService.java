package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.BaseInfo;

public interface IBaseInfoService {


    /**
     * 获取查询结果
     * @param companyId
     * @return
     */
    BaseInfo getBaseInfoResult(Long companyId);
}
