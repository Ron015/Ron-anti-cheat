package ai.idealistic.vacan.abstraction.check.implementation.combat.killaura.movedirection;

import ai.idealistic.vacan.abstraction.check.Check;
import ai.idealistic.vacan.abstraction.check.e;
import ai.idealistic.vacan.utils.b.f;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.util.Vector;

public class c extends ai.idealistic.vacan.abstraction.check.b {
   private final ai.idealistic.vacan.abstraction.check.b bz = new ai.idealistic.vacan.abstraction.check.a.a(this, "move_direction_1", true, 2000L, 30000L, 40000L, 60000L);
   private final ai.idealistic.vacan.abstraction.check.b bA = new ai.idealistic.vacan.abstraction.check.a.a(this, "move_direction_2", true, 2000L, 30000L, 40000L, 60000L);
   private b bB = new b((Entity)null, System.currentTimeMillis());
   private final List<a> bC = new ai.idealistic.vacan.utils.a.a();
   private float aQ = 0.0F;
   private float bD = 0.0F;
   private String bE = "";
   private String bF = "";
   private double bG;
   private final List<UUID> bH = new ai.idealistic.vacan.utils.a.a();
   private final List<Double> aD = new ai.idealistic.vacan.utils.a.a();

   public c(e var1) {
      super(var1, (Check.DataType)null, (Check.DetectionType)null, (String)null, true);
   }

   public void run() {
      this.a((Runnable)(() -> {
         if (this.bB.bw + 3000L > System.currentTimeMillis()) {
            Entity var1 = this.bB.by;
            if (var1 != null) {
               Location var2 = ai.idealistic.vacan.compatibility.b.a.b.f(var1);
               if (var2 == null) {
                  return;
               }

               double var3 = (double)f.a(this.ac, var1);
               double var5 = var3 - 0.4D;
               double var7 = (double)f.l(a(this.ac.getLocation().toVector(), (new ai.idealistic.vacan.abstraction.g.b(var2)).dL()).lP);
               double var9 = (double)f.l(this.ac.getLocation().getYaw());
               this.aD.add(var3);
               this.bC.add(new a(Math.abs(var7 - var9), this.ac.getLocation().getYaw(), this.ac.getLocation().getPitch(), System.currentTimeMillis(), ai.idealistic.vacan.compatibility.b.a.b.d(var1)));
               if (this.aD.size() >= 10) {
                  this.D();
               }
            }
         }

      }));
   }

