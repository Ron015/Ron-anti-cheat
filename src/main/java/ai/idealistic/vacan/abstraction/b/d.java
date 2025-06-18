package ai.idealistic.vacan.abstraction.b;

import ai.idealistic.vacan.functionality.server.MultiVersion;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.Material;

public class d {
   private static final Material eS = ai.idealistic.vacan.utils.minecraft.a.d.au("magma");
   private boolean eT = false;
   private boolean dj = false;
   private boolean eU = false;
   private boolean eV = false;
   private boolean eW = false;
   private boolean eX = false;
   private boolean eY = false;
   private boolean eZ = false;
   private boolean fa = false;
   private boolean fb = false;

   public d(ai.idealistic.vacan.abstraction.f.c var1) {
      Location var2 = var1.cg() == null ? var1.getLocation() : var1.cg().getLocation();
      double var3 = var2.getX();
      double var5 = var2.getY() - 0.1D;
      double var7 = var2.getZ();

      for(int var9 = -2; var9 <= 2; ++var9) {
         for(int var10 = -2; var10 <= 2; ++var10) {
            for(int var11 = -2; var11 <= 2; ++var11) {
               boolean var12 = Math.abs(var9) < 2 && Math.abs(var11) < 2;
               ai.idealistic.vacan.abstraction.g.a var13 = (new ai.idealistic.vacan.abstraction.g.b(new Location(var1.bV(), var3 + (double)var9 * 0.3D, var5 + (double)var10 * 0.5D, var7 + (double)var11 * 0.3D))).dO();
               Material var14 = var1.gL.k(new Location(var1.bV(), var3 + (double)var9 * 0.3D, var5 + (double)var10 * 0.5D, var7 + (double)var11 * 0.3D));
               Material var15 = var1.gL.k(new Location(var1.bV(), var3 + (double)var9 * 0.5D, var5 + (double)var10 * 0.5D - 0.3D, var7 + (double)var11 * 0.5D));
               Material var16 = var1.gL.k(new Location(var1.bV(), var3 + (double)var9 * 0.5D, var5 + (double)var10 * 0.5D + 1.0D, var7 + (double)var11 * 0.5D));
               Material var17 = var1.gL.k(new Location(var1.bV(), var3 + (double)var9 * 0.3D, var5 + (double)var10 * 0.5D, var7 + (double)var11 * 0.3D));
               Material var18 = var13.dz();
               if (var14 == null || var17 == null || var18 == null) {
                  return;
               }

               if (ai.idealistic.vacan.utils.minecraft.world.c.W(var14) || ai.idealistic.vacan.utils.minecraft.world.c.s(var14) || ai.idealistic.vacan.utils.minecraft.world.c.X(var14)) {
                  this.dj = true;
               }

               if (Math.abs(var9) < 2 && Math.abs(var11) < 2 && (ai.idealistic.vacan.utils.minecraft.world.c.Z(var14) || ai.idealistic.vacan.utils.minecraft.world.c.s(var14) || ai.idealistic.vacan.utils.minecraft.world.c.x(var14))) {
                  this.eZ = true;
               }

               if (ai.idealistic.vacan.utils.minecraft.world.c.a(var14, false) || ai.idealistic.vacan.utils.minecraft.world.c.a(var16, false)) {
                  this.fa = true;
               }

               if (Math.abs(var10) < 2 && var12 && (ai.idealistic.vacan.utils.minecraft.world.c.x(var14) || ai.idealistic.vacan.utils.minecraft.world.c.x(var16) || ai.idealistic.vacan.utils.minecraft.world.c.W(var14) || ai.idealistic.vacan.utils.minecraft.world.c.L(var14) || ai.idealistic.vacan.utils.minecraft.world.c.L(var16) || ai.idealistic.vacan.utils.minecraft.world.c.Z(var14) || ai.idealistic.vacan.utils.minecraft.world.c.Z(var16))) {
                  this.eY = true;
               }

               if (!ai.idealistic.vacan.utils.minecraft.world.c.a(var14, false) && (ai.idealistic.vacan.utils.minecraft.world.c.ad(var14) || ai.idealistic.vacan.utils.minecraft.world.c.ad(var17) || ai.idealistic.vacan.utils.minecraft.world.c.ad(var15) || ai.idealistic.vacan.utils.minecraft.world.c.k(var17) || ai.idealistic.vacan.utils.minecraft.world.c.o(var17) || ai.idealistic.vacan.utils.minecraft.world.c.X(var14) || ai.idealistic.vacan.utils.minecraft.world.c.W(var14) || ai.idealistic.vacan.utils.minecraft.world.c.L(var14) || ai.idealistic.vacan.utils.minecraft.world.c.L(var16))) {
                  this.eX = true;
               }

               if (MultiVersion.c(MultiVersion.MCVersion.V1_13) && (var14.equals(Material.BUBBLE_COLUMN) || var18.equals(Material.BUBBLE_COLUMN))) {
                  this.fb = true;
               }

               double var19;
               if (ai.idealistic.vacan.utils.minecraft.world.c.a((Object)var13, true) || ai.idealistic.vacan.utils.minecraft.world.c.c(var1.gL.k(new Location(var1.bV(), var3 + (double)var9 * 0.3D, var5, var7 + (double)var11 * 0.3D))) || ai.idealistic.vacan.utils.minecraft.world.c.c(var14) || ai.idealistic.vacan.utils.minecraft.world.c.c(var18) || ai.idealistic.vacan.utils.minecraft.world.c.a(var13)) {
                  this.eW = true;

                  for(var19 = 0.0D; var19 < Math.ceil(var1.cn()); ++var19) {
                     boolean var21 = false;
                     Iterator var22 = (new ai.idealistic.vacan.abstraction.g.b(var2)).e(0.3D, var19, 0.3D).iterator();

                     while(var22.hasNext()) {
                        ai.idealistic.vacan.abstraction.g.b var23 = (ai.idealistic.vacan.abstraction.g.b)var22.next();
                        if (this.a(var1, var23)) {
                           var21 = true;
                           break;
                        }
                     }

                     if (var21) {
                        break;
                     }
                  }
               }

               if (ai.idealistic.vacan.utils.minecraft.world.c.G(var14)) {
                  this.eT = true;
               }

               var19 = var1.bM().getX();
               double var28 = var1.bM().getY();
               double var29 = var1.bM().getZ();
               Material var25 = var1.gL.k(new Location(var1.bV(), var3 + (double)var9, var5 + (double)var10, var7 + (double)var11));
               Material var26 = var1.gL.k(new Location(var1.bV(), var19 + (double)var9, var28 + (double)var10 - 1.0D, var29 + (double)var11));
               Material var27 = var1.gL.k(new Location(var1.bV(), var19 + (double)var9, var28 + (double)var10 + 0.5D, var29 + (double)var11));
               if (var25 == null) {
                  return;
               }

               if (ai.idealistic.vacan.utils.minecraft.world.c.W(var25) || ai.idealistic.vacan.utils.minecraft.world.c.s(var25) || ai.idealistic.vacan.utils.minecraft.world.c.X(var27) || ai.idealistic.vacan.utils.minecraft.world.c.X(var26) || ai.idealistic.vacan.utils.minecraft.world.c.X(var25)) {
                  var1.gk = 3;
               }

               if (var1.gk > 0) {
                  --var1.gk;
                  this.eV = true;
                  this.eU = true;
                  this.dj = true;
               }
            }
         }
      }

   }

