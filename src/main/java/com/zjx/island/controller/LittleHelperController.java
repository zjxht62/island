package com.zjx.island.controller;

import com.zjx.island.common.api.CommonResult;
import com.zjx.island.utils.EmojiUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日常小助手Controller
 *
 * @author trevor.zhao
 * @date 2019/10/12
 */
@Api(tags = "LittleHelperController", description = "日常小助手")
@Controller
@RequestMapping("/helper")
public class LittleHelperController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LittleHelperController.class);

    @ApiOperation("获取早安string")
    @RequestMapping(value = "/morning", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getGoodMorning() {
        return CommonResult.success(EmojiUtil.getRandomEmoji());
    }

}
