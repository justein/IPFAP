package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.constant.UrlConstant;
import cc.mrbird.febs.common.utils.*;
import cc.mrbird.febs.system.entity.CompanyList;
import cc.mrbird.febs.system.entity.Data;
import cc.mrbird.febs.system.entity.JsonRootBean;
import cc.mrbird.febs.system.entity.Search;
import cc.mrbird.febs.system.service.ICompanySearchService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: chenyanfeng
 * @Date: 2018-11-23
 * @Time: 下午6:34
 */
@Service
public class SearchServiceImpl implements ICompanySearchService {

    private String url = UrlConstant.SEARCH_RUL;
    private Map<String, String> headers = HeaderUtils.getHeaders(UrlConstant.AUTHORIZATION);

    private  final String DEFAULT_PAGE_NUM = "1";
    private  final String DEFAULT_PAGE_SIZE = "10";
    private  final String DEFAULT_SORT_TYPE = "0";

    @Override
    public List<Search> getSearchResult(String companyName, String pageNum, String pageSize, String sortType) {
        try {
            if (StringUtils.isBlank(companyName)) {
                return null;
            }

            // 获取请求参数
            Map<String, String> paramsMap = getParamsMap(pageNum, pageSize, sortType);

            CloseableHttpResponse response = HttpClientUtils.doGet(url+ URLEncoder.encode(companyName), this.headers, paramsMap);

            String s = EntityUtils.toString(response.getEntity());

            JsonRootBean jsonRootBean = JsonUtils.convertValue(s, JsonRootBean.class);

            Data data = jsonRootBean.getData();

            List<CompanyList> companyList = Optional.ofNullable(data.getCompanyList()).orElse(new ArrayList<>());

            List<Search> searches = new ArrayList<>();
            for (CompanyList company : companyList) {
                /**只查询在业状态的公司*/
                if (!"在业".equals(company.getRegStatus())) continue;
                Search search = new Search();
                search.setId(company.getId());
                search.setRegCapital(company.getRegCapital());
                search.setName(EmUtils.removeEmTag(company.getName()));
                search.setBase(company.getBase());
                search.setCompanyType(EnumParser.parseCompanyType(company.getCompanyType()));
                search.setEstiblishTime(company.getEstiblishTime());
                search.setLegalPersonName(company.getLegalPersonName());
                search.setType(company.getType());
                searches.add(search);
            }
            return searches;

        }catch (Exception e){
        }
        return null;
    }

    @Override
    public List<Search> getSearchResult(String companyName, String pageNum, String pageSize) {
        return getSearchResult(companyName, pageNum, pageSize, null);
    }

    @Override
    public List<Search> getSearchResult(String companyName) {
        return getSearchResult(companyName, null, null, null);
    }


    private Map<String, String> getParamsMap(String pageNum, String pageSize, String sortType) {
        // 设置默认参数
        Map<String, String> map = new HashMap<>();

        // 页码
        if ( StringUtils.isBlank(pageNum) ) {
            map.put("pageNum", this.DEFAULT_PAGE_NUM);
        }else {
            map.put("pageNum", pageNum);
        }

        // 页面大小
        if ( StringUtils.isBlank(pageSize) ) {
            map.put("pageSize", this.DEFAULT_PAGE_SIZE);
        }else {
            map.put("pageSize", this.DEFAULT_PAGE_SIZE);
        }

        // 排序
        if ( StringUtils.isBlank(sortType) ) {
            map.put("sortType", this.DEFAULT_SORT_TYPE);
        }else {
            map.put("sortType", sortType);
        }
        return map;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
//        JsonRootBean jsonRootBean = JsonUtils.convertValue(tmp, JsonRootBean.class);
//        Data data = jsonRootBean.getData();
//        List<CompanyList> companyList = data.getCompanyList();
//        List<Search> searches = new ArrayList<>();
//        for (CompanyList company : companyList) {
//            Search search = new Search();
//            search.setId(company.getId());
//            search.setRegCapital(company.getRegCapital());
//            search.setName(company.getName());
//            search.setBase(company.getBase());
//            search.setCompanyType(CompanyTypeParser.parse(company.getCompanyType()));
//            search.setEstiblishTime(company.getEstiblishTime());
//            search.setLegalPersonName(company.getLegalPersonName());
//            search.setType(company.getType());
//            System.out.println(JsonUtils.toJSONString(search));
//            searches.add(search);
//        }
//        System.out.println();
    }
}
