package ai.idealistic.vacan.utils.b;

import ai.idealistic.vacan.utils.minecraft.entity.MovingObjectPosition;
import java.util.Set;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Zombie;
import org.bukkit.util.Vector;

public final class f {
   private static final boolean[] aF = new boolean[]{true, false};

   public static double l(double var0, double var2) {
      double var4 = Math.pow(10.0D, var2);
      return Math.ceil(var0 * var4) / var4;
   }

   public static boolean a(e var0, e var1, double var2) {
      double var4 = Math.atan2(var0.hq, var0.ho);
      double var6 = Math.atan2(var1.hq, var1.ho);
      double var8 = Math.abs(var4 - var6);
      if (var8 > 3.141592653589793D) {
         var8 = 6.283185307179586D - var8;
      }

      return var8 <= Math.toRadians(var2);
   }

   public static double a(e var0, e var1) {
      double var2 = Math.atan2(var0.hq, var0.ho);
      double var4 = Math.atan2(var1.hq, var1.ho);
      double var6 = Math.abs(var2 - var4);
      if (var6 > 3.141592653589793D) {
         var6 = 6.283185307179586D - var6;
      }

      return Math.toDegrees(var6);
   }

   public static double a(e var0) {
      return Math.atan2(var0.hq, var0.ho);
   }

   public static float k(float var0) {
      return n(l(var0));
   }

   public static float l(float var0) {
      float var1 = Math.abs((var0 + 360.0F) % 360.0F - 180.0F);
      return var1;
   }

   public static float m(float var0) {
      float var1 = Math.abs((var0 + 360.0F) % 360.0F - 180.0F);
      int var2 = (int)Math.floor((double)(var1 / 360.0F));
      return var1 - (float)(var2 * 360);
   }

   public static float n(float var0) {
      int var1 = (int)Math.floor((double)(var0 / 180.0F));
      return var0 - (float)(var1 * 180);
   }

   public static float o(float var0) {
      int var1 = (int)Math.floor((double)(var0 / 360.0F));
      return var0 - (float)(var1 * 360);
   }

