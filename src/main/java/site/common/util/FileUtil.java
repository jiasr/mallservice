package site.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

public class FileUtil {

	/**
	 * 得到文件夹路径
	 */
	public String getFilePath() {
		try {
			String filePath = this.getClass().getClassLoader().getResource("/")
					.getFile();

			filePath = filePath.substring(1, filePath.length() - 16)
					.replaceAll("%20", " ");

			return filePath;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 *
	 * @todo 删除文件
	 * @author zhangyan
	 * @date 2011-8-2
	 * @param filePath
	 * @return void
	 */
	public static void delete(String filePath) {
		File file = new File(filePath);
		file.delete();
	}


	/**
	 *
	 * @todo 以行为单位读取文件，常用于读面向行的格式化文件
	 * @author zhangyan
	 * @date 2011-8-2
	 * @param fileName
	 *            文件名
	 * @throws IOException
	 * @return
	 */
	public String readFileByLines(String fileName) throws IOException {
		File file = new File(fileName);
		String result = "";
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				if (result.equals(""))
					result = tempString + "<br>";
				else
					result += tempString + "<br>";
				line++;
			}
			reader.close();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return result;
	}

	/**
	 *
	 * @todo 列出参数所给目录下的所有文件
	 * @author zhangyan
	 * @date 2011-8-2
	 * @param directory
	 * @return List<File>
	 */
	public List<File> getFiles(String directory) {
		File dir = new File(directory);
		if (!dir.exists())
			dir.mkdirs();
		List<File> result = Arrays.asList(dir.listFiles());
		return result;
	}

	/**
	 * 得到临时文件夹路径
	 */
	public static String getTempFilePath() {

		// Random r = new Random();
		// int it = Math.abs(r.nextInt());

		FileUtil ft = new FileUtil();
		// int second = Calendar.getInstance().get(Calendar.MILLISECOND);
		String filePath = ft.getFilePath();
		return filePath;
	}

	/**
	 * 复制单个文件
	 *
	 * @param srcFile
	 *            String 原文件路径 如：c:/fqf.txt
	 * @param destFile
	 *            String 复制后路径 如：f:/fqf.txt
	 * @throws IOException
	 * @throws Exception
	 */
	public static boolean copyFile(File sourceFile, File destFile)
			throws IOException {
		boolean boo = false;
		File parentFile = destFile.getParentFile();
		if (!parentFile.exists())
			parentFile.mkdirs();
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
			boo = true;
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
		return boo;
	}

	public static void moveFile(String file, OutputStream out)
			throws IOException {
		moveFile(new File(file), out);
	}

	public static void moveFile(File file, OutputStream out) throws IOException {

		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedInputStream inputStream = new BufferedInputStream(
				fileInputStream);
		copy(inputStream, out);
		fileInputStream.close();
		inputStream.close();
		if (!file.delete()) {
			file.deleteOnExit();
		}

	}

	public static long copy(final InputStream input,
			final OutputStream output) throws IOException {

		final int DEFAULT_BUFFER_SIZE = 1024 * 4;
		final byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
		int n = 0;
		long total = 0;
		while (-1 != (n = input.read(buffer))) {
			output.write(buffer, 0, n);
			total += n;
		}
		output.flush();
		return total;
	}

	/**
	 * 生成jar文件
	 *
	 * @author zhangyan
	 * @date 2011-8-1
	 * @param infile
	 * @param outfile
	 * @return
	 * @throws Exception
	 */
	public static boolean createjar(String infile, String outfile)
			throws IOException {
		return createjar(infile, outfile, "");
	}

	// add by bzh 2008.12.18 可以指定base
	public static boolean createjar(String infile, String outfile, String base)
			throws IOException {
		boolean result = false;
		BufferedInputStream  in = null;
		BufferedOutputStream  out = null;
		JarOutputStream jarOut = null;
		try {
			// 创建文件输入流对象
			in = new BufferedInputStream(new FileInputStream(infile));
			// 创建文件输出流对象
			out = new BufferedOutputStream(new FileOutputStream(outfile));
			// 创建JAR数据输出流对象
			jarOut = new JarOutputStream(out);
			// 创建指向压缩原始文件的入口
			File inputFile = new File(infile);
			base = base.length() == 0 ? "" : base + "/";
			base = base + inputFile.getName();
			JarEntry entry = new JarEntry(base);
			jarOut.putNextEntry(entry);
			// 向压缩文件中输出数据
			int nNumber;
			byte[] buffer = new byte[512];
			while ((nNumber = in.read(buffer)) != -1)
				jarOut.write(buffer, 0, nNumber);
			// 关闭创建的流对象
			jarOut.close();
			out.close();
			in.close();
			result = true;
		} finally {
			if (jarOut != null)
				jarOut.close();
			if (out != null)
				out.close();
			if (in != null)
				in.close();
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new FileUtil().getFilePath());
	}
}
