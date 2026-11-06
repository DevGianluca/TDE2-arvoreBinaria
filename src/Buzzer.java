import javax.sound.sampled.*;

public class Buzzer {

    public static void playBeep(int durationMs) {
        try {
            float sampleRate = 8000f;
            byte[] buf = new byte[1];
            AudioFormat af = new AudioFormat(sampleRate, 8, 1, true, false);
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
            for (int i = 0; i < durationMs * 8; i++) {
                double angle = i / (sampleRate / 800) * 2.0 * Math.PI;
                buf[0] = (byte) (Math.sin(angle) * 127.0);
                sdl.write(buf, 0, 1);
            }

            sdl.drain();
            sdl.stop();
            sdl.close();
        } catch (Exception e) {
            System.out.println("Erro ao tocar som: " + e.getMessage());
        }
    }
}