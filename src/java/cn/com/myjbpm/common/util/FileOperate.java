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
	 * �����ļ�����
	 * @param source Դ�ļ�
	 * @param target Ŀ���ļ�
	 * @throws Exception
	 */
	public static void copyFile(File source, File target) throws Exception {
		logger.debug("�ļ�����: " + source.getName() + " -> " + target.getName());
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(source));
			out = new BufferedOutputStream(new FileOutputStream(target));
			IOUtils.copy(in, out);
			logger.debug("�ļ������ɹ�");
		} catch (IOException e) {
			throw e;
		} finally {
			in.close();
			out.close();
		}
	}
	
	/**
	 * �ж��ļ����ж��Ƿ�Ҫ����ļ�����
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
	 * �����ļ�Ŀ¼
	 * @param dirString
	 */
	public static void examDir(String dirString) {
		File dir = new File(dirString);
		if (!dir.exists()) {
			dir.mkdir();
		}
	}
}
