package ai.idealistic.vacan.utils.b;

import java.util.Random;
import java.util.UUID;

public class c {
   public static final float kj = f(2.0F);
   private static final int kk = 12;
   private static final int kl = 4095;
   private static final int km = 4096;
   public static final float kn = 3.1415927F;
   public static final float ko = 6.2831855F;
   public static final float kp = 1.5707964F;
   private static final float kq = 6.2831855F;
   private static final float kr = 360.0F;
   private static final float ks = 651.8986F;
   private static final float kt = 11.377778F;
   public static final float ku = 0.017453292F;
   private static final float[] kv = new float[4096];
   public static boolean kw = true;
   private static final float[] kx = new float[65536];
   private static final int[] ky;

   public static float d(float var0) {
      return kw ? kv[(int)(var0 * 651.8986F) & 4095] : kx[(int)(var0 * 10430.378F) & '\uffff'];
   }

   public static float e(float var0) {
      return kw ? kv[(int)((var0 + 1.5707964F) * 651.8986F) & 4095] : kx[(int)(var0 * 10430.378F + 16384.0F) & '\uffff'];
   }

   public static float f(float var0) {
      return (float)Math.sqrt((double)var0);
   }

   public static float G(double var0) {
      return (float)Math.sqrt(var0);
   }

   public static int g(float var0) {
      int var1 = (int)var0;
      return var0 < (float)var1 ? var1 - 1 : var1;
   }

   public static int H(double var0) {
      return (int)(var0 + 1024.0D) - 1024;
   }

   public static int I(double var0) {
      int var2 = (int)var0;
      return var0 < (double)var2 ? var2 - 1 : var2;
   }

   public static long J(double var0) {
      long var2 = (long)var0;
      return var0 < (double)var2 ? var2 - 1L : var2;
   }

   public static int K(double var0) {
      return (int)(var0 >= 0.0D ? var0 : -var0 + 1.0D);
   }

   public static float h(float var0) {
      return var0 >= 0.0F ? var0 : -var0;
   }

   public static int p(int var0) {
      return var0 >= 0 ? var0 : -var0;
   }

   public static int i(float var0) {
      int var1 = (int)var0;
      return var0 > (float)var1 ? var1 + 1 : var1;
   }

   public static int L(double var0) {
      int var2 = (int)var0;
      return var0 > (double)var2 ? var2 + 1 : var2;
   }

   public static int b(int var0, int var1, int var2) {
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }

   public static float a(float var0, float var1, float var2) {
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }

   public static double h(double var0, double var2, double var4) {
      return var0 < var2 ? var2 : (var0 > var4 ? var4 : var0);
   }

   public static double i(double var0, double var2, double var4) {
      return var4 < 0.0D ? var0 : (var4 > 1.0D ? var2 : var0 + (var2 - var0) * var4);
   }

   public static double k(double var0, double var2) {
      if (var0 < 0.0D) {
         var0 = -var0;
      }

      if (var2 < 0.0D) {
         var2 = -var2;
      }

      return var0 > var2 ? var0 : var2;
   }

   public static int h(int var0, int var1) {
      return var0 < 0 ? -((-var0 - 1) / var1) - 1 : var0 / var1;
   }

   public static int a(Random var0, int var1, int var2) {
      return var1 >= var2 ? var1 : var0.nextInt(var2 - var1 + 1) + var1;
   }

   public static float a(Random var0, float var1, float var2) {
      return var1 >= var2 ? var1 : var0.nextFloat() * (var2 - var1) + var1;
   }

   public static double a(Random var0, double var1, double var3) {
      return var1 >= var3 ? var1 : var0.nextDouble() * (var3 - var1) + var1;
   }

   public static double a(long[] var0) {
      long var1 = 0L;
      long[] var3 = var0;
      int var4 = var0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         long var6 = var3[var5];
         var1 += var6;
      }

