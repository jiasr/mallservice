package site.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 压缩和解压缩工具类
 *
 * @author zhangyan
 * @date 2011-8-3
 *
 */
public class ZipUtil {
	// 压缩文件
	static public void zip(String zipFile, String inputFile) throws Exception {
		zip(zipFile, new File(inputFile));
	}

	// 压缩文件
	static public void zip(String zipFile, File inputFile) throws Exception {
		ZipOutputStream out = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(zipFile));
			String base = "";
			// 如果inputFile是个文件不是目录
			if (!inputFile.isDirectory()) {
				out.putNextEntry(new ZipEntry(base + "/"));
				base = base.length() == 0 ? "" : base + "/";
				base = base + inputFile.getName();
			}
			zip(out, inputFile, base);
			out.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e1) {
				throw e1;
			}
		}
	}

	// 解压缩文件
	static public void unzip(String zipFile, String unzipDirectory)
			throws Exception {
		ZipInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry z;
			while ((z = in.getNextEntry()) != null) {
				// System.out.println("unziping " + z.getName());
				if (z.isDirectory()) {
					String name = z.getName();
					name = name.substring(0, name.length() - 1);
					File f = new File(unzipDirectory + File.separator + name);
					f.mkdir();
					// System.out.println("mkdir " + outputDirectory +
					// File.separator
					// + name);
				} else {
					File f = new File(unzipDirectory + File.separator
							+ z.getName());
					f.createNewFile();
					out = new FileOutputStream(f);
					int b;
					while ((b = in.read()) != -1)
						out.write(b);
					out.close();
				}
			}

			in.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e1) {
				throw e1;
			}
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				throw e2;
			}
		}
	}

	// 压缩文件
	static public void zip(ZipOutputStream out, File f, String base)
			throws Exception {
		FileInputStream in = null;
		try {
			if (f.isDirectory()) {
				File[] fl = f.listFiles();
				out.putNextEntry(new ZipEntry(base + "/"));
				base = base.length() == 0 ? "" : base + "/";
				for (int i = 0; i < fl.length; i++) {
					zip(out, fl[i], base + fl[i].getName());
				}
			} else {
				out.putNextEntry(new ZipEntry(base));
				in = new FileInputStream(f);
				int b;
				while ((b = in.read()) != -1)
					out.write(b);
				in.close();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e1) {
				throw e1;
			}
		}
	}

}
