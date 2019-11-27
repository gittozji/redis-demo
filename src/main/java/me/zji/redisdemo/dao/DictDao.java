
package me.zji.redisdemo.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author zhanzj19285
 * @date 2019/10/31
 */
@Mapper
public interface DictDao {
    List<Map> selectById(String id, String xx);
}