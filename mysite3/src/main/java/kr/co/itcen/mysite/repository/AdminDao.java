package kr.co.itcen.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.mysite.vo.GuestBookVo;
import kr.co.itcen.mysite.vo.SiteVo;

@Repository
public class AdminDao {
	@Autowired
	private SqlSession sqlsession;

	public List<GuestBookVo> getGuestBookList() {
		List<GuestBookVo> list = sqlsession.selectList("admin.guestbookgetList");
		return list;
	}

	public Boolean updatemain(SiteVo vo) {
		int count=sqlsession.update("site.update",vo);
		return count==1;
	}

	public SiteVo get(Long no) {
		SiteVo vo = sqlsession.selectOne("site.get",no);
		return vo;
	}

	public Boolean deletegetGuestBook(Long no) {
		int count = sqlsession.delete("admin.guestbookDelete",no);
		return count==1;
	}

}