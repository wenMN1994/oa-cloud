package com.oa.file.service;

import com.oa.file.domain.SysFile;

import java.util.List;

/**
 * 系统文件Service接口
 *
 * @author DragonWen
 * @date 2022-03-19
 */
public interface ISysFileService
{
    /**
     * 查询系统文件
     *
     * @param id 系统文件主键
     * @return 系统文件
     */
    public SysFile selectSysFileById(Long id);

    /**
     * 查询系统文件列表
     *
     * @param sysFile 系统文件
     * @return 系统文件集合
     */
    public List<SysFile> selectSysFileList(SysFile sysFile);

    /**
     * 新增系统文件
     *
     * @param sysFile 系统文件
     * @return 结果
     */
    public int insertSysFile(SysFile sysFile);

    /**
     * 修改系统文件
     *
     * @param sysFile 系统文件
     * @return 结果
     */
    public int updateSysFile(SysFile sysFile);

    /**
     * 批量删除系统文件
     *
     * @param ids 需要删除的系统文件主键集合
     * @return 结果
     */
    public int deleteSysFileByIds(Long[] ids);

    /**
     * 删除系统文件信息
     *
     * @param id 系统文件主键
     * @return 结果
     */
    public int deleteSysFileById(Long id);
}
