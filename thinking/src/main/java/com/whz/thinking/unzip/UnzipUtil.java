package com.whz.thinking.unzip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSONObject;

public class UnzipUtil
{
	/**
	 * 解压文件到指定目录 解压后的文件名，和之前一致
	 * 
	 * @param zipFile 待解压的zip文件
	 * @param descDir 指定目录
	 */
	public static void unZipFiles(File zipFile, String descDir) throws IOException
	{

		ZipFile zip = new ZipFile( zipFile, Charset.forName( "GBK" ) );// 解决中文文件夹乱码
		String name = zip.getName().substring( zip.getName().lastIndexOf( '\\' ) + 1,
				zip.getName().lastIndexOf( '.' ) );

		File pathFile = new File( descDir + name );
		if (!pathFile.exists())
		{
			pathFile.mkdirs();
		}

		ZipEntry entry = null;
		String zipEntryName = null;
		String outPath = null;
		File file = null;
		byte[] buf1 = null;
		int len = 0;
		InputStream in = null;
		FileOutputStream out = null;

		try
		{
			for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();)
			{
				entry = (ZipEntry) entries.nextElement();
				zipEntryName = entry.getName();
				in = zip.getInputStream( entry );
				outPath = (descDir + name + "/" + zipEntryName).replaceAll( "\\*", "/" );

				// 判断路径是否存在,不存在则创建文件路径
				file = new File( outPath.substring( 0, outPath.lastIndexOf( '/' ) ) );
				if (!file.exists())
				{
					file.mkdirs();
				}
				// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
				if (new File( outPath ).isDirectory())
				{
					continue;
				}
				// 输出文件路径信息
				// System.out.println(outPath);

				out = new FileOutputStream( outPath );
				buf1 = new byte[1024];

				while ((len = in.read( buf1 )) > 0)
				{
					out.write( buf1, 0, len );
				}
			}
		} 
		finally
		{
			if (null != out)
			{
				out.close();
			}
			
			if (null != in)
			{
				in.close();
			}
			
			if (null != zip)
			{
				zip.close();
			}
		}

		System.out.println( "******************解压完毕********************" );
		return;
	}
	
	private static void readFile(String path)
	{
		if (path == null)
		{
			System.out.println( "文件不存在" );
			return;
		}
		
		try
		{
			String info = FileUtils.readFileToString( new File(path), Charset.forName("UTF-8") );
			
			JSONObject jsonObject = JSONObject.parseObject( info );
			
			String name = jsonObject.getString( "name" );
			
			System.out.println( name );
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 测试
	public static void main(String[] args)
	{
		try
		{
			FileUtils.forceDelete(new File("E:/Study/abc/") );
			
			unZipFiles( new File( "E:/Study/Study.rpk" ), "E:/Study/abc/" );
			
			//File file = FileUtils.getFile( "E:/Study/abc/Study", "templet.json" );
			
			Collection<File> files = FileUtils.listFiles( new File("E:/Study/abc/"), new String[] {"json"}, true );
			
			File resultFile = null;
			String filePath = null;
			if (files.iterator().hasNext())
			{
				resultFile = files.iterator().next();
				filePath = resultFile.getAbsolutePath();
			}
			
			System.out.println( filePath );
			
			readFile(filePath);
			
			
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			FileUtils.forceDelete(new File("E:/Study/abc/") );
		} 
		catch (IOException e)
		{
			
		}
	}

}
