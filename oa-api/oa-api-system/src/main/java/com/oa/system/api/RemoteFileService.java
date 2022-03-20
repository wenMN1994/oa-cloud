package com.oa.system.api;

import com.oa.common.core.constant.FileConstants;
import com.oa.system.api.domain.SysFileVo;
import com.oa.system.api.factory.RemoteFileFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
     * @param fileGroup 自定义请求头（文件分组标识）
     * @return 结果
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R<SysFileVo> upload(@RequestPart(value = "file") MultipartFile file, @RequestHeader(FileConstants.FILE_GROUP) String fileGroup);

    /**
     * 获取系统文件详细信息
     *
     * @param id 文件ID
     * @return 结果
     */
    @PostMapping(value = "/getFileInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public R<SysFileVo> getInfo(@RequestParam(value = "id", required = true) Long id);

    /**
     * 更新系统文件状态isEnable
     * @param id 文件ID
     * @param isEnable 状态（0：有效，1无效）
     * @return
     */
    @PostMapping(value = "/updateFileIsEnable", consumes = MediaType.APPLICATION_JSON_VALUE)
    public R<Boolean> updateFileIsEnable(@RequestParam(value = "id", required = true) Long id,
                                         @RequestParam(value = "isEnable", required = true) String isEnable);
}
