package ai.idealistic.vacan.utils.b;

import lombok.Generated;

public class e {
   public final double ho;
   public final double hq;

   @Generated
   public double dT() {
      return this.ho;
   }

   @Generated
   public double dV() {
      return this.hq;
   }

   @Generated
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof e)) {
         return false;
      } else {
         e var2 = (e)var1;
         if (!var2.e(this)) {
            return false;
         } else if (Double.compare(this.dT(), var2.dT()) != 0) {
            return false;
         } else {
            return Double.compare(this.dV(), var2.dV()) == 0;
         }
      }
   }

   @Generated
   protected boolean e(Object var1) {
      return var1 instanceof e;
   }

   @Generated
   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      long var3 = Double.doubleToLongBits(this.dT());
      int var7 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
      long var5 = Double.doubleToLongBits(this.dV());
      var7 = var7 * 59 + (int)(var5 >>> 32 ^ var5);
      return var7;
   }

   @Generated
   public String toString() {
      return "RayLine(x=" + this.dT() + ", z=" + this.dV() + ")";
   }

   @Generated
   public e(double var1, double var3) {
      this.ho = var1;
      this.hq = var3;
   }
}
