package com.zjx.island.controller.helper;

import com.zjx.island.biz.helper.BusHelper;
import com.zjx.island.biz.helper.BusQueryModel;
import com.zjx.island.common.api.CommonResult;
import com.zjx.island.utils.EmojiUtil;
import com.zjx.island.utils.HttpUWUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 日常小助手Controller
 *
 * @author trevor.zhao
 * @date 2019/10/12
 */
@Api(tags = "LittleHelperController", description = "日常小助手")
@RestController
@RequestMapping("/helper")
public class LittleHelperController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LittleHelperController.class);

    @Autowired
    BusHelper busHelper;

    @ApiOperation("获取早安string")
    @RequestMapping(value = "/morning", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getGoodMorning() {
        return CommonResult.success(EmojiUtil.getRandomEmoji());
    }

    @ApiOperation("根据线路名获取运行方向")
    @RequestMapping(value = "getLineDirOptionByLine/{line}", method = RequestMethod.GET)
    @ResponseBody
    public String getLineDirOptionByLine(@PathVariable("line") String line) {
        return busHelper.getLineDirOptionToMobileByLine(line);
    }

    @ApiOperation("根据运行方向获取车站")
    @RequestMapping(value = "getLineDirOptionByDir", method = RequestMethod.POST)
    @ResponseBody
    public String getStationOptionByDir(@RequestBody BusQueryModel busQueryModel) {
        return busHelper.getStationOptionToMobileByLine(busQueryModel.getLine(), busQueryModel.getDirName());
    }

    @ApiOperation("根据上车车站获取距离")
    @RequestMapping(value = "getDistanceByStation", method = RequestMethod.POST)
    @ResponseBody
    public String getDistanceByStation(@RequestBody BusQueryModel busQueryModel) {
        return busHelper.getDistanceByStation(busQueryModel.getLine(), busQueryModel.getDirName(), busQueryModel.getStationName());
    }



}
