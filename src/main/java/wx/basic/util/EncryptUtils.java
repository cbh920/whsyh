/**
 * @文件名 EncryptUtils.java
 * @包名 com.work614.util
 * @说明 加密工具类 可用md5 sha等进行加密
 * @作者 zdyang
 * @时间 2014年4月7日 下午10:16:50
 * @版本 V1.0
 */
package wx.basic.util;

import java.security.MessageDigest;

/**
 * @类名 MD5Utils
 * @author zdyang
 * @描述 加密工具类 可用md5 sha等进行加密
 * @日期 2014年4月7日 下午10:16:50
 */
public class EncryptUtils {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * @方法名 MD5
	 * @描述 对密码加盐之后使用md5加密 生成的加密串为32位
	 * @param salt
	 * @param password
	 * @return String
	 * @作者 zdyang
	 * @时间 2014年4月7日 下午10:50:58
	 */
	public static String MD5(String salt, String password) {
		return encrypt(salt, password, "MD5");
	}

	/**
	 * @方法名 SHA
	 * @描述 对密码加盐之后使用SHA加密 生成的加密串为40位
	 * @param salt
	 * @param password
	 * @return String
	 * @作者 zdyang
	 * @时间 2014年4月7日 下午10:50:58
	 */
	public static String SHA(String salt, String password) {
		return encrypt(salt, password, "SHA");
	}
	/**
	 * @方法名 SHA
	 * @描述 对密码加盐之后使用SHA-256加密 生成的加密串为64位
	 * @param salt
	 * @param password
	 * @return String
	 * @作者 zdyang
	 * @时间 2014年4月7日 下午10:50:58
	 */
	public static String SHA256(String salt, String password) {
		return encrypt(salt, password, "SHA-256");
	}

	/**
	 * @方法名 encrypt
	 * @描述 对密码加盐后进行相应算法的加密
	 * @param salt
	 * @param password
	 * @param algorithm
	 * @return String
	 * @作者 zdyang
	 * @时间 2014年4月7日 下午10:55:14
	 */
	private static String encrypt(String salt, String password, String algorithm) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			// 加密后的字符串
			result = byteArrayToHexString(md.digest(mergePasswordAndSalt(salt,
					password).getBytes("utf-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * @方法名 mergePasswordAndSalt
	 * @描述 合并盐值和密码 按照一定规则
	 * @param salt
	 * @param password
	 * @return String
	 * @作者 zdyang
	 * @时间 2014年4月7日 下午10:47:47
	 */
	private static String mergePasswordAndSalt(String salt, String password) {
		if (password == null) {
			return null;
		}

		if ((salt == null) || "".equals(salt))
			salt = "";
		StringBuffer newSalt = new StringBuffer(salt);
		newSalt.reverse();
		return password + "{" + newSalt.toString() + "}";
	}

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * @方法名 byteToHexString
	 * @描述 将一个字节转化为十六进制字符串
	 * @param b
	 * @return String
	 * @作者 zdyang
	 * @时间 2014年4月7日 下午10:56:27
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}
	
	public static void main(String[] args) {
		System.out.println(SHA256("杨贝贝", "baozi.1989"));
	}

}