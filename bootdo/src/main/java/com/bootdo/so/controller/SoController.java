package com.bootdo.so.controller;

import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.so.domain.SoDO;
import com.bootdo.so.service.SoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 销售
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2019-03-26 17:36:08
 */
 
@Controller
@RequestMapping("/so/so")
public class SoController {
	@Autowired
	private SoService soService;
	
	@GetMapping()
	@RequiresPermissions("so:so:so")
	String So(){
	    return "so/so/so";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("so:so:so")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SoDO> soList = soService.list(query);
		int total = soService.count(query);
		PageUtils pageUtils = new PageUtils(soList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("so:so:add")
	String add(){
	    return "so/so/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("so:so:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SoDO so = soService.get(id);
		model.addAttribute("so", so);
	    return "so/so/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("so:so:add")
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
	@RequiresPermissions("so:so:edit")
	public R update( SoDO so){
		soService.update(so);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("so:so:remove")
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
	@RequiresPermissions("so:so:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		soService.batchRemove(ids);
		return R.ok();
	}
	
}
