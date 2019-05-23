package com.bootdo.so.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.so.model.SoItemDO;
import com.bootdo.so.service.SoItemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author guodun
 * @date 2019-04-06 11:36:47
 */
 
@Controller
@RequestMapping("/soItem")
public class SoItemController {
	@Autowired
	private SoItemService soItemService;
	
	@GetMapping()
	@RequiresPermissions("soItem:list")
	String soItem(){
	    return "soItem/soItem";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("so:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SoItemDO> soItemList = soItemService.listByMap(query);
		int total = soItemService.count(query);
		PageUtils pageUtils = new PageUtils(soItemList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("soItem:add")
	String add(){
	    return "soItem/soItem_add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("soItem:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SoItemDO soItem = soItemService.getById(id);
		model.addAttribute("soItem", soItem);
	    return "soItem/soItem_edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("soItem:add")
	public R save( SoItemDO soItem){
		if(soItemService.save(soItem)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("soItem:edit")
	public R update( SoItemDO soItem){
		soItemService.update(soItem);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("soItem:remove")
	public R remove( Integer id){
		if(soItemService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("soItem:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		soItemService.batchRemove(ids);
		return R.ok();
	}
	
}