   @SafeVarargs
   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, Set<Material>... var2) {
      World var3 = var0.bV();
      Vector var4 = var1.toVector();
      Vector var5 = var4.clone().add(new Vector(-0.3D, -0.5D, -0.3D));
      Vector var6 = var4.clone().add(new Vector(0.3D, 0.1D, 0.3D));

      for(int var7 = var5.getBlockX(); var7 <= var6.getBlockX(); ++var7) {
         for(int var8 = var5.getBlockY(); var8 <= var6.getBlockY(); ++var8) {
            for(int var9 = var5.getBlockZ(); var9 <= var6.getBlockZ(); ++var9) {
               ai.idealistic.vacan.abstraction.g.a var10 = (new ai.idealistic.vacan.abstraction.g.b(var3, (double)var7, (double)var8, (double)var9)).dO();
               Set[] var11 = var2;
               int var12 = var2.length;

               for(int var13 = 0; var13 < var12; ++var13) {
                  Set var14 = var11[var13];
                  if (var14.contains(var10.dz())) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, Set<Material> var2) {
      World var3 = var0.bV();
      Vector var4 = var1.toVector();
      Vector var5 = var4.clone().add(new Vector(-0.3D, -0.5D, -0.3D));
      Vector var6 = var4.clone().add(new Vector(0.3D, 0.1D, 0.3D));

      for(int var7 = var5.getBlockX(); var7 <= var6.getBlockX(); ++var7) {
         for(int var8 = var5.getBlockY(); var8 <= var6.getBlockY(); ++var8) {
            for(int var9 = var5.getBlockZ(); var9 <= var6.getBlockZ(); ++var9) {
               ai.idealistic.vacan.abstraction.g.a var10 = (new ai.idealistic.vacan.abstraction.g.b(var3, (double)var7, (double)var8, (double)var9)).dO();
               if (var2.contains(var10.dz())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, Material var2) {
      World var3 = var0.bV();
      Vector var4 = var1.toVector();
      Vector var5 = var4.clone().add(new Vector(-0.3D, -0.5D, -0.3D));
      Vector var6 = var4.clone().add(new Vector(0.3D, 0.1D, 0.3D));

      for(int var7 = var5.getBlockX(); var7 <= var6.getBlockX(); ++var7) {
         for(int var8 = var5.getBlockY(); var8 <= var6.getBlockY(); ++var8) {
            for(int var9 = var5.getBlockZ(); var9 <= var6.getBlockZ(); ++var9) {
               ai.idealistic.vacan.abstraction.g.a var10 = (new ai.idealistic.vacan.abstraction.g.b(var3, (double)var7, (double)var8, (double)var9)).dO();
               if (var10.dz() == var2) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1) {
      World var2 = var0.bV();
      Vector var3 = var1.toVector();
      Vector var4 = var3.clone().add(new Vector(-0.3D, -0.5D, -0.3D));
      Vector var5 = var3.clone().add(new Vector(0.3D, 0.1D, 0.3D));

      for(int var6 = var4.getBlockX(); var6 <= var5.getBlockX(); ++var6) {
         for(int var7 = var4.getBlockY(); var7 <= var5.getBlockY(); ++var7) {
            for(int var8 = var4.getBlockZ(); var8 <= var5.getBlockZ(); ++var8) {
               ai.idealistic.vacan.abstraction.g.a var9 = (new ai.idealistic.vacan.abstraction.g.b(var2, (double)var6, (double)var7, (double)var8)).dO();
               if (ai.idealistic.vacan.utils.minecraft.world.c.ab(var9.dz())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean b(ai.idealistic.vacan.abstraction.f.c var0, Location var1) {
      World var2 = var0.bV();
      Vector var3 = var1.toVector();
      Vector var4 = var3.clone().add(new Vector(-0.3D, -0.3D, -0.3D));
      Vector var5 = var3.clone().add(new Vector(0.3D, 0.3D, 0.3D));

      for(int var6 = var4.getBlockX(); var6 <= var5.getBlockX(); ++var6) {
         for(int var7 = var4.getBlockY(); var7 <= var5.getBlockY(); ++var7) {
            for(int var8 = var4.getBlockZ(); var8 <= var5.getBlockZ(); ++var8) {
               ai.idealistic.vacan.abstraction.g.a var9 = (new ai.idealistic.vacan.abstraction.g.b(var2, (double)var6, (double)var7, (double)var8)).dO();
               if (ai.idealistic.vacan.utils.minecraft.world.c.ab(var9.dz())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean c(ai.idealistic.vacan.abstraction.f.c var0, Location var1) {
      World var2 = var0.bV();
      Vector var3 = var1.toVector();
      Vector var4 = var3.clone().add(new Vector(-0.3D, 0.0D, -0.3D));
      Vector var5 = var3.clone().add(new Vector(0.3D, 0.5D, 0.3D));

      for(int var6 = var4.getBlockX(); var6 <= var5.getBlockX(); ++var6) {
         for(int var7 = var4.getBlockY(); var7 <= var5.getBlockY(); ++var7) {
            for(int var8 = var4.getBlockZ(); var8 <= var5.getBlockZ(); ++var8) {
               ai.idealistic.vacan.abstraction.g.a var9 = (new ai.idealistic.vacan.abstraction.g.b(var2, (double)var6, (double)var7, (double)var8)).dO();
               if (ai.idealistic.vacan.utils.minecraft.world.c.ab(var9.dz())) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private static float[] a(Player var0, Entity var1) {
      Location var2 = ai.idealistic.vacan.compatibility.b.a.b.f(var1);
      if (var2 == null) {
         return null;
      } else {
         Vector var3 = var2.toVector().subtract(ai.idealistic.vacan.functionality.server.c.i(var0).getLocation().toVector());
         float var4 = (float)Math.toDegrees(Math.atan2(var3.getX(), var3.getZ()));
         float var5 = (float)Math.toDegrees(Math.asin(-var3.getY()));
         return new float[]{l(var4), var5};
      }
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Entity var1, float var2) {
      Location var3 = var0.getLocation();
      boolean var4 = false;
      boolean var5 = false;
      boolean var6;
      if (var1 instanceof Player) {
         Location var7 = ai.idealistic.vacan.compatibility.b.a.b.e((Player)var1);
         if (var7 == null) {
            return false;
         }

         double var8 = var7.getX();
         double var10 = var7.getY();
         double var12 = var7.getZ();
         ai.idealistic.vacan.utils.minecraft.entity.a var14 = new ai.idealistic.vacan.utils.minecraft.entity.a(var8 - (double)var2, var10 - 0.10000000149011612D, var12 - (double)var2, var8 + (double)var2, var10 + 1.899999976158142D, var12 + (double)var2);
         var4 = a(var0, var3, var4, var14);
         var6 = var1.isInsideVehicle();
      } else {
         double var15 = var1.getLocation().getX();
         double var9 = var1.getLocation().getY();
         double var11 = var1.getLocation().getZ();
         ai.idealistic.vacan.utils.minecraft.entity.a var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var15 - (double)var2, var9 - 0.10000000149011612D, var11 - (double)var2, var15 + (double)var2, var9 + 1.899999976158142D, var11 + (double)var2);
         var4 = a(var0, var3, var4, var13);
         var5 = a(var0, var0.bM(), var5, var13);
         var6 = var1.isInsideVehicle() || !(var1 instanceof Villager) && !(var1 instanceof Zombie) && !(var1 instanceof Skeleton) && !(var1 instanceof Creeper);
      }

      return var4 || var5 || var6;
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, Entity var2, float var3, float var4) {
      Location var5 = var0.getLocation();
      boolean var6 = false;
      double var8 = var1.getX();
      double var10 = var1.getY();
      double var12 = var1.getZ();
      ai.idealistic.vacan.utils.minecraft.entity.a var14 = new ai.idealistic.vacan.utils.minecraft.entity.a(var8 - (double)var3, var10 - 0.10000000149011612D, var12 - (double)var3, var8 + (double)var3, var10 + 1.899999976158142D, var12 + (double)var3);
      var6 = a(var0, var5, var6, var14, (double)var4);
      boolean var7 = var2.isInsideVehicle();
      return var6 || var7;
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, Entity var2, float var3) {
      boolean var4 = false;
      double var6 = var1.getX();
      double var8 = var1.getY();
      double var10 = var1.getZ();
      ai.idealistic.vacan.utils.minecraft.entity.a var12 = new ai.idealistic.vacan.utils.minecraft.entity.a(var6 - (double)var3, var8 - 0.10000000149011612D, var10 - (double)var3, var6 + (double)var3, var8 + 1.899999976158142D, var10 + (double)var3);
      var4 = a(var0, var0.bR().dR(), var4, var12);
      boolean var5 = var2.isInsideVehicle();
      return var4 || var5;
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, float var2) {
      Location var3 = var0.getLocation();
      boolean var4 = false;
      double var5 = var1.getX();
      double var7 = var1.getY();
      double var9 = var1.getZ();
      ai.idealistic.vacan.utils.minecraft.entity.a var11 = new ai.idealistic.vacan.utils.minecraft.entity.a(var5 - (double)var2, var7 - (double)var2, var9 - (double)var2, var5 + (double)var2, var7 + (double)var2, var9 + (double)var2);
      var4 = a(var0, var3, var4, var11);
      return var4;
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, float var2, double var3) {
      Location var5 = var0.getLocation();
      boolean var6 = false;
      double var7 = var1.getX();
      double var9 = var1.getY();
      double var11 = var1.getZ();
      ai.idealistic.vacan.utils.minecraft.entity.a var13 = new ai.idealistic.vacan.utils.minecraft.entity.a(var7 - (double)var2, var9 - (double)var2, var11 - (double)var2, var7 + (double)var2, var9 + (double)var2, var11 + (double)var2);
      var6 = a(var0, var5, var6, var13, var3);
      return var6;
   }

   private static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, boolean var2, ai.idealistic.vacan.utils.minecraft.entity.a var3) {
      boolean[] var4 = aF;
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         boolean var10000 = var4[var6];
         boolean[] var8 = aF;
         int var9 = var8.length;

         for(int var10 = 0; var10 < var9; ++var10) {
            boolean var11 = var8[var10];
            float var12 = var1.getYaw();
            float var13 = var1.getPitch();
            MovingObjectPosition var14 = a(var12, var13, var11, var3, var0);
            var2 |= var14 != null && var14.kS != null;
         }
      }

      return var2;
   }

   private static boolean a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, boolean var2, ai.idealistic.vacan.utils.minecraft.entity.a var3, double var4) {
      boolean[] var6 = aF;
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         boolean var10000 = var6[var8];
         boolean[] var10 = aF;
         int var11 = var10.length;

         for(int var12 = 0; var12 < var11; ++var12) {
            boolean var13 = var10[var12];
            float var14 = var1.getYaw();
            float var15 = var1.getPitch();
            MovingObjectPosition var16 = a(var14, var15, var13, var3, var0, var4);
            var2 |= var16 != null && var16.kS != null;
         }
      }

      return var2;
   }

   private static MovingObjectPosition a(float var0, float var1, boolean var2, ai.idealistic.vacan.utils.minecraft.entity.a var3, ai.idealistic.vacan.abstraction.f.c var4) {
      Location var5 = var4.getLocation();
      double var6 = var5.getX();
      double var8 = var5.getY();
      double var10 = var5.getZ();
      ai.idealistic.vacan.utils.minecraft.d.c var12 = new ai.idealistic.vacan.utils.minecraft.d.c(var6, var8 + (double)a(var2, var4), var10);
      ai.idealistic.vacan.utils.minecraft.d.c var13 = c(var1, var0);
      ai.idealistic.vacan.utils.minecraft.d.c var14 = var12.i(new ai.idealistic.vacan.utils.minecraft.d.c(var13.lR * 3.0D, var13.lS * 3.0D, var13.lT * 3.0D));
      return var3.a(var12, var14);
   }

   private static MovingObjectPosition a(float var0, float var1, boolean var2, ai.idealistic.vacan.utils.minecraft.entity.a var3, ai.idealistic.vacan.abstraction.f.c var4, double var5) {
      Location var7 = var4.getLocation();
      double var8 = var7.getX();
      double var10 = var7.getY();
      double var12 = var7.getZ();
      ai.idealistic.vacan.utils.minecraft.d.c var14 = new ai.idealistic.vacan.utils.minecraft.d.c(var8, var10 + (double)a(var2, var4), var12);
      ai.idealistic.vacan.utils.minecraft.d.c var15 = c(var1, var0);
      ai.idealistic.vacan.utils.minecraft.d.c var16 = var14.i(new ai.idealistic.vacan.utils.minecraft.d.c(var15.lR * var5, var15.lS * var5, var15.lT * var5));
      return var3.a(var14, var16);
   }

   private static ai.idealistic.vacan.utils.minecraft.d.c c(float var0, float var1) {
      float var2 = (float)Math.cos((double)(-var1 * 0.017453292F - 3.1415927F));
      float var3 = (float)Math.sin((double)(-var1 * 0.017453292F - 3.1415927F));
      float var4 = (float)(-Math.cos((double)(-var0 * 0.017453292F)));
      float var5 = (float)Math.sin((double)(-var0 * 0.017453292F));
      return new ai.idealistic.vacan.utils.minecraft.d.c((double)(var3 * var4), (double)var5, (double)(var2 * var4));
   }

   public static float a(boolean var0, ai.idealistic.vacan.abstraction.f.c var1) {
      float var2 = 1.62F;
      if (var1.bC().isSleeping()) {
         var2 = 0.2F;
      }

      if (var0) {
         var2 -= 0.08F;
      }

      return var2;
   }

   public static double O(double var0) {
      return var0 - Math.floor(var0);
   }

   public static float b(Player var0, Entity var1) {
      ai.idealistic.vacan.abstraction.f.c var2 = ai.idealistic.vacan.functionality.server.c.i(var0);
      float var3 = 0.01F;
      float var4 = 0.01F;
      boolean var5 = false;

      for(int var6 = 0; var6 < 40; ++var6) {
         if (a(var2, var1, var4)) {
            var3 = var4;
            var5 = true;
         } else {
            var4 += 0.01F;
         }
      }

      return var5 ? var3 : 0.4F;
   }

   public static float a(ai.idealistic.vacan.abstraction.f.c var0, Entity var1) {
      float var2 = 0.01F;
      float var3 = 0.01F;
      boolean var4 = false;

      for(int var5 = 0; var5 < 60; ++var5) {
         if (a(var0, var1, var3)) {
            var2 = var3;
            var4 = true;
         } else {
            var3 += 0.01F;
         }
      }

      return var4 ? var2 : 0.6F;
   }

   public static float a(ai.idealistic.vacan.abstraction.f.c var0, Location var1, Entity var2) {
      float var3 = 0.01F;
      float var4 = 0.01F;
      boolean var5 = false;

      for(int var6 = 0; var6 < 100; ++var6) {
         if (a(var0, var1, var2, var4, 3.0F)) {
            var3 = var4;
            var5 = true;
         } else {
            var4 += 0.01F;
         }
      }

      return var5 ? var3 : 0.6F;
   }

   public static double a(Player var0, Location var1, Location var2, double var3, boolean var5) {
      double var6 = 0.0D;
      double var8 = 0.1D;
      byte var10 = 60;
      float var11 = var1.getYaw();
      double var12 = Math.toRadians((double)var11);
      e var14 = new e(-Math.sin(var12), Math.cos(var12));
      double var15 = (double)a(var5, var0);

      for(int var17 = 0; var17 < var10; ++var17) {
         double var18 = var1.getX() + var14.ho * var6;
         double var20 = var1.getY() + var15 - 1.0D;
         double var22 = var1.getZ() + var14.hq * var6;
         Location var24 = new Location(ai.idealistic.vacan.compatibility.b.a.b.i(var0), var18, var20, var22);
         if (a(var24, var2, var3, 2.0D, var3)) {
            return var6;
         }

         var6 += var8;
      }

      return var6;
   }

   public static boolean a(Location var0, Location var1, double var2, double var4, double var6) {
      boolean var8 = var0.getX() >= var1.getX() - var2 / 2.0D && var0.getX() <= var1.getX() + var2 / 2.0D;
      boolean var9 = var0.getY() >= var1.getY() - var4 / 2.0D && var0.getY() <= var1.getY() + var4 / 2.0D;
      boolean var10 = var0.getZ() >= var1.getZ() - var6 / 2.0D && var0.getZ() <= var1.getZ() + var6 / 2.0D;
      return var8 && var9 && var10;
   }

   public static float a(boolean var0, Player var1) {
      float var2 = 1.62F;
      if (var1.isSleeping()) {
         var2 = 0.2F;
      }

      if (var0) {
         var2 -= 0.08F;
      }

      return var2;
   }

   public static boolean a(Player var0, Location var1) {
      double var2 = var1.getX();
      double var4 = var1.getY();
      double var6 = var1.getZ();

      for(int var8 = -1; var8 <= 1; ++var8) {
         for(int var9 = -1; var9 <= 1; ++var9) {
            for(int var10 = -1; var10 <= 1; ++var10) {
               Material var11 = (new ai.idealistic.vacan.abstraction.g.b(new Location(ai.idealistic.vacan.compatibility.b.a.b.i(var0), var2 + (double)var8 * 0.3D, var4 + (double)var9 * 0.3D, var6 + (double)var10 * 0.3D))).dO().dA();
               if (var11 != null && !ai.idealistic.vacan.utils.minecraft.world.c.S(var11)) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   public static boolean a(ai.idealistic.vacan.abstraction.f.c var0, ai.idealistic.vacan.utils.minecraft.entity.a var1, double var2) {
      boolean var4 = false;
      var4 = a(var0, var0.getLocation(), var4, var1, var2);
      return var4;
   }

   public static boolean b(ai.idealistic.vacan.abstraction.f.c var0, ai.idealistic.vacan.utils.minecraft.entity.a var1, double var2) {
      boolean var4 = false;
      boolean var5 = false;
      var4 = a(var0, var0.getLocation(), var4, var1, var2);
      var5 = a(var0, var0.bM(), var4, var1, var2);
      return var4 || var5;
   }

   @Generated
   private f() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
