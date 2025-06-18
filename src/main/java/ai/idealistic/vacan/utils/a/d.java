package ai.idealistic.vacan.utils.a;

import lombok.Generated;

public final class d<X, Y> {
   private X kc;
   private Y kd;

   @Generated
   public X fr() {
      return this.kc;
   }

   @Generated
   public Y fs() {
      return this.kd;
   }

   @Generated
   public void j(X var1) {
      this.kc = var1;
   }

   @Generated
   public void k(Y var1) {
      this.kd = var1;
   }

   @Generated
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof d)) {
         return false;
      } else {
         d var2 = (d)var1;
         Object var3 = this.fr();
         Object var4 = var2.fr();
         if (var3 == null) {
            if (var4 != null) {
               return false;
            }
         } else if (!var3.equals(var4)) {
            return false;
         }

         Object var5 = this.fs();
         Object var6 = var2.fs();
         if (var5 == null) {
            if (var6 != null) {
               return false;
            }
         } else if (!var5.equals(var6)) {
            return false;
         }

         return true;
      }
   }

   @Generated
   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      Object var3 = this.fr();
      int var5 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      Object var4 = this.fs();
      var5 = var5 * 59 + (var4 == null ? 43 : var4.hashCode());
      return var5;
   }

   @Generated
   public String toString() {
      return "Pair(x=" + this.fr() + ", y=" + this.fs() + ")";
   }

   @Generated
   public d(X var1, Y var2) {
      this.kc = var1;
      this.kd = var2;
   }
}
