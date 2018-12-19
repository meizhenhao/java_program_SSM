package com.taotao.service;

import com.taotao.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface TbItemServiceInterface {
	public TbItem findItemById(long id);
	public EUDataGridResult getItemList(int page , int rows);
}
