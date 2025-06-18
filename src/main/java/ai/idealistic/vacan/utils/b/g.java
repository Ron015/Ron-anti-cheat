package ai.idealistic.vacan.utils.b;

public class g {
   public static float fu() {
      float var0 = 0.5F;
      return var0 * var0 * var0 * 8.0F;
   }

   public static float u(int var0) {
      return fu() * 0.15F * (float)var0;
   }

   public static int p(float var0) {
      for(int var1 = 1; var1 <= 200; ++var1) {
         float var2 = u(var1);
         float var3 = var0 / var2;
         int var4 = (int)var3;
         if ((double)Math.abs(var3 - (float)var4) < 0.001D) {
            return var1;
         }
      }

      return -1;
   }
}
