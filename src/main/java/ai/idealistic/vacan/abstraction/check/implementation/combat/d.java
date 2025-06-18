package ai.idealistic.vacan.abstraction.check.implementation.combat;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.CheckEnums;
import ai.idealistic.vacan.functionality.server.MultiVersion;
import ai.idealistic.vacan.utils.b.f;
import ai.idealistic.vacan.utils.b.h;
import ai.idealistic.vacan.utils.minecraft.entity.MovingObjectPosition;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Pose;

public class d extends ai.idealistic.vacan.abstraction.check.e {
   private final ai.idealistic.vacan.abstraction.check.b az = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "hitbox_raytrace", true, 2000L, 30000L, 40000L, 60000L);
   private final ai.idealistic.vacan.abstraction.check.b aA = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "throughblocks", true, 2000L, 30000L, 40000L, 60000L);
   private final ai.idealistic.vacan.abstraction.check.b aB = new ai.idealistic.vacan.abstraction.check.a.a(this, (Check.DataType)null, (Check.DetectionType)null, "simple", true, 2000L, 30000L, 40000L, 60000L);
   private static final boolean aC;
   private final List<Double> aD = new ai.idealistic.vacan.utils.a.a();
   private int aE = 0;
   private static final boolean[] aF;
   private static final double aG = 3.001D;
   private static final double aH = 10.0D;
   private double aI = -1.0D;
   private double aJ = 0.0D;
   private double aK = 0.0D;
   private final ai.idealistic.vacan.utils.b.d aL = new ai.idealistic.vacan.utils.b.d();
   private final h aM = new h();

   public d(CheckEnums.HackType var1, ai.idealistic.vacan.abstraction.f.c var2) {
      super(var1, var2);
   }

   protected void a(boolean var1, Object var2) {
      if (var2 instanceof ai.idealistic.vacan.abstraction.d.e) {
         ai.idealistic.vacan.abstraction.d.e var3 = (ai.idealistic.vacan.abstraction.d.e)var2;
         if (!(var3.fz instanceof Player)) {
            return;
         }

         if (var3.fz.getVehicle() != null || this.ac.cg() != null) {
            return;
         }

         if (this.ac.bW()) {
            if (ai.idealistic.vacan.utils.minecraft.entity.b.b(this.ac, ai.idealistic.vacan.functionality.server.c.i((Player)var3.fz).bC()) && !this.ac.cl().equals(GameMode.CREATIVE)) {
               ai.idealistic.vacan.abstraction.f.c var4 = ai.idealistic.vacan.functionality.server.c.i((Player)var3.fz);
               List var5 = var4.bQ();
               HashSet var6 = new HashSet();
               new HashSet();
               Location var8 = var4.getLocation().clone();
               Location var9 = this.ac.getLocation().clone();
               if (a(var9, var8) > 0.5D) {
                  Location var10 = var4.getLocation();

                  for(int var11 = -3; var11 <= 3; ++var11) {
                     for(int var12 = -3; var12 <= 3; ++var12) {
                        for(int var13 = -3; var13 <= 3; ++var13) {
                           Location var14 = new Location(var4.bC().getWorld(), var10.getX() + (double)var11, var10.getY() + (double)var12, var10.getZ() + (double)var13);
                           Block var15 = a(var14);
                           if (var15 != null) {
                              Material var16 = var15.getType();
                              List var17 = MultiVersion.c(MultiVersion.MCVersion.V1_13) ? ai.idealistic.vacan.utils.minecraft.world.d.j(var15) : ai.idealistic.vacan.utils.minecraft.world.d.k(var15);
                              if (var16.isSolid() && var17 != null) {
                                 var6.addAll(var17);
                              }
                           }
                        }
                     }
                  }
               }

               boolean var44 = this.ac.a(MultiVersion.MCVersion.V1_8);
               float var45 = var44 ? 0.4F : 0.3F;
               AtomicReference var46 = new AtomicReference(Double.MAX_VALUE);
               HashSet var47 = new HashSet();
               boolean[] var48 = aF;
               int var50 = var48.length;

               for(int var52 = 0; var52 < var50; ++var52) {
                  boolean var53 = var48[var52];
                  Object var18 = var53 ? this.aL : this.aM;
                  Location var19 = this.ac.getLocation();
                  Location var20 = this.ac.bM();
                  ai.idealistic.vacan.utils.minecraft.d.c[] var21 = new ai.idealistic.vacan.utils.minecraft.d.c[]{a(var19.getYaw(), var19.getPitch(), (ai.idealistic.vacan.utils.b.b)var18), a(var20.getYaw(), var20.getPitch(), (ai.idealistic.vacan.utils.b.b)var18), a(var20.getYaw(), var20.getPitch(), (ai.idealistic.vacan.utils.b.b)var18)};
                  boolean[] var22 = aF;
                  int var23 = var22.length;

                  for(int var24 = 0; var24 < var23; ++var24) {
                     boolean var25 = var22[var24];
                     ai.idealistic.vacan.utils.minecraft.d.c[] var26 = var21;
                     int var27 = var21.length;

                     for(int var28 = 0; var28 < var27; ++var28) {
                        ai.idealistic.vacan.utils.minecraft.d.c var29 = var26[var28];
                        ai.idealistic.vacan.utils.minecraft.d.c var30 = new ai.idealistic.vacan.utils.minecraft.d.c(var19.getX(), var19.getY() + (double)this.b(var25), var19.getZ());
                        ai.idealistic.vacan.utils.minecraft.d.c var31 = var30.q(var29.lR * 6.0D, var29.lS * 6.0D, var29.lT * 6.0D);
                        LinkedList var32 = new LinkedList(var5);
                        var32.add(var4.getLocation());
                        var32.add(var4.bM());
                        var32.add(var4.bC().getLocation().clone());
                        Iterator var33 = var32.iterator();

                        while(var33.hasNext()) {
                           Location var34 = (Location)var33.next();
                           ai.idealistic.vacan.utils.minecraft.entity.a var35 = new ai.idealistic.vacan.utils.minecraft.entity.a(var34.getX() - (double)var45, var34.getY() - 0.10000000149011612D, var34.getZ() - (double)var45, var34.getX() + (double)var45, var34.getY() + 1.899999976158142D, var34.getZ() + (double)var45);
                           MovingObjectPosition var36 = var35.a(var30, var31);
                           if (var36 != null) {
                              double var37 = var36.kS.j(var30);
                              if (var37 < (Double)var46.get()) {
                                 var46.set(var37);
                              }
                           }
                        }

                        double var54 = Double.MAX_VALUE;
                        Iterator var55 = var6.iterator();

                        while(var55.hasNext()) {
                           ai.idealistic.vacan.utils.minecraft.entity.a var56 = (ai.idealistic.vacan.utils.minecraft.entity.a)var55.next();
                           ai.idealistic.vacan.utils.minecraft.d.c var57 = new ai.idealistic.vacan.utils.minecraft.d.c(var19.getX(), var19.getY() + (double)this.c(var25), var19.getZ());
                           ai.idealistic.vacan.utils.minecraft.d.c var38 = var57.q(var29.lR * 6.0D, var29.lS * 6.0D, var29.lT * 6.0D);
                           MovingObjectPosition var39 = var56.a(var57, var38);
                           double var40 = var39 != null ? var39.kS.j(var30) : 0.0D;
                           if (var40 < (Double)var46.get() && var40 < var54 && var39 != null && var40 < 6.0D) {
                              var54 = var40;
                           }
                        }

                        var47.add(var54);
                     }
                  }
               }

               boolean var49 = false;
               if ((Double)var46.get() > 10.0D) {
                  var49 = true;
                  if (++this.aI > 3.0D) {
                     this.az.c("Missing HitBox of " + var4.bC().getName());
                     var3.setCancelled(true);
                  }
               } else {
                  this.aI = Math.max(this.aI - 5.0D, 0.0D);
               }

               if ((Double)var46.get() > 3.001D && (Double)var46.get() < 10.0D) {
                  var49 = true;
                  if (this.aJ++ > 2.5D) {
                     this.az.c("Distance " + var46.get());
                     var3.setCancelled(true);
                  }
               } else if ((Double)var46.get() < 3.001D && this.aJ > 0.0D) {
                  this.aJ -= 0.05D;
               }

               double var51 = ai.idealistic.vacan.utils.b.a.b.e((Collection)var47) + 0.03D + 0.003D - (Double)var46.get();
               if (var51 < -0.669D) {
                  ++this.aK;
                  this.aA.c("Hitting through block (dev: " + f.l(Math.abs(var51), 6.0D) + ")");
                  var3.setCancelled(true);
               } else if (this.aK > 0.0D) {
                  this.aK -= 0.5D;
               }
            }
         } else {
            LivingEntity var42 = var3.fz;
            if (ai.idealistic.vacan.utils.minecraft.entity.b.b(this.ac, var42) && !this.ac.cl().equals(GameMode.CREATIVE)) {
               double var43 = (double)f.a((ai.idealistic.vacan.abstraction.f.c)this.ac, (Entity)var42);
               double var7 = var43 - 0.4D;
               this.aD.add(var43);
               if (this.aD.size() >= 10) {
                  this.a(this.ac.getLocation(), var43);
               }
            }
         }
      }

   }

   private static ai.idealistic.vacan.utils.minecraft.d.c a(float var0, float var1, ai.idealistic.vacan.utils.b.b var2) {
      float var3 = var2.e(-var0 * 0.017453292F - 3.1415927F);
      float var4 = var2.d(-var0 * 0.017453292F - 3.1415927F);
      float var5 = -var2.e(-var1 * 0.017453292F);
      float var6 = var2.d(-var1 * 0.017453292F);
      return new ai.idealistic.vacan.utils.minecraft.d.c((double)(var4 * var5), (double)var6, (double)(var3 * var5));
   }

   private float b(boolean var1) {
      float var2 = 1.62F;
      if (var1) {
         var2 -= 0.08F;
      }

      if (aC && this.ac.bC().getPose().equals(Pose.SWIMMING)) {
         --var2;
      }

      return var2;
   }

   private float c(boolean var1) {
      float var2;
      if (aC && this.ac.bC().getPlayer().getPose().equals(Pose.SWIMMING)) {
         var2 = 0.4F;
      } else {
         var2 = 1.62F;
         if (var1) {
            var2 -= 0.35F;
         }
      }

      return var2;
   }

   private static Block a(Location var0) {
      return var0.getWorld().isChunkLoaded(var0.getBlockX() >> 4, var0.getBlockZ() >> 4) ? var0.getWorld().getBlockAt(var0) : null;
   }

   private static double a(Location var0, Location var1) {
      double var2 = var0.getX() - var1.getX();
      double var4 = var0.getY() - var1.getY();
      double var6 = var0.getZ() - var1.getZ();
      return Math.sqrt(var2 * var2 + var4 * var4 + var6 * var6);
   }

   private void a(Location var1, double var2) {
      String var4 = null;
      double var5 = 0.0D;

      Double var8;
      for(Iterator var7 = this.aD.iterator(); var7.hasNext(); var5 += var8) {
         var8 = (Double)var7.next();
      }

      double var10 = var5 / (double)this.aD.size();
      if (var10 > (this.ac.bW() ? 0.43D : 0.5D)) {
         var4 = "simple";
      }

      int var9 = (int)(var10 / 0.4D * 100.0D);
      if (var4 != null) {
         this.aE += 100;
         this.aB.a(var4 + ", hitbox-size-analysis: " + var10 + ", hitbox-size-last: " + var2 + ", percent-of-deviation: " + var9 + "%, reach: " + f.l(var10 / 0.4D * 3.0D, 2.0D) + " blocks", var1);
      } else if (this.aE > 0) {
         this.aE -= 50;
      }

      this.aD.clear();
   }

   protected boolean m() {
      return ai.idealistic.vacan.utils.minecraft.entity.b.F(this.ac);
   }

   static {
      aC = MultiVersion.c(MultiVersion.MCVersion.V1_14);
      aF = new boolean[]{true, false};
   }
}