   private void D() {
      this.bH.clear();
      this.bE = "";
      this.bF = "";
      double var1 = 0.0D;
      double var3 = 0.0D;
      double var5 = (double)((a)this.bC.get(0)).bv;
      double var7 = (double)((a)this.bC.get(0)).bu;
      double var9 = (double)((a)this.bC.get(0)).bv;
      double var11 = (double)Math.abs(((a)this.bC.get(0)).bu - ((a)this.bC.get(1)).bu);
      int var13 = 0;
      int var14 = 0;
      int var15 = 0;
      int var16 = 0;
      int var17 = 0;
      int var18 = 0;
      int var19 = 0;
      int var20 = 0;
      int var21 = 0;
      int var22 = 0;
      int var23 = 0;
      int var24 = 0;

      Iterator var25;
      Double var26;
      for(var25 = this.aD.iterator(); var25.hasNext(); var1 += var26) {
         var26 = (Double)var25.next();
      }

      a var57;
      for(var25 = this.bC.iterator(); var25.hasNext(); var5 = (double)var57.bu) {
         var57 = (a)var25.next();
         var3 += Math.abs((double)var57.bu - var5);
      }

      double var56 = Math.abs((double)((a)this.bC.get(0)).bu - var7);
      double var27 = Math.abs((double)((a)this.bC.get(0)).bv - var9);

      double var10000;
      for(int var29 = 0; var29 < this.bC.size(); ++var29) {
         if (!this.bH.contains(((a)this.bC.get(var29)).bx)) {
            this.bH.add(((a)this.bC.get(var29)).bx);
         }

         double var30 = Math.abs((double)((a)this.bC.get(var29)).bu - var7);
         double var32 = Math.abs((double)((a)this.bC.get(var29)).bv - var9);
         double var34 = var30 * 1.0737420320510864D + (double)((float)(var30 + 0.15D));
         double var36 = var32 * 1.0737420320510864D - (double)((float)(var32 - 0.15D));
         double var38 = Math.abs(var30 - var34);
         double var40 = Math.abs(var32 - var36);
         double var42 = Math.abs(var30 - var38);
         double var44 = Math.abs(var32 - var40);
         double var46 = Math.abs(var42 - this.bG);
         double var50 = Math.abs(var30 - var11);
         double var52 = var30 - var56;
         var10000 = var32 - var27;
         if (var50 < 2.0D && var30 > 2.5D && ((a)this.bC.get(var29)).bt < 10.0D) {
            ++var22;
         }

         if ((Double)this.aD.get(var29) < 0.1D && var30 > 5.0D) {
            ++var13;
         }

         if ((Double)this.aD.get(var29) < 0.03D && var30 > 1.0D) {
            ++var14;
         }

         if (var50 < 0.99D && var30 > 3.0D) {
            ++var15;
         }

         if (var50 < 0.02D && var30 > 2.0D) {
            ++var16;
         }

         if (var50 < 2.0D && var30 > 3.0D) {
            ++var23;
         }

         double var48 = f.l(var30 / var50, 2.0D);
         if (Double.isInfinite(var48)) {
            ++var24;
         }

         if (f.l(var30, 2.0D) == 0.1D || f.l(var32, 2.0D) == 0.1D) {
            ++var17;
         }

         if (f.l(var30, 2.0D) == 0.01D || f.l(var32, 2.0D) == 0.01D) {
            ++var17;
         }

         if (var52 > 0.01D && var52 < 2.0D) {
            ++var18;
         }

         if (var52 < -0.01D && var52 > -2.0D) {
            ++var19;
         }

         if (var52 > 2.0D) {
            ++var20;
         }

         if (var52 < -2.0D) {
            ++var21;
         }

         var7 = (double)((a)this.bC.get(var29)).bu;
         var9 = (double)((a)this.bC.get(var29)).bv;
         var56 = var30;
         var27 = var32;
         this.bG = var42;
      }

      var10000 = var1 / (double)this.aD.size();
      if (this.bH.size() < 3) {
         if (var13 > 6) {
            this.a("heuristic(basic)", 210.0F);
         }

         if (var14 > 7) {
            this.a("heuristic(low)", 210.0F);
         }

         if (var22 > 7) {
            this.a("heuristic(sync)", 170.0F);
         }

         if (var15 > 4) {
            this.a("heuristic(aim)", 100.0F);
         }

         if (var23 > 8) {
            this.a("heuristic(aggressive)", 65.0F);
         }

         if (var16 > 2) {
            this.a("heuristic(constant)", 60.0F);
         }

         if (var24 > 1) {
            this.b("heuristic(interpolation)", var24 > 2 ? 40.0F : 35.0F);
         }

         if (var17 > 2) {
            this.a("pattern(gcd)", 210.0F);
         }

         if (var18 > 3 && var19 > 3) {
            this.a("pattern(random)", 40.0F);
         }

         if (var20 > 3 && var21 > 3 && var20 + var21 > 8 && this.bH.size() < 2) {
            this.a("pattern(snap)", 40.0F);
         }
      }

      double var31 = Math.floor((double)(this.aQ / 200.0F));
      if (!this.bE.isEmpty() && this.aQ > a(E()).bJ) {
         this.bz.a("(layer1) type: " + this.bE + ", bH: " + var13 + ", lH: " + var14 + ", rA: " + var22 + ", mKM: " + var15 + ", aA: " + var23 + ", cR: " + var16 + ", gcd: " + var17 + ", aPI: " + var18 + ", aPD: " + var19 + ", aPI2: " + var20 + ", aPD2: " + var21, this.ac.bM());
         this.aQ -= 10.0F;
      }

      if (!this.bF.isEmpty() && this.bD > a(E()).bJ / 2.0F + 50.0F) {
         this.bA.a("(layer2) type: " + this.bF + ", infs: " + var24, this.ac.bM());
         this.bD -= 10.0F;
      }

      if (this.aQ > 0.0F) {
         this.aQ -= a(E()).bK;
      }

      if (this.aQ > a(E()).bJ) {
         this.aQ -= 10.0F;
      }

      if (this.bD > 0.0F) {
         this.bD -= (float)((double)a(E()).bK * 1.5D);
      }

      if ((double)this.bD > (double)a(E()).bJ * 1.5D) {
         this.bD -= 10.0F;
      }

      this.aD.clear();
      this.bC.clear();
   }

   public void a(Entity var1) {
      this.a((Runnable)(() -> {
         if (var1 instanceof Player || var1 instanceof Zombie || var1 instanceof Creeper || var1 instanceof Skeleton) {
            this.bB = new b(var1, System.currentTimeMillis());
         }

      }));
   }

   private static ai.idealistic.vacan.utils.minecraft.d.b a(Vector var0, Vector var1) {
      Vector var2 = var1.subtract(var0);
      double var3 = Math.hypot(var2.getX(), var2.getZ());
      float var5 = (float)(Math.atan2(var2.getZ(), var2.getX()) * 180.0D / 3.141592653589793D) - 90.0F;
      float var6 = (float)(-(Math.atan2(var2.getY(), var3) * 180.0D / 3.141592653589793D));
      return new ai.idealistic.vacan.utils.minecraft.d.b(var5, var6);
   }

   private void a(String var1, float var2) {
      this.aQ += var2 / (float)this.bH.size();
      if (this.bE.isEmpty()) {
         this.bE = var1;
      } else {
         this.bE = this.bE + ", " + var1;
      }

   }

   private void b(String var1, float var2) {
      this.bD += var2;
      if (this.bF.isEmpty()) {
         this.bF = var1;
      } else if (!this.bF.contains(var1)) {
         this.bF = this.bF + ", " + var1;
      }

   }

   private static PriorityType E() {
      return PriorityType.CAREFUL;
   }

   private static d a(PriorityType var0) {
      switch(var0) {
      case AGGRESSIVE:
         return new d(200.0F, 4.0F);
      case LENIENT:
         return new d(900.0F, 6.0F);
      case SILENT:
         return new d(1500.0F, 8.0F);
      default:
         return new d(400.0F, 5.0F);
      }
   }
}
