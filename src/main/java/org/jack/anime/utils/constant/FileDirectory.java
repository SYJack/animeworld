package org.jack.anime.utils.constant;

import org.jack.anime.utils.tool.PropertyReader;

public enum FileDirectory {
	
	COVER(PropertyReader.getProperty("aliyun.oss.coverFileDirectory")),
	PORTRAIT(PropertyReader.getProperty("aliyun.oss.portraitFileDirectory"));
	
	private String directory;
	
	private FileDirectory(String directory){
		this.directory = directory;
	}
	
	@Override
    public String toString() {
        return this.directory;
    }
}
