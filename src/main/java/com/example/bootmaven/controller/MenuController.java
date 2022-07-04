package com.example.bootmaven.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.bootmaven.entity.Menu;
import com.example.bootmaven.service.IMenuService;
import com.example.bootmaven.tools.response.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.example.bootmaven.vo.votransfer.MenuTransfer;
import com.example.bootmaven.vo.MenuVO;



import com.example.bootmaven.BaseController;

/**
* <p>
* 菜单 前端控制器
* </p>
*
* @author robin
* @since 2022-07-04
*/
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

/**
* 服务对象
*/
@Resource
private IMenuService iMenuService;
@Resource
private MenuTransfer transfer;

/**
* 分页查询所有数据
*
* @param page 分页对象
* @param entity 查询实体
* @return 所有数据
*/
@GetMapping(value = "page.do")
@ApiOperation(value = "查询Menu数据列表，带分页", notes = "查询Menu数据列表，带分页")
public R<Page<Menu>> page(Page<Menu> page, Menu  menu)
{
try{
return success(this.iMenuService.page(page, new QueryWrapper<Menu>( menu)));
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
@ApiOperation(value = "查询Menu数据列表,不分页", notes = "查询Menu数据列表,不分页")
public R<List<Menu>> listAll(Menu   menu)
{
try{
return success(this.iMenuService.list(new QueryWrapper<Menu>( menu)));
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
@ApiOperation(value = "根据id获取Menu数据", notes = "id")
public R<Menu> getById(String id)
{
try{
return success(this.iMenuService.getById(id));
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
@ApiOperation(value = "Menu数据新增", notes = "Menu数据新增")
public R<Boolean> save(@RequestBody Menu  menu)
{
try{
return success(this.iMenuService.save( menu));
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
@ApiOperation(value = "Menu数据更新", notes = "{entity}数据更新")
public R<Boolean> update(@RequestBody Menu  menu) {
try{
return success(this.iMenuService.updateById( menu));
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
@ApiOperation(value = "根据id删除Menu数据", notes = "根据id删除Menu数据")
public R<Boolean> removeById(@RequestParam("id") String id) {
try
{
return success(this.iMenuService.removeById(id));
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
@ApiOperation(value = "批量删除Menu数据", notes = "批量删除Menu数据")
public R<Boolean> removeByIds(@RequestParam("idList") List<Long> idList) {
try
{
return success(this.iMenuService.removeByIds(idList));
} catch (Exception ex) {
return failed(ex.getMessage());
}
}
}
