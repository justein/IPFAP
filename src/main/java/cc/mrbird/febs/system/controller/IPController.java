package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.ImgResult;
import cc.mrbird.febs.common.utils.QiniuFileUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
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

}
