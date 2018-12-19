package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.TbItemServiceInterface;


@Controller
public class TbItemController {
	@Autowired
	private TbItemServiceInterface itemService;
	
	@RequestMapping("/item/hello")
	@ResponseBody
	public String test(){
		
		return "hello world";
	}
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId){
		
		
		TbItem tbItem = itemService.findItemById(itemId);
		
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page , Integer rows){
		return itemService.getItemList(page, rows);
	}
	
}
