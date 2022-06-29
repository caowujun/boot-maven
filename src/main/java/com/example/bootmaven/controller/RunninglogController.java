package com.example.bootmaven.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bootmaven.BaseController;
import com.example.bootmaven.entity.Runninglog;
import com.example.bootmaven.service.IRunninglogService;
import com.example.bootmaven.tools.response.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 执行日志 前端控制器
 * </p>
 *
 * @author robin
 * @since 2022-06-29
 */
@RestController
@RequestMapping("/runninglog")
public class RunninglogController extends BaseController {

    /**
     * 服务对象
     */
    @Resource
    private IRunninglogService iRunninglogService;


    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param entity 查询实体
     * @return 所有数据
     */
    @GetMapping(value = "page.do")
    @ApiOperation(value = "查询Runninglog数据列表，带分页", notes = "查询Runninglog数据列表，带分页")
    public R<Page<Runninglog>> page(Page<Runninglog> page, Runninglog entity) {
        try {
            return success(this.iRunninglogService.page(page, new QueryWrapper<Runninglog>(entity)));
        } catch (Exception ex) {
            return failed(ex.getMessage());
        }
    }

    /**
     * 查询所有数据
     *
     * @param entity 查询实体
     * @return 所有数据
     */
    @GetMapping(value = "listAll.do")
    @ApiOperation(value = "查询Runninglog数据列表,不分页", notes = "查询Runninglog数据列表,不分页")
    public R<List<Runninglog>> listAll(Runninglog entity) {
        try {
            return success(this.iRunninglogService.list(new QueryWrapper<Runninglog>(entity)));
        } catch (Exception ex) {
            return failed(ex.getMessage());
        }
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getById.do")
    @ApiOperation(value = "根据id获取Runninglog数据", notes = "id")
    public R<Runninglog> getById(String id) {
        try {
            return success(this.iRunninglogService.getById(id));
        } catch (Exception ex) {
            return failed(ex.getMessage());
        }
    }

    /**
     * 新增数据
     *
     * @param entity 实体对象
     * @return 新增结果
     */
    @PostMapping(value = "insert.do")
    @ApiOperation(value = "Runninglog数据新增", notes = "Runninglog数据新增")
    public R<Boolean> save(@RequestBody Runninglog entity) {
        try {
            return success(this.iRunninglogService.save(entity));
        } catch (Exception ex) {
            return failed(ex.getMessage());
        }
    }

    /**
     * 修改数据
     *
     * @param entity 实体对象
     * @return 修改结果
     */
    @PostMapping(value = "update.do")
    @ApiOperation(value = "Runninglog数据更新", notes = "{entity}数据更新")
    public R<Boolean> update(@RequestBody Runninglog entity) {
        try {
            return success(this.iRunninglogService.updateById(entity));
        } catch (Exception ex) {
            return failed(ex.getMessage());
        }
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @PostMapping(value = "removeById.do")
    @ApiOperation(value = "根据id删除Runninglog数据", notes = "根据id删除Runninglog数据")
    public R<Boolean> removeById(@RequestParam("id") String id) {
        try {
            return success(this.iRunninglogService.removeById(id));
        } catch (Exception ex) {
            return failed(ex.getMessage());
        }
    }

    /**
     * 批量删除数据
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @PostMapping(value = "removeByIds.do")
    @ApiOperation(value = "批量删除Runninglog数据", notes = "批量删除Runninglog数据")
    public R<Boolean> removeByIds(@RequestParam("idList") List<Long> idList) {
        try {
            return success(this.iRunninglogService.removeByIds(idList));
        } catch (Exception ex) {
            return failed(ex.getMessage());
        }
    }
}
