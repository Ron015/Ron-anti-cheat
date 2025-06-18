package ai.idealistic.vacan.utils.b;

public class d implements b {
   private static final float[] kv = new float[4096];
   private static final float ks = N(651.8986469044033D);

   public float d(float var1) {
      return kv[(int)(var1 * ks) & 4095];
   }

   public float e(float var1) {
      return kv[(int)(var1 * ks + 1024.0F) & 4095];
   }

   public static float N(double var0) {
      return (float)((double)Math.round(var0 * 1.0E8D) / 1.0E8D);
   }

   static {
      for(int var0 = 0; var0 < kv.length; ++var0) {
         kv[var0] = N(Math.sin((double)var0 * 3.141592653589793D * 2.0D / 4096.0D));
      }

   }
}
