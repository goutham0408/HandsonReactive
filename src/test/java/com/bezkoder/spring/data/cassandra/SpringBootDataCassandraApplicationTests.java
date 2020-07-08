package com.bezkoder.spring.data.cassandra;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
//import org.apache.coyote.http2.Stream;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.bezkoder.spring.data.cassandra.controller.NotesLibController;
import com.bezkoder.spring.data.cassandra.model.Notestable;
import com.bezkoder.spring.data.cassandra.repository.NotesLibRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SpringBootDataCassandraApplicationTests {
	
/*	@Autowired
	private Notestable notestable;*/
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private NotesLibRepository noteslibrepository;
	
	
	@Before
	public void setup() {
		assertNotNull(entityManager);
		assertNotNull(noteslibrepository);
		
		Notestable java = new Notestable();
		java.setNotename("Java");
		java.setNote("Features");
		java.setCreatedate("2020-06-10");
		java.setUpdatedate("2020-06-11");
		java.setDeleted(false);
	};
	
	
	 @Test
	    public void findAllTest() {
	        Optional<Notestable> found = noteslibrepository.findByNotename("java");
	 
	        assertNotNull(found);
	        assertEquals("Mary", found.get().getNotename());
	 }
	
/*	@Test
	public void getAllTest() {
		when(noteslibrepository.findAll()).thenReturn(Stream
				.of(new Notestable("Java", "Features", "2020-06-10","2020-06-11",false)).collect(Collectors.toList()));
			assertEquals(1, ((List<Notestable>) Notestable.getAllNotes()).size());
	}*/
	
}