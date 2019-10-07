package kr.co.itcen.mysite.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.mysite.vo.SiteVo;
@Repository
public class SiteDao {
	@Autowired
	private SqlSession sqlsession;

	public SiteVo get(Long no) {
		SiteVo vo = sqlsession.selectOne("site.get",no);
		return vo;
	}
	
}
