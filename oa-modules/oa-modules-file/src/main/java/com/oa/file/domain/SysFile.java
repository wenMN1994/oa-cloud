package com.oa.file.domain;

import com.oa.common.core.annotation.Excel;
import com.oa.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 系统文件对象 sys_file
 *
 * @author DragonWen
 * @date 2022-03-19
 */
public class SysFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件ID */
    private Long id;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String url;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String name;

    /** 文件后缀 */
    @Excel(name = "文件后缀")
    private String fileSuffix;

    /** 文件分组 */
    @Excel(name = "文件分组")
    private String fileGroup;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long fileSize;

    /** 对象存储key */
    @Excel(name = "对象存储key")
    private String ossKey;

    /** 是否有效（0：有效，1无效） */
    @Excel(name = "是否有效", readConverterExp = "0=：有效，1无效")
    private String isEnable;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setFileSuffix(String fileSuffix)
    {
        this.fileSuffix = fileSuffix;
    }

    public String getFileSuffix()
    {
        return fileSuffix;
    }
    public void setFileGroup(String fileGroup)
    {
        this.fileGroup = fileGroup;
    }

    public String getFileGroup()
    {
        return fileGroup;
    }
    public void setFileSize(Long fileSize)
    {
        this.fileSize = fileSize;
    }

    public Long getFileSize()
    {
        return fileSize;
    }
    public void setOssKey(String ossKey)
    {
        this.ossKey = ossKey;
    }

    public String getOssKey()
    {
        return ossKey;
    }
    public void setIsEnable(String isEnable)
    {
        this.isEnable = isEnable;
    }

    public String getIsEnable()
    {
        return isEnable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("url", getUrl())
                .append("name", getName())
                .append("fileSuffix", getFileSuffix())
                .append("fileGroup", getFileGroup())
                .append("fileSize", getFileSize())
                .append("ossKey", getOssKey())
                .append("isEnable", getIsEnable())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
