package com.oa.system.api;

import com.oa.common.core.web.domain.AjaxResult;
import com.oa.system.api.domain.SysFileVo;
import com.oa.system.api.factory.RemoteFileFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.oa.common.core.constant.ServiceNameConstants;
import com.oa.common.core.domain.R;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "remoteFileService", value = ServiceNameConstants.FILE_SERVICE, fallbackFactory = RemoteFileFallbackFactory.class)
public interface RemoteFileService
{
    /**
     * 上传文件
     *
     * @param file 文件信息
     * @return 结果
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R<SysFileVo> upload(@RequestPart(value = "file") MultipartFile file);

    /**
     * 获取系统文件详细信息
     *
     * @param id 文件ID
     * @return 结果
     */
    @PostMapping(value = "/getFileInfo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R<SysFileVo> getInfo(@RequestPart("id") Long id);
}
