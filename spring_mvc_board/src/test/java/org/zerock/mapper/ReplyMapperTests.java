package org.zerock.mapper;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Test
	public void testMapper() {
		
		log.info("안녕"+ mapper);
	}
	
	@Test
	public void testCreate() {
			
			ReplyVO vo = new ReplyVO();
			
			//게시물 번호
			vo.setBno(602L);
			vo.setReply("댓글 테스트" );
			vo.setReply("테스트REplyer");
			
			mapper.insert(vo);
	}

}
