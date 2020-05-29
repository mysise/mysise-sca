package org.mysise.demo.service.impl;

import org.mysise.demo.entity.IndexTest;
import org.mysise.demo.mapper.IndexTestMapper;
import org.mysise.demo.service.IIndexTestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fanwenjie
 * @since 2020-05-29
 */
@Service
public class IndexTestServiceImpl extends ServiceImpl<IndexTestMapper, IndexTest> implements IIndexTestService {

}
