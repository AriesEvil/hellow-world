package com.feng.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {

	private Integer statureUnitCM; // 身高（厘米）
	private Integer statureUnitInch;// 身高（英寸）
	private Integer studentsNum; // 学生数量
	private Integer teacherNum; // 老师数量
	private Double runningSpeed; // 运行速度
	private Date createTime;// 创建时间
	private Date invalidTime;// 失效时间
	private Double perCapitaIncome;// 人均收入
	private Integer Category; // 类别
	private Integer roomsNum;// 房间数量
	private Integer popularity;// 流行度
	private Date businessHours;// 营业时间
	private String ecorationStyle;// 装修风格
	private String metal; // 金
	private String wood;// 木
	private String water; // 水
	private String Fire; // 火
	private String Earth;// 土

	public static void main(String[] args) throws ParseException, IOException {
		// TODO Auto-generated method stub
		// 当前日期
		Date currentDate = new Date();
		// 每页的行数
		int linesPerPage = 0;

		getLastMaxMonthDate();
		beijingTimeToXWY();
		writeFile();
		transfer();

	}

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getNowTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		String lastMonth = dft.format(cal.getTime());
		return lastMonth;
	}

	/**
	 * 获取当前月份最后一天
	 * 
	 * @return
	 */
	public static String getMaxMonthDate() {
		SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		// calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dft.format(calendar.getTime());
	}

	/**
	 * 
	 * 描述:获取上个月的最后一天.
	 * 
	 * @return
	 */
	public static String getLastMaxMonthDate() {
		// 生成时间，北京当前时间的上个月最后一天，输出格式为：2018-01-01 20:00:00
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("北京当前时间的上个月最后一天:" + dft.format(calendar.getTime()));
		return dft.format(calendar.getTime());
	}

	/**
	 * 将北京时间 2018-06-25 18:00:30，转换为洛杉矶时间，输出格式：2018-01-01 20:00:00
	 * @throws ParseException
	 */
	public static void beijingTimeToXWY() throws ParseException {
		String beijingTime = "2018-06-25 18:00:30";// 北京时间
		SimpleDateFormat foo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = foo.parse(beijingTime);
		long time = date.getTime(); 
		long hours = 15 * 60 * 60 * 1000;
		time = time-hours;
		System.out.println("洛杉矶时间："+foo.format(new Date(time)));
	}
	

	public static void writeFile() throws IOException {
		// 将以下文字写入文件（GBK编码）
		String sample = "Java是一种广泛使用的计算机编程语言，拥有跨平台、面向对象、泛型编程的特性，广泛应用于企业级Web应用开发和移动应用开发。";
		OutputStreamWriter pw = null;// 定义一个流
		pw = new OutputStreamWriter(new FileOutputStream("D:/test.txt"), "GBK"); // 确认流的输出文件和编码格式，此过程创建了“test.txt”
		pw.write(sample);// 将要写入文件的内容，可以多次write
		pw.close();// 将要写入文件的内容，可以多次write
	}

	public static void transfer() throws IOException {
		// 读取文件内容，写入新的文件（UTF8编码）
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/test.txt"), "GBK"));
		BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("D:/test1.txt"), Charset.forName("UTF-8")));
		String str = null;
		while ((str = br.readLine()) != null) {// 读取一行
			System.out.println(str);
			bw.write(str + "\n");// 把转换后的字符串输出到新的文件
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