   private boolean a(ai.idealistic.vacan.abstraction.f.c var1, ai.idealistic.vacan.abstraction.g.b var2) {
      if (MultiVersion.c(MultiVersion.MCVersion.V1_13)) {
         int var3 = var2.dE();
         int var4 = ai.idealistic.vacan.utils.minecraft.world.c.c(var1.bV());
         if (var3 > var4) {
            ai.idealistic.vacan.abstraction.g.b var5 = var2.dC();
            int var6 = var3 - var4;
            int var7 = ai.idealistic.vacan.utils.b.a.B(var1.cn());
            HashSet var8 = new HashSet(var6);
            HashSet var9 = new HashSet(var6);

            for(int var10 = 0; var10 <= var6; ++var10) {
               Collection var11 = var5.dC().d(0.0D, (double)(-var10), 0.0D).e(0.3D, 0.0D, 0.3D);
               Iterator var12 = var11.iterator();

               while(var12.hasNext()) {
                  ai.idealistic.vacan.abstraction.g.b var13 = (ai.idealistic.vacan.abstraction.g.b)var12.next();
                  ai.idealistic.vacan.abstraction.g.a var14 = var13.dO();
                  Material var15 = var14.dz();
                  if (var15 == Material.SOUL_SAND) {
                     var1.gT = System.currentTimeMillis();
                     var1.gV = System.currentTimeMillis();
                     return true;
                  }

                  if (var15 == eS) {
                     var1.gU = System.currentTimeMillis();
                     var1.gV = System.currentTimeMillis();
                     return true;
                  }

                  if (ai.idealistic.vacan.utils.minecraft.world.c.ab(var15)) {
                     if (!var14.dB()) {
                        var9.add(var10);
                        if (var9.size() == var7) {
                           return false;
                        }
                     }
                  } else if (!var14.dB()) {
                     var8.add(var10);
                     if (var8.size() == 8) {
                        return false;
                     }
                  }
               }
            }
         }
      }

      return false;
   }

