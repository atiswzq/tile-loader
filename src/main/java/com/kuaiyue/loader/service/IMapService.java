package com.kuaiyue.loader.service;

import com.kuaiyue.loader.controller.vo.DownloadParamVO;

public interface IMapService {

    /**
     * 计算下载的瓦片数量
     * 
     * @param downloadParamVO
     * @return
     */
    long calculateCount(DownloadParamVO downloadParamVO);
	
    /**
     * 开始下载瓦片
     * 
     * @param downloadParamVO
     */
    void startDownload(DownloadParamVO downloadParamVO);
	
}
