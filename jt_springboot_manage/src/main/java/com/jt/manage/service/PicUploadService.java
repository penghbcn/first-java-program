package com.jt.manage.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jt.common.vo.PicUploadResult;

@Service
public class PicUploadService {
	@Value("${pathw}")
	private String pathw;
	@Value("${urlw}")
	private String urlw;

	public PicUploadResult picUpload(MultipartFile uploadFile) {
		PicUploadResult picUploadResult = new PicUploadResult();
		// 判断后缀
		// 获取原名称
		String oldFileName = uploadFile.getOriginalFilename();
		// 截取后缀
		String extFileName = oldFileName.substring(oldFileName.lastIndexOf("."));
		// 正则判断合法性
		if (!extFileName.matches("^.(jpg|png|gif)$")) {
			picUploadResult.setError(1);
			return picUploadResult;
		}
		try {
			// 判断木马,根据是否有宽高来判断
			BufferedImage bufferedImage = ImageIO.read(uploadFile.getInputStream());
			picUploadResult.setHeight(bufferedImage.getHeight() + "");
			picUploadResult.setWidth(bufferedImage.getWidth() + "");
		} catch (IOException e) {
			e.printStackTrace();
			picUploadResult.setError(1);
			return picUploadResult;
		}
		// 生成路径image/2018/7/27
		String dir = "/image/" + new SimpleDateFormat("yyyy/MM/dd").format(new Date()) + "/";
		// 拼接url路径
		// 存储到图片服务器
		// String path = "C:\\apache-tomcat-8.0.23\\webapps\\ROOT" + dir;
		// String urlPath = "http://localhost:8080" + dir;
		// Ngnix跳转
		String path = pathw + dir;
		String urlPath = urlw + dir;
		System.out.println(pathw);
		System.out.println(urlw);
		// 创建磁盘目录
		File _dir = new File(path);
		if (!_dir.exists()) {
			_dir.mkdirs();
		}
		String fileName = System.currentTimeMillis() + "" + RandomUtils.nextInt(100, 999) + extFileName;
		picUploadResult.setUrl(urlPath + fileName);
		// 写出磁盘
		try {
			uploadFile.transferTo(new File(path + fileName));
			picUploadResult.setError(0);
			return picUploadResult;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			picUploadResult.setError(1);
			return picUploadResult;
		}
	}
}
