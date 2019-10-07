package kr.co.itcen.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.mysite.repository.SiteDao;
import kr.co.itcen.mysite.vo.SiteVo;
@Service
public class SiteService {
	@Autowired
	private SiteDao siteDao;
	public SiteVo get(Long no) {
		return siteDao.get(no);
	}

}
