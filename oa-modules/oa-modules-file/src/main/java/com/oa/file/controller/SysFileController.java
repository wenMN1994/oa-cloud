package com.oa.file.controller;

import com.oa.common.core.constant.FileConstants;
import com.oa.common.core.utils.StringUtils;
import com.oa.common.core.web.domain.AjaxResult;
import com.oa.common.security.utils.SecurityUtils;
import com.oa.file.domain.SysFile;
import com.oa.file.service.ISysFileService;
import com.oa.system.api.domain.SysFileVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.oa.common.core.domain.R;
import com.oa.common.core.utils.file.FileUtils;
import com.oa.file.service.ISysFileUploadService;

import java.util.Objects;

/**
 * 文件请求处理
 * 
 * @author DragonWen
 */
@RestController
public class SysFileController {
    private static final Logger log = LoggerFactory.getLogger(SysFileController.class);

    @Autowired
    private ISysFileUploadService sysFileUploadService;

    @Autowired
    private ISysFileService sysFileService;

    /**
     * 文件上传请求
     * @param file 文件信息
     * @param fileGroup 自定义请求头（文件分组标识）
     * @return
     */
    @PostMapping("upload")
    public R<SysFileVo> upload(@RequestPart(value = "file")MultipartFile file, @RequestHeader(FileConstants.FILE_GROUP) String fileGroup) {
        try {
            // 上传并返回访问地址
            String url = sysFileUploadService.uploadFile(file);
            // 返回前端数据实体
            SysFileVo sysFileVo = new SysFileVo();
            sysFileVo.setName(FileUtils.getName(url));
            sysFileVo.setUrl(url);

            // 文件信息保存实体
            SysFile sysFile = new SysFile();
            sysFile.setUrl(url);
            sysFile.setFileGroup(fileGroup);
            sysFile.setFileSize(file.getSize());
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件后缀
            String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            if(Objects.equals(FileConstants.FILE_GROUP_AVATAR, fileGroup)){
                fileName = fileName + "_" + SecurityUtils.getUsername();
                fileSuffix = FileConstants.FILE_GROUP_JPEG;
            }
            sysFile.setName(fileName);
            sysFile.setFileSuffix(fileSuffix);
            // 获取对象存储key
            String key = url.substring(url.lastIndexOf("_") + 1, url.lastIndexOf("."));
            sysFile.setOssKey(key);
            sysFile.setIsEnable(FileConstants.FILE_GROUP_DISABLE);
            sysFile.setCreateBy(SecurityUtils.getUsername());
            sysFileService.insertSysFile(sysFile);
            sysFileVo.setId(sysFile.getId());
            return R.ok(sysFileVo);
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return R.fail(e.getMessage());
        }
    }

    /**
     * 获取系统文件详细信息(服务间调用)
     * @param id 文件ID
     * @return
     */
    @PostMapping(value = "/getFileInfo")
    public R<SysFileVo> getInfo(@RequestParam(value = "id", required = true) Long id) {
        try {
            SysFile sysFile = sysFileService.selectSysFileById(id);
            if(StringUtils.isNotNull(sysFile)){
                SysFileVo sysFileVo = new SysFileVo();
                sysFileVo.setId(sysFile.getId());
                sysFileVo.setName(sysFile.getName());
                sysFileVo.setUrl(sysFile.getUrl());
                return R.ok(sysFileVo);
            }else {
                return R.fail("文件不存在：ID="+id);
            }
        }catch (Exception e) {
            log.error("获取文件ID={}，失败", id, e);
            return R.fail(e.getMessage());
        }
    }

    /**
     * 更新系统文件状态isEnable
     * @param id 文件ID
     * @param isEnable 状态（0：有效，1无效）
     * @return
     */
    @PostMapping(value = "/updateFileIsEnable")
    public R<Boolean> updateFileIsEnable(@RequestParam(value = "id", required = true) Long id,
                                         @RequestParam(value = "isEnable", required = true) String isEnable) {
        try {
            SysFile sysFile = new SysFile();
            sysFile.setId(id);
            sysFile.setIsEnable(isEnable);
            sysFile.setUpdateBy(SecurityUtils.getUsername());
            sysFileService.updateSysFile(sysFile);
            return R.ok(true);
        }catch (Exception e) {
            log.error("更新系统文件状态失败ID={}", id, e);
            return R.fail(e.getMessage());
        }
    }
}