package com.example.bootmaven.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.bootmaven.entity.Roleuser;
import com.example.bootmaven.service.IRoleuserService;
import com.example.bootmaven.response.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import com.example.bootmaven.vo.votransfer.RoleuserTransfer;


import com.example.bootmaven.BaseController;

/**
 * <p>
 * 角色-用户对应表 前端控制器
 * </p>
 *
 * @author robin
 * @since 2022-07-04
 */
@RestController
@RequestMapping("/roleuser")
public class RoleuserController extends BaseController {

    /**
     * 服务对象
     */
    @Resource
    private IRoleuserService iRoleuserService;
    @Resource
    private RoleuserTransfer transfer;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param entity 查询实体
     * @return 所有数据
     */
    @GetMapping(value = "page.do")
    @ApiOperation(value = "查询Roleuser数据列表，带分页", notes = "查询Roleuser数据列表，带分页")
    public R<Page<Roleuser>> page(Page<Roleuser> page, Roleuser roleuser) {
        try {
            return success(this.iRoleuserService.page(page, new QueryWrapper<Roleuser>(roleuser)));
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
    @ApiOperation(value = "查询Roleuser数据列表,不分页", notes = "查询Roleuser数据列表,不分页")
    public R<List<Roleuser>> listAll(Roleuser roleuser) {
        try {
            return success(this.iRoleuserService.list(new QueryWrapper<Roleuser>(roleuser)));
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
    @ApiOperation(value = "根据id获取Roleuser数据", notes = "id")
    public R<Roleuser> getById(String id) {
        try {
            return success(this.iRoleuserService.getById(id));
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
    @ApiOperation(value = "Roleuser数据新增", notes = "Roleuser数据新增")
    public R<Boolean> save(@RequestBody Roleuser roleuser) {
        try {
            return success(this.iRoleuserService.save(roleuser));
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
    @ApiOperation(value = "Roleuser数据更新", notes = "{entity}数据更新")
    public R<Boolean> update(@RequestBody Roleuser roleuser) {
        try {
            return success(this.iRoleuserService.updateById(roleuser));
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
    @ApiOperation(value = "根据id删除Roleuser数据", notes = "根据id删除Roleuser数据")
    public R<Boolean> removeById(@RequestParam("id") String id) {
        try {
            return success(this.iRoleuserService.removeById(id));
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
    @ApiOperation(value = "批量删除Roleuser数据", notes = "批量删除Roleuser数据")
    public R<Boolean> removeByIds(@RequestParam("idList") List<Long> idList) {
        try {
            return success(this.iRoleuserService.removeByIds(idList));
        } catch (Exception ex) {
            return failed(ex.getMessage());
        }
    }
}
