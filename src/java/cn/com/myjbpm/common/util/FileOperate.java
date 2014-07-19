package cn.com.myjbpm.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.com.myjbpm.center.action.DeployAction;

public class FileOperate {
	private static Log logger = LogFactory.getLog(DeployAction.class);
	
	/**
	 * 进行文件拷贝
	 * @param source 源文件
	 * @param target 目标文件
	 * @throws Exception
	 */
	public static void copyFile(File source, File target) throws Exception {
		logger.debug("文件拷贝: " + source.getName() + " -> " + target.getName());
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(source));
			out = new BufferedOutputStream(new FileOutputStream(target));
			IOUtils.copy(in, out);
			logger.debug("文件拷贝成功");
		} catch (IOException e) {
			throw e;
		} finally {
			in.close();
			out.close();
		}
	}
	
	/**
	 * 判断文件名判断是否要求的文件类型
	 * @param filename
	 * @param fileTypes
	 * @return
	 */
	public static boolean verifyFileClassy(String filename, String ...fileTypes) {
		
		int index = filename.lastIndexOf(".");
		if(index < 0 || index >= filename.length()){
			return false;
		}else{
			String tempStr = filename
					.substring(index + 1);
			for(String fileType : fileTypes){
				if(tempStr.equals(fileType)){
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * 创建文件目录
	 * @param dirString
	 */
	public static void examDir(String dirString) {
		File dir = new File(dirString);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}
}
