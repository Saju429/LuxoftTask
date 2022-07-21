package com.lux.task;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lux.task.dao.NaceRepo;
import com.lux.task.models.NaceItem;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class NacedetailsServiceApplicationTests {

	@Autowired
	NaceRepo nRepo;
	
	@Test
	@Order(1)
	public void testAddNaceItem() {
		NaceItem nItem = new NaceItem();
		nItem.setOderid(398596);
		nItem.setCode("10.83");
		nItem.setDescription("Processing of tea and coffee");
		nRepo.save(nItem);
		assertNotNull(nRepo.findById(398596).get());
	}
	
	@Test
	@Order(2)
	public void testGetAllNaceDetails() {
		List<NaceItem> list = nRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testGetNaceDetails() {
		NaceItem nItem = nRepo.findById(398510).get();
		assertEquals("1.47",nItem.getCode());
	}
	
	@Test
	@Order(4)
	public void testUpdateNaceDetails() {
		NaceItem nItem = nRepo.findById(398492).get();
		nItem.setCode("1.41");
		nRepo.save(nItem);
		assertNotEquals("10.21",nRepo.findById(398596).get().getCode());
	}
	
	@Test
	@Order(5)
	public void testDeleteNaceItem() {
		nRepo.deleteById(398483);
		assertThat(nRepo.existsById(398596)).isFalse();
	}
}
