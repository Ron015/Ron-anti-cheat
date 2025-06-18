package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.Check;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.potion.PotionEffectType;

public class h extends ai.idealistic.vacan.abstraction.check.b {
   private double cP = 0.0D;
   private double du = 0.0D;
   private int cT = 0;
   private int cU = 0;
   private int dB = 0;
   private int dd = 0;
   private int dC = 0;
   private boolean dD = false;
   private boolean dE = true;
   private static final double dF = 0.026D;
   private static final double dG = 0.02D;
   private static final double dH = 0.0073D;
   private double dI = 0.0D;
   private double dJ = 0.0D;
   private static final double[] dK = new double[]{0.2806D, 0.1726D};
   private static final double[] dL = new double[]{0.6132D, 0.3601D};
   private double dM = 0.0D;
   private double dN = 0.0D;
   private double dO = 0.0D;
   private double dP = 0.0D;
   private double dQ = 0.0D;
   private int dR = 0;
   private int dS = 0;
   private int dT = 0;
   private boolean dU = false;

   public h(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, (Check.DataType)null, Check.DetectionType.PACKETS, "speed", true);
   }

   private boolean b(ai.idealistic.vacan.abstraction.f.c var1) {
      return var1.cq() || var1.cg() != null;
   }

   void run() {
      this.a(() -> {
         ai.idealistic.vacan.abstraction.f.c var1 = this.ac;
         if (this.b(var1)) {
            this.cT = 0;
            this.cU = 0;
            this.dB = 0;
            this.cP = 0.0D;
            this.du = 0.0D;
            this.dD = false;
            this.dE = true;
            this.dI = 0.0D;
            this.dJ = 0.0D;
            this.dM = 0.0D;
            this.dN = 0.0D;
            this.dO = 0.0D;
            this.dP = 0.0D;
            this.dQ = 0.0D;
            this.dR = 0;
            this.dS = 0;
            this.dT = 0;
            this.dU = false;
            this.dd = 0;
            this.dC = 0;
         } else {
            boolean var2 = var1.cg() != null ? var1.cg().isOnGround() : var1.bI();
            Location var3 = var1.getLocation();
            Location var4 = this.ac.bM();
            double var5 = var3.getX() - var4.getX();
            double var7 = var3.getZ() - var4.getZ();
            double var9 = Math.sqrt(var5 * var5 + var7 * var7);
            double var11 = Math.toRadians((double)ai.idealistic.vacan.utils.b.c.g(var3.getYaw()));
            ai.idealistic.vacan.utils.b.e var13 = new ai.idealistic.vacan.utils.b.e(-Math.sin(var11), Math.cos(var11));
            ai.idealistic.vacan.utils.b.e var14 = new ai.idealistic.vacan.utils.b.e(var5, var7);
            boolean var15 = ai.idealistic.vacan.utils.b.f.a(var13, var14, 46.0D);
            boolean var16 = ai.idealistic.vacan.utils.b.f.a(var13, var14, 80.0D);
            boolean var17 = false;
            if (!this.ac.gw) {
               this.dB = 0;
            }

            double var18 = Math.max(ai.idealistic.vacan.compatibility.a.f.a.e(this.ac, "GENERIC_MOVEMENT_SPEED"), 0.0D) * 1.3D;
            if (var3.getX() != var4.getX() || var3.getY() != var4.getY() || var3.getZ() != var4.getZ()) {
               this.d(var2);
               double var20;
               double var22;
               if (this.cU == 0) {
                  this.dE = false;
                  this.dD = false;
                  var20 = var15 ? 0.2975D : (var16 ? 0.289D : 0.235D);
                  var20 = this.dB > 6 ? 0.061D : (this.dB > 3 ? 0.09D : (this.dB > 1 ? 0.17D : var20));
                  var22 = ai.idealistic.vacan.utils.b.f.a(var13, var14, 65.0D) ? 0.15D : 0.12D + var18;
                  if (var20 < (var20 + var18) * this.ar()) {
                     this.dI = ((var20 + var18) * this.ar() - var20) * 0.5D;
                  }

                  if (this.cT == 1 && this.dQ > var22) {
                     this.dI = this.dQ - var22 * 0.91D;
                  }

                  var20 += var18;
                  var20 *= this.ar();
                  var20 += this.dI;
                  if (this.ac.dk().fl && var9 > var20) {
                     ++var20;
                     ++this.dI;
                     this.dU = true;
                  }

                  if (var9 < var20) {
                     this.c(var5, var7);
                  }

                  if (this.dI > 0.0D) {
                     this.dI -= 0.02D;
                  }

                  if (this.dI < 0.0D) {
                     this.dI = 0.0D;
                  }
               } else if (this.cU == 1 || this.cU == 2 && !this.dD) {
                  if (!ai.idealistic.vacan.utils.b.f.a(var13, var14, 46.0D) && !this.dE) {
                     if (ai.idealistic.vacan.utils.b.f.a(var13, var14, 65.0D)) {
                        var20 = dK[Math.max(0, Math.min(this.cU - 1, dK.length - 1))] + dL[Math.max(0, Math.min(this.cU - 1, dL.length - 1))] / 2.0D;
                     } else {
                        var20 = dK[Math.max(0, Math.min(this.cU - 1, dK.length - 1))];
                     }
                  } else {
                     var20 = dL[Math.max(0, Math.min(this.cU - 1, dL.length - 1))];
                  }

                  if (this.dI > 0.146D) {
                     var20 += this.dI - 0.146D;
                  }

                  var20 += var18;
                  var20 *= this.ar();
                  if (this.dB > 0) {
                     var20 /= 1.2D;
                  }

                  if (this.ac.dk().fl) {
                     ++var20;
                  }

                  if (var9 < var20 + this.dJ) {
                     this.c(var5, var7);
                  } else {
                     this.c(-Math.sin(Math.toRadians((double)var3.getYaw())) * var20, Math.cos(Math.toRadians((double)var3.getYaw())) * var20);
                  }

                  if (var1.bK() && var15 && this.cU == 1) {
                     this.dE = true;
                  }

                  this.dJ /= 1.3D;
               } else {
                  var20 = this.dO * 0.9100000262260437D;
                  var22 = this.dP * 0.9100000262260437D;
                  this.c(var20, var22);
                  Math.sqrt(a(var5, var20) * a(var5, var20) + a(var7, var22) * a(var7, var22));
                  double var26 = ai.idealistic.vacan.utils.b.f.a(var14);
                  double var28 = (this.dB > 2 ? 0.0073D : (this.dB > 1 ? 0.02D : 0.026D)) * this.ar();
                  boolean var30 = false;
                  Iterator var31 = this.ac.u(2.4D).iterator();

                  while(var31.hasNext()) {
                     Entity var32 = (Entity)var31.next();
                     if (var32.getUniqueId() != this.ac.bT()) {
                        var30 = true;
                        break;
                     }
                  }

                  boolean var33 = this.a(var3, var4, var3.clone().add(-Math.sin(var26) * 0.3D, 0.0D, Math.cos(var26) * 0.3D)) || var30;
                  if (var33 && var9 < this.dQ * 1.2D + (var30 ? var28 + 0.2D : 0.03D)) {
                     if (a(var5, var20) > var28) {
                        var20 = var5;
                     }

                     if (a(var7, var22) > var28) {
                        var22 = var7;
                     }
                  }

                  boolean var34 = a(var5, var20) < var28 && a(var7, var22) < var28;
                  if (var34) {
                     this.c(var5, var7);
                  } else {
                     this.c(-Math.sin(Math.toRadians((double)var3.getYaw())) * 0.02D, Math.cos(Math.toRadians((double)var3.getYaw())) * 0.02D);
                  }
               }

               this.a(var3.getY() - var4.getY(), 0.039D * this.ar(), new ai.idealistic.vacan.utils.minecraft.d.a(var5, var7));
               if (this.i(var3) || this.i(var4)) {
                  this.dR = 4;
               }

               if (var5 != this.dM || var7 != this.dN) {
                  var20 = Math.sqrt(this.dM * this.dM + this.dN * this.dN);
                  var22 = a(var20, var9);
                  if (var22 <= 1.01D && var22 > 0.1D && this.ac.dk().fl) {
                     this.c(var5, var7);
                     this.dU = true;
                  }

                  if (this.ac.dk().fl && this.dR > 0) {
                     this.dR = 0;
                     this.dS = 3;
                     this.dU = true;
                  }

                  if (var22 >= 0.04D && var22 <= 2.2D && this.dS > 0) {
                     --this.dS;
                     this.c(var5, var7);
                  }

                  if (var22 >= 0.04D && var22 <= 3.1D && this.dT > 0) {
                     --this.dT;
                     this.c(var5, var7);
                  }

                  if (var22 >= 0.02D && var22 <= 1.7D && this.ac.dk().fm) {
                     this.ac.dk().fm = false;
                     this.c(var5, var7);
                  }

                  if (this.ac.dk().fl && a(var20, var9) > 0.1D && a(var20, var9) <= 1.0D) {
                     this.c(var5, var7);
                     this.dU = true;
                  }

                  if (var22 >= 0.01D && var22 <= 4.3D && this.dd > 0) {
                     this.c(var5, var7);
                  }

                  if (this.d(var3) && var22 < 0.1D) {
                     this.c(var5, var7);
                  }

                  if (this.ac.go > 0 && var22 < 2.75D && var22 > 0.01D) {
                     this.c(var5, var7);
                     --this.ac.go;
                  }

                  if (this.ac.cg() != null) {
                     this.c(var5, var7);
                  }

                  var20 = Math.sqrt(this.dM * this.dM + this.dN * this.dN);
                  var22 = a(var20, var9);
                  if (this.dC > 0 && var22 > 1.0E-7D && var22 < 0.09D) {
                     --this.dC;
                     this.c(var5, var7);
                     var22 = a(var20, var9);
                  }

                  if (var5 != this.dM || var7 != this.dN) {
                     this.du += this.cU == 1 ? 4.0D : 1.0D;
                     this.cP += var22 * 1.5D + (this.cU == 1 ? 0.5D : (var22 > 0.04D ? 0.12D : 0.06D));
                     if (this.cP > 0.05D) {
                        this.dI /= 2.0D;
                        var17 = true;
                     }

                     if (this.cP > 1.0D || this.cP > 0.4D && this.du > 10.0D) {
                        double var24 = Math.max(this.hackType.getCheck().a("minimum_speed_difference", 1.0E-10D), 1.0E-10D);
                        if (this.aq() != null) {
                           var24 = Math.max(var24, 0.13D);
                        }

                        if (var22 >= var24) {
                           this.a(1.0D + var22, "simulation[accel], diff: " + var22, this.ac.bM(), 0, true);
                        }

                        this.cP -= 0.1D;
                     }
                  }
               }

               if (this.dU) {
                  this.ac.dk().fl = false;
                  this.dU = false;
               }

               if (this.cP > 0.0D) {
                  this.cP -= 0.002D;
                  this.cP /= 1.1D;
               }

               if (this.du > 0.0D) {
                  this.du -= 0.3D;
               }

               if (this.dd > 0) {
                  --this.dd;
               }

               this.dO = var5;
               this.dP = var7;
               if (!var17) {
                  this.dQ = var9;
               }

               this.dI /= 1.14D;
               if (this.dR > 0) {
                  --this.dR;
               }
            }

         }
      });
   }

   private ai.idealistic.vacan.abstraction.f.b aq() {
      return this.ac.a(PotionEffectType.SPEED, 5L);
   }

   private double ar() {
      double var1 = 1.0D;
      ai.idealistic.vacan.abstraction.f.b var3 = this.aq();
      boolean var4 = var3 != null;
      Location var5 = this.ac.getLocation().clone().add(0.0D, -0.5D, 0.0D);
      Location var6 = this.ac.bM().clone().add(0.0D, -0.5D, 0.0D);
      if (ai.idealistic.vacan.utils.minecraft.entity.d.kV && this.ac.cd().getBoots() != null) {
         int var7 = this.ac.cd().getBoots().getEnchantmentLevel(Enchantment.SOUL_SPEED);
         double var8 = (double)(var7 + 1) * 0.4D;
         var1 += var8;
      }

      if (var3 != null) {
         var1 += (double)(var3.gf.getAmplifier() + 1) * 0.2D;
      }

      if (this.f(var5) || this.h(var5) || this.f(var6) || this.h(var6)) {
         var1 *= 1.6D;
      }

      if (this.ac.u(2.0D).size() > 1) {
         var1 *= 1.4D;
      }

      if (ai.idealistic.vacan.utils.minecraft.world.c.L((new ai.idealistic.vacan.abstraction.g.b(this.ac.getLocation())).dO().dz())) {
         var1 *= 0.2D;
      }

      if (this.af() || this.af()) {
         ai.idealistic.vacan.abstraction.f.b var10 = ai.idealistic.vacan.utils.minecraft.entity.d.kU ? this.ac.a(PotionEffectType.DOLPHINS_GRACE, 0L) : null;
         if (var10 != null) {
            var1 *= 6.2D;
         }
      }

      if (this.g(var5)) {
         var1 *= 1.4D;
      }

      if (this.ac.co()) {
         var1 *= 18.0D;
      }

      if (this.ac.cr() || this.ac.gn > 0) {
         var1 *= 25.0D;
      }

      var1 *= (double)(this.ac.bC().getWalkSpeed() * 5.0F);
      return var1;
   }

   private static double a(double var0, double var2) {
      return g(g(var0) - g(var2));
   }

   private void a(double var1, double var3, ai.idealistic.vacan.utils.minecraft.d.a var5) {
      ai.idealistic.vacan.abstraction.d.c var6 = null;
      Iterator var7 = this.ac.gE.iterator();

      while(var7.hasNext()) {
         ai.idealistic.vacan.abstraction.d.c var8 = (ai.idealistic.vacan.abstraction.d.c)var7.next();
         if (this.b(var1, var8.bp().getY())) {
            double var9 = Math.sqrt(var5.ho * var5.ho + var5.hp * var5.hp);
            double var11 = Math.sqrt(var8.bp().getX() * var8.bp().getX() + var8.bp().getZ() * var8.bp().getZ());
            if (var9 < var11 * 2.5D + var3) {
               this.dM = var5.ho;
               this.dN = var5.hp;
               this.dJ = (var11 + var3) * 1.6D;
            }

            var6 = var8;
            this.dD = true;
            break;
         }
      }

      if (var6 != null) {
         this.ac.gE.remove(var6);
      }

   }

   private boolean b(double var1, double var3) {
      return g(g(var1) - g(var3)) < 0.08D;
   }

   void P() {
      this.a(() -> {
         this.dC = 1;
         this.cU = 0;
      });
   }

   void d(boolean var1) {
      this.a(() -> {
         this.cU = var1 ? 0 : this.cU + 1;
         this.dB = this.ac.gw ? this.dB + 1 : 0;
         this.cT = var1 ? this.cT + 1 : 0;
      });
   }

   void ac() {
      this.a(() -> {
         this.dT = 10;
      });
   }

   void ab() {
      this.a(() -> {
         this.dd = 2;
      });
   }

   private static double g(double var0) {
      return Math.abs(var0);
   }

   private void c(double var1, double var3) {
      this.dM = var1;
      this.dN = var3;
   }

   private boolean af() {
      return this.ac.dp().aX();
   }

   private boolean f(Location var1) {
      return this.ac.dp().aT();
   }

   private boolean a(Location... var1) {
      for(int var2 = -2; var2 <= 2; ++var2) {
         for(int var3 = 0; var3 <= 2; ++var3) {
            for(int var4 = -2; var4 <= 3; ++var4) {
               Location[] var5 = var1;
               int var6 = var1.length;

               for(int var7 = 0; var7 < var6; ++var7) {
                  Location var8 = var5[var7];
                  double var9 = var8.getX();
                  double var11 = var8.getY();
                  double var13 = var8.getZ();
                  Material var15 = this.ac.gL.k(new Location(this.ac.bV(), var9 + (double)var2 * 0.5D, var11 + (double)var3 * 0.5D, var13 + (double)var4 * 0.5D));
                  if (var15 != null && (ai.idealistic.vacan.utils.minecraft.world.c.ad(var15) || ai.idealistic.vacan.utils.minecraft.world.c.ab(var15) || var15.toString().contains("GRASS")) || ai.idealistic.vacan.utils.minecraft.world.c.c(var15)) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   private boolean d(Location var1) {
      double var2 = var1.getX();
      double var4 = var1.getY() - 0.1D;
      double var6 = var1.getZ();

      for(int var8 = -2; var8 <= 2; ++var8) {
         for(double var9 = 1.0D; var9 <= 2.0D; var9 += 0.5D) {
            for(int var11 = -2; var11 <= 2; ++var11) {
               Material var12 = this.ac.gL.k(new Location(this.ac.bV(), var2 + (double)var8 * 0.5D, var4 + var9, var6 + (double)var11 * 0.5D));
               if (var12 != null && ai.idealistic.vacan.utils.minecraft.world.c.ab(var12)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private boolean g(Location var1) {
      return this.ac.dp().aY();
   }

   private boolean h(Location var1) {
      return this.ac.dp().aU();
   }

   private boolean i(Location var1) {
      return this.ac.dp().aV();
   }
}
