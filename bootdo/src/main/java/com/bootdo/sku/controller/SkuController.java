package com.bootdo.sku.controller;

import java.util.List;
import java.util.Map;

import com.bootdo.aop.Log;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
 * @date 2019-03-28 10:42:16
 */
 
@Controller
@RequestMapping("/sku")
public class SkuController {
	@Autowired
	private SkuService skuService;
	
	@GetMapping()
	@RequiresPermissions("sku:list")
	String sku(){
	    return "sku/sku";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("sku:list")
	@Log
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SkuDO> skuList = skuService.listByMap(query);
		int total = skuService.count(query);
		PageUtils pageUtils = new PageUtils(skuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("sku:add")
	String add(){
	    return "sku/sku_add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("sku:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		SkuDO sku = skuService.getById(id);
		model.addAttribute("sku", sku);
	    return "sku/sku_edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("sku:add")
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
	@RequiresPermissions("sku:edit")
	public R update( SkuDO sku){
		skuService.update(sku);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("sku:remove")
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
	@RequiresPermissions("sku:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		skuService.batchRemove(ids);
		return R.ok();
	}
	
}
