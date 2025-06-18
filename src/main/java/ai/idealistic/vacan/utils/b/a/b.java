package ai.idealistic.vacan.utils.b.a;

import ai.idealistic.vacan.utils.a.d;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lombok.Generated;

public final class b {
   public static final double kE = Math.pow(2.0D, 24.0D);

   private static double Q(double var0) {
      double var2 = 1.0D / (1.0D + 0.5D * Math.abs(var0));
      double var4 = var2 * Math.exp(-(var0 * var0) - 1.26551223D + var2 * (1.00002368D + var2 * (0.37409196D + var2 * (0.09678418D + var2 * (-0.18628806D + var2 * (0.27886807D + var2 * (-1.13520398D + var2 * (1.48851587D + var2 * (-0.82215223D + var2 * 0.17087277D)))))))));
      return var0 >= 0.0D ? 1.0D - var4 : var4 - 1.0D;
   }

   public static double R(double var0) {
      return 0.5D * (1.0D + Q(var0 / ai.idealistic.vacan.utils.b.a.ki));
   }

   public static double c(Collection<? extends Number> var0) {
      int var1 = 0;
      double var2 = 0.0D;
      double var4 = 0.0D;

      Iterator var8;
      Number var9;
      for(var8 = var0.iterator(); var8.hasNext(); ++var1) {
         var9 = (Number)var8.next();
         var2 += var9.doubleValue();
      }

      double var6 = var2 / (double)var1;

      for(var8 = var0.iterator(); var8.hasNext(); var4 += Math.pow(var9.doubleValue() - var6, 2.0D)) {
         var9 = (Number)var8.next();
      }

      return var4 / (double)var1;
   }

   public static double d(Collection<? extends Number> var0) {
      double var1 = Double.MAX_VALUE;

      Number var4;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var1 = Math.min(var1, var4.doubleValue())) {
         var4 = (Number)var3.next();
      }

