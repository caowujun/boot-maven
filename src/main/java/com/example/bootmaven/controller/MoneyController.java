package com.example.bootmaven.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.bootmaven.entity.Money;
import com.example.bootmaven.service.IMoneyService;
import com.example.bootmaven.response.R;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.example.bootmaven.vo.votransfer.MoneyTransfer;
import com.example.bootmaven.vo.MoneyVO;



import com.example.bootmaven.BaseController;

/**
* <p>
* 消费 前端控制器
* </p>
*
* @author robin
* @since 2022-07-05
*/
@RestController
@RequestMapping("/money")
public class MoneyController extends BaseController {

/**
* 服务对象
*/
@Resource
private IMoneyService iMoneyService;
@Resource
private MoneyTransfer transfer;

/**
* 分页查询所有数据
*
* @param page 分页对象
* @param money 查询实体
* @return 所有数据
*/
@GetMapping(value = "page.do")
@ApiOperation(value = "查询Money数据列表，带分页", notes = "查询Money数据列表，带分页")
public R<Page<Money>> page(Page<Money> page, Money  money)
{
try{
return success(this.iMoneyService.page(page, new QueryWrapper<Money>( money)));
} catch (Exception ex) {
return failed(ex.getMessage());
}
}

/**
* 查询所有数据
*
* @param money 查询实体
* @return 所有数据
*/
@GetMapping(value = "listAll.do")
@ApiOperation(value = "查询Money数据列表,不分页", notes = "查询Money数据列表,不分页")
public R<List<Money>> listAll(Money   money)
{
try{
return success(this.iMoneyService.list(new QueryWrapper<Money>( money)));
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
@ApiOperation(value = "根据id获取Money数据", notes = "id")
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
* @param money 实体对象
* @return 新增结果
*/
@PostMapping(value = "insert.do")
@ApiOperation(value = "Money数据新增", notes = "Money数据新增")
public R<Boolean> save(@RequestBody Money  money)
{
try{
return success(this.iMoneyService.save( money));
} catch (Exception ex) {
return failed(ex.getMessage());
}
}

/**
* 修改数据
*
* @param money 实体对象
* @return 修改结果
*/
@PostMapping(value = "update.do")
@ApiOperation(value = "Money数据更新", notes = "{entity}数据更新")
public R<Boolean> update(@RequestBody Money  money) {
try{
return success(this.iMoneyService.updateById( money));
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
@ApiOperation(value = "根据id删除Money数据", notes = "根据id删除Money数据")
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
@PostMapping(value = "removeByIds.do")
@ApiOperation(value = "批量删除Money数据", notes = "批量删除Money数据")
public R<Boolean> removeByIds(@RequestParam("idList") List<Long> idList) {
try
{
return success(this.iMoneyService.removeByIds(idList));
} catch (Exception ex) {
return failed(ex.getMessage());
}
}
}
