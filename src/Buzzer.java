import javax.sound.sampled.*;

public class Buzzer {

    public static void playBeep(int durationMs) {
        try {
            float sampleRate = 8000f;
            int totalSamples = durationMs * 8;
            byte[] buf = new byte[totalSamples];
            for (int i = 0; i < totalSamples; i++) {
                double angle = i / (sampleRate / 800) * 2.0 * Math.PI;
                buf[i] = (byte) (Math.sin(angle) * 127.0);
            }

            AudioFormat af = new AudioFormat(sampleRate, 8, 1, true, false);
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
            sdl.write(buf, 0, buf.length);
            sdl.drain();
            sdl.stop();
            sdl.close();
        } catch (Exception e) {
            System.out.println("Erro ao tocar som: " + e.getMessage());
        }
    }
}