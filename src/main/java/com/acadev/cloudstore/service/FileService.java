package com.acadev.cloudstore.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.acadev.cloudstore.model.response.FilesResponse;

public interface FileService {

	String echo();

	void saveFilesByProductId(Integer id, List<MultipartFile> files);
	
	FilesResponse getFilesByProductId(Integer id);

	Resource getFileByProductIdAndFileName(Integer id, String fileName);

}
