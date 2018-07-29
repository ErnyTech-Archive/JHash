package jhash.util;

public class BytesToHex {
    private byte[] bytes;

    public BytesToHex(byte[] bytes) {
        this.bytes = bytes;
    }

    public String toString() {
        StringBuilder hexString = new StringBuilder();
        for (byte aByte : this.bytes) {
            String hex = Integer.toHexString(0xff & aByte);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