   public boolean aS() {
      return !this.aT() && !this.aY() && !this.aU() && !this.aW() && !this.aX() && !this.ba() && !this.bc();
   }

   @Generated
   public boolean aT() {
      return this.eT;
   }

   @Generated
   public boolean aU() {
      return this.dj;
   }

   @Generated
   public boolean aV() {
      return this.eU;
   }

   @Generated
   public boolean aW() {
      return this.eV;
   }

   @Generated
   public boolean aX() {
      return this.eW;
   }

   @Generated
   public boolean aY() {
      return this.eX;
   }

   @Generated
   public boolean aZ() {
      return this.eY;
   }

   @Generated
   public boolean ba() {
      return this.eZ;
   }

   @Generated
   public boolean bb() {
      return this.fa;
   }

   @Generated
   public boolean bc() {
      return this.fb;
   }

   @Generated
   public void j(boolean var1) {
      this.eT = var1;
   }

   @Generated
   public void k(boolean var1) {
      this.dj = var1;
   }

   @Generated
   public void l(boolean var1) {
      this.eU = var1;
   }

   @Generated
   public void m(boolean var1) {
      this.eV = var1;
   }

   @Generated
   public void n(boolean var1) {
      this.eW = var1;
   }

   @Generated
   public void o(boolean var1) {
      this.eX = var1;
   }

   @Generated
   public void p(boolean var1) {
      this.eY = var1;
   }

   @Generated
   public void q(boolean var1) {
      this.eZ = var1;
   }

   @Generated
   public void r(boolean var1) {
      this.fa = var1;
   }

   @Generated
   public void s(boolean var1) {
      this.fb = var1;
   }

   @Generated
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof d)) {
         return false;
      } else {
         d var2 = (d)var1;
         if (!var2.e(this)) {
            return false;
         } else if (this.aT() != var2.aT()) {
            return false;
         } else if (this.aU() != var2.aU()) {
            return false;
         } else if (this.aV() != var2.aV()) {
            return false;
         } else if (this.aW() != var2.aW()) {
            return false;
         } else if (this.aX() != var2.aX()) {
            return false;
         } else if (this.aY() != var2.aY()) {
            return false;
         } else if (this.aZ() != var2.aZ()) {
            return false;
         } else if (this.ba() != var2.ba()) {
            return false;
         } else if (this.bb() != var2.bb()) {
            return false;
         } else {
            return this.bc() == var2.bc();
         }
      }
   }

   @Generated
   protected boolean e(Object var1) {
      return var1 instanceof d;
   }

   @Generated
   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      int var3 = var2 * 59 + (this.aT() ? 79 : 97);
      var3 = var3 * 59 + (this.aU() ? 79 : 97);
      var3 = var3 * 59 + (this.aV() ? 79 : 97);
      var3 = var3 * 59 + (this.aW() ? 79 : 97);
      var3 = var3 * 59 + (this.aX() ? 79 : 97);
      var3 = var3 * 59 + (this.aY() ? 79 : 97);
      var3 = var3 * 59 + (this.aZ() ? 79 : 97);
      var3 = var3 * 59 + (this.ba() ? 79 : 97);
      var3 = var3 * 59 + (this.bb() ? 79 : 97);
      var3 = var3 * 59 + (this.bc() ? 79 : 97);
      return var3;
   }

   @Generated
   public String toString() {
      return "EnvironmentData(ice=" + this.aT() + ", slime=" + this.aU() + ", slimeWide=" + this.aV() + ", slimeHeight=" + this.aW() + ", liquid=" + this.aX() + ", semi=" + this.aY() + ", glide=" + this.aZ() + ", jumpModify=" + this.ba() + ", climb=" + this.bb() + ", bubble=" + this.bc() + ")";
   }

   @Generated
   public d() {
   }
}