      return (double)var1 / (double)var0.length;
   }

   public static boolean b(float var0, float var1) {
      return h(var1 - var0) < 1.0E-5F;
   }

   public static int i(int var0, int var1) {
      return (var0 % var1 + var1) % var1;
   }

   public static float j(float var0) {
      var0 %= 360.0F;
      if (var0 >= 180.0F) {
         var0 -= 360.0F;
      }

      if (var0 < -180.0F) {
         var0 += 360.0F;
      }

      return var0;
   }

   public static double M(double var0) {
      var0 %= 360.0D;
      if (var0 >= 180.0D) {
         var0 -= 360.0D;
      }

      if (var0 < -180.0D) {
         var0 += 360.0D;
      }

      return var0;
   }

   public static int i(String var0, int var1) {
      try {
         return Integer.parseInt(var0);
      } catch (Throwable var3) {
         return var1;
      }
   }

   public static int c(String var0, int var1, int var2) {
      return Math.max(var2, i(var0, var1));
   }

   public static double b(String var0, double var1) {
      try {
         return Double.parseDouble(var0);
      } catch (Throwable var4) {
         return var1;
      }
   }

   public static double a(String var0, double var1, double var3) {
      return Math.max(var3, b(var0, var1));
   }

   public static int q(int var0) {
      int var1 = var0 - 1;
      var1 |= var1 >> 1;
      var1 |= var1 >> 2;
      var1 |= var1 >> 4;
      var1 |= var1 >> 8;
      var1 |= var1 >> 16;
      return var1 + 1;
   }

   private static boolean r(int var0) {
      return var0 != 0 && (var0 & var0 - 1) == 0;
   }

   private static int s(int var0) {
      var0 = r(var0) ? var0 : q(var0);
      return ky[(int)((long)var0 * 125613361L >> 27) & 31];
   }

   public static int t(int var0) {
      return s(var0) - (r(var0) ? 0 : 1);
   }

   public static int j(int var0, int var1) {
      if (var1 == 0) {
         return 0;
      } else if (var0 == 0) {
         return var1;
      } else {
         if (var0 < 0) {
            var1 *= -1;
         }

         int var2 = var0 % var1;
         return var2 == 0 ? var0 : var0 + var1 - var2;
      }
   }

   public static int b(float var0, float var1, float var2) {
      return c(g(var0 * 255.0F), g(var1 * 255.0F), g(var2 * 255.0F));
   }

   public static int c(int var0, int var1, int var2) {
      int var3 = (var0 << 8) + var1;
      var3 = (var3 << 8) + var2;
      return var3;
   }

   public static int k(int var0, int var1) {
      int var2 = (var0 & 16711680) >> 16;
      int var3 = (var1 & 16711680) >> 16;
      int var4 = (var0 & '\uff00') >> 8;
      int var5 = (var1 & '\uff00') >> 8;
      int var6 = var0 & 255;
      int var7 = var1 & 255;
      int var8 = (int)((float)var2 * (float)var3 / 255.0F);
      int var9 = (int)((float)var4 * (float)var5 / 255.0F);
      int var10 = (int)((float)var6 * (float)var7 / 255.0F);
      return var0 & -16777216 | var8 << 16 | var9 << 8 | var10;
   }

   public static long d(int var0, int var1, int var2) {
      long var3 = (long)var0 * 3129871L ^ (long)var2 * 116129781L ^ (long)var1;
      var3 = var3 * var3 * 42317861L + var3 * 11L;
      return var3;
   }

   public static UUID a(Random var0) {
      long var1 = var0.nextLong() & -61441L | 16384L;
      long var3 = var0.nextLong() & 4611686018427387903L | Long.MIN_VALUE;
      return new UUID(var1, var3);
   }

   static {
      int var0;
      for(var0 = 0; var0 < 65536; ++var0) {
         kx[var0] = (float)Math.sin((double)var0 * 3.141592653589793D * 2.0D / 65536.0D);
      }

      ky = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};

      for(var0 = 0; var0 < 4096; ++var0) {
         kv[var0] = (float)Math.sin((double)(((float)var0 + 0.5F) / 4096.0F * 6.2831855F));
      }

      for(var0 = 0; var0 < 360; var0 += 90) {
         kv[(int)((float)var0 * 11.377778F) & 4095] = (float)Math.sin((double)((float)var0 * 0.017453292F));
      }

   }
}
