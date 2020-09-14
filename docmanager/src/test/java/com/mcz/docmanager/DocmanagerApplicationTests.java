package com.mcz.docmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Base64;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.mcz.docmanager.repository.JdbcTemplate;
import com.mcz.docmanager.web.Controller;

@RunWith(MockitoJUnitRunner.class)
public class DocmanagerApplicationTests {

	private static final String TEST_DATA = "<root><file><name>mcz</name></file></root>";

	// @Test
//	void contextLoads() {
//	}
	@Test
	public void store() throws Exception {

		JdbcTemplate repo = new JdbcTemplate();
		String encodedDoc = Base64.getEncoder().encodeToString(TEST_DATA.getBytes());
		long id = repo.save(encodedDoc);
		System.out.println("@@ >> TEST Response: Doc Created with" + id);
		assertNotEquals(id, 0);

		Controller controller = new Controller();
		System.out.println("@@ >> TEST id" + id);
		String response = controller.readDoc((int) id);
		System.out.println("@@ >> TEST Response" + response);
		assertEquals(TEST_DATA, response);
	}

}
