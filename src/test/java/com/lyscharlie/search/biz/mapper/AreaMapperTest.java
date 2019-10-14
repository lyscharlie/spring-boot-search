package com.lyscharlie.search.biz.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyscharlie.search.SearchApplication;
import com.lyscharlie.search.biz.entity.Area;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SearchApplication.class)
public class AreaMapperTest {

	@Autowired
	private AreaMapper areaMapper;

	@Test
	public void testSelectById() {
		Long id = 12L;
		Area area = this.areaMapper.selectById(id);
		System.out.println(JSONObject.toJSONString(area));
		Assert.assertTrue(null != area);
	}

	@Test
	public void testSelectOne() {
		QueryWrapper<Area> wrapper = new QueryWrapper<>();
		wrapper.eq("status", 1).eq("area_level", 2).eq("parent_id", 1).orderByAsc("area_id").last("limit 1");
		Area area = this.areaMapper.selectOne(wrapper);
		System.out.println(JSONObject.toJSONString(area));
		Assert.assertTrue(null != area);
	}

	@Test
	public void testSelectByMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("parent_id", 1);
		List<Area> list = this.areaMapper.selectByMap(map);
		System.out.println(JSONObject.toJSONString(list));
		Assert.assertTrue(!CollectionUtils.isEmpty(list));
	}

	@Test
	public void testSelectList() {
		// LambdaQueryWrapper<Area> lambdaQuery = Wrappers.<Area>lambdaQuery();
		// lambdaQuery.eq(Area::getAreaLevel, 2).eq(Area::getParentId, 1).eq(Area::getStatus, 1);
		List<Area> list = this.areaMapper.selectList(Wrappers.<Area>lambdaQuery().eq(Area::getAreaLevel, 2).eq(Area::getParentId, 1).eq(Area::getStatus, 1));
		System.out.println(JSONObject.toJSONString(list));
		Assert.assertTrue(!CollectionUtils.isEmpty(list));
	}

	@Test
	public void testSelectPage() {
		IPage<Area> page = new Page<>();
		page.setCurrent(1);
		page.setSize(20);
		// page.is

		page = this.areaMapper.selectPage(page, Wrappers.<Area>lambdaQuery().eq(Area::getAreaLevel, 2).eq(Area::getParentId, 1).eq(Area::getStatus, 1));
		System.out.println(JSONObject.toJSONString(page));
		Assert.assertTrue(null != page);
	}

}
