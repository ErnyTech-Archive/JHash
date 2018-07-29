package jhash;

import jhash.util.BytesToHex;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;

public class JHash {
    private JHashApi jHashApi;
    private Thread jHashThread;

    public JHash(JHashApi jHashApi) {
        this.jHashApi = jHashApi;
    }

    public void execute(Callback callback) {
        this.jHashThread = new Thread(() -> {
            byte[] bytes = this.jHashApi.getBytes();
            BytesToHex bytesToHex = new BytesToHex(bytes);
            String hex = bytesToHex.toString();
            callback.onSuccess(hex, bytes);
        });
        this.jHashThread.start();
    }

    public void cancel() {
        this.jHashThread.interrupt();
    }
}
