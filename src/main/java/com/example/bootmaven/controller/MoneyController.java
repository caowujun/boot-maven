package com.example.bootmaven.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bootmaven.tools.response.R;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.bootmaven.entity.Money;
import com.example.bootmaven.service.IMoneyService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 消费 前端控制器
 * </p>
 *
 * @author robin
 * @since 2022-06-24
 */
@RestController
@RequestMapping("/money")
public class MoneyController extends BaseController {

/**
* 服务对象
*/
@Resource
private IMoneyService iMoneyService;

/**
* 分页查询所有数据
*
* @param page 分页对象
* @param entity 查询实体
* @return 所有数据
*/
 @GetMapping(value = "page.do")
 @ApiOperation(value = "查询数据列表，带分页", notes = "根据条件查询")
 public R<IPage<Money>> page(IPage<Money> page, Money  entity)
 {
 try{
 return success(this.iMoneyService.page(page, new QueryWrapper<Money>(entity)));
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
 @ApiOperation(value = "查询数据列表,不分页", notes = "根据条件查询")
 public R<List<Money>> listAll(Money  entity)
 {
 try{
 return success(this.iMoneyService.list(new QueryWrapper<Money>(entity)));
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
@GetMapping("{id}")
 @ApiOperation(value = "根据id获取数据", notes = "id")
 public R<Money> getById(String id)
 {
 try{
 return success(this.iMoneyService.getById(id));
 } catch (Exception ex) {
 return failed(ex.getMessage());
 }
 }

/**
* 新增数据
*
* @param Money 实体对象
* @return 新增结果
*/
 @PostMapping(value = "insert.do")
 @ApiOperation(value = "数据保存", notes = "新增")
public R<Boolean> save(@RequestBody Money  entity)
 {
 try{
return success(this.iMoneyService.save(entity));
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
 @ApiOperation(value = "数据保存", notes = "更新")
public R<Boolean> update(@RequestBody Money  entity) {
 try{
return success(this.iMoneyService.updateById(entity));
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
@PostMapping
@ApiOperation(value = "删除数据", notes = "id")
public R<Boolean> removeById(@RequestParam("id") String id) {
 try
 {
 return success(this.iMoneyService.removeById(id));
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
 @PostMapping
@ApiOperation(value = "批量删除数据", notes = "id集合")
 public R<Boolean> removeById(@RequestParam("idList") List<Long> idList) {
 try
 {
 return success(this.iMoneyService.removeByIds(idList));
 } catch (Exception ex) {
 return failed(ex.getMessage());
 }
 }
}
