
package me.zji.redisdemo.service;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author zhanzj19285
 * @date 2019/10/30
 */
public interface DictService {
    List<Map> getDictById(String id);

    List<Map> getDictByIdNoCache(String id);

    List<Map> getDictByTenant(String tenantId);
}
