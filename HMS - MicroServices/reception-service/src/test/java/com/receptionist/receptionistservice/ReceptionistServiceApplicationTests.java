package com.receptionist.receptionistservice;

import com.receptionist.receptionistservice.model.Guest;
import com.receptionist.receptionistservice.repository.GuestRepository;
import com.receptionist.receptionistservice.service.GuestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ReceptionistServiceApplicationTests {

	@Autowired
	private GuestService guestService;

	@MockBean
	private GuestRepository  guestRepository;

	@Test	//Test for getGuest
	public void getGuestTest() {
		when(guestRepository.findAll()).thenReturn(Stream
				.of(new Guest(1L,"abhi",45L,"cap","abc@gmail.com","male","mumbai",1L,"1-nov-2021","1-nov-2021",500L),
						new Guest(2L,"abhi",7894L,"cap","abc@gmail.com","male","mumbai",1L,"1-nov-2021","1-nov-2021",500L)).collect(Collectors.toList()));
				assertEquals(2,guestService.getGuest().size());
	}

	@Test  //Test for addGuestTest
	public void addGuestTest(){
		Guest guest = new Guest(1L,"abhi",45L,"cap","abc@gmail.com","male","mumbai",1L,"1-nov-2021","1-nov-2021",500L);
		guestService.saveGuest(guest);
		verify(guestRepository,times(1)).save(guest);
	}
}
