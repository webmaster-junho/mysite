package kr.co.itcen.mysite.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.itcen.mysite.exception.FileUploadException;
import kr.co.itcen.mysite.repository.AdminDao;
import kr.co.itcen.mysite.vo.GuestBookVo;
import kr.co.itcen.mysite.vo.SiteVo;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	private static final String SAVE_PATH="/uploads";
	private static final String URL_PREFIX="/images";
	public List<GuestBookVo> getGuestBookList() {

		return adminDao.getGuestBookList();
	}

	public Boolean updatemain(SiteVo vo) {
		return adminDao.updatemain(vo);
	}

	public String store(MultipartFile multipartFile) {
		String url ="";
		if (multipartFile == null)
			return url;
		String originalFilename = multipartFile.getOriginalFilename();
		String extName = originalFilename.substring(originalFilename.lastIndexOf('.') + 1);
		String saveFileName = generateSaveFilename(extName);
		try {
			byte[] fileDate = multipartFile.getBytes();
			OutputStream os=new FileOutputStream(SAVE_PATH+"/"+saveFileName);
			os.write(fileDate);
			os.close();
			url=URL_PREFIX+"/"+saveFileName;
		} catch (IOException e) {
			throw new FileUploadException();
		}
		return url;
	}
	private String generateSaveFilename(String extName) {
		String filename = "";
		Calendar calendar = Calendar.getInstance();
		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += (".") + extName;
		return filename;
	}

	public SiteVo get(Long no) {
		return adminDao.get(no);
	}

	public Boolean deleteGuestBook(Long no) {
		return adminDao.deletegetGuestBook(no);
	}

}