package com.bootdo.sku.controller;

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

import com.bootdo.sku.model.SkuDO;
import com.bootdo.sku.service.SkuService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 商品
 * 
 * @author guodun
 * @date 2019-03-27 13:39:00
 */
 
@Controller
@RequestMapping("/bootdo/sku")
public class SkuController {
	@Autowired
	private SkuService skuService;
	
	@GetMapping()
	@RequiresPermissions("bootdo:sku:sku")
	String Sku(){
	    return "bootdo/sku/sku";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("bootdo:sku:sku")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SkuDO> skuList = skuService.listByMap(query);
		int total = skuService.count(query);
		PageUtils pageUtils = new PageUtils(skuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("bootdo:sku:add")
	String add(){
	    return "bootdo/sku/sku_add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("bootdo:sku:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SkuDO sku = skuService.getById(id);
		model.addAttribute("sku", sku);
	    return "bootdo/sku/sku_edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("bootdo:sku:add")
	public R save( SkuDO sku){
		if(skuService.save(sku)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("bootdo:sku:edit")
	public R update( SkuDO sku){
		skuService.update(sku);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("bootdo:sku:remove")
	public R remove( Integer id){
		if(skuService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("bootdo:sku:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		skuService.batchRemove(ids);
		return R.ok();
	}
	
}
