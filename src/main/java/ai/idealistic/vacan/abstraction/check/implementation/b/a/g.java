package ai.idealistic.vacan.abstraction.check.implementation.b.a;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.Iterator;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Entity;
import org.bukkit.potion.PotionEffectType;

public class g extends ai.idealistic.vacan.abstraction.check.b {
   private int cU = 0;
   private int cT = 0;
   private int cY = 0;
   private int cZ = 0;
   private int da = 0;
   private int db = 0;
   private int dc = 0;
   private int dd = 0;
   private int de = 0;
   private int df = 0;
   private int dg = 0;
   private int dh = 0;
   private int di = 0;
   private boolean dj = false;
   private boolean dk = false;
   private boolean dl = false;
   private boolean dm = false;
   private boolean dn = false;
   private boolean do = false;
   private boolean dp = false;
   private int dq = 0;
   private int dr = 0;
   private int ds = 0;
   private int dt = 0;
   private double cP = 0.0D;
   private double du = 0.0D;
   private int dv = 0;
   private double dw = 0.0D;
   private double dx = 0.0D;
   private double dy = 0.0D;
   private int dz = 0;
   private double dA = 0.0D;

   public g(ai.idealistic.vacan.abstraction.check.e var1) {
      super(var1, (Check.DataType)null, Check.DetectionType.PACKETS, "gravity_packets", true);
   }

