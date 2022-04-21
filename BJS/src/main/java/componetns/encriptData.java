package componetns;

import org.apache.commons.codec.binary.Base64;

public class encriptData {
static String a = "AnuragSinha";
	public static String encodePasswrod() throws Exception {
		byte[] encodingValue = Base64.encodeBase64(a.getBytes());
		System.out.println("Encoded String : " + new String(encodingValue));
		/*byte[] decodedValue = Base64.decodeBase64(encodingValue);
		System.out.println("Decoded String : " + new String(decodedValue));*/
		return a;
	}

	public static void main(String[] args) throws Exception {
		encodePasswrod();
	}
}
