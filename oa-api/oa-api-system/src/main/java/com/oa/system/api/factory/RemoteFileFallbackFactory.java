package com.oa.system.api.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.oa.common.core.domain.R;
import com.oa.system.api.RemoteFileService;
import com.oa.system.api.domain.SysFileVo;

/**
 * 文件服务降级处理
 * 
 * @author ruoyi
 */
@Component
public class RemoteFileFallbackFactory implements FallbackFactory<RemoteFileService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteFileFallbackFactory.class);

    @Override
    public RemoteFileService create(Throwable throwable)
    {
        log.error("文件服务调用失败:{}", throwable.getMessage());
        return new RemoteFileService()
        {
            @Override
            public R<SysFileVo> upload(MultipartFile file, String fileGroup) {
                return R.fail("上传文件失败:" + throwable.getMessage());
            }

            @Override
            public R<SysFileVo> getInfo(Long id) {
                return R.fail("获取文件信息失败:" + throwable.getMessage());
            }

            @Override
            public R<Boolean> updateFileIsEnable(Long id, String isEnable) {
                return R.fail("修改文件状态失败:" + throwable.getMessage());
            }

        };
    }
}
