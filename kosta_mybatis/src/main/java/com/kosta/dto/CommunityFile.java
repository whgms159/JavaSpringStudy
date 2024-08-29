package com.kosta.dto;

import java.util.List;

import lombok.Data;

@Data
public class CommunityFile {
	private int id, communityId;
	private String originFileName, storedFilePath;
	private User creator;
	private List<CommunityFile> fileList;
	private long fileSize;
}
