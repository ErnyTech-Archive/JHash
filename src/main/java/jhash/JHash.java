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
            var bytesToHex = new BytesToHex(bytes);
            var hex = bytesToHex.toString();
            callback.onSuccess(hex, bytes);
        });
        this.jHashThread.start();
    }

    public void cancel() {
        this.jHashThread.interrupt();
    }
}
