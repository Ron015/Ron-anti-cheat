package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.Check;
import org.bukkit.Location;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Vehicle;
import org.bukkit.potion.PotionEffectType;

public class i extends ai.idealistic.vacan.abstraction.check.b {
   private double cP = 0.0D;
   private double cQ = 0.0D;
   private double cR = 0.0D;
   private double cS = 0.0D;
   private int cT = 0;
   private int cU = 0;
   private int cV = 0;
   private int dV = 0;
   private int cW = 0;
   private Location cX = null;

   public i(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, (Check.DataType)null, Check.DetectionType.PACKETS, "vehicle", true);
   }

   void run() {
      this.a(() -> {
         ai.idealistic.vacan.abstraction.f.c var1 = this.ac;
         Entity var2 = var1.cg();
         if (var2 == null) {
            this.cV = 0;
            this.cP = 0.0D;
            this.dV = 0;
            this.cW = 0;
            this.cU = 0;
            this.cT = 0;
            this.cX = null;
            this.cQ = 0.0D;
            this.cR = 0.0D;
            this.cS = 0.0D;
         } else if (var2 instanceof Vehicle) {
            Vehicle var3 = (Vehicle)var2;
            ++this.cV;
            boolean var4 = var1.cg().isOnGround();
            this.d(var4);
            Location var5 = var1.cg().getLocation();
            if (this.cX == null) {
               this.cX = var5.clone();
            }

            double var6 = var5.getX() - this.cX.getX();
            double var8 = var5.getZ() - this.cX.getZ();
            double var10 = Math.sqrt(var6 * var6 + var8 * var8);
            double var12 = a(var10, this.cR * 0.91D);
            double var14 = a(var12, this.cS);
            double var16 = var5.getY() - this.cX.getY();
            ai.idealistic.vacan.abstraction.b.d var18 = this.ac.dp();
            double var19 = var3 instanceof Boat ? 0.04D : 0.0784000015258789D;
            double var21 = Math.abs(Math.abs(var16) - Math.abs(this.cQ - var19));
            if (var21 > 1.0E-4D && this.cU > 4 && var3 instanceof Boat) {
               if (this.dV < 0) {
                  this.dV = 0;
               }

               ++this.dV;
               if (this.dV > 10) {
                  this.a("prediction vehicle gravity: " + var21, this.ac.bM(), 0, true);
                  this.dV = 9;
               }
            } else if (!(var3 instanceof Minecart) && a(this.cQ, var19) < 1.0E-10D) {
               ++this.dV;
               if (this.dV > 7) {
                  this.a("prediction vehicle gravity: " + var21, this.ac.bM(), 0, true);
                  this.dV = 6;
               }
            } else if (this.dV > 0) {
               this.dV -= 2;
            }

            if (var14 < 1.0E-10D && var10 > 0.1D && !(var3 instanceof Minecart) && !(var2 instanceof Boat)) {
               if (this.cW < 0) {
                  this.cW = 0;
               }

               ++this.cW;
               if (this.cW > 8) {
                  this.a("prediction vehicle speed: " + var14, this.ac.bM());
                  this.cW = 7;
               }
            } else if (this.cW > 0) {
               this.cW -= 2;
            }

            if (!var18.aS()) {
               this.dV -= 2;
            }

            if (this.cV > 1) {
               double var23 = 1.0D;
               double var25 = 1.0D;
               if (var3 instanceof Horse) {
                  if (this.cU == 0) {
                     var23 = 1.05D;
                  } else if (this.cU < 4) {
                     var23 = 1.7D;
                  } else if (this.cU < 14) {
                     var23 = 1.2D;
                  } else {
                     var23 = 0.4D;
                  }

                  if (this.cU < 2) {
                     var25 = 1.5D;
                  } else if (this.cU < 4) {
                     var25 = 1.2D + this.cQ - 0.0784000015258789D + 0.03D;
                  } else if (this.cU < 18) {
                     var25 = this.cQ - 0.0784000015258789D + 0.6D;
                  } else {
                     var25 = this.cQ - 0.0784000015258789D;
                  }
               }

               var23 *= this.ar();
               if (var18.aY()) {
                  ++var23;
                  var25 += 0.75D;
               }

               if (var18.aZ() || var18.aX()) {
                  var23 += 0.2D;
                  if (var25 < 0.0D) {
                     var25 = 0.0D;
                  }

                  var25 += 0.3D;
               }

               if (var18.aW()) {
                  ++var23;
                  ++var25;
               }

               if (var10 > var23) {
                  this.cP += var10 / var23;
                  if (this.cP > 12.0D) {
                     this.a("vehicle limit speed: " + var10, this.ac.bM());
                     this.cP /= 1.3D;
                  }
               }

               if (var16 > var25) {
                  this.cP += Math.abs(var16 / var25);
                  if (this.cP > 15.0D) {
                     this.a("vehicle limit gravity: " + var16, this.ac.bM());
                     this.cP /= 1.3D;
                  }
               }

               this.cP /= 1.2D;
            }

            this.cX = var5.clone();
            this.cQ = var16;
            this.cR = var10;
            this.cS = var12;
         }
      });
   }

   private double ar() {
      double var1 = 1.0D;
      ai.idealistic.vacan.abstraction.f.b var3 = this.ac.a(PotionEffectType.SPEED, 5L);
      Location var4 = this.ac.getLocation().clone().add(0.0D, -0.5D, 0.0D);
      Location var5 = this.ac.bM().clone().add(0.0D, -0.5D, 0.0D);
      if (ai.idealistic.vacan.utils.minecraft.entity.d.kV && this.ac.cd().getBoots() != null) {
         int var6 = this.ac.cd().getBoots().getEnchantmentLevel(Enchantment.SOUL_SPEED);
         double var7 = (double)(var6 + 1) * 0.4D;
         var1 += var7;
      }

      if (var3 != null) {
         var1 += (double)(var3.gf.getAmplifier() + 1) * 0.2D;
      }

      if (this.f(var4) || this.h(var4) || this.f(var5) || this.h(var5)) {
         var1 *= 1.6D;
      }

      if (this.af() || this.af()) {
         ai.idealistic.vacan.abstraction.f.b var9 = ai.idealistic.vacan.utils.minecraft.entity.d.kU ? this.ac.a(PotionEffectType.DOLPHINS_GRACE, 0L) : null;
         if (var9 != null) {
            var1 *= 6.2D;
         }
      }

      if (this.g(var4)) {
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

   void P() {
      this.a(() -> {
         this.cU = 0;
         this.cV = 0;
      });
   }

   private void d(boolean var1) {
      this.a(() -> {
         this.cU = var1 ? 0 : this.cU + 1;
         this.cT = var1 ? this.cT + 1 : 0;
      });
   }

   private static double g(double var0) {
      return Math.abs(var0);
   }

   private boolean af() {
      return this.ac.dp().aX();
   }

   private boolean f(Location var1) {
      return this.ac.dp().aT();
   }

   private boolean g(Location var1) {
      return this.ac.dp().aY();
   }

   private boolean h(Location var1) {
      return this.ac.dp().aU();
   }
}
