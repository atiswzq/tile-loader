package com.kuaiyue.loader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kuaiyue.loader.bean.LngLat;
import com.kuaiyue.loader.bean.Tile;
import com.kuaiyue.loader.commons.toolkit.CoordinateToolkit;
import com.kuaiyue.loader.controller.vo.DownloadParamVO;

/**
 * 谷歌地图下载器
 * 
 * @author lhq
 *
 */
@Service("gmapService")
public class GmapService implements IMapService {
    @Value("${config.baseUrl.gmap}")
    private String baseUrl;

	/**
     * 计算下载的瓦片数量
     * 
     */
	@Override
    public long calculateCount(DownloadParamVO downloadParamVO) {
        return MapServiceToolkit.calcTileCount(downloadParamVO, (LngLat lngLat, int zoom, Tile tile) -> CoordinateToolkit.gcj02_LngLat_To_Tile(lngLat, zoom, tile));
	}
	
	/**
     * 开始下载瓦片
     * 
     */
    @Override
    public void startDownload(DownloadParamVO downloadParamVO) {
        MapServiceToolkit.addDownTask(downloadParamVO, baseUrl, this, (LngLat lngLat, int zoom, Tile tile) -> CoordinateToolkit.gcj02_LngLat_To_Tile(lngLat, zoom, tile));
    }
	
}
