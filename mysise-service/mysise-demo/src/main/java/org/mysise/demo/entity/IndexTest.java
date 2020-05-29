package org.mysise.demo.entity;

import org.mysise.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author fanwenjie
 * @since 2020-05-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class IndexTest extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;


}