   private boolean b(ai.idealistic.vacan.abstraction.f.c var1) {
      Iterator var2 = var1.u(2.0D).iterator();

      while(var2.hasNext()) {
         Entity var3 = (Entity)var2.next();
         if (var3 instanceof Boat) {
            this.di = ai.idealistic.vacan.utils.b.a.B(20.0D);
            return true;
         }
      }

      if (this.di > 0) {
         --this.di;
         return true;
      } else if (!var1.cq() && var1.cg() == null) {
         if (var1.d(var1.gU) > 1000L && var1.d(var1.gT) > 1000L) {
            for(int var4 = 0; var4 < ai.idealistic.vacan.utils.b.a.B(var1.cn()); ++var4) {
               Material var5 = (new ai.idealistic.vacan.abstraction.g.b(var1.getLocation().clone().add(0.0D, (double)var4, 0.0D))).dO().dz();
               if (ai.idealistic.vacan.utils.minecraft.world.c.Z(var5) || ai.idealistic.vacan.utils.minecraft.world.c.L(var5)) {
                  return true;
               }
            }

            return false;
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   void run() {
      this.a(() -> {
         ai.idealistic.vacan.abstraction.f.c var1 = this.ac;
         if (this.b(var1)) {
            this.cU = 0;
            this.cT = 0;
            this.cP = 0.0D;
            this.du = 0.0D;
            this.o(0.0D);
            this.da = 0;
            this.df = 0;
            this.dj = false;
            this.dk = false;
            this.dl = false;
            this.dm = false;
            this.dn = false;
            this.do = false;
            this.dp = false;
            this.dq = 0;
            this.dr = 0;
            this.ds = 0;
            this.dt = 0;
            this.dv = 0;
            this.dw = 0.0D;
            this.dx = 0.0D;
            this.dy = 0.0D;
            this.dz = 0;
            this.dA = 0.0D;
         } else {
            boolean var2 = this.ac.cg() != null ? this.ac.cg().isOnGround() : this.ac.bI();
            Location var3 = var1.getLocation();
            Location var4 = this.ac.bM();
            double var5 = var3.getX() - var4.getX();
            double var7 = var3.getZ() - var4.getZ();
            double var9 = Math.sqrt(var5 * var5 + var7 * var7);
            if (var3.getX() != var4.getX() || var3.getY() != var4.getY() || var3.getZ() != var4.getZ()) {
               double var11 = var3.getY() - var4.getY();
               double var13 = 0.08D;
               double var15 = this.aj() && this.ad() * 1.5D > var11 ? var11 : this.ad();
               if (ai.idealistic.vacan.utils.minecraft.world.c.L((new ai.idealistic.vacan.abstraction.g.b(var3)).dO().dz())) {
                  var15 /= 10.0D;
               }

               boolean var17 = this.af();
               if (this.al()) {
                  this.do = true;
               }

               double var18;
               if (var2) {
                  if (this.ac.getLocation().getY() > this.dx) {
                     this.dn = true;
                  }

                  if (this.cT != 1) {
                     this.o(0.0D);
                     if (this.g(var11) < 0.08D && this.g(var11) > 0.0D && (this.d(var3) || this.al() || this.ai())) {
                        this.o(var11);
                     }
                  } else {
                     var18 = this.dA -= var13;
                     var18 *= 0.9800000190734863D;
                     this.o(0.0D);
                     if (var11 > var18 && var11 < 0.0D) {
                        this.o(var11);
                     } else if (this.dm && var11 < 0.5D) {
                        this.o(var11);
                     }

                     if (this.al()) {
                        this.dj = true;
                     }
                  }

                  if (this.ah() || this.ah()) {
                     this.dv = 2;
                  }

                  if (this.dv > 0 && var11 != 0.0D && var11 < 0.785D) {
                     this.o(var11);
                     --this.dv;
                  }

                  this.dx = this.ac.getLocation().getY();
               } else if (this.cU == 1) {
                  if (var11 > 0.0D) {
                     this.o((double)((float)var15));
                  } else {
                     this.o(-var13 * 0.9800000190734863D);
                  }

                  if (this.dj) {
                     this.dr = 3;
                  }

                  if (this.dr > 0) {
                     var18 = this.ad() + this.g(this.dw) * 0.09D;
                     if (var11 == 0.0D) {
                        this.o(0.0D);
                     } else if (var18 > var11) {
                        this.o(var11);
                     }

                     --this.dr;
                  }
               } else {
                  this.dm = this.cU == 14;
                  this.dA -= var13;
                  this.dA *= 0.9800000190734863D;
                  if (this.dA < -3.92D) {
                     this.dA = -3.92D;
                  }

                  this.dj = false;
               }

               if (var1.dj().fl) {
                  this.ds = 2;
               }

               if (this.m(var11) > 0.01D && var1.dj().fl && var11 <= 0.25D) {
                  this.o(var11);
                  var1.dj().fl = false;
               }

               if (this.ds > 0) {
                  --this.ds;
               }

               if (this.m(var11) > 0.01D && var1.dj().fl && var11 <= 1.0D) {
                  this.o(var11);
                  var1.dj().fl = false;
               }

               boolean var20 = this.m(var11) > 0.001D && var1.dj().fk && this.dk;
               if (var20) {
                  var1.dj().fk = false;
                  this.dq = 4;
               }

               if ((this.ah() || this.ah() || this.an()) && var11 != 0.0D && var11 < 0.51D) {
                  this.o(var11);
               }

               var18 = this.g(this.g(var11) - this.g(this.ae()));
               if (!this.ac.gD.isEmpty() && var18 > 0.001D) {
                  this.n(var11);
               }

               double var21 = this.g(this.g(var11) - this.g(this.ae()));
               if (this.dc > 0 && var21 > 0.001D && var11 < 0.118D && var11 > -0.16D) {
                  this.o(var11);
                  --this.dc;
               } else if (var21 > 0.001D && var11 < 0.118D && var11 > -0.16D && this.ak()) {
                  this.o(var11);
                  this.dc = 2;
               }

               double var23 = this.g(this.g(var11) - this.g(this.ae()));
               if (var23 > 0.008D && this.d(var3)) {
                  if (var11 < this.ae() && var11 > -0.08D) {
                     this.o(var11);
                     this.cY = 3;
                     this.cZ = 0;
                  }
               } else if (var23 > 0.008D && this.cY > 0) {
                  if (var11 < this.ae() && var11 > -0.08D) {
                     this.o(var11);
                     --this.cY;
                     this.cZ = 0;
                  }
               } else if (this.cZ > 18 && this.cY > 0) {
                  --this.cY;
                  this.cZ = 0;
               }

               boolean var25 = this.ag();
               if (MultiVersion.c(MultiVersion.MCVersion.V1_13) && this.ac.bC().isSwimming()) {
                  this.dh = 2;
               } else if (this.dh > 0) {
                  --this.dh;
               }

               double var26 = this.c(var3) ? 0.4D : 0.2D;
               double var28 = MultiVersion.c(MultiVersion.MCVersion.V1_13) ? (this.dh > 0 ? 0.4D : var26) : var26;
               if (var23 > 0.01D && var17 && var11 > -3.92D && var11 < (var25 ? 0.8D : var28)) {
                  this.o(var11);
                  this.dt = var25 ? 8 : 5;
               }

               if (this.g(this.g(var11) - this.g(this.ae())) > 0.01D && this.dl && var11 < 4.2D) {
                  this.o(var11);
               }

               if (this.dt > 0 && this.g(this.g(var11) - this.g(this.ae())) < 0.14D) {
                  --this.dt;
                  this.o(var11);
               }

               ai.idealistic.vacan.abstraction.f.b var30;
               double var31;
               if (ai.idealistic.vacan.utils.minecraft.entity.d.kW) {
                  var30 = this.ac.a(PotionEffectType.LEVITATION, 0L);
                  if (var30 != null || this.da > 0) {
                     if (var30 != null) {
                        this.da = 2;
                        var31 = 0.05D * (double)var30.gf.getAmplifier() + 1.0D;
                        this.df = var30.gf.getAmplifier() + 1;
                     } else {
                        var31 = 0.05D * (double)this.df;
                     }

                     if (var11 < var31 && var11 >= 0.0D) {
                        this.o(var11);
                        this.dw = 0.0D;
                     }

                     if (this.da > 0) {
                        --this.df;
                     }
                  }
               }

               if (ai.idealistic.vacan.utils.minecraft.entity.d.kT) {
                  var30 = this.ac.a(PotionEffectType.SLOW_FALLING, 0L);
                  if (var30 != null || this.de > 0) {
                     if (var30 != null) {
                        this.de = 2;
                        var31 = 0.02D * (double)var30.gf.getAmplifier() + 0.5D;
                        this.dg = var30.gf.getAmplifier() + 1;
                     } else {
                        var31 = 0.02D * (double)this.dg + 0.5D;
                     }

                     if (var11 < var31 && var11 < 0.0D) {
                        this.o(var11);
                     }

                     if (this.de > 0) {
                        --this.dg;
                     }
                  }
               }

               if (this.ac.cr() || this.ac.co() || this.ac.gn > 0) {
                  this.o(var11);
                  this.da = 3;
                  this.df = 3;
               }

               if (!var2) {
                  if (this.cU == 1) {
                     if (var11 < 0.0D) {
                        this.dw = var11;
                     }
                  } else if (var11 < 0.0D) {
                     this.dw += var11;
                  } else {
                     this.dw = 0.0D;
                  }
               }

               double var33 = this.g(this.g(var11) - this.g(this.ae()));
               if (this.db > 0 && var33 > 0.001D && var11 < 0.0D && var11 > -0.16D) {
                  this.o(var11);
                  --this.db;
               } else if (var33 > 0.001D && var11 < 0.0D && var11 > -0.16D && this.ai()) {
                  this.o(var11);
                  this.db = 2;
               }

               if (this.m(var11) > 0.001D && this.dq > 0 && var11 > 0.0D && var11 < 1.52D) {
                  this.o(var11);
                  this.dp = true;
                  --this.dq;
               }

               if (this.m(var11) > 0.001D && this.dz > 0 && this.dy > 0.0D && this.m(var11) <= this.dy) {
                  this.o(var11);
               }

               --this.dz;
               if (this.dz == 0) {
                  this.dy = 0.0D;
               }

               if (this.ac.cg() != null) {
                  this.o(var11);
               }

               double var35;
               if (!this.ac.b(MultiVersion.MCVersion.V1_19) && this.cU > 5 && this.cU < 10 && var11 < this.ae() + 0.04D && var9 < 0.1D) {
                  var35 = 0.076D;
                  ai.idealistic.vacan.abstraction.f.b var37 = this.ac.a(ai.idealistic.vacan.utils.minecraft.entity.e.lD, 1L);
                  if (var37 != null) {
                     var35 += 0.04D * (double)(var37.gf.getAmplifier() + 1);
                     if (var35 > 0.16D) {
                        var35 = 0.16D;
                     }
                  }

                  if (this.m(var11) < var35) {
                     this.o(var11);
                  }
               }

               if (this.ac.dj().fm && this.m(var11) < 1.2D) {
                  this.o(var11);
                  this.ac.dj().fm = false;
               }

               if (this.do && this.ae() > var11 && this.m(var11) <= 0.08D) {
                  this.o(var11);
                  this.do = false;
               }

               if (this.dp && this.ae() > var11 && this.m(var11) <= 0.1D) {
                  this.o(var11);
                  this.dp = false;
               }

               if (this.ac.go > 0 && this.m(var11) < 2.5D && this.m(var11) > 0.01D) {
                  this.o(var11);
                  this.do = true;
                  --this.ac.go;
               }

               var35 = this.g(this.g(var11) - this.g(this.ae()));
               if (var35 > (this.ac.cg() != null && var11 < 0.0D ? 0.36D : (this.ac.cg() != null ? 0.09D : 0.009D))) {
                  if (var35 < 1.9D && this.dd > 0) {
                     this.o(0.0D);
                  } else if (this.ac.cg() == null) {
                     if (this.dn && this.cU == 1 && this.ae() > var11 && this.m(var11) <= 0.03D) {
                        return;
                     }

                     if (this.e(var4.clone().add(0.0D, 0.5D, 0.0D)) && var3.distance(var4) < 0.3D) {
                        return;
                     }

                     if (var35 < 0.1D) {
                        PotionEffectType[] var41 = new PotionEffectType[]{ai.idealistic.vacan.utils.minecraft.entity.d.kW ? PotionEffectType.LEVITATION : null, ai.idealistic.vacan.utils.minecraft.entity.d.kT ? PotionEffectType.SLOW_FALLING : null, ai.idealistic.vacan.utils.minecraft.entity.e.lD};
                        int var38 = var41.length;

                        for(int var39 = 0; var39 < var38; ++var39) {
                           PotionEffectType var40 = var41[var39];
                           if (var40 != null && var1.b(var40, 5L)) {
                              return;
                           }
                        }
                     }

                     this.cP += var35;
                     ++this.du;
                     if (this.cP > (this.ac.cg() != null ? 0.6D : 0.05D)) {
                        StringBuilder var42 = new StringBuilder(String.valueOf(ai.idealistic.vacan.utils.b.f.l(var35, 6.0D)));
                        if (var35 < 1.0D) {
                           var42.deleteCharAt(0);
                        }

                        if (this.du > (double)(this.cU == 1 ? 0 : (this.cP > 0.3D ? 0 : (this.cP > 0.16D ? 1 : 3)))) {
                           double var43 = Math.max(this.hackType.getCheck().a("minimum_gravity_difference", 0.0D), 0.0D);
                           if (var35 > var43) {
                              this.a(1.0D + var35, "simulation[gravity], y: " + var42 + ", ry: " + var35, this.ac.bM());
                           }
                        }
                     }

                     this.o(var11);
                     if (this.cP > 0.0D) {
                        this.cP -= 0.004D;
                     }

                     if (this.du > 0.0D) {
                        this.du -= 0.3D;
                     }

                     this.du /= 1.08D;
                     this.cP /= this.du < 4.0D ? 1.17D : 1.04D;
                  }
               } else {
                  ++this.cZ;
                  this.cP /= 1.01D;
                  if (this.cZ == 48) {
                     this.cZ = 0;
                  }
               }
            }

            this.dk = this.am() || this.am();
            if (this.dd > 0) {
               --this.dd;
            }

         }
      });
   }

   void ab() {
      this.a(() -> {
         this.dd = 2;
      });
   }

   private double m(double var1) {
      return this.g(this.g(var1) - this.g(this.ae()));
   }

   private void n(double var1) {
      ai.idealistic.vacan.abstraction.d.c var3 = null;
      Iterator var4 = this.ac.gD.iterator();

      while(var4.hasNext()) {
         ai.idealistic.vacan.abstraction.d.c var5 = (ai.idealistic.vacan.abstraction.d.c)var4.next();
         if (this.b(var1, var5.bp().getY())) {
            this.o(var1);
            this.do = true;
            var3 = var5;
            break;
         }
      }

      if (var3 != null) {
         this.ac.gD.remove(var3);
      }

   }

   private boolean b(double var1, double var3) {
      return this.g(this.g(var1) - this.g(var3)) < 0.08D;
   }

   void P() {
      this.a(() -> {
         this.cU = 0;
         this.cT = 0;
         this.dy = 0.35D;
         this.dz = g() <= 100L ? 1 : 5;
         this.cP /= 1.5D;
         this.o(0.0D);
      });
   }

   private void d(boolean var1) {
      boolean var2 = this.ac.cg() != null ? this.ac.cg().isOnGround() : var1;
      this.cT = var2 ? this.cT + 1 : 0;
      this.cU = var2 ? 0 : this.cU + 1;
   }

   void f(boolean var1) {
      this.a(() -> {
         this.d(var1);
      });
   }

   void ac() {
      this.a(() -> {
         this.dl = true;
         this.da = 13;
         this.df = 4;
      });
   }

   private double ad() {
      double var1 = 0.42D;
      ai.idealistic.vacan.abstraction.f.b var3 = this.ac.a(ai.idealistic.vacan.utils.minecraft.entity.e.lD, 1L);
      if (var3 != null) {
         var1 += 0.1D * (double)(var3.gf.getAmplifier() + 1);
      }

      return var1;
   }

   private double g(double var1) {
      return Math.abs(var1);
   }

   private double ae() {
      return this.dA;
   }

   private void o(double var1) {
      this.dA = var1;
   }

   private boolean af() {
      return this.ac.dp().aX();
   }

   private boolean ag() {
      return this.ac.dp().bc();
   }

   private boolean ah() {
      return this.ac.dp().aY();
   }

   private boolean ai() {
      return this.ac.dp().aY();
   }

   private boolean aj() {
      return this.ac.dp().ba();
   }

   private boolean ak() {
      return this.ac.dp().bb();
   }

   private boolean al() {
      return this.ac.dp().aU();
   }

   private boolean am() {
      return this.ac.dp().aV();
   }

   private boolean an() {
      return this.ac.dp().aW();
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

   private boolean e(Location var1) {
      double var2 = var1.getX();
      double var4 = var1.getY();
      double var6 = var1.getZ();

      for(int var8 = -1; var8 <= 1; ++var8) {
         for(int var9 = -1; var9 <= 1; ++var9) {
            for(int var10 = -1; var10 <= 1; ++var10) {
               Material var11 = this.ac.gL.k(new Location(this.ac.bV(), var2 + (double)var8 * 0.3D, var4 + (double)var9 * 0.3D, var6 + (double)var10 * 0.3D));
               if (var11 != null && ai.idealistic.vacan.utils.minecraft.world.c.ab(var11)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private boolean c(Location var1) {
      double var2 = var1.getX();
      double var4 = var1.getY() - 0.1D;
      double var6 = var1.getZ();

      for(int var8 = -1; var8 <= 1; ++var8) {
         for(int var9 = -1; var9 <= 1; ++var9) {
            for(int var10 = -1; var10 <= 1; ++var10) {
               Material var11 = this.ac.gL.k(new Location(this.ac.bV(), var2 + (double)var8, var4 + (double)var9, var6 + (double)var10));
               if (var11 != null && ai.idealistic.vacan.utils.minecraft.world.c.ab(var11)) {
                  return true;
               }
            }
         }
      }

      return false;
   }
}
