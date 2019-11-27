
package me.zji.redisdemo.controller;

import me.zji.redisdemo.service.DictService;
import me.zji.redisdemo.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author zhanzj19285
 * @date 2019/10/30
 */
@RestController
public class Controller {
    @Autowired
    private DictService dictService;
    @Autowired
    private TemplateService templateService;

    @GetMapping("/dict/{id}")
    public List<Map> getDict(@PathVariable("id") String id) {
        return dictService.getDictById(id);
    }

    @GetMapping("/dict/nocache/{id}")
    public List<Map> getDictNoCache(@PathVariable("id") String id) {
        return dictService.getDictByIdNoCache(id);
    }

    @GetMapping("/example")
    public void example() {
        templateService.example();
    }
}