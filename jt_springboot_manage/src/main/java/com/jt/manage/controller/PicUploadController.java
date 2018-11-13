package com.jt.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;
import com.jt.manage.service.PicUploadService;

@RestController
public class PicUploadController {
	@Autowired
	private PicUploadService picUploadService;

	@RequestMapping("pic/upload")
	public PicUploadResult picUpload(MultipartFile uploadFile) {
		PicUploadResult picUploadResult = picUploadService.picUpload(uploadFile);
		return picUploadResult;
	}
}
