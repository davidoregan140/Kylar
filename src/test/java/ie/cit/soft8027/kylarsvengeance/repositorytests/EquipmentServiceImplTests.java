package ie.cit.soft8027.kylarsvengeance.repositorytests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ie.cit.soft8027.kylarsvengeance.domain.Equipment;
import ie.cit.soft8027.kylarsvengeance.repository.EquipmentRepository;
import ie.cit.soft8027.kylarsvengeance.service.EquipmentService;
import ie.cit.soft8027.kylarsvengeance.service.EquipmentServiceImpl;

public class EquipmentServiceImplTests {

	private EquipmentService equipmentService;
	private EquipmentRepository repoMock;

	@Before
	public void setup() {

		repoMock = mock(EquipmentRepository.class);

		Equipment e = new Equipment();
		e.setId(1);
		e.setType("distance weapon");
		e.setName("Longbow");
		e.setDamageInflicted(65);
		e.setProtectionProvided(2);
		e.setUpgradeLevel(1);
		e.setPrice(300);

		Equipment e2 = new Equipment();
		e2.setId(2);
		e2.setType("shield");
		e2.setName("Iron Shield");
		e2.setDamageInflicted(20);
		e2.setProtectionProvided(80);
		e2.setUpgradeLevel(1);
		e2.setPrice(550);

		List<Equipment> equipmentList = new ArrayList<>();

		equipmentList.add(e);
		equipmentList.add(e2);

		when(repoMock.get(1)).thenReturn(e);
		when(repoMock.get(2)).thenReturn(e2);

		when(repoMock.findAll()).thenReturn(equipmentList);

		equipmentService = new EquipmentServiceImpl(repoMock);

	}


	//All tests are successful
	@Test
	public void get() {
		Equipment e = equipmentService.get(1);
		assertEquals("Longbow", e.getName());
	}

	@Test
	public void get2() {
		Equipment e = equipmentService.get(2);
		assertEquals("Iron Shield", e.getName());
	}


	@Test
	public void findAll() {
		assertTrue(equipmentService.findAll().size() == 2);
	}





}
