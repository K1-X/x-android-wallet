package bd.com.appcore.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressLint("DefaultLocale")
public class FileUtil {

	// 
	public static boolean checkAndCreateDirs(String path) {
		File file = new File(path);
		if (!file.exists()) {
			int y = path.lastIndexOf('.');
			int x = path.lastIndexOf('/');
			if (y > 0 && y > x) {
				String parentDir = path.substring(0, x);
				return new File(parentDir).mkdirs();
			} else {
				return file.mkdirs();
			}
		}
		return true;
	}

	// 
	public static byte[] readFileContent(String filepath) throws IOException {
		BufferedInputStream i = null;
		BufferedOutputStream o = null;
		try {
			i = new BufferedInputStream(new FileInputStream(filepath));
			ByteArrayOutputStream ao = new ByteArrayOutputStream();
			o = new BufferedOutputStream(ao);

			int read = -1;
			byte[] buffer = new byte[2048];
			while (true) {
				read = i.read(buffer);
				if (read == -1) {
					// 
					break;
				}
				o.write(buffer, 0, read);
			}
			o.flush();

			return ao.toByteArray();
		} finally {
			if (i != null) {
				try {
					i.close();
				} catch (Exception e) {
				}
			}
			if (o != null) {
				try {
					o.close();
				} catch (Exception e) {
				}
			}
		}
	}

