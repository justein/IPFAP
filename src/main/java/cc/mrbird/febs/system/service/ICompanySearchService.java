package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.BaseInfo;
import cc.mrbird.febs.system.entity.Search;

import java.util.List;

public interface ICompanySearchService {


    /**
     * 获取查询结果
     * @param companyName
     * @param pageNum
     * @param pageSize
     * @param sortType
     * @return
     */
    List<Search> getSearchResult(String companyName, String pageNum, String pageSize, String sortType);


    /**
     * 获取查询结果
     * @param companyName
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Search> getSearchResult(String companyName, String pageNum, String pageSize);


    /**
     * 获取查询结果
     * @param companyName
     * @return
     */
    List<Search> getSearchResult(String companyName);


}
