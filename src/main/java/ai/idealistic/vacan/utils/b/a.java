package ai.idealistic.vacan.utils.b;

import java.util.Random;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.util.NumberConversions;
import org.bukkit.util.Vector;

public final class a {
   public static final double ki = Math.sqrt(2.0D);

   public static int z(double var0) {
      return NumberConversions.floor(var0);
   }

   public static int A(double var0) {
      return NumberConversions.round(var0);
   }

   public static int B(double var0) {
      return NumberConversions.ceil(var0);
   }

   public static double e(int var0, int var1) {
      return (double)var0 + (var1 == 0 ? 0.0D : (double)var1 / Math.pow(10.0D, (double)(1 + (int)Math.log10((double)var1))));
   }

   public static double e(double var0, double var2) {
      var2 = (double)((int)Math.pow(10.0D, var2));
      return Math.floor(var0 * var2) / var2;
   }

   public static float a(float var0, double var1) {
      var1 = (double)((int)Math.pow(10.0D, var1));
      return (float)(Math.floor((double)var0 * var1) / var1);
   }

   public static double C(double var0) {
      return var0 - Math.floor(var0);
   }

   public static double f(double var0, double var2) {
      return Math.floor(var0 * var2) / var2;
   }

   public static double g(double var0, double var2) {
      return Math.ceil(var0 * var2) / var2;
   }

   public static double h(double var0, double var2) {
      return Math.floor(var0 * var2) / var2;
   }

   public static int a(Number var0, int var1) {
      return (int)((long)var1 * Math.round(var0.doubleValue() / (double)var1));
   }

   public static int b(Number var0, int var1) {
      return (int)((double)var1 * Math.floor(var0.doubleValue() / (double)var1));
   }

   public static int c(Number var0, int var1) {
      return (int)((double)var1 * Math.ceil(var0.doubleValue() / (double)var1));
   }

   public static int o(int var0) {
      int var1 = 0;
      int var2 = var0 - 1;

      for(int var3 = 0; var3 < var2; ++var3) {
         --var0;
         var1 += var0;
      }

      return var1;
   }

   public static int f(int var0, int var1) {
      int var2 = var0 - 1;

      for(int var3 = 0; var3 < var2; ++var3) {
         --var0;
         if (var3 == var1) {
            return var0;
         }
      }

      return 0;
   }

   public static double i(double var0, double var2) {
      double var4 = var0 - var2;
      return var4 * var4;
   }

   public static double a(double var0, double var2, double var4, double var6, double var8, double var10) {
      return i(var0, var2) + i(var4, var6) + i(var8, var10);
   }

   public static double b(double var0, double var2, double var4, double var6, double var8, double var10) {
      return Math.sqrt(a(var0, var2, var4, var6, var8, var10));
   }

   public static int b(double var0, int var2) {
      return B(var0 * (double)var2);
   }

   public static double g(double var0, double var2, double var4) {
      return var4 <= var0 ? var2 : g(var0, var4, var2 % var4);
   }

   public static double a(Location var0, Vector var1) {
      return Math.sqrt(i(var0.getX(), var1.getX()) + i(var0.getZ(), var1.getZ()));
   }

   public static double a(Vector var0, Location var1) {
      return a(var1, var0);
   }

   public static double a(ai.idealistic.vacan.abstraction.g.b var0, Vector var1) {
      return Math.sqrt(i(var0.dT(), var1.getX()) + i(var0.dV(), var1.getZ()));
   }

   public static double a(Vector var0, ai.idealistic.vacan.abstraction.g.b var1) {
      return a(var1, var0);
   }

   public static double a(Location var0, ai.idealistic.vacan.abstraction.g.b var1) {
      return Math.sqrt(i(var0.getX(), var1.dT()) + i(var0.getZ(), var1.dV()));
   }

   public static double a(ai.idealistic.vacan.abstraction.g.b var0, Location var1) {
      return a(var1, var0);
   }

   public static double b(Vector var0, Vector var1) {
      return Math.sqrt(i(var0.getX(), var1.getX()) + i(var0.getZ(), var1.getZ()));
   }

   public static double f(Location var0, Location var1) {
      return Math.sqrt(i(var0.getX(), var1.getX()) + i(var0.getZ(), var1.getZ()));
   }

   public static double a(ai.idealistic.vacan.abstraction.g.b var0, ai.idealistic.vacan.abstraction.g.b var1) {
      return Math.sqrt(i(var0.dT(), var1.dT()) + i(var0.dV(), var1.dV()));
   }

   public static double b(Location var0, ai.idealistic.vacan.abstraction.g.b var1) {
      return Math.sqrt(i(var0.getY(), var1.dU()));
   }

