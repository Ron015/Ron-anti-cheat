package ai.idealistic.vacan.abstraction.b;

import org.bukkit.Location;

public class b {
   private ai.idealistic.vacan.abstraction.f.c eP;
   private Location eQ;
   public int eR;

   public b(ai.idealistic.vacan.abstraction.f.c var1, ai.idealistic.vacan.abstraction.f.c var2) {
      this.eP = var1;
      this.eQ = var2.getLocation();
      this.eR = 0;
   }

   public b(ai.idealistic.vacan.abstraction.f.c var1, Location var2) {
      this.eP = var1;
      this.eQ = var2;
      this.eR = 0;
   }

   public ai.idealistic.vacan.abstraction.f.c aP() {
      return this.eP;
   }

   public Location aQ() {
      return this.eQ;
   }

   public int aR() {
      return this.eR;
   }

   public void d(ai.idealistic.vacan.abstraction.f.c var1) {
      this.eP = var1;
   }

   public void j(Location var1) {
      this.eQ = var1;
   }

   public void c(int var1) {
      this.eR = var1;
   }

   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof b)) {
         return false;
      } else {
         b var2 = (b)var1;
         if (!var2.e(this)) {
            return false;
         } else {
            label39: {
               ai.idealistic.vacan.abstraction.f.c var3 = this.aP();
               ai.idealistic.vacan.abstraction.f.c var4 = var2.aP();
               if (var3 == null) {
                  if (var4 == null) {
                     break label39;
                  }
               } else if (var3.equals(var4)) {
                  break label39;
               }

               return false;
            }

            Location var5 = this.aQ();
            Location var6 = var2.aQ();
            if (var5 == null) {
               if (var6 != null) {
                  return false;
               }
            } else if (!var5.equals(var6)) {
               return false;
            }

            if (this.aR() != var2.aR()) {
               return false;
            } else {
               return true;
            }
         }
      }
   }

   protected boolean e(Object var1) {
      return var1 instanceof b;
   }

   public int hashCode() {
      boolean var1 = true;
      byte var2 = 1;
      ai.idealistic.vacan.abstraction.f.c var3 = this.aP();
      int var5 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      Location var4 = this.aQ();
      var5 = var5 * 59 + (var4 == null ? 43 : var4.hashCode());
      var5 = var5 * 59 + this.aR();
      return var5;
   }

   public String toString() {
      return "CheckBoundData(attacker=" + this.aP() + ", target=" + this.aQ() + ", failures=" + this.aR() + ")";
   }
}
