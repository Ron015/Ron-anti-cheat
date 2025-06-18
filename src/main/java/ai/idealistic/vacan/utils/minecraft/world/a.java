package ai.idealistic.vacan.utils.minecraft.world;

import java.util.Iterator;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.Material;

public class a {
   public static boolean a(double[][] var0, ai.idealistic.vacan.abstraction.g.b var1, boolean var2, Material var3) {
      if (var3 != null) {
         double[][] var4 = var0;
         int var5 = var0.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            double[] var7 = var4[var6];
            if (var2) {
               Iterator var11 = var1.e(var7[0], var7[1], var7[2]).iterator();

               while(var11.hasNext()) {
                  ai.idealistic.vacan.abstraction.g.b var9 = (ai.idealistic.vacan.abstraction.g.b)var11.next();
                  Material var10 = var9.dO().dA();
                  if (var10 != null && var3 == var10) {
                     return true;
                  }
               }
            } else {
               Material var8 = var1.dC().d(var7[0], var7[1], var7[2]).dO().dA();
               if (var8 != null && var3 == var8) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean a(double[][] var0, Location var1, boolean var2, Material var3) {
      return a(var0, new ai.idealistic.vacan.abstraction.g.b(var1), var2, var3);
   }

   @SafeVarargs
   public static boolean a(double[][] var0, ai.idealistic.vacan.abstraction.g.b var1, boolean var2, Set<Material>... var3) {
      double[][] var4 = var0;
      int var5 = var0.length;

      label54:
      for(int var6 = 0; var6 < var5; ++var6) {
         double[] var7 = var4[var6];
         if (!var2) {
            Material var15 = var1.dC().d(var7[0], var7[1], var7[2]).dO().dA();
            if (var15 != null) {
               Set[] var16 = var3;
               int var17 = var3.length;

               for(int var18 = 0; var18 < var17; ++var18) {
                  Set var19 = var16[var18];
                  if (var19.contains(var15)) {
                     return true;
                  }
               }
            }
         } else {
            Iterator var8 = var1.e(var7[0], var7[1], var7[2]).iterator();

            while(true) {
               Material var10;
               do {
                  if (!var8.hasNext()) {
                     continue label54;
                  }

                  ai.idealistic.vacan.abstraction.g.b var9 = (ai.idealistic.vacan.abstraction.g.b)var8.next();
                  var10 = var9.dO().dA();
               } while(var10 == null);

               Set[] var11 = var3;
               int var12 = var3.length;

               for(int var13 = 0; var13 < var12; ++var13) {
                  Set var14 = var11[var13];
                  if (var14.contains(var10)) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   @SafeVarargs
   public static boolean a(double[][] var0, Location var1, boolean var2, Set<Material>... var3) {
      return a(var0, new ai.idealistic.vacan.abstraction.g.b(var1), var2, var3);
   }

   @SafeVarargs
   public static boolean a(double[] var0, ai.idealistic.vacan.abstraction.g.b var1, boolean var2, Set<Material>... var3) {
      double var4 = var0[0];
      double var6 = var0[1];
      double var8 = var0[2];
      if (var2) {
         Iterator var10 = var1.e(var4, var6, var8).iterator();

         while(true) {
            Material var12;
            do {
               if (!var10.hasNext()) {
                  return false;
               }

               ai.idealistic.vacan.abstraction.g.b var11 = (ai.idealistic.vacan.abstraction.g.b)var10.next();
               var12 = var11.dO().dA();
            } while(var12 == null);

            Set[] var13 = var3;
            int var14 = var3.length;

            for(int var15 = 0; var15 < var14; ++var15) {
               Set var16 = var13[var15];
               if (var16.contains(var12)) {
                  return true;
               }
            }
         }
      } else {
         Material var17 = var1.dC().d(var4, var6, var8).dO().dA();
         if (var17 != null) {
            Set[] var18 = var3;
            int var19 = var3.length;

            for(int var20 = 0; var20 < var19; ++var20) {
               Set var21 = var18[var20];
               if (var21.contains(var17)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   @SafeVarargs
   public static boolean a(double[] var0, Location var1, boolean var2, Set<Material>... var3) {
      return a(var0, new ai.idealistic.vacan.abstraction.g.b(var1), var2, var3);
   }
}
