package com.oa.file.mapper;

import com.oa.file.domain.SysFile;

import java.util.List;

/**
 * 系统文件Mapper接口
 *
 * @author DragonWen
 * @date 2022-03-19
 */
public interface SysFileMapper
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
     * 删除系统文件
     *
     * @param id 系统文件主键
     * @return 结果
     */
    public int deleteSysFileById(Long id);

    /**
     * 批量删除系统文件
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysFileByIds(Long[] ids);
}
