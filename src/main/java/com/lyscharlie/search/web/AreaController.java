package com.lyscharlie.search.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lyscharlie.search.biz.entity.Area;
import com.lyscharlie.search.biz.service.AreaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("area")
@Slf4j
public class AreaController {

	@Autowired
	private AreaService areaService;

	@RequestMapping("chinaList.php")
	public List<Area> queryListForChina() {
		List<Area> list = this.areaService.list(Wrappers.<Area>lambdaQuery().eq(Area::getParentId, 1));
		return list;
	}

}