   public static double b(ai.idealistic.vacan.abstraction.g.b var0, Location var1) {
      return b(var1, var0);
   }

   public static double g(Location var0, Location var1) {
      return Math.sqrt(i(var0.getY(), var1.getY()));
   }

   public static double b(ai.idealistic.vacan.abstraction.g.b var0, ai.idealistic.vacan.abstraction.g.b var1) {
      return Math.sqrt(i(var0.dU(), var1.dU()));
   }

   public static float c(float var0) {
      var0 %= 360.0F;
      if (var0 >= 180.0F) {
         var0 -= 360.0F;
      }

      if (var0 < -180.0F) {
         var0 += 360.0F;
      }

      return var0;
   }

   public static double D(double var0) {
      var0 %= 360.0D;
      if (var0 >= 180.0D) {
         var0 -= 360.0D;
      }

      if (var0 < -180.0D) {
         var0 += 360.0D;
      }

      return var0;
   }

   public static int g(int var0, int var1) {
      return (new Random()).nextInt(Math.abs(var1 - var0)) + var0;
   }

   public static double j(double var0, double var2) {
      return var0 + (var2 - var0) * (new Random()).nextDouble();
   }

   public static float a(float var0, float var1) {
      return var0 + (var1 - var0) * (new Random()).nextFloat();
   }

   public static Integer ak(String var0) {
      try {
         return Integer.parseInt(var0);
      } catch (Exception var2) {
         return null;
      }
   }

   public static boolean al(String var0) {
      try {
         Integer.parseInt(var0);
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   public static boolean am(String var0) {
      try {
         Long.parseLong(var0);
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   public static Double an(String var0) {
      try {
         return Double.parseDouble(var0);
      } catch (Exception var2) {
         return null;
      }
   }

   public static boolean ao(String var0) {
      try {
         Double.parseDouble(var0);
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   public static Float ap(String var0) {
      try {
         return Float.parseFloat(var0);
      } catch (Exception var2) {
         return null;
      }
   }

   public static boolean aq(String var0) {
      try {
         Float.parseFloat(var0);
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   public static boolean ar(String var0) {
      if (var0 != null && var0.length() != 0) {
         char[] var1 = var0.toCharArray();
         int var2 = var1.length;
         boolean var3 = false;
         boolean var4 = false;
         boolean var5 = false;
         boolean var6 = false;
         int var7 = var1[0] == '-' ? 1 : 0;
         int var8;
         if (var2 > var7 + 1 && var1[var7] == '0' && var1[var7 + 1] == 'x') {
            var8 = var7 + 2;
            if (var8 == var2) {
               return false;
            } else {
               while(var8 < var1.length) {
                  if ((var1[var8] < '0' || var1[var8] > '9') && (var1[var8] < 'a' || var1[var8] > 'f') && (var1[var8] < 'A' || var1[var8] > 'F')) {
                     return false;
                  }

                  ++var8;
               }

               return true;
            }
         } else {
            --var2;

            for(var8 = var7; var8 < var2 || var8 < var2 + 1 && var5 && !var6; ++var8) {
               if (var1[var8] >= '0' && var1[var8] <= '9') {
                  var6 = true;
                  var5 = false;
               } else if (var1[var8] == '.') {
                  if (var4 || var3) {
                     return false;
                  }

                  var4 = true;
               } else if (var1[var8] != 'e' && var1[var8] != 'E') {
                  if (var1[var8] != '+' && var1[var8] != '-') {
                     return false;
                  }

                  if (!var5) {
                     return false;
                  }

                  var5 = false;
                  var6 = false;
               } else {
                  if (var3) {
                     return false;
                  }

                  if (!var6) {
                     return false;
                  }

                  var3 = true;
                  var5 = true;
               }
            }

            if (var8 < var1.length) {
               if (var1[var8] >= '0' && var1[var8] <= '9') {
                  return true;
               } else if (var1[var8] != 'e' && var1[var8] != 'E') {
                  if (var1[var8] == '.') {
                     return !var4 && !var3 && var6;
                  } else if (!var5 && (var1[var8] == 'd' || var1[var8] == 'D' || var1[var8] == 'f' || var1[var8] == 'F')) {
                     return var6;
                  } else if (var1[var8] != 'l' && var1[var8] != 'L') {
                     return false;
                  } else {
                     return var6 && !var3 && !var4;
                  }
               } else {
                  return false;
               }
            } else {
               return !var5 && var6;
            }
         }
      } else {
         return false;
      }
   }

   public static boolean E(double var0) {
      return var0 < 1.0E-4D;
   }

   public static double F(double var0) {
      return (double)((float)var0);
   }

   @Generated
   private a() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
