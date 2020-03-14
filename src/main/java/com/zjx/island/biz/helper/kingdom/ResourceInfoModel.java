package com.zjx.island.biz.helper.kingdom;

/**
 * 资源Model
 *
 * @author trevor.zhao
 * @date 2020/3/14
 */
public class ResourceInfoModel {
    /**
     * 是否可下载
     */
    private Boolean isDownloadable;
    /**
     * 名称
     */
    private String name;
    /**
     * 云盘地址
     */
    private String yunpanUrl;
    /**
     * 提取码
     */
    private String extractionCode;

    public ResourceInfoModel(Boolean isDownloadable, String name, String yunpanUrl, String extractionCode) {
        this.isDownloadable = isDownloadable;
        this.name = name;
        this.yunpanUrl = yunpanUrl;
        this.extractionCode = extractionCode;
    }

    public Boolean getDownloadable() {
        return isDownloadable;
    }

    public void setDownloadable(Boolean downloadable) {
        isDownloadable = downloadable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYunpanUrl() {
        return yunpanUrl;
    }

    public void setYunpanUrl(String yunpanUrl) {
        this.yunpanUrl = yunpanUrl;
    }

    public String getExtractionCode() {
        return extractionCode;
    }

    public void setExtractionCode(String extractionCode) {
        this.extractionCode = extractionCode;
    }

    @Override
    public String toString() {
        return "ResourceInfoModel{" +
            "isDownloadable=" + isDownloadable +
            ", name='" + name + '\'' +
            ", yunpanUrl='" + yunpanUrl + '\'' +
            ", extractionCode='" + extractionCode + '\'' +
            '}';
    }
}