	// 
	public static boolean saveStreamFile(InputStream is, String filepath) throws IOException {
		boolean result = true;
		BufferedOutputStream o = null;
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filepath);
			o = new BufferedOutputStream(fileOutputStream);
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = is.read(b)) != -1) {
				o.write(b, 0, len);
			}
			o.flush();
		} finally {
			if (o != null) {
				try {
					is.close();
					o.close();
				} catch (Exception e) {
				}
			}
		}
		return result;
	}

	// 
	public static void saveFileContent(String filepath, byte[] content) throws IOException {
		BufferedOutputStream o = null;
		try {
			o = new BufferedOutputStream(new FileOutputStream(filepath));
			o.write(content);
		} finally {
			if (o != null) {
				try {
					o.flush();
					o.close();
				} catch (Exception e) {
				}
			}
		}
	}
	
	public static File createFile(String folderPath, String fileName) {
		File destDir = new File(folderPath);
		if (!destDir.exists()) {
			destDir.mkdirs();
		}
		return new File(folderPath, fileName);
	}

	// （）
	public static boolean deleteDir(String path) {
		boolean success = cleanDir(path);
		if (success) {
			success = new File(path).delete();
		}
		return success;
	}

	// 
	public static boolean deleteFile(String path) {
		boolean success = false;
		File file = new File(path);
		if (file.exists()) {
			success = file.delete();
		}
		return success;
	}

	// 
	public static boolean cleanDir(String path) {
		File file = new File(path);
		boolean success = true;
		if (file.exists()) {
			File[] list = file.listFiles();
			if (list != null) {
				for (File tempFile : list) {
					if (tempFile.isDirectory()) {
						boolean ret = deleteDir(tempFile.getPath());
						if (!ret) {
							success = false;
						}
					} else {
						boolean ret = tempFile.delete();
						if (!ret) {
							success = false;
						}
					}
				}
			}
		}
		return success;
	}

	// copy，"/"，。
	public static boolean copyFolder(String sourceDir, String targetDir) {
		if (!sourceDir.endsWith(File.separator)) {
			sourceDir = sourceDir + File.separator;
		}
		if (!targetDir.endsWith(File.separator)) {
			targetDir = targetDir + File.separator;
		}

		try {
			(new File(targetDir)).mkdirs(); //  
			File a = new File(sourceDir);
			String[] SubFilenameList = a.list();
			File temp = null;
			for (String filename : SubFilenameList) {
				temp = new File(sourceDir + filename);

				if (temp.isFile()) {
					copyFile(sourceDir + filename, targetDir + filename);
				}
				if (temp.isDirectory()) {// 
					copyFolder(sourceDir + filename + File.separator, targetDir + filename + File.separator);
				}
			}
		} catch (Exception e) {
			Log.d("FileUtil", "copy folder failed!", e);
			return false;

		}
		return true;
	}

	//  ，
	public static boolean copyFile(String source, String target) throws IOException {
		FileInputStream i = null;
		FileOutputStream o = null;
		try {
			i = new FileInputStream(source);
			o = new FileOutputStream(target);
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = i.read(b)) != -1) {
				o.write(b, 0, len);
			}
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}finally {
			if (i != null) {
				try {
					i.close();
				} catch (Exception e) {
				}
			}
			if (o != null) {
				try {
					o.flush();
					o.close();
				} catch (Exception e) {
				}
			}
		}
	}

	// 
	public static void moveFile(String source, String target) throws IOException {
		copyFile(source, target); // copy
		deleteFile(source); // 
	}

	// 
	public static void copyAssetFile(Context context, String source, String target) throws IOException {
		InputStream i = null;
		FileOutputStream o = null;
		try {
			i = context.getAssets().open(source);
			o = new FileOutputStream(target);
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = i.read(b)) != -1) {
				o.write(b, 0, len);
			}
			o.flush();
		} finally {
			if (i != null) {
				try {
					i.close();
				} catch (Exception e) {
				}
			}
			if (o != null) {
				try {
					o.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public static void closeInputStream(InputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (Exception e) {

			}
		}
	}

	public static void closeOutputStream(OutputStream out) {
		if (out != null) {
			try {
				out.close();
			} catch (Exception e) {

			}
		}
	}

	public static String getFilenameFromUrl(String url) {
		String r = url;
		int p = url.lastIndexOf("/");
		if (p != -1) {
			r = url.substring(p + 1);
		}
		p = r.indexOf("?");
		if (p != -1) {
			r = r.substring(0, p);
		}
		return r;
	}

	public static String getFileExtFromUrl(String url) {
		String r = getFilenameFromUrl(url);
		return getFileExtFromFilename(r);
	}

	public static String getFileExtFromFilename(String filename) {
		int p = filename.indexOf(".");
		String ext = "";
		if (p != -1) {
			ext = filename.substring(p + 1);
		}
		return ext;
	}

	public static String getFilenameFromContentDisposition(String contentDisposition) {
		if (contentDisposition != null && !contentDisposition.equals("")) {
			String[] values = contentDisposition.split(";");
			for (String v : values) {
				if (v != null && v.trim().toLowerCase().startsWith("filename=")) {
					try {
						int start = v.indexOf("\"");
						int end = v.lastIndexOf("\"");
						String filename = v.substring(start + 1, end);
						return filename;
					} catch (Exception e) {
						e.printStackTrace(System.out);
						return null;
					}
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param activity
	 * @param file
	 */
	public static void shareFile(Activity activity, File file){
		Intent share = new Intent(Intent.ACTION_SEND);
		share.putExtra(Intent.EXTRA_STREAM,
			Uri.fromFile(file));
		share.setType("*/*");//
		activity.startActivity(Intent.createChooser(share, "Share"));
	}

	public static void importFile(Activity activity, int requestCode){
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("*/*");
		//intent.setType("application/json");   //   json
		intent.addCategory(Intent.CATEGORY_OPENABLE);
		activity.startActivityForResult(intent, requestCode);
	}

	public static String getRealPath(Uri uri){
			File file=null;
			Log.i("hxl", "======");
			String string =uri.toString();
			String a[]=new String[2];
			//sd
			if (string.indexOf(String.valueOf(Environment.getExternalStorageDirectory()))!=-1){
				//Uri
				a = string.split(String.valueOf(Environment.getExternalStorageDirectory()));
				//file
				file = new File(Environment.getExternalStorageDirectory(),a[1]);
			}else if(string.indexOf(String.valueOf(Environment.getDataDirectory()))!=-1) { //
				//Uri
				a = string.split(String.valueOf(Environment.getDataDirectory()));
				//file
				file = new File(Environment.getDataDirectory(), a[1]);
			}
			if(file!=null&& file.exists()){
				return file.getPath();
			}
			return null;
	}

	/*
     * Java 
     *
     */
	public static String getExtensionName(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot >-1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}
	/*
     * Java 
     *
     */
	public static String getFileNameNoEx(String filename) {
		if ((filename != null) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot >-1) && (dot < (filename.length()))) {
				return filename.substring(0, dot);
			}
		}
		return filename;
	}


	public static void writeFileSdcardFileByPath(String message, String filePath) {

		try {
			File file = new File(filePath);
			if (!file.exists()) {
				File dir = new File(file.getParent());
				dir.mkdirs();
				file.createNewFile();
			}
			FileOutputStream outStream = new FileOutputStream(file);
			outStream.write(message.getBytes());
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
