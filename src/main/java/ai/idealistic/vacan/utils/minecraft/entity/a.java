package ai.idealistic.vacan.utils.minecraft.entity;

import ai.idealistic.vacan.utils.minecraft.world.EnumFacing;
import lombok.Generated;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class a {
   public double kF;
   public double kG;
   public double kH;
   public double kI;
   public double kJ;
   public double kK;

   public a(a var1) {
      this.kF = var1.kF;
      this.kG = var1.kG;
      this.kH = var1.kH;
      this.kI = var1.kI;
      this.kJ = var1.kJ;
      this.kK = var1.kK;
   }

   public a(double var1, double var3, double var5, double var7, double var9, double var11) {
      this.kF = Math.min(var1, var7);
      this.kG = Math.min(var3, var9);
      this.kH = Math.min(var5, var11);
      this.kI = Math.max(var1, var7);
      this.kJ = Math.max(var3, var9);
      this.kK = Math.max(var5, var11);
   }

   public a(Location var1) {
      this(var1.getX() - 0.30000001192092896D, var1.getY(), var1.getZ() - 0.30000001192092896D, var1.getX() + 0.30000001192092896D, var1.getY() + 1.7999999523162842D, var1.getZ() + 0.30000001192092896D);
   }

   public a j(double var1, double var3, double var5) {
      double var7 = this.kF;
      double var9 = this.kG;
      double var11 = this.kH;
      double var13 = this.kI;
      double var15 = this.kJ;
      double var17 = this.kK;
      if (var1 < 0.0D) {
         var7 += var1;
      } else if (var1 > 0.0D) {
         var13 += var1;
      }

      if (var3 < 0.0D) {
         var9 += var3;
      } else if (var3 > 0.0D) {
         var15 += var3;
      }

      if (var5 < 0.0D) {
         var11 += var5;
      } else if (var5 > 0.0D) {
         var17 += var5;
      }

      return new a(var7, var9, var11, var13, var15, var17);
   }

   public a k(double var1, double var3, double var5) {
      double var7 = this.kF - var1;
      double var9 = this.kG - var3;
      double var11 = this.kH - var5;
      double var13 = this.kI + var1;
      double var15 = this.kJ + var3;
      double var17 = this.kK + var5;
      return new a(var7, var9, var11, var13, var15, var17);
   }

   public a a(a var1) {
      double var2 = Math.min(this.kF, var1.kF);
      double var4 = Math.min(this.kG, var1.kG);
      double var6 = Math.min(this.kH, var1.kH);
      double var8 = Math.max(this.kI, var1.kI);
      double var10 = Math.max(this.kJ, var1.kJ);
      double var12 = Math.max(this.kK, var1.kK);
      return new a(var2, var4, var6, var8, var10, var12);
   }

   public static a c(double var0, double var2, double var4, double var6, double var8, double var10) {
      double var12 = Math.min(var0, var6);
      double var14 = Math.min(var2, var8);
      double var16 = Math.min(var4, var10);
      double var18 = Math.max(var0, var6);
      double var20 = Math.max(var2, var8);
      double var22 = Math.max(var4, var10);
      return new a(var12, var14, var16, var18, var20, var22);
   }

   public a l(double var1, double var3, double var5) {
      return new a(this.kF + var1, this.kG + var3, this.kH + var5, this.kI + var1, this.kJ + var3, this.kK + var5);
   }

   public double a(a var1, double var2) {
      if (var1.kJ > this.kG && var1.kG < this.kJ && var1.kK > this.kH && var1.kH < this.kK) {
         double var4;
         if (var2 > 0.0D && var1.kI <= this.kF) {
            var4 = this.kF - var1.kI;
            if (var4 < var2) {
               var2 = var4;
            }
         } else if (var2 < 0.0D && var1.kF >= this.kI) {
            var4 = this.kI - var1.kF;
            if (var4 > var2) {
               var2 = var4;
            }
         }
      }

      return var2;
   }

   public double b(a var1, double var2) {
      if (var1.kI > this.kF && var1.kF < this.kI && var1.kK > this.kH && var1.kH < this.kK) {
         double var4;
         if (var2 > 0.0D && var1.kJ <= this.kG) {
            var4 = this.kG - var1.kJ;
            if (var4 < var2) {
               var2 = var4;
            }
         } else if (var2 < 0.0D && var1.kG >= this.kJ) {
            var4 = this.kJ - var1.kG;
            if (var4 > var2) {
               var2 = var4;
            }
         }
      }

      return var2;
   }

   public double c(a var1, double var2) {
      if (var1.kI > this.kF && var1.kF < this.kI && var1.kJ > this.kG && var1.kG < this.kJ) {
         double var4;
         if (var2 > 0.0D && var1.kK <= this.kH) {
            var4 = this.kH - var1.kK;
            if (var4 < var2) {
               var2 = var4;
            }
         } else if (var2 < 0.0D && var1.kH >= this.kK) {
            var4 = this.kK - var1.kH;
            if (var4 > var2) {
               var2 = var4;
            }
         }
      }

      return var2;
   }

   public boolean b(a var1) {
      return var1.kI > this.kF && var1.kF < this.kI && var1.kJ > this.kG && var1.kG < this.kJ && var1.kK > this.kH && var1.kH < this.kK;
   }

   public boolean a(ai.idealistic.vacan.utils.minecraft.d.c var1) {
      return var1.lR > this.kF && var1.lR < this.kI && var1.lS > this.kG && var1.lS < this.kJ && var1.lT > this.kH && var1.lT < this.kK;
   }

   public double fv() {
      double var1 = this.kI - this.kF;
      double var3 = this.kJ - this.kG;
      double var5 = this.kK - this.kH;
      return (var1 + var3 + var5) / 3.0D;
   }

   public a m(double var1, double var3, double var5) {
      double var7 = this.kF + var1;
      double var9 = this.kG + var3;
      double var11 = this.kH + var5;
      double var13 = this.kI - var1;
      double var15 = this.kJ - var3;
      double var17 = this.kK - var5;
      return new a(var7, var9, var11, var13, var15, var17);
   }

   public MovingObjectPosition a(ai.idealistic.vacan.utils.minecraft.d.c var1, ai.idealistic.vacan.utils.minecraft.d.c var2) {
      ai.idealistic.vacan.utils.minecraft.d.c var3 = var1.a(var2, this.kF);
      ai.idealistic.vacan.utils.minecraft.d.c var4 = var1.a(var2, this.kI);
      ai.idealistic.vacan.utils.minecraft.d.c var5 = var1.b(var2, this.kG);
      ai.idealistic.vacan.utils.minecraft.d.c var6 = var1.b(var2, this.kJ);
      ai.idealistic.vacan.utils.minecraft.d.c var7 = var1.c(var2, this.kH);
      ai.idealistic.vacan.utils.minecraft.d.c var8 = var1.c(var2, this.kK);
      if (!this.b(var3)) {
         var3 = null;
      }

      if (!this.b(var4)) {
         var4 = null;
      }

      if (!this.c(var5)) {
         var5 = null;
      }

      if (!this.c(var6)) {
         var6 = null;
      }

      if (!this.d(var7)) {
         var7 = null;
      }

      if (!this.d(var8)) {
         var8 = null;
      }

      ai.idealistic.vacan.utils.minecraft.d.c var9 = null;
      if (var3 != null) {
         var9 = var3;
      }

      if (var4 != null && (var9 == null || var1.k(var4) < var1.k(var9))) {
         var9 = var4;
      }

      if (var5 != null && (var9 == null || var1.k(var5) < var1.k(var9))) {
         var9 = var5;
      }

      if (var6 != null && (var9 == null || var1.k(var6) < var1.k(var9))) {
         var9 = var6;
      }

      if (var7 != null && (var9 == null || var1.k(var7) < var1.k(var9))) {
         var9 = var7;
      }

      if (var8 != null && (var9 == null || var1.k(var8) < var1.k(var9))) {
         var9 = var8;
      }

      if (var9 == null) {
         return null;
      } else {
         EnumFacing var10;
         if (var9 == var3) {
            var10 = EnumFacing.WEST;
         } else if (var9 == var4) {
            var10 = EnumFacing.EAST;
         } else if (var9 == var5) {
            var10 = EnumFacing.DOWN;
         } else if (var9 == var6) {
            var10 = EnumFacing.UP;
         } else if (var9 == var7) {
            var10 = EnumFacing.NORTH;
         } else {
            var10 = EnumFacing.SOUTH;
         }

         return new MovingObjectPosition(var9, var10);
      }
   }

   private boolean b(ai.idealistic.vacan.utils.minecraft.d.c var1) {
      return var1 != null && var1.lS >= this.kG && var1.lS <= this.kJ && var1.lT >= this.kH && var1.lT <= this.kK;
   }

   private boolean c(ai.idealistic.vacan.utils.minecraft.d.c var1) {
      return var1 != null && var1.lR >= this.kF && var1.lR <= this.kI && var1.lT >= this.kH && var1.lT <= this.kK;
   }

   private boolean d(ai.idealistic.vacan.utils.minecraft.d.c var1) {
      return var1 != null && var1.lR >= this.kF && var1.lR <= this.kI && var1.lS >= this.kG && var1.lS <= this.kJ;
   }

   public String toString() {
      return "box[" + this.kF + ", " + this.kG + ", " + this.kH + " -> " + this.kI + ", " + this.kJ + ", " + this.kK + "]";
   }

   public a n(double var1, double var3, double var5) {
      this.kF += var1;
      this.kG += var3;
      this.kH += var5;
      this.kI += var1;
      this.kJ += var3;
      this.kK += var5;
      return this;
   }

   public Vector dL() {
      double var1 = (this.kF + this.kI) / 2.0D;
      double var3 = (this.kH + this.kK) / 2.0D;
      double var5 = this.kG;
      return new Vector(var1, var5, var3);
   }

   public void c(a var1) {
      this.kF = Math.min(this.kF, var1.kF);
      this.kG = Math.min(this.kG, var1.kG);
      this.kH = Math.min(this.kH, var1.kH);
      this.kI = Math.max(this.kI, var1.kI);
      this.kJ = Math.max(this.kJ, var1.kJ);
      this.kK = Math.max(this.kK, var1.kK);
   }

   public double cn() {
      return (this.kJ - this.kG) * 0.8500000238418579D;
   }

   public Vector fw() {
      return this.dL().setY(this.cn() + this.kG);
   }

   public a fx() {
      return new a(this.kF, this.kG, this.kH, this.kI, this.kJ, this.kK);
   }

   public boolean d(a var1) {
      if (this == var1) {
         return true;
      } else if (var1 == null) {
         return false;
      } else {
         return this.kF == var1.kF && this.kG == var1.kG && this.kH == var1.kH && this.kI == var1.kI && this.kJ == var1.kJ && this.kK == var1.kK;
      }
   }

   @Generated
   public double fy() {
      return this.kF;
   }

   @Generated
   public double fz() {
      return this.kG;
   }

   @Generated
   public double fA() {
      return this.kH;
   }

   @Generated
   public double fB() {
      return this.kI;
   }

   @Generated
   public double fC() {
      return this.kJ;
   }

   @Generated
   public double fD() {
      return this.kK;
   }

   // $FF: synthetic method
   public Object clone() {
      return this.fx();
   }
}
