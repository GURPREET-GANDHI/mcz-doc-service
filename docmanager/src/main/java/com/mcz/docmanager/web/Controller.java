package com.mcz.docmanager.web;

import java.io.Reader;
import java.sql.Clob;
import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mcz.docmanager.repository.JdbcTemplate;

@RestController
public class Controller {

	private JdbcTemplate jdbcOps = new JdbcTemplate();

	@GetMapping("read/{id}")
	public String readDoc(@PathVariable Integer id) throws Exception {

		System.out.println("@@Request" + id);
		Clob clobData = jdbcOps.findById(id);
		if (clobData == null) {
			throw new Exception("No Data Found with id" + id);
		}
		Reader reader = clobData.getCharacterStream();
		 StringBuffer fileData = new StringBuffer();
         int ch;
         while ((ch = reader.read())!=-1) {
        	 fileData.append(""+(char)ch);
         }
         String file = fileData.toString();
         byte[] decodedBytes = Base64.getDecoder().decode(file);
         String decodedfile = new String(decodedBytes);
		System.out.println("Contents: "+decodedfile);
		return decodedfile;
	}

}
