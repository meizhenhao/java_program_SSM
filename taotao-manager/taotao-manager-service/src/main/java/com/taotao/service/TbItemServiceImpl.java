package com.taotao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

@Service
public class TbItemServiceImpl implements TbItemServiceInterface{

	@Autowired
	private TbItemMapper itemMapper;
	
	@Override
	public TbItem findItemById(long id) {
		// TODO Auto-generated method stub
		TbItem item = itemMapper.selectByPrimaryKey(id);
		return item;
	}
	
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		// TODO Auto-generated method stub
		//查询条件，默认是查询所有
		TbItemExample tbItemExample = new TbItemExample();
		
		//拦截sql语句，并设置页数和条目，limit
		PageHelper.startPage(page, rows);
		
		//执行sql语句，返回结果
		List<TbItem> list = itemMapper.selectByExample(tbItemExample);
		
		//查询总条目
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		
		EUDataGridResult result = new EUDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		
		return result;
	}

}
