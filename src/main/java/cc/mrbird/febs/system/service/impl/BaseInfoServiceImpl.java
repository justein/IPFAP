package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.constant.UrlConstant;
import cc.mrbird.febs.common.utils.EnumParser;
import cc.mrbird.febs.common.utils.HttpClientUtils;
import cc.mrbird.febs.common.utils.JsonUtils;
import cc.mrbird.febs.system.entity.BaseInfo;
import cc.mrbird.febs.system.entity.Data;
import cc.mrbird.febs.system.entity.JsonRootBean;
import cc.mrbird.febs.system.service.IBaseInfoService;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

/***
 * @ClassName: BaseInfoServiceImpl
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/12 下午6:22
 * @version : V1.0
 */
public class BaseInfoServiceImpl implements IBaseInfoService {
    private String url = UrlConstant.BASE_INFO_URL;
    private Map<String, String> headers;

    public BaseInfoServiceImpl(Map<String, String> _headers) {
        this.headers = _headers;
    }

    @Override
    public BaseInfo getBaseInfoResult(Long companyId) {

        try {
            if (companyId == null) {
                return null;
            }
            CloseableHttpResponse response = HttpClientUtils.doGet(url+ URLEncoder.encode(companyId.toString()), this.headers, null);

            String s = EntityUtils.toString(response.getEntity());

            JsonRootBean jsonRootBean = JsonUtils.convertValue(s, JsonRootBean.class);
            Data data = jsonRootBean.getData();
            BaseInfo baseInfo = getBaseInfo(data);

            return baseInfo;
        }catch (Exception e){

        }
        return null;
    }

    private BaseInfo getBaseInfo(Data data) {
        if (data == null) {
            return null;
        }
        BaseInfo baseInfo = new BaseInfo();
        baseInfo.setType(EnumParser.parseType(data.getType()));
        baseInfo.setId(data.getId()+"");
        baseInfo.setIsMicroEnt(EnumParser.parseIsMicroEnt(data.getIsMicroEnt()));
        baseInfo.setRegNumber(data.getRegNumber());

        baseInfo.setName(data.getName());

        baseInfo.setRegLocation(data.getRegLocation());
        baseInfo.setTaxNumber(data.getTaxNumber());
        baseInfo.setAlias(data.getAlias());
        baseInfo.setOrgNumber(data.getOrgNumber());
        baseInfo.setRegStatus(data.getRegStatus());
        baseInfo.setLegalPersonName(data.getLegalPersonName());
        baseInfo.setCompanyOrgType(data.getCompanyOrgType());
        baseInfo.setCreditCode(data.getCreditCode());

        return baseInfo;
    }
}
