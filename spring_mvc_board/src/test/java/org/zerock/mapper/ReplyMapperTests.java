package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	private Long[] bnoArr = { 602L, 621L };

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

	@Test
	public void testCreate() {

		IntStream.range(1, 10).forEach(i -> {

			ReplyVO vo = new ReplyVO();

			vo.setBno(621L);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);
			mapper.insert(vo);

		});
	}

	@Test
	public void testRead() {

		Long targetRno = 5L;

		ReplyVO vo = mapper.read(targetRno);

		log.info("조회" + vo);
	}

	@Test
	public void testDelete() {

		Long targetRno = 3L;

		mapper.delete(targetRno);
	}

	@Test
	public void testMapper() {

		log.info("안녕" + mapper);
	}

	@Test
	public void testUpdate() {

		Long targetRno = 5L;

		ReplyVO vo = mapper.read(targetRno);

		vo.setReply("수정 10번댓글");

		mapper.update(vo);

	}
	
	@Test
	public void testList() {
		
		Criteria cri = new Criteria();
		
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[1]);
		
		replies.forEach(reply -> log.info("페이징"+reply));
	}

}
