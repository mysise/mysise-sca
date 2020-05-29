package org.mysise.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *  公共部分
 * <p>
 * @author fanwenjie@cvte.com
 * @since   2019/11/13 4:04 下午
 */
@Data
public class BaseEntity implements Serializable {

    /**
     *  自增，本项目默认为自增，如果不是自增的请不要继承该接口
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    private LocalDateTime createTime = LocalDateTime.now();

    private LocalDateTime updateTime = LocalDateTime.now();
}
