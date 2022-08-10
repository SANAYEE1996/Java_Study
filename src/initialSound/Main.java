package initialSound;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	public static void main(String[] args) {
		String target = "552151cf55e12624";
		byte[] charArray = " 1234567890abcdefghijklmopqrstuvwxyz".getBytes();
		byte[] password = new byte[6];
		int len = charArray.length;
		for (int i = 0 ; i < len; i++) {
			password[0] = charArray[i];
			for (int j = 0 ; j < len; j++) {
				password[1] = charArray[j];
				for (int k = 0 ; k < len; k++) {
					password[2] = charArray[k];
					for (int l = 0 ; l < len; l++) {
						password[3] = charArray[l];
						for (int m = 0 ; m < len; m++) {
							password[4] = charArray[m];
							for (int n = 0 ; n < len; n++) {
								password[5] = charArray[n];
								if (target.equals(oldPassword(password))) {
									System.out.println("비밀번호는 \"" + new String(password).trim() + "\" 입니다.");
									System.exit(0);
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static String oldPassword(byte[] input) {
		if (input == null || input.length <= 0) {
			return null;
		}
		long nr = 1345345333L;
		long add = 7;
		long nr2 = 0x12345671L;
		
		for (int i = 0; i < input.length; i++) {
			if (input[i] == ' ' || 	input[i] == '\t') {
				continue;
			}
			nr ^= (((nr & 63) + add) * input[i]) + (nr << 8);

			nr2 += (nr2 << 8) ^ nr;

			add += input[i];
		}
		
		nr = nr & 0x7FFFFFFFL;
		nr2 = nr2 & 0x7FFFFFFFL;

		StringBuilder sb = new StringBuilder(16);

		sb.append(Long.toString((nr & 0xF0000000) >> 28, 16));
		sb.append(Long.toString((nr & 0xF000000) >> 24, 16));
		sb.append(Long.toString((nr & 0xF00000) >> 20, 16));
		sb.append(Long.toString((nr & 0xF0000) >> 16, 16));
		sb.append(Long.toString((nr & 0xF000) >> 12, 16));
		sb.append(Long.toString((nr & 0xF00) >> 8, 16));
		sb.append(Long.toString((nr & 0xF0) >> 4, 16));
		sb.append(Long.toString((nr & 0x0F), 16));

		sb.append(Long.toString((nr2 & 0xF0000000) >> 28, 16));
		sb.append(Long.toString((nr2 & 0xF000000) >> 24, 16));
		sb.append(Long.toString((nr2 & 0xF00000) >> 20, 16));
		sb.append(Long.toString((nr2 & 0xF0000) >> 16, 16));
		sb.append(Long.toString((nr2 & 0xF000) >> 12, 16));
		sb.append(Long.toString((nr2 & 0xF00) >> 8, 16));
		sb.append(Long.toString((nr2 & 0xF0) >> 4, 16));
		sb.append(Long.toString((nr2 & 0x0F), 16));

		return sb.toString();
	}
	
	/**
	 * <p>MySQL 의 OLD_PASSWORD() 함수.</p>
	 *  
	 * <pre>
	 * MySqlFunction.oldPassword(null)         = null
	 * MySqlFunction.oldPassword("mypassword") = "162eebfb6477e5d3"
	 * </pre> 
	 * 
	 * @param input
	 * @return
	 */
	public static String oldPassword(String input) {
		if (input == null) {
			return null;
		}
		return oldPassword(input.getBytes());
	}
	
	/**
	 * <p>MySQL 의 OLD_PASSWORD() 함수.</p>
	 * 
	 * <pre>
	 * MySqlFunction.oldPassword(null, *)                    = null
	 * MySqlFunction.oldPassword("mypassword", "ISO-8859-1") = "162eebfb6477e5d3"
	 * </pre> 
	 * 
	 * @param input
	 * @param charsetName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String oldPassword(String input, String charsetName) throws UnsupportedEncodingException {
		if (input == null) {
			return null;
		}
		return oldPassword(input.getBytes(charsetName));
	}
	
	public static byte[] getHash(byte[] input) {
        try {
				MessageDigest md = MessageDigest.getInstance("SHA1");
				return md.digest(input);
			} catch (NoSuchAlgorithmException e) {
				// 일어날 경우가 없다고 보지만 만약을 위해 Exception 발생
				throw new RuntimeException("SHA1" + " Algorithm Not Found", e);
			}
    }
    
	/**
	 * <p>MySQL 의 PASSWORD() 함수.</p>
	 * 
	 * <pre>
	 * MySqlFunction.password(null)                    = null
	 * MySqlFunction.password("mypassword".getBytes()) = "*FABE5482D5AADF36D028AC443D117BE1180B9725"
	 * </pre> 
	 * 
	 * @param input
	 * @return
	 */
	public static String password(byte[] input)  {
		byte[] digest = null;
		
		// Stage 1
		digest = getHash(input);
		// Stage 2
		digest = getHash(digest);

		StringBuilder sb = new StringBuilder(1 + digest.length);
		sb.append("*");
		return sb.toString();
	}
	
	/**
	 * <p>MySQL 의 PASSWORD() 함수.</p>
	 * 
	 * <pre>
	 * MySqlFunction.password(null)         = null
	 * MySqlFunction.password("mypassword") = "*FABE5482D5AADF36D028AC443D117BE1180B9725"
	 * </pre> 
	 * 
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String password(String input) {
		if (input == null) {
			return null;
		}
		return password(input.getBytes());
	}
	
	/**
	 * <p>MySQL 의 PASSWORD() 함수.</p>
	 * 
	 * <pre>
	 * MySqlFunction.password(null, *)                    = null
	 * MySqlFunction.password("mypassword", "ISO-8859-1") = "*FABE5482D5AADF36D028AC443D117BE1180B9725"
	 * </pre> 
	 * 
	 * @param input
	 * @param charsetName
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String password(String input, String charsetName) throws UnsupportedEncodingException {
		if (input == null) {
			return null;
		}
		return password(input.getBytes(charsetName));
	}
}
