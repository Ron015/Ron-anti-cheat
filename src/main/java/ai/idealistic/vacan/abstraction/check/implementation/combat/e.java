package ai.idealistic.vacan.abstraction.check.implementation.combat;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.abstraction.d.h;
import ai.idealistic.vacan.utils.b.f;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.util.Vector;

public class e extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b aN;
   private final ai.idealistic.vacan.abstraction.check.b aO;
   private final double[] aP = new double[]{0.248136D, 0.3332D};
   private float aQ = 0.0F;
   private long aR = System.currentTimeMillis();
   private double aS = 1.0D;
   private int aT = 0;
   private boolean aU = false;
   private Vector aV = null;

   public e(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
      this.aN = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, Check.DetectionType.PACKETS, "vertical", true, 2000L, 30000L, 40000L, 60000L);
      this.aO = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, Check.DetectionType.PACKETS, "horizontal", true, 2000L, 30000L, 40000L, 60000L);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof h) {
         this.aU = false;
      } else if (var2 instanceof PlayerVelocityEvent) {
         PlayerVelocityEvent var3 = (PlayerVelocityEvent)var2;
         this.aU = true;
         Location[] var4 = new Location[]{this.ac.getLocation().clone().add(var3.getVelocity()), this.ac.getLocation().clone().add(var3.getVelocity()).add(0.0D, 1.0D, 0.0D)};
         boolean var5 = true;
         Location[] var6 = var4;
         int var7 = var4.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            Location var9 = var6[var8];
            if (this.b(var9)) {
               var5 = false;
               break;
            }
         }

         if (var5) {
            this.aV = var3.getVelocity();
            this.aS = 1.0D;
            this.aT = 0;
         }

         if (this.aQ > 0.0F) {
            this.aQ -= 5.0F;
         }
      } else if (var2 instanceof PlayerMoveEvent && (this.aO.i() || this.aN.i())) {
         long var22 = System.currentTimeMillis() - this.aR;
         PlayerMoveEvent var23 = (PlayerMoveEvent)var2;
         Location var24 = var23.getFrom();
         Location var25 = var23.getTo();
         double var26 = var25.getX() - var24.getX();
         double var10 = var25.getY() - var24.getY();
         double var12 = var25.getZ() - var24.getZ();
         if (this.aV != null) {
            if (g(g(var10) - g(this.aV.getY())) < this.aS) {
               this.aS = var10;
            }

            if (!(g(g(var10) - g(this.aV.getY())) < 1.0E-4D)) {
               if (var22 > 25L) {
                  if (this.aT < 2) {
                     if (!this.aU) {
                        ++this.aT;
                     }
                  } else {
                     if (this.aV.getY() != 0.003D) {
                        this.a("velocity manipulation [y] (motion: " + h(this.aS) + ", velocity: " + h(this.aV.getY()) + ")", this.f(this.aS) ? 12.0D : 25.0D, this.aN);
                     }

                     this.aV = null;
                  }
               }
            } else {
               double var14 = var26 - this.aV.getX();
               double var16 = var12 - this.aV.getZ();
               double var18 = g(var14) + g(var16);
               double var20 = 1.0D;
               if (!this.ac.bI() && !this.ac.bJ()) {
                  if (var18 > 0.05D * var20) {
                     this.a("velocity manipulation [xz] (air deviation: " + var18 + ")", 14.0D, this.aO);
                  }
               } else if (var18 > 0.2D * var20) {
                  this.a("velocity manipulation [xz] (ground deviation: " + var18 + ")", 30.0D, this.aO);
               }

               this.aV = null;
               this.aT = 0;
            }
         }

         this.aR = System.currentTimeMillis();
      }

   }

   private void a(String var1, double var2, ai.idealistic.vacan.abstraction.check.b var4) {
      var4.a(() -> {
         this.aQ += (float)var2;
         if (this.aQ > 60.0F) {
            var4.c(var1);
            this.aQ = 50.0F;
         }

      });
   }

   private boolean f(double var1) {
      double[] var3 = this.aP;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         if (var6 == h(var1)) {
            return true;
         }
      }

      return false;
   }

   private static double g(double var0) {
      return Math.abs(var0);
   }

   private static double h(double var0) {
      return f.l(var0, 6.0D);
   }

   private boolean b(Location var1) {
      double var2 = var1.getX();
      double var4 = var1.getY() + 0.1D;
      double var6 = var1.getZ();

      for(int var8 = -1; var8 <= 1; ++var8) {
         for(int var9 = -1; var9 <= 1; ++var9) {
            for(int var10 = -1; var10 <= 1; ++var10) {
               Material var11 = (new ai.idealistic.vacan.abstraction.g.b(new Location(this.ac.bV(), var2 + (double)var8 * 0.3D, var4 + (double)var9 * 0.3D, var6 + (double)var10 * 0.3D))).dO().dA();
               if (var11 != null && (ai.idealistic.vacan.utils.minecraft.world.c.ad(var11) || ai.idealistic.vacan.utils.minecraft.world.c.ab(var11) || var11.toString().contains("GRASS")) || ai.idealistic.vacan.utils.minecraft.world.c.c(var11)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   protected boolean m() {
      return this.ac.cg() == null && !this.ac.dp().aU() && !this.ac.dp().aV() && !this.ac.dp().aW() && ai.idealistic.vacan.utils.minecraft.entity.b.F(this.ac) && !this.ac.v(-1.0D);
   }
}
