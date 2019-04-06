package com.bootdo.so.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.so.model.SoDO;
import com.bootdo.so.service.SoService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 销售
 * 
 * @author guodun
 * @date 2019-04-06 11:36:46
 */
 
@Controller
@RequestMapping("/so")
public class SoController {
	@Autowired
	private SoService soService;
	
	@GetMapping()
	@RequiresPermissions("so:list")
	String so(){
	    return "so/so";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("so:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SoDO> soList = soService.listByMap(query);
		int total = soService.count(query);
		PageUtils pageUtils = new PageUtils(soList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("so:add")
	String add(){
	    return "so/so_add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("so:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SoDO so = soService.getById(id);
		model.addAttribute("so", so);
	    return "so/so_edit";
	}

	@ResponseBody
	@GetMapping("/showItem")
	@RequiresPermissions("so:list")
	public SoDO showItem(){
		return new SoDO();
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("so:add")
	public R save( SoDO so){
		if(soService.save(so)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("so:edit")
	public R update( SoDO so){
		soService.update(so);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("so:remove")
	public R remove( Integer id){
		if(soService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("so:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		soService.batchRemove(ids);
		return R.ok();
	}
	
}
