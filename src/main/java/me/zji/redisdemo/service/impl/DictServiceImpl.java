
package me.zji.redisdemo.service.impl;

import me.zji.redisdemo.dao.DictDao;
import me.zji.redisdemo.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author zhanzj19285
 * @date 2019/10/30
 */
@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictDao dictDao;

    /**
     * 加缓存
     *
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "dict", key = "#id")
    public List<Map> getDictById(String id) {
        List<Map> list = dictDao.selectById(id, id + "suffix");
        return list;
    }

    /**
     * 不加缓存
     *
     * @param id
     * @return
     */
    @Override
    public List<Map> getDictByIdNoCache(String id) {
        return getDictById(id);
    }

    @Override
    public List<Map> getDictByTenant(String tenantId) {
        Map map = new HashMap();
        map.put("tenantId", tenantId);
        map.put("keyNo", "9998");
        map.put("keyValue", "9998");
        map.put("caption", "9998");
        map.put("memo", "9998");
        dictDao.insert(map);
        return dictDao.selectByTenant(tenantId);
    }

    // @CachePut 添加

    // @CacheEvict 移除
}