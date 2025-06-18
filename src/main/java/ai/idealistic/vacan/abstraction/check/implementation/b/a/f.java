package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.Check;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class f extends ai.idealistic.vacan.abstraction.check.b {
   private double cP = 0.0D;
   private double cQ = 0.0D;
   private double cR = 0.0D;
   private double cS = 0.0D;
   private int cT = 0;
   private int cU = 0;
   private int cV = 0;
   private int cW = 0;
   private Location cX = null;
   private final ai.idealistic.vacan.abstraction.b.a.a bk = new ai.idealistic.vacan.abstraction.b.a.a();

   public f(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, (Check.DataType)null, Check.DetectionType.PACKETS, "elytra", false);
   }

   void W() {
      this.a(() -> {
         if (this.ac.cg() == null) {
            PlayerInventory var1 = this.ac.cd();
            ItemStack var2 = var1.getChestplate();
            if (var2 != null) {
               if (var2.getType() == Material.ELYTRA) {
                  if (var2.getDurability() < 432) {
                     double var3 = this.bk.a(1.0D, 20);
                     double var5 = 15.0D;
                     if (var3 >= var5) {
                        this.a("elytra(glide-spam)", this.ac.bM(), 0, true);
                        if (this.j()) {
                           this.ac.bC().setGliding(false);
                        }
                     }
                  } else {
                     this.a("elytra(no-durability-glide)", this.ac.bM(), 0, true);
                     if (this.j()) {
                        this.ac.bC().setGliding(false);
                     }
                  }
               } else {
                  this.a("elytra(no-elytra-glide)", this.ac.bM(), 0, true);
                  if (this.j()) {
                     this.ac.bC().setGliding(false);
                  }
               }
            } else {
               this.a("elytra(no-chestplate-item-glide)", this.ac.bM(), 0, true);
               if (this.j()) {
                  this.ac.bC().setGliding(false);
               }
            }
         } else {
            this.a("elytra(vehicle-glide)", this.ac.bM(), 0, true);
            if (this.j()) {
               this.ac.bC().setGliding(false);
            }
         }

      });
   }

   void X() {
      this.a(() -> {
         ai.idealistic.vacan.abstraction.f.c var1 = this.ac;
         if (!var1.co()) {
            this.cV = 0;
            this.cU = 0;
            this.cT = 0;
            this.cP = 0.0D;
            this.cW = 0;
            this.cX = null;
            this.cQ = 0.0D;
            this.cR = 0.0D;
            this.cS = 0.0D;
         } else {
            ++this.cV;
            boolean var2 = var1.bI();
            this.d(var2);
            Location var3 = var1.getLocation();
            if (this.cX == null) {
               this.cX = var3.clone();
            }

            double var4 = var3.getX() - this.cX.getX();
            double var6 = var3.getZ() - this.cX.getZ();
            double var8 = Math.sqrt(var4 * var4 + var6 * var6);
            double var10 = a(var8, this.cR * 0.91D);
            double var12 = a(var10, this.cS);
            double var14 = var3.getY() - this.cX.getY();
            ai.idealistic.vacan.abstraction.b.d var16 = this.ac.dp();
            double var17 = Math.abs(Math.abs(var14) - Math.abs(this.cQ));
            if (this.cV > 1) {
               if (var8 > 0.05D && var16.aS() && var12 < 1.0E-8D) {
                  this.cW += var12 == 0.0D ? 3 : 1;
                  if (this.cW > 12) {
                     this.a("invalid elytra speed: " + var12, this.ac.bM(), 0, true);
                     this.cW = 8;
                  }
               } else if (this.cW > 0) {
                  this.cW -= 2;
               }

               if (var17 == 0.0D && var16.aS()) {
                  this.cP += 2.0D;
                  if (this.cP >= 5.0D) {
                     this.a("invalid elytra gravity: " + var17, this.ac.bM(), 0, true);
                     this.cP /= 1.3D;
                  }
               }

               if (var8 > 2.4D || var14 > 1.7D) {
                  this.a("elytra limit", this.ac.bM(), 0, true);
               }

               this.cP /= 1.15D;
            }

            this.cX = var3.clone();
            this.cQ = var14;
            this.cR = var8;
            this.cS = var10;
         }
      });
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
}
