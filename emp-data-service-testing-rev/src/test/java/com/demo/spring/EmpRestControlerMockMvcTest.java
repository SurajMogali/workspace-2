package com.demo.spring;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.demo.spring.entity.Emp;
import com.demo.spring.repository.EmpRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmpRestControlerMockMvcTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	EmpRepository empRepository;

	@Test
    public void test_updateSalary() throws Exception {
        when(empRepository.findById(100)).thenReturn(Optional.of(new Emp(100,"aaa","bbb",4000.0)));
        when(empRepository.updateSalary(100,77777)).thenReturn(1);//repo is returning int
        mvc.perform(patch("/updatesal/100/77777"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.status").value("Salary updated"));
    }
}
	
	