      return var1;
   }

   public static float S(double var0) {
      float var2 = (float)((double)((float)var0) * 0.6D + 0.2D);
      return var2 * var2 * var2 * 8.0F;
   }

   public static float T(double var0) {
      return S(var0) * 0.15F;
   }

   public static double e(Collection<? extends Number> var0) {
      double var1 = Double.MIN_VALUE;

      Number var4;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var1 = Math.max(var1, var4.doubleValue())) {
         var4 = (Number)var3.next();
      }

      return var1;
   }

   public static double f(Collection<? extends Number> var0) {
      double var1 = c(var0);
      return Math.sqrt(var1);
   }

   public static double g(Collection<? extends Number> var0) {
      double var1 = 0.0D;
      int var3 = 0;
      ArrayList var4 = Lists.newArrayList();
      Iterator var5 = var0.iterator();

      while(var5.hasNext()) {
         Number var6 = (Number)var5.next();
         var1 += var6.doubleValue();
         ++var3;
         var4.add(var6.doubleValue());
      }

      Collections.sort(var4);
      double var11 = var1 / (double)var3;
      double var7 = var3 % 2 != 0 ? (Double)var4.get(var3 / 2) : ((Double)var4.get((var3 - 1) / 2) + (Double)var4.get(var3 / 2)) / 2.0D;
      double var9 = c(var0);
      return 3.0D * (var11 - var7) / var9;
   }

   public static double h(Collection<? extends Number> var0) {
      double var1 = 0.0D;

      Number var4;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var1 += var4.doubleValue()) {
         var4 = (Number)var3.next();
      }

      return var1 / (double)var0.size();
   }

   public static double i(Collection<? extends Number> var0) {
      double var1 = 0.0D;
      int var3 = 0;

      for(Iterator var4 = var0.iterator(); var4.hasNext(); ++var3) {
         Number var5 = (Number)var4.next();
         var1 += var5.doubleValue();
      }

      if ((double)var3 < 3.0D) {
         return 0.0D;
      } else {
         double var16 = (double)var3 * ((double)var3 + 1.0D) / (((double)var3 - 1.0D) * ((double)var3 - 2.0D) * ((double)var3 - 3.0D));
         double var6 = 3.0D * Math.pow((double)var3 - 1.0D, 2.0D) / (((double)var3 - 2.0D) * ((double)var3 - 3.0D));
         double var8 = var1 / (double)var3;
         double var10 = 0.0D;
         double var12 = 0.0D;

         Number var15;
         for(Iterator var14 = var0.iterator(); var14.hasNext(); var12 += Math.pow(var8 - var15.doubleValue(), 4.0D)) {
            var15 = (Number)var14.next();
            var10 += Math.pow(var8 - var15.doubleValue(), 2.0D);
         }

         return var16 * (var12 / Math.pow(var10 / var1, 2.0D)) - var6;
      }
   }

   public static long j(Collection<? extends Number> var0) {
      long var1 = (Long)var0.toArray()[0];
      long var3 = 0L;
      Iterator var5 = var0.iterator();

      while(var5.hasNext()) {
         Number var6 = (Number)var5.next();
         int var7 = 1;
         Iterator var8 = var0.iterator();

         while(var8.hasNext()) {
            Number var9 = (Number)var8.next();
            if (var9.equals(var6)) {
               ++var7;
            }

            if ((long)var7 > var3) {
               var1 = (Long)var6;
               var3 = (long)var7;
            }
         }
      }

      return var1;
   }

   public static float d(float var0, float var1) {
      float var2 = var0 % 360.0F;
      float var3 = var1 % 360.0F;
      float var4 = Math.abs(var2 - var3);
      return (float)Math.abs(Math.min(360.0D - (double)var4, (double)var4));
   }

   public static double a(Double[] var0) {
      double var1 = -1.0D;
      int var3 = 0;

      for(int var4 = 0; var4 < var0.length; ++var4) {
         double var5 = var0[var4];
         int var7 = 1;

         for(int var8 = var4 + 1; var8 < var0.length; ++var8) {
            if (Math.abs(var0[var8] - var5) < 0.001D) {
               ++var7;
            }
         }

         if (var7 > var3) {
            var3 = var7;
            var1 = var5;
         } else if (var7 == var3) {
            var1 = Double.NaN;
         }
      }

      return var1;
   }

   private static double c(List<Double> var0) {
      return var0.size() % 2 == 0 ? ((Double)var0.get(var0.size() / 2) + (Double)var0.get(var0.size() / 2 - 1)) / 2.0D : (Double)var0.get(var0.size() / 2);
   }

   public static boolean a(Number var0) {
      return var0.doubleValue() < 1.0D && (Double.toString(var0.doubleValue()).contains("E") || var0.doubleValue() == 0.0D);
   }

   public static boolean b(Number var0) {
      return var0.doubleValue() > 10000.0D && Double.toString(var0.doubleValue()).contains("E");
   }

   public static long b(long var0, long var2) {
      return var2 <= 16384L ? var0 : b(var2, var0 % var2);
   }

   public static double m(double var0, double var2) {
      if (var0 == var2) {
         return 0.0D;
      } else if (var0 < var2) {
         return m(var2, var0);
      } else {
         return Math.abs(var2) < 1.0E-5D ? var0 : m(var2, var0 - Math.floor(var0 / var2) * var2);
      }
   }

   public static long e(float var0, float var1) {
      long var2 = (long)((double)var0 * kE);
      long var4 = (long)((double)var1 * kE);
      return b(var2, var4);
   }

   public static long n(double var0, double var2) {
      long var4 = (long)(var0 * kE);
      long var6 = (long)(var2 * kE);
      return b(var4, var6);
   }

   public static float d(List<Float> var0) {
      float var1 = (Float)var0.get(0);

      for(int var2 = 1; var2 < var0.size(); ++var2) {
         var1 = f((Float)var0.get(var2), var1);
         if ((double)var1 < 1.0E-7D) {
            return 0.0F;
         }
      }

      return var1;
   }

   public static float f(float var0, float var1) {
      if (var0 == 0.0F) {
         return var1;
      } else {
         int var2 = g(var1, var0);
         float var3 = (var1 / var0 - (float)var2) * var0;
         if (Math.abs(var3) < Math.max(var0, var1) * 0.001F) {
            var3 = 0.0F;
         }

         return f(var3, var0);
      }
   }

   public static int g(float var0, float var1) {
      float var2 = var0 / var1;
      float var3 = Math.max(var0, var1) * 0.001F;
      return (int)(var2 + var3);
   }

   public static double k(Collection<? extends Number> var0) {
      return 20.0D / h(var0);
   }

   public static int l(Collection<? extends Number> var0) {
      return var0.size() - n(var0);
   }

   public static d<List<Double>, List<Double>> m(Collection<? extends Number> var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Number var3 = (Number)var2.next();
         var1.add(var3.doubleValue());
      }

      double var15 = c(var1.subList(0, var1.size() / 2));
      double var4 = c(var1.subList(var1.size() / 2, var1.size()));
      double var6 = Math.abs(var15 - var4);
      double var8 = var15 - 1.5D * var6;
      double var10 = var4 + 1.5D * var6;
      d var12 = new d(new ArrayList(), new ArrayList());
      Iterator var13 = var1.iterator();

      while(var13.hasNext()) {
         Double var14 = (Double)var13.next();
         if (var14 < var8) {
            ((List)var12.fr()).add(var14);
         } else if (var14 > var10) {
            ((List)var12.fs()).add(var14);
         }
      }

      return var12;
   }

   public static List<Long> e(List<Integer> var0) {
      ArrayList var1 = new ArrayList();
      Iterator var2 = var0.iterator();

      while(var2.hasNext()) {
         Integer var3 = (Integer)var2.next();
         if (var3 != null) {
            var1.add(var3.longValue());
         } else {
            var1.add((Object)null);
         }
      }

      return var1;
   }

   public static int n(Collection<? extends Number> var0) {
      return (int)var0.stream().distinct().count();
   }

   public static double o(double var0, double var2) {
      return Math.sqrt(var0 * var0 + var2 * var2);
   }

   @Generated
   private b() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
