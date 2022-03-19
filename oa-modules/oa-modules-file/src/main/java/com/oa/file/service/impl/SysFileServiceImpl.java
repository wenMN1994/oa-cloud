package com.oa.file.service.impl;

import com.oa.file.domain.SysFile;
import com.oa.file.mapper.SysFileMapper;
import com.oa.file.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统文件Service业务层处理
 *
 * @author DragonWen
 * @date 2022-03-19
 */
@Service
public class SysFileServiceImpl implements ISysFileService
{
    @Autowired
    private SysFileMapper sysFileMapper;

    /**
     * 查询系统文件
     *
     * @param id 系统文件主键
     * @return 系统文件
     */
    @Override
    public SysFile selectSysFileById(Long id)
    {
        return sysFileMapper.selectSysFileById(id);
    }

    /**
     * 查询系统文件列表
     *
     * @param sysFile 系统文件
     * @return 系统文件
     */
    @Override
    public List<SysFile> selectSysFileList(SysFile sysFile)
    {
        return sysFileMapper.selectSysFileList(sysFile);
    }

    /**
     * 新增系统文件
     *
     * @param sysFile 系统文件
     * @return 结果
     */
    @Override
    public int insertSysFile(SysFile sysFile)
    {
        return sysFileMapper.insertSysFile(sysFile);
    }

    /**
     * 修改系统文件
     *
     * @param sysFile 系统文件
     * @return 结果
     */
    @Override
    public int updateSysFile(SysFile sysFile)
    {
        return sysFileMapper.updateSysFile(sysFile);
    }

    /**
     * 批量删除系统文件
     *
     * @param ids 需要删除的系统文件主键
     * @return 结果
     */
    @Override
    public int deleteSysFileByIds(Long[] ids)
    {
        return sysFileMapper.deleteSysFileByIds(ids);
    }

    /**
     * 删除系统文件信息
     *
     * @param id 系统文件主键
     * @return 结果
     */
    @Override
    public int deleteSysFileById(Long id)
    {
        return sysFileMapper.deleteSysFileById(id);
    }
}
