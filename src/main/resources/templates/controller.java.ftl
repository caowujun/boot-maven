package ${package.Controller};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RequestMapping;
import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
@Api(tags="${table.controllerName}",value="${table.comment!}")
public class ${table.controllerName} {
</#if>

/**
* 服务对象
*/
@Resource
private ${table.serviceName} i${entity}Service;

/**
* 分页查询所有数据
*
* @param page 分页对象
* @param entity 查询实体
* @return 所有数据
*/
 @GetMapping(value = "page.do")
 @ApiOperation(value = "查询数据列表，带分页", notes = "根据条件查询")
 public R page(IPage<${entity}> page, ${entity}  entity)
 {
 try{
 return success(this.i${entity}Service.page(page, new QueryWrapper<${entity}>(entity)));
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
 public R listAll(${entity}  entity)
 {
 try{
 return success(this.i${entity}Service.list(new QueryWrapper<${entity}>(entity)));
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
 public R getById(String id)
 {
 try{
 return success(this.i${entity}Service.getById(id));
 } catch (Exception ex) {
 return failed(ex.getMessage());
 }
 }

/**
* 新增数据
*
* @param ${entity} 实体对象
* @return 新增结果
*/
 @PostMapping(value = "insert.do")
 @ApiOperation(value = "数据保存", notes = "新增")
public R save(@RequestBody ${entity}  entity)
 {
 try{
return success(this.i${entity}Service.save(entity));
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
public R update(@RequestBody ${entity}  entity) {
 try{
return success(this.i${entity}Service.updateById(entity));
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
public R removeById(@RequestParam("id") String id) {
 try
 {
 return success(this.i${entity}Service.removeById(id));
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
 public R removeById(@RequestParam("idList") List<Long> idList) {
 try
 {
 return success(this.i${entity}Service.removeByIds(idList));
 } catch (Exception ex) {
 return failed(ex.getMessage());
 }
 }
}
</#if>
