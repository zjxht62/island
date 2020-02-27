package com.zjx.island.biz.moviequery;

/**
 * Demo class
 *
 * @author trevor.zhao
 * @date 2020/2/27
 */
public enum Cinema {
    WANGFUJING_APM("百老汇影城(apm购物中心店)", "267"),
    XIDAN("首都电影院(西单店)", "149"),
    HENGDIAN("横店电影城(王府井店)", "79"),
    WUKESONG("耀莱成龙国际影城(五棵松店)", "87"),
    SHIJINGSHANWANDA("万达影城(石景山店)", "133"),
    DONGFANGGUANGCHANG("百老汇影城(东方广场店)", "269"),
    WANGFUJING_YAOLAI("耀莱成龙国际影城(王府井店)", "10781"),
    XINHUADAZHONGSI("新华国际影城(大钟寺店)", "1589"),
    SANLITUN("美嘉欢乐影城(三里屯店)", "136"),
    DIZHILITANG("地质礼堂", "261"),
    LUMIAI("卢米埃影城(住总万科店)", "15773");


    Cinema(String cinemaName, String cinemaId) {
        this.cinemaName = cinemaName;
        this.cinemaId = cinemaId;
    }

    /**
     * 影院名称
     */
    private String cinemaName;
    /**
     * 影院id
     */
    private String cinemaId;

    public String getCinemaName() {
        return cinemaName;
    }

    public String getCinemaId() {
        return cinemaId;
    }
}
