package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.BaseResult;
import cc.mrbird.febs.common.entity.ImgResult;
import cc.mrbird.febs.common.utils.JsonUtils;
import cc.mrbird.febs.common.utils.QiniuFileUtil;
import cc.mrbird.febs.system.entity.BaseInfo;
import cc.mrbird.febs.system.entity.CompanyList;
import cc.mrbird.febs.system.entity.Search;
import cc.mrbird.febs.system.service.IBaseInfoService;
import cc.mrbird.febs.system.service.ICompanySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/***
 * @ClassName: IPController
 * @Description: TODO
 * @Author: Lyn
 * @Date: 2020/2/12 下午3:42
 * @version : V1.0
 */
@RequestMapping("ip")
@RestController
public class IPController extends BaseController {

    @Autowired
    private ICompanySearchService searchService;
    @Autowired
    private IBaseInfoService baseInfoService;
    @RequestMapping("/upload")
    @ResponseBody
    public ImgResult upload(MultipartFile file, HttpServletRequest request) {

        String desFilePath = "";
        String oriName = "";
        ImgResult imgResult = new ImgResult();
        Map<String, String> dataMap;
        try {
            String filePath = QiniuFileUtil.upload(file);
            System.out.println(desFilePath);
            // 6.返回保存结果信息"?
            dataMap = new HashMap<>();
            dataMap.put("src", filePath);
            imgResult.setData(dataMap);
            imgResult.setMsg(oriName + "上传成功！");

        } catch (Exception e) {
            imgResult.setCode(1);
            System.out.println(desFilePath + "图片保存失败");

        }
        return imgResult;
    }

    @PostMapping("/companyInfo")
    @ResponseBody
    public String getCompanyInfo(@RequestParam("companyName") String companyName) {
        // 默认搜索10个
        List<Search> searchResult = searchService.getSearchResult(companyName);
        // 需要根据regLocation字段来确定返回第几个
        Search search = searchResult.get(0);
        BaseInfo baseInfoResult = baseInfoService.getBaseInfoResult(search.getId());
        BaseResult baseResult = new BaseResult();
        if (baseInfoResult!=null && !"".equals(baseInfoResult.getRegLocation())) {
            baseResult.setCode(200);
            baseResult.setMsg("查询成功");
            baseResult.setObject(baseInfoResult);
        }else{
            baseResult.setCode(400);
            baseResult.setMsg("查询失败");
            baseResult.setObject(new BaseInfo());
        }
        return JsonUtils.toJSONString(baseResult);
    }

    @RequestMapping("/saveInventionIPFunds")
    @ResponseBody
    public String saveInventionIPFunds(@RequestParam("ipfundsContent") String ipfundsContent) {
        System.out.println(ipfundsContent);
        return null;
    }

}
